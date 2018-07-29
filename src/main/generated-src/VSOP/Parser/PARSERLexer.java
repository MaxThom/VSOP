// Generated from Parser\PARSER.g4 by ANTLR 4.7.1
package VSOP.Parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PARSERLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, ARITHMETIC_OPERATOR=22, CONDITIONAL_OPERATOR=23, 
		MULTILINE_OPEN_COMMENT=24, MULTILINE_CLOSE_COMMENT=25, MULTILINE_COMMENT=26, 
		INTEGER_BIN=27, INTEGER_HEX=28, INTEGER_DEC=29, OBJECT_IDENTIFIER=30, 
		TYPE_IDENTIFIER=31, STRING=32, SINGLE_LINE_COMMENT=33, WS=34;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "ARITHMETIC_OPERATOR", "CONDITIONAL_OPERATOR", 
		"MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", "MULTILINE_COMMENT", 
		"INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", "TYPE_IDENTIFIER", 
		"STRING", "SINGLE_LINE_COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'class'", "'extends'", "'{'", "'}'", "'('", "','", "')'", "':'", 
		"'<-'", "';'", "'while'", "'do'", "'if'", "'then'", "'else'", "'bool'", 
		"'int32'", "'string'", "'unit'", "'true'", "'false'", null, null, "'(*'", 
		"'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, "ARITHMETIC_OPERATOR", 
		"CONDITIONAL_OPERATOR", "MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", 
		"MULTILINE_COMMENT", "INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", 
		"TYPE_IDENTIFIER", "STRING", "SINGLE_LINE_COMMENT", "WS"
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


	public PARSERLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "PARSER.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2$\u00f8\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\30\3\30\3\30\5\30\u00a4\n\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\7\33\u00b0\n\33\f\33\16\33\u00b3\13\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\7\34\u00bb\n\34\f\34\16\34\u00be\13\34\3\35\3\35\3\35"+
		"\7\35\u00c3\n\35\f\35\16\35\u00c6\13\35\3\36\3\36\7\36\u00ca\n\36\f\36"+
		"\16\36\u00cd\13\36\3\37\3\37\7\37\u00d1\n\37\f\37\16\37\u00d4\13\37\3"+
		" \3 \7 \u00d8\n \f \16 \u00db\13 \3!\3!\3!\3!\7!\u00e1\n!\f!\16!\u00e4"+
		"\13!\3!\5!\u00e7\n!\3\"\3\"\3\"\3\"\7\"\u00ed\n\"\f\"\16\"\u00f0\13\""+
		"\3#\6#\u00f3\n#\r#\16#\u00f4\3#\3#\4\u00b1\u00e2\2$\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$\3\2\r\6"+
		"\2,-//\61\61``\4\2DDdd\5\2\62;C\\c|\4\2ZZzz\3\2\62;\3\2c|\6\2\62;C\\a"+
		"ac|\3\2C\\\3\3$$\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0102\2\3\3\2\2\2"+
		"\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2"+
		"\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2"+
		"\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2"+
		"\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2"+
		"\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2"+
		"\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\3G\3\2\2\2\5M\3\2\2\2"+
		"\7U\3\2\2\2\tW\3\2\2\2\13Y\3\2\2\2\r[\3\2\2\2\17]\3\2\2\2\21_\3\2\2\2"+
		"\23a\3\2\2\2\25d\3\2\2\2\27f\3\2\2\2\31l\3\2\2\2\33o\3\2\2\2\35r\3\2\2"+
		"\2\37w\3\2\2\2!|\3\2\2\2#\u0081\3\2\2\2%\u0087\3\2\2\2\'\u008e\3\2\2\2"+
		")\u0093\3\2\2\2+\u0098\3\2\2\2-\u009e\3\2\2\2/\u00a3\3\2\2\2\61\u00a5"+
		"\3\2\2\2\63\u00a8\3\2\2\2\65\u00ab\3\2\2\2\67\u00b7\3\2\2\29\u00bf\3\2"+
		"\2\2;\u00c7\3\2\2\2=\u00ce\3\2\2\2?\u00d5\3\2\2\2A\u00dc\3\2\2\2C\u00e8"+
		"\3\2\2\2E\u00f2\3\2\2\2GH\7e\2\2HI\7n\2\2IJ\7c\2\2JK\7u\2\2KL\7u\2\2L"+
		"\4\3\2\2\2MN\7g\2\2NO\7z\2\2OP\7v\2\2PQ\7g\2\2QR\7p\2\2RS\7f\2\2ST\7u"+
		"\2\2T\6\3\2\2\2UV\7}\2\2V\b\3\2\2\2WX\7\177\2\2X\n\3\2\2\2YZ\7*\2\2Z\f"+
		"\3\2\2\2[\\\7.\2\2\\\16\3\2\2\2]^\7+\2\2^\20\3\2\2\2_`\7<\2\2`\22\3\2"+
		"\2\2ab\7>\2\2bc\7/\2\2c\24\3\2\2\2de\7=\2\2e\26\3\2\2\2fg\7y\2\2gh\7j"+
		"\2\2hi\7k\2\2ij\7n\2\2jk\7g\2\2k\30\3\2\2\2lm\7f\2\2mn\7q\2\2n\32\3\2"+
		"\2\2op\7k\2\2pq\7h\2\2q\34\3\2\2\2rs\7v\2\2st\7j\2\2tu\7g\2\2uv\7p\2\2"+
		"v\36\3\2\2\2wx\7g\2\2xy\7n\2\2yz\7u\2\2z{\7g\2\2{ \3\2\2\2|}\7d\2\2}~"+
		"\7q\2\2~\177\7q\2\2\177\u0080\7n\2\2\u0080\"\3\2\2\2\u0081\u0082\7k\2"+
		"\2\u0082\u0083\7p\2\2\u0083\u0084\7v\2\2\u0084\u0085\7\65\2\2\u0085\u0086"+
		"\7\64\2\2\u0086$\3\2\2\2\u0087\u0088\7u\2\2\u0088\u0089\7v\2\2\u0089\u008a"+
		"\7t\2\2\u008a\u008b\7k\2\2\u008b\u008c\7p\2\2\u008c\u008d\7i\2\2\u008d"+
		"&\3\2\2\2\u008e\u008f\7w\2\2\u008f\u0090\7p\2\2\u0090\u0091\7k\2\2\u0091"+
		"\u0092\7v\2\2\u0092(\3\2\2\2\u0093\u0094\7v\2\2\u0094\u0095\7t\2\2\u0095"+
		"\u0096\7w\2\2\u0096\u0097\7g\2\2\u0097*\3\2\2\2\u0098\u0099\7h\2\2\u0099"+
		"\u009a\7c\2\2\u009a\u009b\7n\2\2\u009b\u009c\7u\2\2\u009c\u009d\7g\2\2"+
		"\u009d,\3\2\2\2\u009e\u009f\t\2\2\2\u009f.\3\2\2\2\u00a0\u00a4\4>?\2\u00a1"+
		"\u00a2\7>\2\2\u00a2\u00a4\7?\2\2\u00a3\u00a0\3\2\2\2\u00a3\u00a1\3\2\2"+
		"\2\u00a4\60\3\2\2\2\u00a5\u00a6\7*\2\2\u00a6\u00a7\7,\2\2\u00a7\62\3\2"+
		"\2\2\u00a8\u00a9\7,\2\2\u00a9\u00aa\7+\2\2\u00aa\64\3\2\2\2\u00ab\u00ac"+
		"\7*\2\2\u00ac\u00ad\7,\2\2\u00ad\u00b1\3\2\2\2\u00ae\u00b0\13\2\2\2\u00af"+
		"\u00ae\3\2\2\2\u00b0\u00b3\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b1\u00af\3\2"+
		"\2\2\u00b2\u00b4\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b4\u00b5\7,\2\2\u00b5"+
		"\u00b6\7+\2\2\u00b6\66\3\2\2\2\u00b7\u00b8\7\62\2\2\u00b8\u00bc\t\3\2"+
		"\2\u00b9\u00bb\t\4\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00ba"+
		"\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd8\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf"+
		"\u00c0\7\62\2\2\u00c0\u00c4\t\5\2\2\u00c1\u00c3\t\4\2\2\u00c2\u00c1\3"+
		"\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		":\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00cb\t\6\2\2\u00c8\u00ca\t\4\2\2"+
		"\u00c9\u00c8\3\2\2\2\u00ca\u00cd\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc"+
		"\3\2\2\2\u00cc<\3\2\2\2\u00cd\u00cb\3\2\2\2\u00ce\u00d2\t\7\2\2\u00cf"+
		"\u00d1\t\b\2\2\u00d0\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2"+
		"\2\2\u00d2\u00d3\3\2\2\2\u00d3>\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d9"+
		"\t\t\2\2\u00d6\u00d8\t\b\2\2\u00d7\u00d6\3\2\2\2\u00d8\u00db\3\2\2\2\u00d9"+
		"\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da@\3\2\2\2\u00db\u00d9\3\2\2\2"+
		"\u00dc\u00e2\7$\2\2\u00dd\u00de\7^\2\2\u00de\u00e1\7$\2\2\u00df\u00e1"+
		"\13\2\2\2\u00e0\u00dd\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e4\3\2\2\2"+
		"\u00e2\u00e3\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4\u00e2"+
		"\3\2\2\2\u00e5\u00e7\t\n\2\2\u00e6\u00e5\3\2\2\2\u00e7B\3\2\2\2\u00e8"+
		"\u00e9\7\61\2\2\u00e9\u00ea\7\61\2\2\u00ea\u00ee\3\2\2\2\u00eb\u00ed\n"+
		"\13\2\2\u00ec\u00eb\3\2\2\2\u00ed\u00f0\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00efD\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f1\u00f3\t\f\2\2"+
		"\u00f2\u00f1\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5"+
		"\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f7\b#\2\2\u00f7F\3\2\2\2\17\2\u00a3"+
		"\u00b1\u00bc\u00c4\u00cb\u00d2\u00d9\u00e0\u00e2\u00e6\u00ee\u00f4\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}