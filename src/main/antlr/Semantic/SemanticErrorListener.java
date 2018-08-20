package Semantic;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Error listener override for the parser. Display syntax error
 */
public class SemanticErrorListener extends BaseErrorListener {
    private static SemanticErrorListener INSTANCE;
    public static SemanticErrorListener getInstance(String src) {
        if (INSTANCE == null)
            INSTANCE = new SemanticErrorListener(src);
        return INSTANCE;
    }

    private String inputSource;
    public boolean inError;

    private SemanticErrorListener(String src) {
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