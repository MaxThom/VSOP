package Parser;


import VSOP.Parser.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

import static VSOP.Parser.PARSERParser.*;

public class ParserListener extends PARSERBaseListener {

    private Map<String, Integer> variables;
    private String fileName;
    public String treeOuput;

    public Boolean lexicalError = false;

    public ParserListener(String fileName) {
        variables = new HashMap<>();
        this.fileName = fileName;
        treeOuput = "";
    }

    @Override
    public void exitProgram(ProgramContext ctx) {
        StringBuilder output = new StringBuilder();
        output.append("[");

        for (ClassDefinitionContext classDef : ctx.classDefinition()) {
            output.append(handleClass(classDef));
            output.append(", ");
        }
        if ( ctx.classDefinition().size() > 0) output.delete(output.length()-2, output.length());

        output.append("]");
        //System.out.println(ctx.getText());
        //System.out.println(treeOutput);
        this.treeOuput = output.toString();
    }



    private StringBuilder handleClass(ClassDefinitionContext classDef) {

        // Class Info
        StringBuilder output = new StringBuilder();
        output.append("Class(");
        output.append(classDef.TYPE_IDENTIFIER(0).getText());
        output.append(", ");
        output.append(classDef.TYPE_IDENTIFIER(1) != null ? classDef.TYPE_IDENTIFIER(1).getText() : "Object");

        // Fields
        output.append(", [");
        for (FieldContext field : classDef.field()) {
            output.append(handleField(field));
            output.append(", ");
        }
        if (classDef.field().size() > 0) output.delete(output.length()-2, output.length());
        output.append("]");

        // Methods
        output.append(", [");
        for (MethodDefinitionContext method : classDef.methodDefinition()) {
            output.append(handleMethod(method));
            output.append(", ");
        }
        if (classDef.methodDefinition().size() > 0) output.delete(output.length()-2, output.length());
        output.append("]");
        output.append(")");

        return output;
    }

    private StringBuilder handleField(FieldContext field) {
        StringBuilder output = new StringBuilder();
        output.append("Field(");
        output.append(field.OBJECT_IDENTIFIER().getText());
        output.append(", ");
        output.append(field.varType().getText());

        if (field.statement() != null) {
            output.append(", ");
            output.append(handleStatement(field.statement()));
        }
        if (field.block() != null) {
            output.append(", ");
            output.append(handleBlock(field.block()));
        }

        output.append(")");
        return output;
    }

    private StringBuilder handleMethod(MethodDefinitionContext method) {
        StringBuilder output = new StringBuilder();
        //Method Info
        output.append("Method(");
        output.append(method.OBJECT_IDENTIFIER());
        output.append(", ");
        output.append("[");

        for (FormalContext formal : method.formal()) {
            output.append(handleFormal(formal));
            output.append(", ");
        }

        if (method.formal().size() > 0) output.delete(output.length()-2, output.length());
        output.append("]");

        output.append(", ");
        output.append(method.varType().getText());
        output.append(", ");
        output.append(handleBlock(method.block()));
        output.append(")");

        return output;
    }

    private StringBuilder handleFormal(FormalContext formal) {
        StringBuilder output = new StringBuilder();

        output.append(formal.OBJECT_IDENTIFIER().getText());
        output.append(" : ");
        output.append(formal.varType().getText());

        return output;
    }

    private StringBuilder handleBlock(BlockContext block) {
        StringBuilder output = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int countStat = 0;
        for (ParseTree child : block.children) {

            if (child instanceof ParserRuleContext) {
                countStat++;

                if (child instanceof BlockContext) {
                    temp.append(handleBlock((BlockContext) child));
                } else if (child instanceof StatementContext) {
                    temp.append(handleStatement((StatementContext) child));
                } else if (child instanceof IfStatementContext) {
                    temp.append(handleIfStatement((IfStatementContext) child));
                } else if (child instanceof WhileStatementContext) {
                    temp.append(handleWhileStatement((WhileStatementContext) child));
                }

                temp.append(", ");
            }
        }

        if (countStat > 1) {
            output.append("[");
            if (temp.length() > 1) temp.delete(temp.length()-2, temp.length());
            output.append(temp);
            output.append("]");
        } else {
            if (temp.length() > 1) temp.delete(temp.length()-2, temp.length());
            output.append(temp);
        }

        return output;
    }

