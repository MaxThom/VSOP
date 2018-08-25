package Parser;


import VSOP.Parser.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

import static VSOP.Parser.PARSERParser.*;

/**
 * Class overriding the default listener of antlr. Each hit on a token generate two methods. One enter and one exit. Exit when everything under the node has been looked.
 */
public class ParserListener extends PARSERBaseListener {

    public String treeOuput;

    public ParserListener(String fileName) {
        treeOuput = "";
    }

    /**
     * Exit program token.
     * @param ctx
     */
    @Override
    public void exitProgram(ProgramContext ctx) {
        try {
            StringBuilder output = new StringBuilder();
            output.append("[");

            // Move in the tree for each class and generate output
            for (ClassDefinitionContext classDef : ctx.classDefinition()) {
                output.append(handleClass(classDef));
                output.append(", ");
            }
            if ( ctx.classDefinition().size() > 0) output.delete(output.length()-2, output.length());

            output.append("]");
            this.treeOuput = output.toString();
        } catch (Exception e) {

        }
    }

    /**
     * Handle class node
     * @param classDef
     * @return
     */
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

    /**
     * Handle field node
     * @param field
     * @return
     */
    private StringBuilder handleField(FieldContext field) {
        // Field info
        StringBuilder output = new StringBuilder();
        output.append("Field(");
        output.append(field.OBJECT_IDENTIFIER().getText());
        output.append(", ");
        output.append(field.varType().getText());

        // Append statement
        if (field.statement() != null) {
            output.append(", ");
            output.append(handleStatement(field.statement()));
        }

        // Append block
        if (field.block() != null) {
            output.append(", ");
            output.append(handleBlock(field.block()));
        }

        output.append(")");
        return output;
    }

    /**
     * Handle method node
     * @param method
     * @return
     */
    private StringBuilder handleMethod(MethodDefinitionContext method) {
        StringBuilder output = new StringBuilder();
        //Method Info
        output.append("Method(");
        output.append(method.OBJECT_IDENTIFIER());
        output.append(", ");
        output.append("[");

        // For each arguments in the method
        for (FormalContext formal : method.formal()) {
            output.append(handleFormal(formal));
            output.append(", ");
        }

        if (method.formal().size() > 0) output.delete(output.length()-2, output.length());
        output.append("]");

        // Handle method block
        output.append(", ");
        output.append(method.varType().getText());
        output.append(", ");
        output.append(handleBlock(method.block()));
        output.append(")");

        return output;
    }

    /**
     * Handle formal node
     * @param formal
     * @return
     */
    private StringBuilder handleFormal(FormalContext formal) {
        StringBuilder output = new StringBuilder();

        // Formal info
        output.append(formal.OBJECT_IDENTIFIER().getText());
        output.append(" : ");
        output.append(formal.varType().getText());

        return output;
    }

