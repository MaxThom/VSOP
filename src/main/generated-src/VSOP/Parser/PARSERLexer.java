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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, UN_OPERATOR=26, FACTOR_OPERATOR=27, TERM_OPERATOR=28, AND_OPERATOR=29, 
		CONDITIONAL_OPERATOR=30, NEGATIVE_OPERATOR=31, VOID_OPERATOR=32, MULTILINE_OPEN_COMMENT=33, 
		MULTILINE_CLOSE_COMMENT=34, MULTILINE_COMMENT=35, INTEGER_BIN=36, INTEGER_HEX=37, 
		INTEGER_DEC=38, OBJECT_IDENTIFIER=39, TYPE_IDENTIFIER=40, STRING=41, SINGLE_LINE_COMMENT=42, 
		WS=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"UN_OPERATOR", "FACTOR_OPERATOR", "TERM_OPERATOR", "AND_OPERATOR", "CONDITIONAL_OPERATOR", 
		"NEGATIVE_OPERATOR", "VOID_OPERATOR", "MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", 
		"MULTILINE_COMMENT", "INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", 
		"TYPE_IDENTIFIER", "STRING", "SINGLE_LINE_COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "';'", "'}'", "'class'", "'extends'", "','", 
		"':'", "'<-'", "'.'", "'while'", "'do'", "'if'", "'then'", "'else'", "'let'", 
		"'in'", "'new'", "'bool'", "'int32'", "'string'", "'unit'", "'true'", 
		"'false'", null, "'d zzdqasdw'", null, "'and'", null, "'-'", "'()'", "'(*'", 
		"'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "UN_OPERATOR", "FACTOR_OPERATOR", "TERM_OPERATOR", "AND_OPERATOR", 
		"CONDITIONAL_OPERATOR", "NEGATIVE_OPERATOR", "VOID_OPERATOR", "MULTILINE_OPEN_COMMENT", 
		"MULTILINE_CLOSE_COMMENT", "MULTILINE_COMMENT", "INTEGER_BIN", "INTEGER_HEX", 
		"INTEGER_DEC", "OBJECT_IDENTIFIER", "TYPE_IDENTIFIER", "STRING", "SINGLE_LINE_COMMENT", 
		"WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2-\u0136\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\33\3\33\3\33\3\33\3\33\5\33\u00c7\n\33\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37"+
		"\5\37\u00dd\n\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\7$\u00ee"+
		"\n$\f$\16$\u00f1\13$\3$\3$\3$\3%\3%\3%\7%\u00f9\n%\f%\16%\u00fc\13%\3"+
		"&\3&\3&\7&\u0101\n&\f&\16&\u0104\13&\3\'\3\'\7\'\u0108\n\'\f\'\16\'\u010b"+
		"\13\'\3(\3(\7(\u010f\n(\f(\16(\u0112\13(\3)\3)\7)\u0116\n)\f)\16)\u0119"+
		"\13)\3*\3*\3*\3*\7*\u011f\n*\f*\16*\u0122\13*\3*\5*\u0125\n*\3+\3+\3+"+
		"\3+\7+\u012b\n+\f+\16+\u012e\13+\3,\6,\u0131\n,\r,\16,\u0132\3,\3,\4\u00ef"+
		"\u0120\2-\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-\3\2\r\5\2,-\61\61``\4\2DDdd"+
		"\5\2\62;C\\c|\4\2ZZzz\3\2\62;\3\2c|\6\2\62;C\\aac|\3\2C\\\3\3$$\4\2\f"+
		"\f\17\17\5\2\13\f\17\17\"\"\2\u0141\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\3Y\3\2\2\2\5["+
		"\3\2\2\2\7]\3\2\2\2\t_\3\2\2\2\13a\3\2\2\2\rc\3\2\2\2\17i\3\2\2\2\21q"+
		"\3\2\2\2\23s\3\2\2\2\25u\3\2\2\2\27x\3\2\2\2\31z\3\2\2\2\33\u0080\3\2"+
		"\2\2\35\u0083\3\2\2\2\37\u0086\3\2\2\2!\u008b\3\2\2\2#\u0090\3\2\2\2%"+
		"\u0094\3\2\2\2\'\u0097\3\2\2\2)\u009b\3\2\2\2+\u00a0\3\2\2\2-\u00a6\3"+
		"\2\2\2/\u00ad\3\2\2\2\61\u00b2\3\2\2\2\63\u00b7\3\2\2\2\65\u00c6\3\2\2"+
		"\2\67\u00c8\3\2\2\29\u00d3\3\2\2\2;\u00d5\3\2\2\2=\u00dc\3\2\2\2?\u00de"+
		"\3\2\2\2A\u00e0\3\2\2\2C\u00e3\3\2\2\2E\u00e6\3\2\2\2G\u00e9\3\2\2\2I"+
		"\u00f5\3\2\2\2K\u00fd\3\2\2\2M\u0105\3\2\2\2O\u010c\3\2\2\2Q\u0113\3\2"+
		"\2\2S\u011a\3\2\2\2U\u0126\3\2\2\2W\u0130\3\2\2\2YZ\7*\2\2Z\4\3\2\2\2"+
		"[\\\7+\2\2\\\6\3\2\2\2]^\7}\2\2^\b\3\2\2\2_`\7=\2\2`\n\3\2\2\2ab\7\177"+
		"\2\2b\f\3\2\2\2cd\7e\2\2de\7n\2\2ef\7c\2\2fg\7u\2\2gh\7u\2\2h\16\3\2\2"+
		"\2ij\7g\2\2jk\7z\2\2kl\7v\2\2lm\7g\2\2mn\7p\2\2no\7f\2\2op\7u\2\2p\20"+
		"\3\2\2\2qr\7.\2\2r\22\3\2\2\2st\7<\2\2t\24\3\2\2\2uv\7>\2\2vw\7/\2\2w"+
		"\26\3\2\2\2xy\7\60\2\2y\30\3\2\2\2z{\7y\2\2{|\7j\2\2|}\7k\2\2}~\7n\2\2"+
		"~\177\7g\2\2\177\32\3\2\2\2\u0080\u0081\7f\2\2\u0081\u0082\7q\2\2\u0082"+
		"\34\3\2\2\2\u0083\u0084\7k\2\2\u0084\u0085\7h\2\2\u0085\36\3\2\2\2\u0086"+
		"\u0087\7v\2\2\u0087\u0088\7j\2\2\u0088\u0089\7g\2\2\u0089\u008a\7p\2\2"+
		"\u008a \3\2\2\2\u008b\u008c\7g\2\2\u008c\u008d\7n\2\2\u008d\u008e\7u\2"+
		"\2\u008e\u008f\7g\2\2\u008f\"\3\2\2\2\u0090\u0091\7n\2\2\u0091\u0092\7"+
		"g\2\2\u0092\u0093\7v\2\2\u0093$\3\2\2\2\u0094\u0095\7k\2\2\u0095\u0096"+
		"\7p\2\2\u0096&\3\2\2\2\u0097\u0098\7p\2\2\u0098\u0099\7g\2\2\u0099\u009a"+
		"\7y\2\2\u009a(\3\2\2\2\u009b\u009c\7d\2\2\u009c\u009d\7q\2\2\u009d\u009e"+
		"\7q\2\2\u009e\u009f\7n\2\2\u009f*\3\2\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2"+
		"\7p\2\2\u00a2\u00a3\7v\2\2\u00a3\u00a4\7\65\2\2\u00a4\u00a5\7\64\2\2\u00a5"+
		",\3\2\2\2\u00a6\u00a7\7u\2\2\u00a7\u00a8\7v\2\2\u00a8\u00a9\7t\2\2\u00a9"+
		"\u00aa\7k\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7i\2\2\u00ac.\3\2\2\2\u00ad"+
		"\u00ae\7w\2\2\u00ae\u00af\7p\2\2\u00af\u00b0\7k\2\2\u00b0\u00b1\7v\2\2"+
		"\u00b1\60\3\2\2\2\u00b2\u00b3\7v\2\2\u00b3\u00b4\7t\2\2\u00b4\u00b5\7"+
		"w\2\2\u00b5\u00b6\7g\2\2\u00b6\62\3\2\2\2\u00b7\u00b8\7h\2\2\u00b8\u00b9"+
		"\7c\2\2\u00b9\u00ba\7n\2\2\u00ba\u00bb\7u\2\2\u00bb\u00bc\7g\2\2\u00bc"+
		"\64\3\2\2\2\u00bd\u00be\7p\2\2\u00be\u00bf\7q\2\2\u00bf\u00c7\7v\2\2\u00c0"+
		"\u00c1\7k\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c3\7p\2\2\u00c3\u00c4\7w\2\2"+
		"\u00c4\u00c5\7n\2\2\u00c5\u00c7\7n\2\2\u00c6\u00bd\3\2\2\2\u00c6\u00c0"+
		"\3\2\2\2\u00c7\66\3\2\2\2\u00c8\u00c9\7f\2\2\u00c9\u00ca\7\"\2\2\u00ca"+
		"\u00cb\7|\2\2\u00cb\u00cc\7|\2\2\u00cc\u00cd\7f\2\2\u00cd\u00ce\7s\2\2"+
		"\u00ce\u00cf\7c\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7f\2\2\u00d1\u00d2"+
		"\7y\2\2\u00d28\3\2\2\2\u00d3\u00d4\t\2\2\2\u00d4:\3\2\2\2\u00d5\u00d6"+
		"\7c\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7f\2\2\u00d8<\3\2\2\2\u00d9\u00dd"+
		"\4>?\2\u00da\u00db\7>\2\2\u00db\u00dd\7?\2\2\u00dc\u00d9\3\2\2\2\u00dc"+
		"\u00da\3\2\2\2\u00dd>\3\2\2\2\u00de\u00df\7/\2\2\u00df@\3\2\2\2\u00e0"+
		"\u00e1\7*\2\2\u00e1\u00e2\7+\2\2\u00e2B\3\2\2\2\u00e3\u00e4\7*\2\2\u00e4"+
		"\u00e5\7,\2\2\u00e5D\3\2\2\2\u00e6\u00e7\7,\2\2\u00e7\u00e8\7+\2\2\u00e8"+
		"F\3\2\2\2\u00e9\u00ea\7*\2\2\u00ea\u00eb\7,\2\2\u00eb\u00ef\3\2\2\2\u00ec"+
		"\u00ee\13\2\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00f0\3"+
		"\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2"+
		"\u00f3\7,\2\2\u00f3\u00f4\7+\2\2\u00f4H\3\2\2\2\u00f5\u00f6\7\62\2\2\u00f6"+
		"\u00fa\t\3\2\2\u00f7\u00f9\t\4\2\2\u00f8\u00f7\3\2\2\2\u00f9\u00fc\3\2"+
		"\2\2\u00fa\u00f8\3\2\2\2\u00fa\u00fb\3\2\2\2\u00fbJ\3\2\2\2\u00fc\u00fa"+
		"\3\2\2\2\u00fd\u00fe\7\62\2\2\u00fe\u0102\t\5\2\2\u00ff\u0101\t\4\2\2"+
		"\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0103"+
		"\3\2\2\2\u0103L\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0109\t\6\2\2\u0106"+
		"\u0108\t\4\2\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2"+
		"\2\2\u0109\u010a\3\2\2\2\u010aN\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u0110"+
		"\t\7\2\2\u010d\u010f\t\b\2\2\u010e\u010d\3\2\2\2\u010f\u0112\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111P\3\2\2\2\u0112\u0110\3\2\2\2"+
		"\u0113\u0117\t\t\2\2\u0114\u0116\t\b\2\2\u0115\u0114\3\2\2\2\u0116\u0119"+
		"\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118R\3\2\2\2\u0119"+
		"\u0117\3\2\2\2\u011a\u0120\7$\2\2\u011b\u011c\7^\2\2\u011c\u011f\7$\2"+
		"\2\u011d\u011f\13\2\2\2\u011e\u011b\3\2\2\2\u011e\u011d\3\2\2\2\u011f"+
		"\u0122\3\2\2\2\u0120\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0124\3\2"+
		"\2\2\u0122\u0120\3\2\2\2\u0123\u0125\t\n\2\2\u0124\u0123\3\2\2\2\u0125"+
		"T\3\2\2\2\u0126\u0127\7\61\2\2\u0127\u0128\7\61\2\2\u0128\u012c\3\2\2"+
		"\2\u0129\u012b\n\13\2\2\u012a\u0129\3\2\2\2\u012b\u012e\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012dV\3\2\2\2\u012e\u012c\3\2\2\2"+
		"\u012f\u0131\t\f\2\2\u0130\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0130"+
		"\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\3\2\2\2\u0134\u0135\b,\2\2\u0135"+
		"X\3\2\2\2\20\2\u00c6\u00dc\u00ef\u00fa\u0102\u0109\u0110\u0117\u011e\u0120"+
		"\u0124\u012c\u0132\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}