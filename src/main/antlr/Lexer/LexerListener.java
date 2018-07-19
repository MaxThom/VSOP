package Lexer;



import VSOP.Lexer.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class LexerListener extends LEXERBaseListener {

    private Map<String, Integer> variables;
    private Map<String, String> operatorsName;
    private String fileName;

    public LexerListener(String fileName) {
        this.fileName = fileName;
        variables = new HashMap<>();
        operatorsName = new HashMap<>();
        operatorsName.put("{", "lbrace");
        operatorsName.put("}", "rbrace");
        operatorsName.put("(", "lpar");
        operatorsName.put(")", "rpar");
        operatorsName.put(":", "colon");
        operatorsName.put(";", "semicolon");
        operatorsName.put(",", "comma");
        operatorsName.put("+", "plus");
        operatorsName.put("-", "minus");
        operatorsName.put("*", "times");
        operatorsName.put("/", "div");
        operatorsName.put("^", "pow");
        operatorsName.put(".", "dot");
        operatorsName.put("=", "equal");
        operatorsName.put("<", "lower");
        operatorsName.put("<=", "lower-equal");
        operatorsName.put("<-", "assign");

    }

    @Override
    public void exitObjectIdentifier(LEXERParser.ObjectIdentifierContext ctx) {


        printToken(ctx.OBJECT_IDENTIFIER().getSymbol(), "object-literal,");
    }

    @Override
    public void exitTypeIdentifier(LEXERParser.TypeIdentifierContext ctx) {


        printToken(ctx.TYPE_IDENTIFIER().getSymbol(), "type-literal,");
    }

    @Override
    public void exitKeyword(LEXERParser.KeywordContext ctx) {


        printToken(ctx.KEYWORD().getSymbol(), "");
    }

    @Override
    public void exitOperator(LEXERParser.OperatorContext ctx) {


        printTokenCustom(ctx.OPERATOR().getSymbol(), operatorsName.get(ctx.OPERATOR().getText()));
    }

    @Override
    public void exitInteger(LEXERParser.IntegerContext ctx) {
        TerminalNode node = null;
        String text = null;
        int radix = 10;
        if(ctx.INTEGER_BIN() != null) {
            node = ctx.INTEGER_BIN();
            text = node.getText().substring(2);
            radix = 2;
        } else if(ctx.INTEGER_HEX() != null) {
            node = ctx.INTEGER_HEX();
            text = node.getText().substring(2);
            radix = 16;
        } else if(ctx.INTEGER_DEC() != null) {
            node = ctx.INTEGER_DEC();
            text = node.getText();
            radix = 10;
        }

        try {
            int decimalValue = Integer.parseInt(text, radix);
            if (node != null)
                printTokenCustom(node.getSymbol(), "integer-literal," + decimalValue);
        }
        catch (Exception e) {
            printError(node.getSymbol().getLine(), node.getSymbol().getCharPositionInLine(), "\n  " + node.getText() + " is not a valid integer literal.");
        }
    }

    private void printToken(Token token, String message) {
        String output = token.getLine() + "," + (token.getCharPositionInLine()+1) + "," + message + token.getText();

        System.out.println(output);
    }

    private void printTokenCustom(Token token, String message) {
        String output = token.getLine() + "," + (token.getCharPositionInLine()+1) + "," + message;

        System.out.println(output);
    }

    private void printError(int line, int column, String message) {
        String output = this.fileName + ":" + line + ":" + column+1 + ": " + message;

        System.out.println(output);
    }
}
