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
		KEYWORD=1, MULTILINE_OPEN_COMMENT=2, MULTILINE_CLOSE_COMMENT=3, MULTILINE_COMMENT=4, 
		INTEGER_BIN=5, INTEGER_HEX=6, INTEGER_DEC=7, OBJECT_IDENTIFIER=8, TYPE_IDENTIFIER=9, 
		STRING=10, SINGLE_LINE_COMMENT=11, OPERATOR=12, WS=13;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KEYWORD", "MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", "MULTILINE_COMMENT", 
		"INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", "TYPE_IDENTIFIER", 
		"STRING", "SINGLE_LINE_COMMENT", "OPERATOR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'(*'", "'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", 
		"MULTILINE_COMMENT", "INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", 
		"TYPE_IDENTIFIER", "STRING", "SINGLE_LINE_COMMENT", "OPERATOR", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\17\u00c6\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2k\n"+
		"\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\7\5w\n\5\f\5\16\5z\13\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\7\6\u0082\n\6\f\6\16\6\u0085\13\6\3\7\3\7\3\7\7\7"+
		"\u008a\n\7\f\7\16\7\u008d\13\7\3\b\3\b\7\b\u0091\n\b\f\b\16\b\u0094\13"+
		"\b\3\t\3\t\7\t\u0098\n\t\f\t\16\t\u009b\13\t\3\n\3\n\7\n\u009f\n\n\f\n"+
		"\16\n\u00a2\13\n\3\13\3\13\3\13\3\13\7\13\u00a8\n\13\f\13\16\13\u00ab"+
		"\13\13\3\13\5\13\u00ae\n\13\3\f\3\f\3\f\3\f\7\f\u00b4\n\f\f\f\16\f\u00b7"+
		"\13\f\3\r\3\r\3\r\3\r\3\r\5\r\u00be\n\r\3\16\6\16\u00c1\n\16\r\16\16\16"+
		"\u00c2\3\16\3\16\4x\u00a9\2\17\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\3\2\r\4\2DDdd\5\2\62;C\\c|\4\2ZZzz\3\2\62;\3\2"+
		"c|\6\2\62;C\\aac|\3\2C\\\3\3$$\4\2\f\f\17\17\7\2*\61<?``}}\177\177\5\2"+
		"\13\f\17\17\"\"\2\u00e3\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2"+
		"\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\3j\3\2\2\2\5l\3\2\2\2"+
		"\7o\3\2\2\2\tr\3\2\2\2\13~\3\2\2\2\r\u0086\3\2\2\2\17\u008e\3\2\2\2\21"+
		"\u0095\3\2\2\2\23\u009c\3\2\2\2\25\u00a3\3\2\2\2\27\u00af\3\2\2\2\31\u00bd"+
		"\3\2\2\2\33\u00c0\3\2\2\2\35\36\7c\2\2\36\37\7p\2\2\37k\7f\2\2 !\7d\2"+
		"\2!\"\7q\2\2\"#\7q\2\2#k\7n\2\2$%\7e\2\2%&\7n\2\2&\'\7c\2\2\'(\7u\2\2"+
		"(k\7u\2\2)*\7f\2\2*k\7q\2\2+,\7g\2\2,-\7n\2\2-.\7u\2\2.k\7g\2\2/\60\7"+
		"g\2\2\60\61\7z\2\2\61\62\7v\2\2\62\63\7g\2\2\63\64\7p\2\2\64\65\7f\2\2"+
		"\65k\7u\2\2\66\67\7h\2\2\678\7c\2\289\7n\2\29:\7u\2\2:k\7g\2\2;<\7k\2"+
		"\2<k\7h\2\2=>\7k\2\2>k\7p\2\2?@\7k\2\2@A\7p\2\2AB\7v\2\2BC\7\65\2\2Ck"+
		"\7\64\2\2DE\7k\2\2EF\7u\2\2FG\7p\2\2GH\7w\2\2HI\7n\2\2Ik\7n\2\2JK\7n\2"+
		"\2KL\7g\2\2Lk\7v\2\2MN\7p\2\2NO\7g\2\2Ok\7y\2\2PQ\7p\2\2QR\7q\2\2Rk\7"+
		"v\2\2ST\7u\2\2TU\7v\2\2UV\7t\2\2VW\7k\2\2WX\7p\2\2Xk\7i\2\2YZ\7v\2\2Z"+
		"[\7j\2\2[\\\7g\2\2\\k\7p\2\2]^\7v\2\2^_\7t\2\2_`\7w\2\2`k\7g\2\2ab\7w"+
		"\2\2bc\7p\2\2cd\7k\2\2dk\7v\2\2ef\7y\2\2fg\7j\2\2gh\7k\2\2hi\7n\2\2ik"+
		"\7g\2\2j\35\3\2\2\2j \3\2\2\2j$\3\2\2\2j)\3\2\2\2j+\3\2\2\2j/\3\2\2\2"+
		"j\66\3\2\2\2j;\3\2\2\2j=\3\2\2\2j?\3\2\2\2jD\3\2\2\2jJ\3\2\2\2jM\3\2\2"+
		"\2jP\3\2\2\2jS\3\2\2\2jY\3\2\2\2j]\3\2\2\2ja\3\2\2\2je\3\2\2\2k\4\3\2"+
		"\2\2lm\7*\2\2mn\7,\2\2n\6\3\2\2\2op\7,\2\2pq\7+\2\2q\b\3\2\2\2rs\7*\2"+
		"\2st\7,\2\2tx\3\2\2\2uw\13\2\2\2vu\3\2\2\2wz\3\2\2\2xy\3\2\2\2xv\3\2\2"+
		"\2y{\3\2\2\2zx\3\2\2\2{|\7,\2\2|}\7+\2\2}\n\3\2\2\2~\177\7\62\2\2\177"+
		"\u0083\t\2\2\2\u0080\u0082\t\3\2\2\u0081\u0080\3\2\2\2\u0082\u0085\3\2"+
		"\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\f\3\2\2\2\u0085\u0083"+
		"\3\2\2\2\u0086\u0087\7\62\2\2\u0087\u008b\t\4\2\2\u0088\u008a\t\3\2\2"+
		"\u0089\u0088\3\2\2\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c"+
		"\3\2\2\2\u008c\16\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0092\t\5\2\2\u008f"+
		"\u0091\t\3\2\2\u0090\u008f\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2"+
		"\2\2\u0092\u0093\3\2\2\2\u0093\20\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0099"+
		"\t\6\2\2\u0096\u0098\t\7\2\2\u0097\u0096\3\2\2\2\u0098\u009b\3\2\2\2\u0099"+
		"\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a\22\3\2\2\2\u009b\u0099\3\2\2"+
		"\2\u009c\u00a0\t\b\2\2\u009d\u009f\t\7\2\2\u009e\u009d\3\2\2\2\u009f\u00a2"+
		"\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\24\3\2\2\2\u00a2"+
		"\u00a0\3\2\2\2\u00a3\u00a9\7$\2\2\u00a4\u00a5\7^\2\2\u00a5\u00a8\7$\2"+
		"\2\u00a6\u00a8\13\2\2\2\u00a7\u00a4\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8"+
		"\u00ab\3\2\2\2\u00a9\u00aa\3\2\2\2\u00a9\u00a7\3\2\2\2\u00aa\u00ad\3\2"+
		"\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ae\t\t\2\2\u00ad\u00ac\3\2\2\2\u00ae"+
		"\26\3\2\2\2\u00af\u00b0\7\61\2\2\u00b0\u00b1\7\61\2\2\u00b1\u00b5\3\2"+
		"\2\2\u00b2\u00b4\n\n\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b7\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\30\3\2\2\2\u00b7\u00b5\3\2\2"+
		"\2\u00b8\u00be\t\13\2\2\u00b9\u00ba\7>\2\2\u00ba\u00be\7?\2\2\u00bb\u00bc"+
		"\7>\2\2\u00bc\u00be\7/\2\2\u00bd\u00b8\3\2\2\2\u00bd\u00b9\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\32\3\2\2\2\u00bf\u00c1\t\f\2\2\u00c0\u00bf\3\2\2"+
		"\2\u00c1\u00c2\3\2\2\2\u00c2\u00c0\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4"+
		"\3\2\2\2\u00c4\u00c5\b\16\2\2\u00c5\34\3\2\2\2\20\2jx\u0083\u008b\u0092"+
		"\u0099\u00a0\u00a7\u00a9\u00ad\u00b5\u00bd\u00c2\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}