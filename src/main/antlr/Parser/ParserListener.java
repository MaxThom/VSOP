package Parser;


import VSOP.Parser.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;

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

        if (field.varValue() != null) {
            output.append(", ");
            output.append(field.varValue().getText());
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
        output.append(assign.OBJECT_IDENTIFIER(0).getText());
        output.append(", ");

        if (assign.statement() != null) {
            output.append(handleStatement(assign.statement()));
        } else if (assign.varValue() != null) {
            output.append(assign.varValue().getText());
        } else if (assign.OBJECT_IDENTIFIER(1) != null) {
            output.append(assign.OBJECT_IDENTIFIER(1).getText());
        }

        output.append(")");
        return output;
    }


    private StringBuilder handleLet(LetContext let) {
        StringBuilder output = new StringBuilder();
        output.append("Let(");
        output.append(let.OBJECT_IDENTIFIER(0).getText());
        output.append(", ");
        output.append(let.varType().getText());
        output.append(", ");

        int statOffset = 0;
        if (let.statement().size() > 1) {
            output.append(handleStatement(let.statement(statOffset)));
            statOffset++;
            output.append(", ");

        } else if (let.varValue() != null) {
            output.append(let.varValue().getText());
            output.append(", ");
        } else if (let.OBJECT_IDENTIFIER(1) != null) {
            output.append(let.OBJECT_IDENTIFIER(1).getText());
            output.append(", ");
        } else {
            output.append(handleStatement(let.statement(0)));
        }

        output.append(handleStatement(let.statement(statOffset)));
        output.append(")");
        return output;
    }


    /*
    private StringBuilder handleMethod(MethodDefinitionContext method) {
        StringBuilder output = new StringBuilder();
        return output;
    }
    */
}
