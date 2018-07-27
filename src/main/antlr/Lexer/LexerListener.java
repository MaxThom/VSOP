package Lexer;

import VSOP.Lexer.LEXERBaseListener;
import VSOP.Lexer.LEXERParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.*;

public class LexerListener extends LEXERBaseListener {

    private final String LINE_FEED_WIN = "\r\n";
    private final String LINE_FEED_LIN = "\n";

    private Map<String, Integer> variables;
    private Map<String, String> operatorsName;
    private Map<String, String> characterEscape;
    private Stack<CommentNode> commentStack;
    private Stack<CommentNode> closeCommentStack;
    private String fileName;

    public Boolean lexicalError = false;
    public ArrayList<String> tokenOutput;
    public ArrayList<String> errorOutput;

    public LexerListener(String fileName) {
        this.fileName = fileName;
        tokenOutput = new ArrayList();
        errorOutput = new ArrayList();
        commentStack = new Stack<>();
        closeCommentStack = new Stack<>();
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
       if (commentStack.empty()) {
            printToken(ctx.OBJECT_IDENTIFIER().getSymbol(), "object-identifier,");
       }
    }

    @Override
    public void exitTypeIdentifier(LEXERParser.TypeIdentifierContext ctx) {
        if (commentStack.empty()) {
            printToken(ctx.TYPE_IDENTIFIER().getSymbol(), "type-identifier,");
        }
    }

    @Override
    public void exitKeyword(LEXERParser.KeywordContext ctx) {
        if (commentStack.empty()) {
            printToken(ctx.KEYWORD().getSymbol(), "");
        }
    }

    @Override
    public void exitOperator(LEXERParser.OperatorContext ctx) {
        if (commentStack.empty()) {
            printTokenCustom(ctx.OPERATOR().getSymbol(), operatorsName.get(ctx.OPERATOR().getText()));
        }
    }

    @Override
    public void exitInteger(LEXERParser.IntegerContext ctx) {
        if (commentStack.empty()) {
            TerminalNode node = null;
            String text = null;
            int radix = 10;
            if (ctx.INTEGER_BIN() != null) {
                node = ctx.INTEGER_BIN();
                text = node.getText().substring(2);
                radix = 2;
            } else if (ctx.INTEGER_HEX() != null) {
                node = ctx.INTEGER_HEX();
                text = node.getText().substring(2);
                radix = 16;
            } else if (ctx.INTEGER_DEC() != null) {
                node = ctx.INTEGER_DEC();
                text = node.getText();
                radix = 10;
            }

            try {
                int decimalValue = Integer.parseInt(text, radix);
                if (node != null)
                    printTokenCustom(node.getSymbol(), "integer-literal," + decimalValue);
            } catch (Exception e) {
                printError(node.getSymbol().getLine(), node.getSymbol().getCharPositionInLine(), "lexical error\n  " + node.getText() + " is not a valid integer literal.");
            }
        }
    }

    @Override
    public void exitString(LEXERParser.StringContext ctx) {
        String string = ctx.STRING().getText();
        if (commentStack.empty()) {
            Boolean inError = false;
            String errorMessage = "lexical error\n";
            int errLine = ctx.STRING().getSymbol().getLine();
            int errCol = ctx.STRING().getSymbol().getCharPositionInLine();



            // Check for EOF
            if (string.charAt(string.length()-1) != '"') {
                inError = true;
                errorMessage += "  unterminated string.";
            }



            //Hexadecimal Character
            int hex = -4;
            while ((hex = string.indexOf("\\x", hex + 4)) != -1) {
                String hexNumber = "";
                try {
                    hexNumber = string.substring(hex + 2, hex + 4);
                    int decimalValue = Integer.parseInt(hexNumber, 16);
                } catch (Exception e) {
                    inError = true;
                    errorMessage += "  \\x" + hexNumber + " is not a valid escape sequence.";

                    errLine = ctx.STRING().getSymbol().getLine();
                    errCol = hex;
                    for (int nl2 = 0; (nl2 = string.substring(0, hex).indexOf(LINE_FEED_LIN, nl2++)) != -1; nl2++) {
                        errLine++;
                        errCol = hex - nl2 - 1;
                    }

                    break;
                }
            }

            // Escape Character
            for (Map.Entry<String, String> escape : characterEscape.entrySet()) {
                string = string.replace(escape.getKey(), escape.getValue());
            }

            // New Line
            int nl = -1;
            //while (string.indexOf(LINE_FEED_WIN, nl) != -1 || string.indexOf(LINE_FEED_LIN, nl) != -1) {
            //    nl = Math.max(string.indexOf(LINE_FEED_WIN, nl), string.indexOf(LINE_FEED_LIN, nl));
            while ((nl = string.indexOf(LINE_FEED_LIN, nl)) != -1) {
                int offsetWin = 0;
                if (string.charAt(nl - 1) == '\r') {
                    offsetWin = 1;
                }

                if (string.charAt(nl - 1 - offsetWin) != '\\') {
                    inError = true;
                    errorMessage += "  character '\\n' is illegal in this context.";
                    nl += 1 + offsetWin;
                    int posErr = nl - 1 - offsetWin;

                    errLine = ctx.STRING().getSymbol().getLine();
                    errCol = posErr - offsetWin;
                    for (int nl2 = 0; (nl2 = string.substring(0, posErr).indexOf(LINE_FEED_LIN, nl2++)) != -1; nl2++) {
                        errLine++;
                        errCol = posErr - nl2 - 1 - offsetWin;
                    }
                } else {
                    int endIndex = nl + 1 + offsetWin;

                    while (string.charAt(endIndex) == ' ' || string.charAt(endIndex) == '\t') {
                        endIndex++;
                    }
                    string = string.substring(0, nl - 1 - offsetWin) + string.substring(endIndex);
                }
            }

            // Other Escape Character
            int esc = -2;
            while ((esc = string.indexOf("\\", esc + 2)) != -1) {
                if (string.charAt(esc + 1) != 'x' && string.charAt(esc + 1) != '"' && string.charAt(esc + 1) != '\\') {
                    inError = true;
                    errorMessage += "  \\" + string.charAt(esc + 1) + " is not a valid escape sequence.";
                    errCol = ctx.STRING().getText().indexOf("\\" + string.charAt(esc+1));
                    String before = ctx.STRING().getText().substring(0, ctx.STRING().getText().indexOf("\\" + string.charAt(esc+1)));
                    int posNewLine = -2;
                    while ((posNewLine = before.indexOf(LINE_FEED_LIN, posNewLine+2)) != -1) {
                        errLine++;
                        errCol = ctx.STRING().getText().indexOf("\\" + string.charAt(esc+1)) - posNewLine - 1;
                    }
                    // TODO : Column error at faulty character

                    break;
                }
            }

            int posNull;
            if ((posNull = string.indexOf('\0')) != -1) {
                inError = true;
                errorMessage += "  character '\\000' is illegal in this context.";
                errLine = ctx.STRING().getSymbol().getLine();
                errCol = posNull;
                for (int nl2 = 0; (nl2 = string.substring(0, posNull).indexOf(LINE_FEED_LIN, nl2++)) != -1; nl2++) {
                    errLine++;
                    errCol = posNull - nl2 - 1;
                }
            }

            if (inError) {
                printError(errLine, errCol, errorMessage);
            } else {
                printTokenCustom(ctx.STRING().getSymbol(), "string-literal," + string);
            }
        }
    }

