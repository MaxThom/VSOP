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
		KEYWORD=1, OPERATOR=2, INTEGER_BIN=3, INTEGER_HEX=4, INTEGER_DEC=5, OBJECT_IDENTIFIER=6, 
		TYPE_IDENTIFIER=7, STRING=8, WS=9;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"KEYWORD", "OPERATOR", "INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", 
		"TYPE_IDENTIFIER", "STRING", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "KEYWORD", "OPERATOR", "INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", 
		"OBJECT_IDENTIFIER", "TYPE_IDENTIFIER", "STRING", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\13\u009c\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2c\n\2\3\3\3\3\3\3\3\3\3\3\5\3j\n\3\3\4\3"+
		"\4\3\4\6\4o\n\4\r\4\16\4p\3\5\3\5\3\5\6\5v\n\5\r\5\16\5w\3\6\3\6\6\6|"+
		"\n\6\r\6\16\6}\3\7\3\7\7\7\u0082\n\7\f\7\16\7\u0085\13\7\3\b\3\b\7\b\u0089"+
		"\n\b\f\b\16\b\u008c\13\b\3\t\3\t\6\t\u0090\n\t\r\t\16\t\u0091\3\t\3\t"+
		"\3\n\6\n\u0097\n\n\r\n\16\n\u0098\3\n\3\n\2\2\13\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\3\2\f\7\2*\61<?``}}\177\177\4\2DDdd\5\2\62;C\\c|"+
		"\4\2ZZzz\3\2\62;\3\2c|\6\2\62;C\\aac|\3\2C\\\3\2$$\5\2\13\f\17\17\"\""+
		"\2\u00b6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\3b\3\2\2\2\5i\3\2"+
		"\2\2\7k\3\2\2\2\tr\3\2\2\2\13y\3\2\2\2\r\177\3\2\2\2\17\u0086\3\2\2\2"+
		"\21\u008d\3\2\2\2\23\u0096\3\2\2\2\25\26\7c\2\2\26\27\7p\2\2\27c\7f\2"+
		"\2\30\31\7d\2\2\31\32\7q\2\2\32\33\7q\2\2\33c\7n\2\2\34\35\7e\2\2\35\36"+
		"\7n\2\2\36\37\7c\2\2\37 \7u\2\2 c\7u\2\2!\"\7f\2\2\"c\7q\2\2#$\7g\2\2"+
		"$%\7n\2\2%&\7u\2\2&c\7g\2\2\'(\7g\2\2()\7z\2\2)*\7v\2\2*+\7g\2\2+,\7p"+
		"\2\2,-\7f\2\2-c\7u\2\2./\7h\2\2/\60\7c\2\2\60\61\7n\2\2\61\62\7u\2\2\62"+
		"c\7g\2\2\63\64\7k\2\2\64c\7h\2\2\65\66\7k\2\2\66c\7p\2\2\678\7k\2\289"+
		"\7p\2\29:\7v\2\2:;\7\65\2\2;c\7\64\2\2<=\7k\2\2=>\7u\2\2>?\7p\2\2?@\7"+
		"w\2\2@A\7n\2\2Ac\7n\2\2BC\7n\2\2CD\7g\2\2Dc\7v\2\2EF\7p\2\2FG\7g\2\2G"+
		"c\7y\2\2HI\7p\2\2IJ\7q\2\2Jc\7v\2\2KL\7u\2\2LM\7v\2\2MN\7t\2\2NO\7k\2"+
		"\2OP\7p\2\2Pc\7i\2\2QR\7v\2\2RS\7j\2\2ST\7g\2\2Tc\7p\2\2UV\7v\2\2VW\7"+
		"t\2\2WX\7w\2\2Xc\7g\2\2YZ\7w\2\2Z[\7p\2\2[\\\7k\2\2\\c\7v\2\2]^\7y\2\2"+
		"^_\7j\2\2_`\7k\2\2`a\7n\2\2ac\7g\2\2b\25\3\2\2\2b\30\3\2\2\2b\34\3\2\2"+
		"\2b!\3\2\2\2b#\3\2\2\2b\'\3\2\2\2b.\3\2\2\2b\63\3\2\2\2b\65\3\2\2\2b\67"+
		"\3\2\2\2b<\3\2\2\2bB\3\2\2\2bE\3\2\2\2bH\3\2\2\2bK\3\2\2\2bQ\3\2\2\2b"+
		"U\3\2\2\2bY\3\2\2\2b]\3\2\2\2c\4\3\2\2\2dj\t\2\2\2ef\7>\2\2fj\7?\2\2g"+
		"h\7>\2\2hj\7/\2\2id\3\2\2\2ie\3\2\2\2ig\3\2\2\2j\6\3\2\2\2kl\7\62\2\2"+
		"ln\t\3\2\2mo\t\4\2\2nm\3\2\2\2op\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\b\3\2\2"+
		"\2rs\7\62\2\2su\t\5\2\2tv\t\4\2\2ut\3\2\2\2vw\3\2\2\2wu\3\2\2\2wx\3\2"+
		"\2\2x\n\3\2\2\2y{\t\6\2\2z|\t\4\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3"+
		"\2\2\2~\f\3\2\2\2\177\u0083\t\7\2\2\u0080\u0082\t\b\2\2\u0081\u0080\3"+
		"\2\2\2\u0082\u0085\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084"+
		"\16\3\2\2\2\u0085\u0083\3\2\2\2\u0086\u008a\t\t\2\2\u0087\u0089\t\b\2"+
		"\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a\u008b"+
		"\3\2\2\2\u008b\20\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008f\7$\2\2\u008e"+
		"\u0090\n\n\2\2\u008f\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u008f\3\2"+
		"\2\2\u0091\u0092\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0094\7$\2\2\u0094"+
		"\22\3\2\2\2\u0095\u0097\t\13\2\2\u0096\u0095\3\2\2\2\u0097\u0098\3\2\2"+
		"\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009b"+
		"\b\n\2\2\u009b\24\3\2\2\2\f\2bipw}\u0083\u008a\u0091\u0098\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}