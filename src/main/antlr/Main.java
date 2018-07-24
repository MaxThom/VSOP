
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
        LEXERParser parser = new LEXERParser(new CommonTokenStream(lexer));
        LexerListener listener = new LexerListener(file.getName());
        parser.addParseListener(listener);

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
                System.out.println(token);
            }
        }

        return listener.lexicalError ? 1 : 0 ;
    }

    private static int startParser(File file) throws IOException  {
        ANTLRInputStream input = new ANTLRInputStream(new FileInputStream(file));

        PARSERLexer lexer = new PARSERLexer(input);

        PARSERParser parser = new PARSERParser(new CommonTokenStream(lexer));
        ParserListener listener = new ParserListener(file.getName());
        parser.addParseListener(listener);

        // Start parsing
        parser.program();

        return listener.lexicalError ? 1 : 0 ;
    }
}
