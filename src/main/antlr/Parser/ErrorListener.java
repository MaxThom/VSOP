package Parser;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class ErrorListener extends BaseErrorListener {
    private static ErrorListener INSTANCE;
    public static ErrorListener getInstance(String src) {
        if (INSTANCE == null)
            INSTANCE = new ErrorListener(src);
        return INSTANCE;
    }


    private static final boolean REPORT_SYNTAX_ERRORS = true;

    private String inputSource;
    public boolean inError;

    private ErrorListener(String src) {
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