    @Override
    public void exitSingleLineComment(LEXERParser.SingleLineCommentContext ctx) {


        //printToken(ctx.SINGLE_LINE_COMMENT().getSymbol(), "");
    }

    @Override
    public void exitMultiLineComment(LEXERParser.MultiLineCommentContext ctx) {
        TerminalNode node = null;

        if (ctx.MULTILINE_COMMENT() != null) {
            node = ctx.MULTILINE_COMMENT();
            String txt = ctx.MULTILINE_COMMENT().getText();
            int nextOpen = 1;
            /*while (txt.indexOf("(*", nextOpen) != -1) {
                nextOpen = txt.indexOf("(*", nextOpen);
                nextOpen += 1;
                commentStack.push(new CommentNode(CommentType.OPEN, node.getSymbol().getLine(), node.getSymbol().getCharPositionInLine()+nextOpen));
            }*/

            for (int i = 0; (i = txt.indexOf("(*", i++)) != -1; i++) {
                int row = node.getSymbol().getLine();
                int col = node.getSymbol().getCharPositionInLine()+i;
                for (int nl = 1; (nl = txt.substring(0, i).indexOf(LINE_FEED_LIN, nl++)) != -1; nl++) {
                    row++;
                    col = i - nl - 1;
                }
                commentStack.push(new CommentNode(CommentType.OPEN, row, col));
            }

            if (txt.substring(txt.length()-3).equals("(*)")) {

            } else if (txt.substring(txt.length()-2).equals("*)")) {
                commentStack.pop();
            }

        } else if (ctx.MULTILINE_OPEN_COMMENT() != null) {
            node = ctx.MULTILINE_OPEN_COMMENT();
            commentStack.push(new CommentNode(CommentType.OPEN, node.getSymbol().getLine(), node.getSymbol().getCharPositionInLine()));
        } else if (ctx.MULTILINE_CLOSE_COMMENT() != null) {
            node = ctx.MULTILINE_CLOSE_COMMENT();
            if (!commentStack.empty()) {
                commentStack.pop();
            } else {
                closeCommentStack.push(new CommentNode(CommentType.CLOSE, node.getSymbol().getLine(), node.getSymbol().getCharPositionInLine()));
            }
        }

    }

    @Override
    public void exitProgram(LEXERParser.ProgramContext ctx) {

        if (!commentStack.empty()) {
            CommentNode node = commentStack.pop();
            printError(node.row, node.col, "lexical error");
        }
        if (!closeCommentStack.empty()) {
            CommentNode node = closeCommentStack.pop();
            printError(node.row, node.col, "lexical error");
        }

    }


    private void printToken(Token token, String message) {
        String output = token.getLine() + "," + (token.getCharPositionInLine()+1) + "," + message + token.getText();
        tokenOutput.add(output);
        //System.out.println(output);
    }

    private void printTokenCustom(Token token, String message) {
        String output = token.getLine() + "," + (token.getCharPositionInLine()+1) + "," + message;
        tokenOutput.add(output);
        //System.out.println(output);
    }

    private void printError(int line, int column, String message) {
        lexicalError = true;
        String output = this.fileName + ":" + line + ":" + (column+1) + ": " + message;
        errorOutput.add(output);
        //System.out.println(output);
    }
}

