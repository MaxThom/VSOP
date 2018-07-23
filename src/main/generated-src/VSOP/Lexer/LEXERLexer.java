// Generated from Lexer\LEXER.g4 by ANTLR 4.7.1
package VSOP.Lexer;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LEXERLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, MULTILINE_OPEN_COMMENT=2, MULTILINE_CLOSE_COMMENT=3, INTEGER_BIN=4, 
		INTEGER_HEX=5, INTEGER_DEC=6, OBJECT_IDENTIFIER=7, TYPE_IDENTIFIER=8, 
		STRING=9, SINGLE_LINE_COMMENT=10, OPERATOR=11, WS=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KEYWORD", "MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", "INTEGER_BIN", 
		"INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", "TYPE_IDENTIFIER", 
		"STRING", "SINGLE_LINE_COMMENT", "OPERATOR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'(*'", "'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", 
		"INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", "TYPE_IDENTIFIER", 
		"STRING", "SINGLE_LINE_COMMENT", "OPERATOR", "WS"
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


	public LEXERLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "LEXER.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16\u00b8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2i\n\2\3\3\3\3"+
		"\3\3\3\4\3\4\3\4\3\5\3\5\3\5\7\5t\n\5\f\5\16\5w\13\5\3\6\3\6\3\6\7\6|"+
		"\n\6\f\6\16\6\177\13\6\3\7\3\7\7\7\u0083\n\7\f\7\16\7\u0086\13\7\3\b\3"+
		"\b\7\b\u008a\n\b\f\b\16\b\u008d\13\b\3\t\3\t\7\t\u0091\n\t\f\t\16\t\u0094"+
		"\13\t\3\n\3\n\3\n\3\n\7\n\u009a\n\n\f\n\16\n\u009d\13\n\3\n\5\n\u00a0"+
		"\n\n\3\13\3\13\3\13\3\13\7\13\u00a6\n\13\f\13\16\13\u00a9\13\13\3\f\3"+
		"\f\3\f\3\f\3\f\5\f\u00b0\n\f\3\r\6\r\u00b3\n\r\r\r\16\r\u00b4\3\r\3\r"+
		"\3\u009b\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16"+
		"\3\2\r\4\2DDdd\5\2\62;C\\c|\4\2ZZzz\3\2\62;\3\2c|\6\2\62;C\\aac|\3\2C"+
		"\\\3\3$$\4\2\f\f\17\17\7\2*\61<?``}}\177\177\5\2\13\f\17\17\"\"\2\u00d4"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\3h\3\2\2\2\5j\3\2\2\2\7m\3\2\2\2\tp\3\2\2\2\13x\3\2\2\2"+
		"\r\u0080\3\2\2\2\17\u0087\3\2\2\2\21\u008e\3\2\2\2\23\u0095\3\2\2\2\25"+
		"\u00a1\3\2\2\2\27\u00af\3\2\2\2\31\u00b2\3\2\2\2\33\34\7c\2\2\34\35\7"+
		"p\2\2\35i\7f\2\2\36\37\7d\2\2\37 \7q\2\2 !\7q\2\2!i\7n\2\2\"#\7e\2\2#"+
		"$\7n\2\2$%\7c\2\2%&\7u\2\2&i\7u\2\2\'(\7f\2\2(i\7q\2\2)*\7g\2\2*+\7n\2"+
		"\2+,\7u\2\2,i\7g\2\2-.\7g\2\2./\7z\2\2/\60\7v\2\2\60\61\7g\2\2\61\62\7"+
		"p\2\2\62\63\7f\2\2\63i\7u\2\2\64\65\7h\2\2\65\66\7c\2\2\66\67\7n\2\2\67"+
		"8\7u\2\28i\7g\2\29:\7k\2\2:i\7h\2\2;<\7k\2\2<i\7p\2\2=>\7k\2\2>?\7p\2"+
		"\2?@\7v\2\2@A\7\65\2\2Ai\7\64\2\2BC\7k\2\2CD\7u\2\2DE\7p\2\2EF\7w\2\2"+
		"FG\7n\2\2Gi\7n\2\2HI\7n\2\2IJ\7g\2\2Ji\7v\2\2KL\7p\2\2LM\7g\2\2Mi\7y\2"+
		"\2NO\7p\2\2OP\7q\2\2Pi\7v\2\2QR\7u\2\2RS\7v\2\2ST\7t\2\2TU\7k\2\2UV\7"+
		"p\2\2Vi\7i\2\2WX\7v\2\2XY\7j\2\2YZ\7g\2\2Zi\7p\2\2[\\\7v\2\2\\]\7t\2\2"+
		"]^\7w\2\2^i\7g\2\2_`\7w\2\2`a\7p\2\2ab\7k\2\2bi\7v\2\2cd\7y\2\2de\7j\2"+
		"\2ef\7k\2\2fg\7n\2\2gi\7g\2\2h\33\3\2\2\2h\36\3\2\2\2h\"\3\2\2\2h\'\3"+
		"\2\2\2h)\3\2\2\2h-\3\2\2\2h\64\3\2\2\2h9\3\2\2\2h;\3\2\2\2h=\3\2\2\2h"+
		"B\3\2\2\2hH\3\2\2\2hK\3\2\2\2hN\3\2\2\2hQ\3\2\2\2hW\3\2\2\2h[\3\2\2\2"+
		"h_\3\2\2\2hc\3\2\2\2i\4\3\2\2\2jk\7*\2\2kl\7,\2\2l\6\3\2\2\2mn\7,\2\2"+
		"no\7+\2\2o\b\3\2\2\2pq\7\62\2\2qu\t\2\2\2rt\t\3\2\2sr\3\2\2\2tw\3\2\2"+
		"\2us\3\2\2\2uv\3\2\2\2v\n\3\2\2\2wu\3\2\2\2xy\7\62\2\2y}\t\4\2\2z|\t\3"+
		"\2\2{z\3\2\2\2|\177\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\f\3\2\2\2\177}\3\2\2"+
		"\2\u0080\u0084\t\5\2\2\u0081\u0083\t\3\2\2\u0082\u0081\3\2\2\2\u0083\u0086"+
		"\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\16\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0087\u008b\t\6\2\2\u0088\u008a\t\7\2\2\u0089\u0088\3\2"+
		"\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\20\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0092\t\b\2\2\u008f\u0091\t\7\2"+
		"\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093"+
		"\3\2\2\2\u0093\22\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u009b\7$\2\2\u0096"+
		"\u0097\7^\2\2\u0097\u009a\7$\2\2\u0098\u009a\13\2\2\2\u0099\u0096\3\2"+
		"\2\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u009c\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\t\t"+
		"\2\2\u009f\u009e\3\2\2\2\u00a0\24\3\2\2\2\u00a1\u00a2\7\61\2\2\u00a2\u00a3"+
		"\7\61\2\2\u00a3\u00a7\3\2\2\2\u00a4\u00a6\n\n\2\2\u00a5\u00a4\3\2\2\2"+
		"\u00a6\u00a9\3\2\2\2\u00a7\u00a5\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\26"+
		"\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00b0\t\13\2\2\u00ab\u00ac\7>\2\2\u00ac"+
		"\u00b0\7?\2\2\u00ad\u00ae\7>\2\2\u00ae\u00b0\7/\2\2\u00af\u00aa\3\2\2"+
		"\2\u00af\u00ab\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\30\3\2\2\2\u00b1\u00b3"+
		"\t\f\2\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4"+
		"\u00b5\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\u00b7\b\r\2\2\u00b7\32\3\2\2"+
		"\2\17\2hu}\u0084\u008b\u0092\u0099\u009b\u009f\u00a7\u00af\u00b4\3\b\2"+
		"\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}