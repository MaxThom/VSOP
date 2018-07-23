package Lexer;



import VSOP.Lexer.*;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.HashMap;
import java.util.Map;

public class LexerListener extends LEXERBaseListener {

    private Map<String, Integer> variables;
    private Map<String, String> operatorsName;
    private Map<String, String> characterEscape;
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

        characterEscape = new HashMap<>();
        characterEscape.put("\\b", "\\x08");
        characterEscape.put("\\t", "\\x09");
        characterEscape.put("\\n", "\\x0a");
        characterEscape.put("\\r", "\\x0d");

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

    @Override
    public void exitString(LEXERParser.StringContext ctx) {
        Boolean inError = false;
        String string = ctx.STRING().getText();

        //Hexadecimal Character
        int hex = -4;
        while((hex = string.indexOf("\\x", hex+4)) != -1) {
            String hexNumber = string.substring(hex+2, hex+4);
            try {
                int decimalValue = Integer.parseInt(hexNumber, 16);
            }
            catch (Exception e) {
                inError = true;
                break;
            }
        }

        // Escape Character
        for (Map.Entry<String, String> escape : characterEscape.entrySet()) {
            string = string.replace(escape.getKey(), escape.getValue());
        }

        // New Line
        int nl = -1;
        while ((nl = string.indexOf("\r\n", nl)) != -1) {
            if (string.charAt(nl-1) != '\\') {
                inError = true;
                nl += 2;
            } else {
                int endIndex = nl + 2;

                while (string.charAt(endIndex) == ' ' || string.charAt(endIndex) == '\t') {
                    endIndex++;
                }
                string = string.substring(0, nl-1) + string.substring(endIndex);
            }
        }

        // Other Escape Character
        int esc = -2;
        while ((esc = string.indexOf("\\", esc+2)) != -1) {
            if (string.charAt(esc+1) != 'x' && string.charAt(esc+1) != '"' && string.charAt(esc+1) != '\\') {
                inError = true;
                break;
            }
        }

        if (inError) {
            printError(ctx.STRING().getSymbol().getLine(), ctx.STRING().getSymbol().getCharPositionInLine(), "\n  " + string + " is not a valid string-literal.");
        } else {
            printTokenCustom(ctx.STRING().getSymbol(), "string-literal," + string);
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