    /**
     * Handle block node
     * @param block
     * @return
     */
    private StringBuilder handleBlock(BlockContext block) {
        StringBuilder output = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        int countStat = 0;
        // Handle every statement in the block
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

    /**
     * Handle statement node
     * @param statement
     * @return
     */
    private StringBuilder handleStatement(StatementContext statement) {
        StringBuilder output = new StringBuilder();

        // Handle every statement.
        if (statement.assign() != null) {
            output.append(handleAssign(statement.assign()));
        } else if (statement.ifStatement() != null) {
            output.append(handleIfStatement(statement.ifStatement()));
        } else if (statement.whileStatement() != null) {
            output.append(handleWhileStatement(statement.whileStatement()));
        } else if (statement.let() != null) {
            output.append(handleLet(statement.let()));
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

    /**
     * Handle ifStatement node
     * @param ifStatement
     * @return
     */
    private StringBuilder handleIfStatement(IfStatementContext ifStatement) {
        StringBuilder output = new StringBuilder();

        // If info
        output.append("If(");
        output.append(handleStatement(ifStatement.ifStat().statement(0)));

        // Handle if statement or block
        if (ifStatement.ifStat().statement(1) != null) {
            output.append(", ");
            output.append(handleStatement(ifStatement.ifStat().statement(1)));
        } else if (ifStatement.ifStat().block() != null) {
            output.append(", ");
            output.append(handleBlock(ifStatement.ifStat().block()));
        }

        // Handle else block if present
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

    /**
     * Handle whileStatement node
     * @param whileStatement
     * @return
     */
    private StringBuilder handleWhileStatement(WhileStatementContext whileStatement) {
        StringBuilder output = new StringBuilder();

        // While info
        output.append("While(");
        output.append(handleStatement(whileStatement.statement(0)));

        // Handle block or statement
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

    /**
     * Handle assign node
     * @param assign
     * @return
     */
    private StringBuilder handleAssign(AssignContext assign) {
        StringBuilder output = new StringBuilder();

        // Assign info
        output.append("Assign(");
        output.append(assign.OBJECT_IDENTIFIER().getText());
        output.append(", ");

        // Assign statement
        if (assign.statement() != null) {
            output.append(handleStatement(assign.statement()));
        }

        output.append(")");
        return output;
    }

    /**
     * Handle let node
     * @param let
     * @return
     */
    private StringBuilder handleLet(LetContext let) {
        // Let info
        StringBuilder output = new StringBuilder();
        output.append("Let(");
        output.append(let.OBJECT_IDENTIFIER().getText());
        output.append(", ");
        output.append(let.varType().getText());
        output.append(", ");

        // Check if initializer is present
        int statOffset = 0;
        if (let.statement().size() == 2 || (let.block() != null && let.statement().size() == 1)) {
            output.append(handleStatement(let.statement(statOffset++)));
            output.append(", ");
        }

        // Handle block or statement of in scope
        if (let.block() != null) {
            output.append(handleBlock(let.block()));
        } else {
            output.append(handleStatement(let.statement(statOffset)));
        }

        output.append(")");
        return output;
    }

    /**
     * Handle obj node
     * @param obj
     * @return
     */
    private StringBuilder handleNewObj(NewObjContext obj) {
        StringBuilder output = new StringBuilder();
        // New info
        output.append("New(");
        output.append(obj.TYPE_IDENTIFIER().getText());
        output.append(")");

        return output;
    }

    /**
     * Handle call node
     * @param call
     * @return
     */
    private StringBuilder handleCallMethod(CallMethodContext call) {
        StringBuilder output = new StringBuilder();

        if (!(call.parent.parent instanceof BlockContext) && call.singleCallMethod().size() > 1) {
            output.append("[");
        }

        // Check each sub call
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

    /**
     * Handle singleCall node
     * @param singleCall
     * @return
     */
    private StringBuilder handleSingleCallMethod(SingleCallMethodContext singleCall) {
        StringBuilder output = new StringBuilder();

        // Add every call, then we go back up
        for (int i = singleCall.callFunction().size()-1; i >= 0 ; i--) {
            output.append("Call(");
        }

        // Add self if no caller
        if (singleCall.caller().size() == 0) {
            output.append("self, ");
        }
        else {
            // Handle caller
            for (int i = 0; i < singleCall.caller().size() ; i++) {
                output.append(handleCaller(singleCall.caller(i)) + ".");
            }

            output.delete(output.length()-1, output.length());
            output.append(", ");
        }

        // Handle the function
        for (int i = 0; i < singleCall.callFunction().size() ; i++) {
            output.append(handleCallFunction(singleCall.callFunction(i)));
            output.append("), ");
        }
        output.delete(output.length()-2, output.length());

        return output;
    }

    /**
     * Handle callFunc node
     * @param callFunc
     * @return
     */
    private StringBuilder handleCallFunction(CallFunctionContext callFunc) {
        StringBuilder output = new StringBuilder();

        // Call info
        output.append(callFunc.OBJECT_IDENTIFIER().getText());
        output.append(", [");

        // Handle every argument
        for (ArgumentContext arg : callFunc.argument()) {
            output.append(handleArgument(arg));
            output.append(", ");
        }

        if (callFunc.argument().size() > 0) output.delete(output.length()-2, output.length());
        output.append("]");

        return output;
    }

    /**
     * Handle caller node
     * @param caller
     * @return
     */
    private StringBuilder handleCaller(CallerContext caller) {
        StringBuilder output = new StringBuilder();

        // Handle every type of caller
        if (caller.newObj() != null) {
            output.append(handleNewObj(caller.newObj()));
        } else if (caller.OBJECT_IDENTIFIER() != null) {
            output.append(caller.OBJECT_IDENTIFIER().getText());
        } else if (caller.ifStatement() != null) {
            output.append(handleIfStatement(caller.ifStatement()));
        }

        return output;
    }

    /**
     * Handle arg node
     * @param arg
     * @return
     */
    private StringBuilder handleArgument(ArgumentContext arg) {
        StringBuilder output = new StringBuilder();

        // Handle arg
        output.append(handleStatement(arg.statement()));

        return output;
    }

    /**
     * Handle binOp node
     * @param binOp
     * @return
     */
    private StringBuilder handleBinaryOperation(BinaryOperationContext binOp) {
        StringBuilder output = new StringBuilder();

        // Handle the operation
        output.append(handleExpr1(binOp.expr1()));

        return output;
    }

    /**
     * Handle expr1 node
     * @param expr1
     * @return
     */
    private StringBuilder handleExpr1(Expr1Context expr1) {
        StringBuilder output = new StringBuilder();

        // Handle and operation
        if (expr1.expr1() != null) {
            output.append("BinOp(");
            output.append(expr1.AND().getText());
            output.append(", ");
            output.append(handleExpr1(expr1.expr1()));
            output.append(", ");
            output.append(handleExprOr(expr1.exprOr()));
            output.append(")");
        } else
            output.append(handleExprOr(expr1.exprOr()));


        return output;
    }

    /**
     * Handle exprOr node
     * @param exprOr
     * @return
     */
    private StringBuilder handleExprOr(ExprOrContext exprOr) {
        StringBuilder output = new StringBuilder();

        // Handle and operation
        if (exprOr.exprOr() != null) {
            output.append("BinOp(");
            output.append(exprOr.OR().getText());
            output.append(", ");
            output.append(handleExprOr(exprOr.exprOr()));
            output.append(", ");
            output.append(handleExpr2(exprOr.expr2()));
            output.append(")");
        } else
            output.append(handleExpr2(exprOr.expr2()));


        return output;
    }

    /**
     * Handle expr2 node
     * @param expr2
     * @return
     */
    private StringBuilder handleExpr2(Expr2Context expr2) {
        StringBuilder output = new StringBuilder();

        // Handle not operation
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

    /**
     * Handle expr3 node
     * @param expr3
     * @return
     */
    private StringBuilder handleExpr3(Expr3Context expr3) {
        StringBuilder output = new StringBuilder();

        // Handle comparator (<, <=, =, !=, >=, >) operation
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

    /**
     * Handle expr4 node
     * @param expr4
     * @return
     */
    private StringBuilder handleExpr4(Expr4Context expr4) {
        StringBuilder output = new StringBuilder();

        // Handle term operation (-, +)
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

    /**
     * Handle expr5 node
     * @param expr5
     * @return
     */
    private StringBuilder handleExpr5(Expr5Context expr5) {
        StringBuilder output = new StringBuilder();

        // Handle factor operation (*, /)
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

    /**
     * Handle expr6 node
     * @param expr6
     * @return
     */
    private StringBuilder handleExpr6(Expr6Context expr6) {
        StringBuilder output = new StringBuilder();

        // Handle negative and isnull operation
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

    /**
     * Handle expr7 node
     * @param expr7
     * @return
     */
    private StringBuilder handleExpr7(Expr7Context expr7) {
        StringBuilder output = new StringBuilder();

        // Handle pow operation
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

    /**
     * Handle expr8 node
     * @param expr8
     * @return
     */
    private StringBuilder handleExpr8(Expr8Context expr8) {
        StringBuilder output = new StringBuilder();

        // Handle for each type of possible value
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
        else if (expr8.block() != null)
            output.append(handleBlock(expr8.block()));

        return output;
    }

}
