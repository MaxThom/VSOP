package Lexer;



import VSOP.Lexer.*;

import java.util.HashMap;
import java.util.Map;

public class LexerListener extends LEXERBaseListener {

    private Map<String, Integer> variables;

    public LexerListener() {
        variables = new HashMap<>();
    }

    @Override
    public void exitAssign(LEXERParser.AssignContext ctx) {
        // This method is called when the parser has finished
        // parsing the assign statement

        // Get variable name
        String variableName = ctx.ID(0).getText();

        // Get value from variable or number
        String value = ctx.ID().size() > 1 ? ctx.ID(1).getText()
                : ctx.NUMBER().getText();

        // Add variable to map
        if(ctx.ID().size() > 1)
            variables.put(variableName, variables.get(value));
        else
            variables.put(variableName, Integer.parseInt(value));
    }

    @Override
    public void exitAdd(LEXERParser.AddContext ctx) {
        // This method is called when the parser has finished
        // parsing the add statement

        String variableName = ctx.ID().size() > 1 ? ctx.ID(1).getText()
                : ctx.ID(0).getText();
        int value = ctx.ID().size() > 1 ? variables.get(ctx.ID(0).getText())
                : Integer.parseInt(ctx.NUMBER().getText());

        variables.put(variableName, variables.get(variableName) + value);
    }

    @Override
    public void exitPrint(LEXERParser.PrintContext ctx) {
        // This method is called when the parser has finished
        // parsing the print statement

//        String output = ctx.ID() == null ? ctx.NUMBER().getText()
//                : variables.get(ctx.ID().getText()).toString();

        String output = "";
        if (ctx.NUMBER() != null) {
            output = ctx.NUMBER().getText();
        } else if (ctx.ID() != null) {
            output = ctx.ID().toString() + " = " + variables.get(ctx.ID().getText()).toString();
        } else if (ctx.TEXT() != null) {
            output = ctx.TEXT().getText();
        }


        System.out.println(output);
    }

    @Override
    public void exitId(LEXERParser.IdContext ctx) {
        String output = ctx.ID().getSymbol().getLine() + ", " + ctx.ID().getSymbol().getCharPositionInLine() + ": " + ctx.ID().getText();

        System.out.println(output);
    }

}
