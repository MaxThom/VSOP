import VSOP.VSOPLexer;
import VSOP.VSOPParser;
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

            VSOPLexer lexer = new VSOPLexer(input);

//            List tokens = lexer.getAllTokens();
//
//            for (int i = 0; i < tokens.size(); i++) {
//                System.out.println(tokens.get(i).toString());
//            }

            VSOPParser parser = new VSOPParser(new CommonTokenStream(lexer));
            parser.addParseListener(new MyListener());

            // Start parsing
            parser.program();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
