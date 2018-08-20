package Lexer;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

/**
 * Error listener override for the lexer. Display illegal character
 */
public class LexerErrorListener extends BaseErrorListener {
    private static LexerErrorListener INSTANCE;
    public static LexerErrorListener getInstance(String src) {
        if (INSTANCE == null)
            INSTANCE = new LexerErrorListener(src);
        return INSTANCE;
    }

    private String inputSource;
    public boolean inError;

    private LexerErrorListener(String src) {
        this.inputSource = src;
        this.inError = false;
    }

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e)
    {

        inError = true;
        System.err.println(String.format("%s:%d:%d: \n  character %s is illegal in this context.", inputSource, line, charPositionInLine+1, msg.substring(msg.indexOf(": ")+2)));
    }
}