    private StringBuilder handleStatement(StatementContext statement) {
        StringBuilder output = new StringBuilder();

        if (statement.assign() != null) {
            output.append(handleAssign(statement.assign()));
        } else if (statement.ifStatement() != null) {
            output.append(handleIfStatement(statement.ifStatement()));
        } else if (statement.whileStatement() != null) {
            output.append(handleWhileStatement(statement.whileStatement()));
        } else if (statement.let() != null) {
            output.append(handleLet(statement.let()));
        //} else if (statement.unOperation() != null) {
            //output.append(handleUnOperation(statement.unOperation()));
        } else if (statement.binaryOperation() != null) {
            output.append(handleBinaryOperation(statement.binaryOperation()));
        } else if (statement.callMethod() != null) {
            output.append(handleCallMethod(statement.callMethod()));
        } else if (statement.newObj() != null) {
            output.append(handleNewObj(statement.newObj()));
        } else if (statement.OBJECT_IDENTIFIER() != null) {
            output.append(statement.OBJECT_IDENTIFIER().getText());
        } else if (statement.varValue() != null) {
            output.append(statement.varValue().getText());
        } else if (statement.statement() != null) {
            output.append(handleStatement(statement.statement()));
        }

        return output;
    }

    private StringBuilder handleIfStatement(IfStatementContext ifStatement) {
        StringBuilder output = new StringBuilder();
        output.append("If(");
        output.append(handleStatement(ifStatement.ifStat().statement(0)));


        if (ifStatement.ifStat().statement(1) != null) {
            output.append(", ");
            output.append(handleStatement(ifStatement.ifStat().statement(1)));
        } else if (ifStatement.ifStat().block() != null) {
            output.append(", ");
            output.append(handleBlock(ifStatement.ifStat().block()));
        }

        if (ifStatement.elseStat() != null) {
            output.append(", ");
            if (ifStatement.elseStat().statement() != null) {
                output.append(handleStatement(ifStatement.elseStat().statement()));
            } else if (ifStatement.elseStat().block() != null) {
                output.append(handleBlock(ifStatement.elseStat().block()));
            }
        }

        output.append(")");
        return output;
    }

    private StringBuilder handleWhileStatement(WhileStatementContext whileStatement) {
        StringBuilder output = new StringBuilder();
        output.append("While(");
        output.append(handleStatement(whileStatement.statement(0)));


        if (whileStatement.statement(1) != null) {
            output.append(", ");
            output.append(handleStatement(whileStatement.statement(1)));
        } else if (whileStatement.block() != null) {
            output.append(", ");
            output.append(handleBlock(whileStatement.block()));
        }

        output.append(")");
        return output;
    }

    private StringBuilder handleAssign(AssignContext assign) {
        StringBuilder output = new StringBuilder();
        output.append("Assign(");
        output.append(assign.OBJECT_IDENTIFIER().getText());
        output.append(", ");

        if (assign.statement() != null) {
            output.append(handleStatement(assign.statement()));
        }

        output.append(")");
        return output;
    }

    private StringBuilder handleLet(LetContext let) {
        StringBuilder output = new StringBuilder();
        output.append("Let(");
        output.append(let.OBJECT_IDENTIFIER().getText());
        output.append(", ");
        output.append(let.varType().getText());
        output.append(", ");

        int statOffset = 0;
        if (let.statement().size() == 2 || (let.block() != null && let.statement().size() == 1)) {
            output.append(handleStatement(let.statement(statOffset++)));
            output.append(", ");
        }

        if (let.block() != null) {
            output.append(handleBlock(let.block()));
        } else {
            output.append(handleStatement(let.statement(statOffset)));
        }


        output.append(")");
        return output;
    }

