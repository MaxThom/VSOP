
import Lexer.DescriptiveErrorListener;
import Lexer.LexerListener;
import Parser.ErrorListener;
import Parser.ParserListener;
import VSOP.Lexer.LEXERLexer;
import VSOP.Lexer.LEXERParser;
import VSOP.Parser.PARSERLexer;
import VSOP.Parser.PARSERParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try {
            int exitCode = 0;
            if (args.length == 0) {
                System.out.println("Error : Missing correct arguments");
                System.exit(1);
            }

            File file = new File(args[args.length-1]);

            switch (args[0]) {
                case "-lex":
                    exitCode = startLexer(file, true);
                    break;
                case "-parse":
                    exitCode = startParser(file, true);
                    break;
                default:
                    exitCode = startProgram(file, args[0].equals("-v") || args[0].equals("-visual"));
                    //System.out.println("Error : Missing correct arguments");
                    //exitCode = 1;
                    break;
            }
            System.exit(exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int startProgram(File file, boolean displayVisual) throws IOException {
        int exitCode = 0;

        if (displayVisual) {
            System.out.println("======================");
            System.out.println("= LEXER ==============");
            System.out.println("======================");
        }
        exitCode = startLexer(file, displayVisual);

        if (exitCode == 0) {
            if (displayVisual) {
                System.out.println("======================");
                System.out.println("= PARSER =============");
                System.out.println("======================");
            }

            exitCode = startParser(file, displayVisual);
        }

        return exitCode;
    }

    private static int startLexer(File file, boolean displayVisual) throws IOException {


        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));
        LEXERLexer lexer = new LEXERLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(DescriptiveErrorListener.getInstance(file.getName()));
        LEXERParser parser = new LEXERParser(new CommonTokenStream(lexer));
        LexerListener listener = new LexerListener(file.getName());
        parser.addParseListener(listener);
        parser.removeErrorListeners();
        parser.addErrorListener(DescriptiveErrorListener.getInstance(file.getName()));

        // Start parsing
        parser.program();

        if (displayVisual) {
            for (String token : listener.tokenOutput) {
                System.out.println(token);
            }
        }
        for (String token : listener.errorOutput) {
            System.err.println(token);
        }

        return DescriptiveErrorListener.getInstance("").inError ? 1 : (listener.lexicalError ? 1 : 0) ;
    }

    private static int startParser(File file, boolean displayVisual) throws IOException  {
        String text = removeSpecialChar(removeComments(file));

        ANTLRInputStream input = new ANTLRInputStream(text);//(new FileInputStream(file));
        PARSERLexer lexer = new PARSERLexer(input);
        lexer.removeErrorListeners();
        lexer.addErrorListener(ErrorListener.getInstance(file.getName()));

        PARSERParser parser = new PARSERParser(new CommonTokenStream(lexer));
        ParserListener listener = new ParserListener(file.getName());
        parser.addParseListener(listener);
        parser.removeErrorListeners();
        parser.addErrorListener(ErrorListener.getInstance(file.getName()));

        // Start parsing
        parser.program();

        if (parser.getNumberOfSyntaxErrors() == 0 && displayVisual)
            System.out.println(listener.treeOuput);

        return parser.getNumberOfSyntaxErrors();
    }

    private static String removeSpecialChar(String file) {
        HashMap<String, String> characterEscape = new HashMap<>();
        characterEscape.put("\\b", "\\x08");
        characterEscape.put("\\t", "\\x09");
        characterEscape.put("\\n", "\\x0a");
        characterEscape.put("\\r", "\\x0d");

        // Escape Character
        for (Map.Entry<String, String> escape : characterEscape.entrySet()) {
            file = file.replace(escape.getKey(), escape.getValue());
        }

        // New Line
        String LINE_FEED_LIN = "\n";
        int nl = -1;
        while ((nl = file.indexOf(LINE_FEED_LIN, nl)) != -1) {
            int offsetWindows = 0;
            if ((nl - 1) >= 0 && file.charAt(nl - 1) == '\r')
                offsetWindows = 1;

            if ((nl - 1 - offsetWindows) >= 0 && file.charAt(nl - 1 - offsetWindows) == '\\') {
                int endIndex = nl + 1 + offsetWindows;
                while (file.charAt(endIndex) == ' ' || file.charAt(endIndex) == '\t')
                    endIndex++;
                file = file.substring(0, nl - 1 - offsetWindows) + file.substring(endIndex);
            }
            ++nl;
        }

        //Hexadecimal Character
        int hex = 0;
        while ((hex = file.indexOf("0x", hex)) != -1 ||
                (hex = file.indexOf("0X", hex)) != -1 ||
                (hex = file.indexOf("0b", hex)) != -1 ||
                (hex = file.indexOf("0B", hex)) != -1) {
            String hexNumber = "";
            try {

                while (file.substring(hex+2, hex+3).matches("[0-9a-zA-Z]")) {
                    hexNumber += file.substring(hex+2, hex+3);
                    ++hex;
                }

                int radix = file.charAt(hex - hexNumber.length() + 1) == 'x' || file.charAt(hex - hexNumber.length() + 1) == 'X' ? 16 : 2;
                int decimalValue = Integer.parseInt(hexNumber, radix);
                file = file.substring(0, hex - hexNumber.length()) + decimalValue + file.substring(hex + 2);
            } catch (Exception e) {

                break;
            }
        }

        return file;
    }

    private static String removeComments(File file) {

        String text = "";
        boolean forgetSingle = false;
        Stack<Integer> comments = new Stack<>();

        // Remove Multiline
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            int c;
            while((c = reader.read()) != -1) {
                text += String.valueOf((char) c);
                if (text.length() >= 2 && text.charAt(text.length()-2) == '(' && text.charAt(text.length()-1) == '*') {
                    comments.push(text.length()-2);
                }
                else if (text.length() >= 2 && text.charAt(text.length()-2) == '*' && text.charAt(text.length()-1) == ')') {

                    text = text.substring(0, comments.pop()) + text.substring(text.length());
                }
            }
        }
        catch (IOException e) {

        }

        // Remove single line
        int i = 0;
        while ((i = text.indexOf("//", i)) != -1) {
            int nl = text.indexOf("\n", i);
            if (nl == -1)
                text = text.substring(0, i);
            else
                text = text.substring(0, i) + text.substring(nl+1);
        }

        return text;
    }
}
