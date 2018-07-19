
import Lexer.LexerListener;
import VSOP.Lexer.LEXERLexer;
import VSOP.Lexer.LEXERParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {

            if (args.length == 0) {
                System.out.println("Error : Missing input file");
                System.exit(1);
            }

            ANTLRInputStream input = new ANTLRInputStream(
                    new FileInputStream(args[0]));

            LEXERLexer lexer = new LEXERLexer(input);

//            List tokens = lexer.getAllTokens();
//
//            for (int i = 0; i < tokens.size(); i++) {
//                System.out.println(tokens.get(i).toString());
//            }

            LEXERParser parser = new LEXERParser(new CommonTokenStream(lexer));
            parser.addParseListener(new LexerListener());

            // Start parsing
            parser.program();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
