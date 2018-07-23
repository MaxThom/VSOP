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
		KEYWORD=1, INTEGER_BIN=2, INTEGER_HEX=3, INTEGER_DEC=4, OBJECT_IDENTIFIER=5, 
		TYPE_IDENTIFIER=6, STRING=7, SINGLE_LINE_COMMENT=8, OPERATOR=9, WS=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KEYWORD", "INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", 
		"TYPE_IDENTIFIER", "STRING", "SINGLE_LINE_COMMENT", "OPERATOR", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\f\u00af\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2e\n\2\3\3\3\3\3\3\7\3j\n\3\f\3\16"+
		"\3m\13\3\3\4\3\4\3\4\7\4r\n\4\f\4\16\4u\13\4\3\5\3\5\7\5y\n\5\f\5\16\5"+
		"|\13\5\3\6\3\6\7\6\u0080\n\6\f\6\16\6\u0083\13\6\3\7\3\7\7\7\u0087\n\7"+
		"\f\7\16\7\u008a\13\7\3\b\3\b\3\b\3\b\7\b\u0090\n\b\f\b\16\b\u0093\13\b"+
		"\3\b\3\b\3\t\3\t\3\t\3\t\7\t\u009b\n\t\f\t\16\t\u009e\13\t\3\t\3\t\3\n"+
		"\3\n\3\n\3\n\3\n\5\n\u00a7\n\n\3\13\6\13\u00aa\n\13\r\13\16\13\u00ab\3"+
		"\13\3\13\3\u0091\2\f\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\3\2"+
		"\f\4\2DDdd\5\2\62;C\\c|\4\2ZZzz\3\2\62;\3\2c|\6\2\62;C\\aac|\3\2C\\\4"+
		"\2\f\f\17\17\7\2*\61<?``}}\177\177\5\2\13\f\17\17\"\"\2\u00cb\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\3d\3\2\2\2\5f\3\2\2\2"+
		"\7n\3\2\2\2\tv\3\2\2\2\13}\3\2\2\2\r\u0084\3\2\2\2\17\u008b\3\2\2\2\21"+
		"\u0096\3\2\2\2\23\u00a6\3\2\2\2\25\u00a9\3\2\2\2\27\30\7c\2\2\30\31\7"+
		"p\2\2\31e\7f\2\2\32\33\7d\2\2\33\34\7q\2\2\34\35\7q\2\2\35e\7n\2\2\36"+
		"\37\7e\2\2\37 \7n\2\2 !\7c\2\2!\"\7u\2\2\"e\7u\2\2#$\7f\2\2$e\7q\2\2%"+
		"&\7g\2\2&\'\7n\2\2\'(\7u\2\2(e\7g\2\2)*\7g\2\2*+\7z\2\2+,\7v\2\2,-\7g"+
		"\2\2-.\7p\2\2./\7f\2\2/e\7u\2\2\60\61\7h\2\2\61\62\7c\2\2\62\63\7n\2\2"+
		"\63\64\7u\2\2\64e\7g\2\2\65\66\7k\2\2\66e\7h\2\2\678\7k\2\28e\7p\2\29"+
		":\7k\2\2:;\7p\2\2;<\7v\2\2<=\7\65\2\2=e\7\64\2\2>?\7k\2\2?@\7u\2\2@A\7"+
		"p\2\2AB\7w\2\2BC\7n\2\2Ce\7n\2\2DE\7n\2\2EF\7g\2\2Fe\7v\2\2GH\7p\2\2H"+
		"I\7g\2\2Ie\7y\2\2JK\7p\2\2KL\7q\2\2Le\7v\2\2MN\7u\2\2NO\7v\2\2OP\7t\2"+
		"\2PQ\7k\2\2QR\7p\2\2Re\7i\2\2ST\7v\2\2TU\7j\2\2UV\7g\2\2Ve\7p\2\2WX\7"+
		"v\2\2XY\7t\2\2YZ\7w\2\2Ze\7g\2\2[\\\7w\2\2\\]\7p\2\2]^\7k\2\2^e\7v\2\2"+
		"_`\7y\2\2`a\7j\2\2ab\7k\2\2bc\7n\2\2ce\7g\2\2d\27\3\2\2\2d\32\3\2\2\2"+
		"d\36\3\2\2\2d#\3\2\2\2d%\3\2\2\2d)\3\2\2\2d\60\3\2\2\2d\65\3\2\2\2d\67"+
		"\3\2\2\2d9\3\2\2\2d>\3\2\2\2dD\3\2\2\2dG\3\2\2\2dJ\3\2\2\2dM\3\2\2\2d"+
		"S\3\2\2\2dW\3\2\2\2d[\3\2\2\2d_\3\2\2\2e\4\3\2\2\2fg\7\62\2\2gk\t\2\2"+
		"\2hj\t\3\2\2ih\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2l\6\3\2\2\2mk\3\2"+
		"\2\2no\7\62\2\2os\t\4\2\2pr\t\3\2\2qp\3\2\2\2ru\3\2\2\2sq\3\2\2\2st\3"+
		"\2\2\2t\b\3\2\2\2us\3\2\2\2vz\t\5\2\2wy\t\3\2\2xw\3\2\2\2y|\3\2\2\2zx"+
		"\3\2\2\2z{\3\2\2\2{\n\3\2\2\2|z\3\2\2\2}\u0081\t\6\2\2~\u0080\t\7\2\2"+
		"\177~\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2"+
		"\2\u0082\f\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0088\t\b\2\2\u0085\u0087"+
		"\t\7\2\2\u0086\u0085\3\2\2\2\u0087\u008a\3\2\2\2\u0088\u0086\3\2\2\2\u0088"+
		"\u0089\3\2\2\2\u0089\16\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u0091\7$\2\2"+
		"\u008c\u008d\7^\2\2\u008d\u0090\7$\2\2\u008e\u0090\13\2\2\2\u008f\u008c"+
		"\3\2\2\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u0092\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u0094\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7$"+
		"\2\2\u0095\20\3\2\2\2\u0096\u0097\7\61\2\2\u0097\u0098\7\61\2\2\u0098"+
		"\u009c\3\2\2\2\u0099\u009b\n\t\2\2\u009a\u0099\3\2\2\2\u009b\u009e\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e"+
		"\u009c\3\2\2\2\u009f\u00a0\b\t\2\2\u00a0\22\3\2\2\2\u00a1\u00a7\t\n\2"+
		"\2\u00a2\u00a3\7>\2\2\u00a3\u00a7\7?\2\2\u00a4\u00a5\7>\2\2\u00a5\u00a7"+
		"\7/\2\2\u00a6\u00a1\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7"+
		"\24\3\2\2\2\u00a8\u00aa\t\13\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ab\3\2\2"+
		"\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\u00ae"+
		"\b\13\2\2\u00ae\26\3\2\2\2\16\2dksz\u0081\u0088\u008f\u0091\u009c\u00a6"+
		"\u00ab\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}