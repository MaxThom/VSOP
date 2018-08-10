// Generated from Test\TEST.g4 by ANTLR 4.7.1
package VSOP.Test;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TESTLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, POW=5, MULTI=6, DIV=7, MINUS=8, PLUS=9, 
		LOWER_EQUAL=10, EQUAL=11, LOWER=12, AND=13, NOT=14, ISNULL=15, DOT=16, 
		ASSIGN=17, INTEGER_BIN=18, INTEGER_HEX=19, INTEGER_DEC=20, STRING=21, 
		WS=22;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "POW", "MULTI", "DIV", "MINUS", "PLUS", 
		"LOWER_EQUAL", "EQUAL", "LOWER", "AND", "NOT", "ISNULL", "DOT", "ASSIGN", 
		"INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "STRING", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'true'", "'false'", "'^'", "'*'", "'/'", "'-'", "'+'", 
		"'<='", "'='", "'<'", "'and'", "'not'", "'isnull'", "'.'", "'<-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "POW", "MULTI", "DIV", "MINUS", "PLUS", 
		"LOWER_EQUAL", "EQUAL", "LOWER", "AND", "NOT", "ISNULL", "DOT", "ASSIGN", 
		"INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "STRING", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public TESTLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TEST.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u008d\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3"+
		"\22\3\22\3\23\3\23\3\23\7\23g\n\23\f\23\16\23j\13\23\3\24\3\24\3\24\7"+
		"\24o\n\24\f\24\16\24r\13\24\3\25\3\25\7\25v\n\25\f\25\16\25y\13\25\3\26"+
		"\3\26\3\26\3\26\7\26\177\n\26\f\26\16\26\u0082\13\26\3\26\5\26\u0085\n"+
		"\26\3\27\6\27\u0088\n\27\r\27\16\27\u0089\3\27\3\27\3\u0080\2\30\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30\3\2\b\4\2DDdd\5\2\62;C\\c|\4\2ZZzz\3\2\62"+
		";\3\3$$\5\2\13\f\17\17\"\"\2\u0092\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\61\3\2\2\2\7\63\3\2\2\2\t8\3\2\2"+
		"\2\13>\3\2\2\2\r@\3\2\2\2\17B\3\2\2\2\21D\3\2\2\2\23F\3\2\2\2\25H\3\2"+
		"\2\2\27K\3\2\2\2\31M\3\2\2\2\33O\3\2\2\2\35S\3\2\2\2\37W\3\2\2\2!^\3\2"+
		"\2\2#`\3\2\2\2%c\3\2\2\2\'k\3\2\2\2)s\3\2\2\2+z\3\2\2\2-\u0087\3\2\2\2"+
		"/\60\7*\2\2\60\4\3\2\2\2\61\62\7+\2\2\62\6\3\2\2\2\63\64\7v\2\2\64\65"+
		"\7t\2\2\65\66\7w\2\2\66\67\7g\2\2\67\b\3\2\2\289\7h\2\29:\7c\2\2:;\7n"+
		"\2\2;<\7u\2\2<=\7g\2\2=\n\3\2\2\2>?\7`\2\2?\f\3\2\2\2@A\7,\2\2A\16\3\2"+
		"\2\2BC\7\61\2\2C\20\3\2\2\2DE\7/\2\2E\22\3\2\2\2FG\7-\2\2G\24\3\2\2\2"+
		"HI\7>\2\2IJ\7?\2\2J\26\3\2\2\2KL\7?\2\2L\30\3\2\2\2MN\7>\2\2N\32\3\2\2"+
		"\2OP\7c\2\2PQ\7p\2\2QR\7f\2\2R\34\3\2\2\2ST\7p\2\2TU\7q\2\2UV\7v\2\2V"+
		"\36\3\2\2\2WX\7k\2\2XY\7u\2\2YZ\7p\2\2Z[\7w\2\2[\\\7n\2\2\\]\7n\2\2] "+
		"\3\2\2\2^_\7\60\2\2_\"\3\2\2\2`a\7>\2\2ab\7/\2\2b$\3\2\2\2cd\7\62\2\2"+
		"dh\t\2\2\2eg\t\3\2\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2\2i&\3\2\2\2"+
		"jh\3\2\2\2kl\7\62\2\2lp\t\4\2\2mo\t\3\2\2nm\3\2\2\2or\3\2\2\2pn\3\2\2"+
		"\2pq\3\2\2\2q(\3\2\2\2rp\3\2\2\2sw\t\5\2\2tv\t\3\2\2ut\3\2\2\2vy\3\2\2"+
		"\2wu\3\2\2\2wx\3\2\2\2x*\3\2\2\2yw\3\2\2\2z\u0080\7$\2\2{|\7^\2\2|\177"+
		"\7$\2\2}\177\13\2\2\2~{\3\2\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080\u0081"+
		"\3\2\2\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0083"+
		"\u0085\t\6\2\2\u0084\u0083\3\2\2\2\u0085,\3\2\2\2\u0086\u0088\t\7\2\2"+
		"\u0087\u0086\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a"+
		"\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008c\b\27\2\2\u008c.\3\2\2\2\n\2h"+
		"pw~\u0080\u0084\u0089\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}