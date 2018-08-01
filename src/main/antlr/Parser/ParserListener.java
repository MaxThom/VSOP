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

    public Boolean lexicalError = false;

    public ParserListener(String fileName) {
        variables = new HashMap<>();
        this.fileName = fileName;
    }

    @Override
    public void exitProgram(ProgramContext ctx) {
        String treeOutput = "";

        for (ClassDefinitionContext classDef : ctx.classDefinition()) {
            treeOutput += handleClass(classDef);
        }


        System.out.println(ctx.getText());
        System.out.println(treeOutput);
    }

    @Override
    public void exitAssign(AssignContext ctx) {

    }

    @Override
    public void exitCondition(ConditionContext ctx) {

    }

    @Override
    public void exitIfStatement(IfStatementContext ctx) {

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

        output.append(")");
        return output;
    }

    private StringBuilder handleMethod(MethodDefinitionContext method) {
        StringBuilder output = new StringBuilder();
        //Method Info
        output.append("Method(");
        output.append(method.OBJECT_IDENTIFIER());
        output.append(", ");

        if (method.formal().size() == 1) {
            output.append(handleFormal(method.formal(0)));
        } else {
            output.append("[");

            for (FormalContext formal : method.formal()) {
                output.append(handleFormal(formal));
                output.append(", ");
            }
            output.delete(output.length()-2, output.length());
            output.append("]");
        }

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

                if (child instanceof StatementContext) {
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
        } else if (statement.unOperation() != null) {
            output.append(handleUnOperation(statement.unOperation()));
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
        }

        return output;
    }

    private StringBuilder handleIfStatement(IfStatementContext ifStatement) {
        StringBuilder output = new StringBuilder();
        output.append("If(");
        output.append(ifStatement.ifStat().condition().getText());


        if (ifStatement.ifStat().statement() != null) {
            output.append(", ");
            output.append(handleStatement(ifStatement.ifStat().statement()));
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
        output.append(whileStatement.condition().getText());


        if (whileStatement.statement() != null) {
            output.append(", ");
            output.append(handleStatement(whileStatement.statement()));
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
        if (let.statement().size() > 1) {
            output.append(handleStatement(let.statement(statOffset++)));
            output.append(", ");
        }

        output.append(handleStatement(let.statement(statOffset)));
        output.append(")");
        return output;
    }

    private StringBuilder handleUnOperation(UnOperationContext unOp) {
        StringBuilder output = new StringBuilder();
        output.append("UnOp(");
        output.append(unOp.UN_OPERATOR().getText());
        output.append(", ");
        output.append(handleStatement(unOp.statement()));
        output.append(")");

        return output;
    }

    private StringBuilder handleNewObj(NewObjContext obj) {
        StringBuilder output = new StringBuilder();
        output.append("New(");
        output.append(obj.TYPE_IDENTIFIER().getText());
        output.append(")");

        return output;
    }

    private StringBuilder handleBinaryOperation(BinaryOperationContext binOp) {
        StringBuilder output = new StringBuilder();
        /*output.append("BinOp(");
        output.append(binOp.ARITHMETIC_OPERATOR(0) != null ? binOp.ARITHMETIC_OPERATOR(0).getText() : binOp.CONDITIONAL_OPERATOR(0).getText());
        output.append(", ");
        output.append(binOp.OBJECT_IDENTIFIER() != null ? binOp.OBJECT_IDENTIFIER().getText() : binOp.varValue().getText());
        output.append(", ");
        output.append(handleStatement(binOp.statement(0)));
        output.append(")");*/

        if (binOp.term().size() == 1) {
            output.append(handleTerm(binOp.term(0)));
        } else {
            for (int i = 0; i < binOp.CONDITIONAL_OPERATOR().size(); i++) {
                output.append("BinOp(");
                output.append(binOp.CONDITIONAL_OPERATOR(i).getText());
                output.append(", ");
                output.append(handleTerm(binOp.term(i)));
                output.append(", ");
                if (i + 1 == binOp.CONDITIONAL_OPERATOR().size()) {
                    output.append(handleTerm(binOp.term(i + 1)));
                    for (int j = 0; j < binOp.CONDITIONAL_OPERATOR().size(); j++)
                        output.append(")");
                }
            }
        }


        /*for (int i = 1; i < binOp.statement().size(); i++) {
            output.append("BinOp(");
            output.append(binOp.ARITHMETIC_OPERATOR(i) != null ? binOp.ARITHMETIC_OPERATOR(i).getText() : binOp.CONDITIONAL_OPERATOR(i).getText());
        }


       // output.append(handleStatement(binOp.statement()));
        output.append(")");*/

        return output;
    }

    private StringBuilder handleTerm(TermContext term) {
        StringBuilder output = new StringBuilder();

        if (term.factor().size() == 1) {
            output.append(handleFactor(term.factor(0)));
        } else {
            for (int i = 0; i < term.TERM_OPERATOR().size(); i++) {
                output.append("BinOp(");
                output.append(term.TERM_OPERATOR(i).getText());
                output.append(", ");
                output.append(handleFactor(term.factor(i)));
                output.append(", ");
                if (i + 1 == term.TERM_OPERATOR().size()) {
                    output.append(handleFactor(term.factor(i + 1)));
                    for (int j = 0; j < term.TERM_OPERATOR().size(); j++)
                        output.append(")");
                }
            }
        }

        return output;
    }

    private StringBuilder handleFactor(FactorContext factor) {
        StringBuilder output = new StringBuilder();

        if (factor.value().size() == 1) {
            output.append(factor.value(0).getText());
        } else {
            for (int i = 0 ; i < factor.FACTOR_OPERATOR().size() ; i++) {
                output.append("BinOp(");
                output.append(factor.FACTOR_OPERATOR(i).getText());
                output.append(", ");
                output.append(handleValue(factor.value(i)));
                output.append(", ");
                if (i+1 == factor.FACTOR_OPERATOR().size()) {
                    output.append(handleValue(factor.value(i+1)));
                    for (int j = 0 ; j < factor.FACTOR_OPERATOR().size() ; j++)
                        output.append(")");
                }
            }
        }

        return output;
    }

    private StringBuilder handleValue(ValueContext value) {
        StringBuilder output = new StringBuilder();
        output.append(value.getChild(0).getText());
        return output;
    }


    private StringBuilder handleCallMethod(CallMethodContext call) {
        StringBuilder output = new StringBuilder();
        output.append("Call(");

        if (call.OBJECT_IDENTIFIER().size() == 1) {
            output.append("self");
            output.append(", ");
            output.append(call.OBJECT_IDENTIFIER(0));
        } else {
            for (int i = 0; i < call.OBJECT_IDENTIFIER().size() - 1; i++) {
                output.append(call.OBJECT_IDENTIFIER(i) + ".");
            }
            output.delete(output.length()-1, output.length());
            output.append(", ");
            output.append(call.OBJECT_IDENTIFIER(call.OBJECT_IDENTIFIER().size() - 1));
        }
        output.append(", [");

        for (ArgumentContext arg : call.argument()) {
            output.append(handleArgument(arg));
            output.append(", ");
        }

        if (call.argument().size() > 0) output.delete(output.length()-2, output.length());
        output.append("])");

        return output;
    }

    private StringBuilder handleArgument(ArgumentContext arg) {
        StringBuilder output = new StringBuilder();
        output.append(arg.varValue() != null ? arg.varValue().getText() : arg.OBJECT_IDENTIFIER().getText());

        return output;
    }

    /*
    private StringBuilder handleMethod(MethodDefinitionContext method) {
        StringBuilder output = new StringBuilder();
        return output;
    }
    */
}
