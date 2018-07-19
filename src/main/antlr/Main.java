
import Lexer.LexerListener;
import Parser.ParserListener;
import VSOP.Lexer.LEXERLexer;
import VSOP.Lexer.LEXERParser;
import VSOP.Parser.PARSERLexer;
import VSOP.Parser.PARSERParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            if (args.length <= 1) {
                System.out.println("Error : Missing correct arguments");
                System.exit(1);
            }

            File file = new File(args[1]);

            switch (args[0]) {
                case "-lex":
                    startLexer(file);
                    break;
                case "-parse":
                    startParser(file);
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

    private static void startLexer(File file) throws IOException {
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));

        LEXERLexer lexer = new LEXERLexer(input);

        LEXERParser parser = new LEXERParser(new CommonTokenStream(lexer));
        parser.addParseListener(new LexerListener(file.getName()));

        // Start parsing
        parser.program();
    }

    private static void startParser(File file) throws IOException  {
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));

        PARSERLexer lexer = new PARSERLexer(input);

        PARSERParser parser = new PARSERParser(new CommonTokenStream(lexer));
        parser.addParseListener(new ParserListener(file.getName()));

        // Start parsing
        parser.program();
    }
}