    private StringBuilder handleUnOperation(ParserRuleContext unOp) {
        StringBuilder output = new StringBuilder();
        /*output.append("UnOp(");
        output.append(unOp.unOperator().getText());
        output.append(", ");

        if (unOp.statement() != null)
            output.append(handleStatement(unOp.statement()));
        else if (unOp.condition() != null)
            output.append(handleCondition(unOp.condition()));

        output.append(")");*/

        return output;
    }

    private StringBuilder handleNewObj(NewObjContext obj) {
        StringBuilder output = new StringBuilder();
        output.append("New(");
        output.append(obj.TYPE_IDENTIFIER().getText());
        output.append(")");

        return output;
    }

    private StringBuilder handleCallMethod(CallMethodContext call) {
        StringBuilder output = new StringBuilder();

        if (!(call.parent.parent instanceof BlockContext) && call.singleCallMethod().size() > 1) {
            output.append("[");
        }

        for (int i = 0; i < call.singleCallMethod().size(); i++) {
            output.append(handleSingleCallMethod(call.singleCallMethod(i)));
            output.append(", ");
        }
        output.delete(output.length()-2, output.length());

        if (!(call.parent.parent instanceof BlockContext) && call.singleCallMethod().size() > 1) {
            output.append("]");
        }

        return output;
    }

    private StringBuilder handleSingleCallMethod(SingleCallMethodContext singleCall) {
        StringBuilder output = new StringBuilder();

        /*if (singleCall.caller().size() == 0) {

            for (int i = 0; i < singleCall.callFunction().size() ; i++) {
                output.append("Call(self, ");
                output.append(handleCallFunction(singleCall.callFunction(i)));
                output.append("), ");
            }
            output.delete(output.length()-2, output.length());
        } else {*/

            for (int i = singleCall.callFunction().size()-1; i >= 0 ; i--) {
                output.append("Call(");
            }

            if (singleCall.caller().size() == 0) {
                output.append("self, ");
            }
            else {
                for (int i = 0; i < singleCall.caller().size() ; i++) {
                    output.append(handleCaller(singleCall.caller(i)) + ".");
                }

                output.delete(output.length()-1, output.length());
                output.append(", ");
            }

            for (int i = 0; i < singleCall.callFunction().size() ; i++) {
                output.append(handleCallFunction(singleCall.callFunction(i)));
                output.append("), ");
            }
            output.delete(output.length()-2, output.length());

       // }





        return output;
    }

    private StringBuilder handleCallFunction(CallFunctionContext callFunc) {
        StringBuilder output = new StringBuilder();

        output.append(callFunc.OBJECT_IDENTIFIER().getText());
        output.append(", [");

        for (ArgumentContext arg : callFunc.argument()) {
            output.append(handleArgument(arg));
            output.append(", ");
        }

        if (callFunc.argument().size() > 0) output.delete(output.length()-2, output.length());
        output.append("]");

        return output;
    }

    private StringBuilder handleCaller(CallerContext caller) {
        StringBuilder output = new StringBuilder();

        if (caller.newObj() != null) {
            output.append(handleNewObj(caller.newObj()));
        } else if (caller.OBJECT_IDENTIFIER() != null) {
            output.append(caller.OBJECT_IDENTIFIER().getText());
        }

        return output;
    }

    private StringBuilder handleArgument(ArgumentContext arg) {
        StringBuilder output = new StringBuilder();

        if (arg.callMethod() != null) {
            output.append(handleCallMethod(arg.callMethod()));
        } else if (arg.newObj() != null) {
            output.append(handleNewObj(arg.newObj()));
        } else if (arg.OBJECT_IDENTIFIER() != null) {
            output.append(arg.OBJECT_IDENTIFIER().getText());
        } else if (arg.varValue() != null) {
            output.append(arg.varValue().getText());
        }  else if (arg.binaryOperation() != null) {
            output.append(handleBinaryOperation(arg.binaryOperation()));
        }

        return output;
    }

    private StringBuilder handleBinaryOperation(BinaryOperationContext binOp) {
        StringBuilder output = new StringBuilder();

        output.append(handleExpr1(binOp.expr1()));

        return output;
    }

