
import Lexer.LexerListener;
import Parser.ParserListener;
import VSOP.Lexer.LEXERLexer;
import VSOP.Lexer.LEXERParser;
import VSOP.Parser.PARSERLexer;
import VSOP.Parser.PARSERParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            if (args.length <= 1) {
                System.out.println("Error : Missing correct arguments");
                System.exit(1);
            }

            ANTLRInputStream input = new ANTLRInputStream(
                    new FileInputStream(args[1]));

            switch (args[0]) {
                case "-lex":
                    startLexer(input);
                    break;
                case "-parse":
                    startParser(input);
                    break;
                default:
                    System.out.println("Error : Missing correct arguments");
                    System.exit(1);
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startLexer(ANTLRInputStream input) {
        LEXERLexer lexer = new LEXERLexer(input);

        LEXERParser parser = new LEXERParser(new CommonTokenStream(lexer));
        parser.addParseListener(new LexerListener());

        // Start parsing
        parser.program();
    }

    private static void startParser(ANTLRInputStream input) {
        PARSERLexer lexer = new PARSERLexer(input);

        PARSERParser parser = new PARSERParser(new CommonTokenStream(lexer));
        parser.addParseListener(new ParserListener());

        // Start parsing
        parser.program();
    }
}
