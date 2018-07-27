package Lexer;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class DescriptiveErrorListener extends BaseErrorListener {
    private static DescriptiveErrorListener INSTANCE;
    public static DescriptiveErrorListener getInstance(String src) {
        if (INSTANCE == null)
            INSTANCE = new DescriptiveErrorListener(src);
        return INSTANCE;
    }


    private static final boolean REPORT_SYNTAX_ERRORS = true;

    private String inputSource;
    public boolean inError;

    private DescriptiveErrorListener(String src) {
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