    private StringBuilder handleExpr1(Expr1Context expr1) {
        StringBuilder output = new StringBuilder();


        if (expr1.expr1() != null) {
            output.append("BinOp(");
            output.append(expr1.AND().getText());
            output.append(", ");
            output.append(handleExpr1(expr1.expr1()));
            output.append(", ");
            output.append(handleExpr2(expr1.expr2()));
            output.append(")");
        } else
            output.append(handleExpr2(expr1.expr2()));


        return output;
    }

    private StringBuilder handleExpr2(Expr2Context expr2) {
        StringBuilder output = new StringBuilder();

        if (expr2.expr2() != null) {
            output.append("UnOp(");
            output.append(expr2.NOT().getText());
            output.append(", ");
            output.append(handleExpr2(expr2.expr2()));
            output.append(")");
        } else
            output.append(handleExpr3(expr2.expr3()));

        return output;
    }

    private StringBuilder handleExpr3(Expr3Context expr3) {
        StringBuilder output = new StringBuilder();

        if (expr3.comparatorOperator() != null) {
            output.append("BinOp(");
            output.append(expr3.comparatorOperator().getText());
            output.append(", ");
            output.append(handleExpr4(expr3.expr4(0)));
            output.append(", ");
            output.append(handleExpr4(expr3.expr4(1)));
            output.append(")");
        } else
            output.append(handleExpr4(expr3.expr4(0)));

        return output;
    }

    private StringBuilder handleExpr4(Expr4Context expr4) {
        StringBuilder output = new StringBuilder();

        if (expr4.termOperator() != null) {
            output.append("BinOp(");
            output.append(expr4.termOperator().getText());
            output.append(", ");
            output.append(handleExpr4(expr4.expr4()));
            output.append(", ");
            output.append(handleExpr5(expr4.expr5()));
            output.append(")");
        } else
            output.append(handleExpr5(expr4.expr5()));

        return output;
    }

    private StringBuilder handleExpr5(Expr5Context expr5) {
        StringBuilder output = new StringBuilder();

        if (expr5.factorOperator() != null) {
            output.append("BinOp(");
            output.append(expr5.factorOperator().getText());
            output.append(", ");
            output.append(handleExpr5(expr5.expr5()));
            output.append(", ");
            output.append(handleExpr6(expr5.expr6()));
            output.append(")");
        } else
            output.append(handleExpr6(expr5.expr6()));

        return output;
    }

    private StringBuilder handleExpr6(Expr6Context expr6) {
        StringBuilder output = new StringBuilder();

        if (expr6.expr6() != null) {
            output.append("UnOp(");
            output.append(expr6.MINUS() != null ? expr6.MINUS().getText() : expr6.ISNULL().getText());
            output.append(", ");
            output.append(handleExpr6(expr6.expr6()));
            output.append(")");
        } else
            output.append(handleExpr7(expr6.expr7()));

        return output;
    }

    private StringBuilder handleExpr7(Expr7Context expr7) {
        StringBuilder output = new StringBuilder();

        if (expr7.POW() != null) {
            output.append("BinOp(");
            output.append(expr7.POW().getText());
            output.append(", ");
            output.append(handleExpr8(expr7.expr8()));
            output.append(", ");
            output.append(handleExpr7(expr7.expr7()));
            output.append(")");
        } else
            output.append(handleExpr8(expr7.expr8()));

        return output;
    }

    private StringBuilder handleExpr8(Expr8Context expr8) {
        StringBuilder output = new StringBuilder();

        if (expr8.expr1() != null)
            output.append(handleExpr1(expr8.expr1()));
        else if (expr8.varValue() != null)
            output.append(expr8.varValue().getText());
        else if (expr8.OBJECT_IDENTIFIER() != null)
            output.append(expr8.OBJECT_IDENTIFIER().getText());
        else if (expr8.callMethod() != null)
            output.append(handleCallMethod(expr8.callMethod()));
        else if (expr8.newObj() != null)
            output.append(handleNewObj(expr8.newObj()));
        else if (expr8.ifStatement() != null)
            output.append(handleIfStatement(expr8.ifStatement()));

        return output;
    }




}
