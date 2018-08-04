package Parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ParserErrorListener extends BaseErrorListener {
    private static ParserErrorListener INSTANCE;
    public static ParserErrorListener getInstance(String src) {
        if (INSTANCE == null)
            INSTANCE = new ParserErrorListener(src);
        return INSTANCE;
    }


    private static final boolean REPORT_SYNTAX_ERRORS = true;

    private String inputSource;
    public boolean inError;

    private ParserErrorListener(String src) {
        this.inputSource = src;
        this.inError = false;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e)
    {

        inError = true;
        System.err.println(String.format("%s:%d:%d: syntax error.", inputSource, line, charPositionInLine+1));
    }
}