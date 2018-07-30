
import Lexer.DescriptiveErrorListener;
import Lexer.LexerListener;
import Parser.ParserListener;
import VSOP.Lexer.LEXERLexer;
import VSOP.Lexer.LEXERParser;
import VSOP.Parser.PARSERLexer;
import VSOP.Parser.PARSERParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.*;
import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try {
            int exitCode = 0;
            if (args.length <= 1) {
                System.out.println("Error : Missing correct arguments");
                System.exit(1);
            }

            File file = new File(args[1]);

            switch (args[0]) {
                case "-lex":
                    exitCode = startLexer(file);
                    break;
                case "-parse":
                    exitCode = startParser(file);
                    break;
                default:
                    System.out.println("Error : Missing correct arguments");
                    exitCode = 1;
                    break;
            }
            System.exit(exitCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int startLexer(File file) throws IOException {
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

        if (listener.errorOutput.isEmpty()) {
            for (String token : listener.tokenOutput) {
                System.out.println(token);
            }
        } else {
            for (String token : listener.tokenOutput) {
                System.out.println(token);
            }

            for (String token : listener.errorOutput) {
                System.err.println(token);
            }
        }

        if (DescriptiveErrorListener.getInstance("").inError)
            return 1;
        return listener.lexicalError ? 1 : 0 ;
    }

    private static int startParser(File file) throws IOException  {
        String text = removeComments(file);

        ANTLRInputStream input = new ANTLRInputStream(text);//(new FileInputStream(file));
        PARSERLexer lexer = new PARSERLexer(input);

        PARSERParser parser = new PARSERParser(new CommonTokenStream(lexer));
        ParserListener listener = new ParserListener(file.getName());
        parser.addParseListener(listener);

        // Start parsing
        parser.program();

        return listener.lexicalError ? 1 : 0 ;
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
