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
		CONDITIONAL_OPERATOR=30, NEGATIVE_OPERATOR=31, MULTILINE_OPEN_COMMENT=32, 
		MULTILINE_CLOSE_COMMENT=33, MULTILINE_COMMENT=34, INTEGER_BIN=35, INTEGER_HEX=36, 
		INTEGER_DEC=37, OBJECT_IDENTIFIER=38, TYPE_IDENTIFIER=39, STRING=40, SINGLE_LINE_COMMENT=41, 
		WS=42;
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
		"NEGATIVE_OPERATOR", "MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", 
		"MULTILINE_COMMENT", "INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", 
		"TYPE_IDENTIFIER", "STRING", "SINGLE_LINE_COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "';'", "'}'", "'class'", "'extends'", "','", 
		"':'", "'<-'", "'.'", "'while'", "'do'", "'if'", "'then'", "'else'", "'let'", 
		"'in'", "'new'", "'bool'", "'int32'", "'string'", "'unit'", "'true'", 
		"'false'", null, null, "'+'", "'and'", null, "'-'", "'(*'", "'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "UN_OPERATOR", "FACTOR_OPERATOR", "TERM_OPERATOR", "AND_OPERATOR", 
		"CONDITIONAL_OPERATOR", "NEGATIVE_OPERATOR", "MULTILINE_OPEN_COMMENT", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u0128\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3"+
		"\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3"+
		"\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\33\5\33\u00c5\n\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36"+
		"\3\36\3\37\3\37\3\37\5\37\u00d2\n\37\3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3#"+
		"\3#\3#\7#\u00e0\n#\f#\16#\u00e3\13#\3#\3#\3#\3$\3$\3$\7$\u00eb\n$\f$\16"+
		"$\u00ee\13$\3%\3%\3%\7%\u00f3\n%\f%\16%\u00f6\13%\3&\3&\7&\u00fa\n&\f"+
		"&\16&\u00fd\13&\3\'\3\'\7\'\u0101\n\'\f\'\16\'\u0104\13\'\3(\3(\7(\u0108"+
		"\n(\f(\16(\u010b\13(\3)\3)\3)\3)\7)\u0111\n)\f)\16)\u0114\13)\3)\5)\u0117"+
		"\n)\3*\3*\3*\3*\7*\u011d\n*\f*\16*\u0120\13*\3+\6+\u0123\n+\r+\16+\u0124"+
		"\3+\3+\4\u00e1\u0112\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,\3\2\r\5\2,,\61\61"+
		"``\4\2DDdd\5\2\62;C\\c|\4\2ZZzz\3\2\62;\3\2c|\6\2\62;C\\aac|\3\2C\\\3"+
		"\3$$\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0133\2\3\3\2\2\2\2\5\3\2\2\2"+
		"\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3"+
		"\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2"+
		"\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2"+
		"\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2"+
		"\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2"+
		"\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2"+
		"\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5Y"+
		"\3\2\2\2\7[\3\2\2\2\t]\3\2\2\2\13_\3\2\2\2\ra\3\2\2\2\17g\3\2\2\2\21o"+
		"\3\2\2\2\23q\3\2\2\2\25s\3\2\2\2\27v\3\2\2\2\31x\3\2\2\2\33~\3\2\2\2\35"+
		"\u0081\3\2\2\2\37\u0084\3\2\2\2!\u0089\3\2\2\2#\u008e\3\2\2\2%\u0092\3"+
		"\2\2\2\'\u0095\3\2\2\2)\u0099\3\2\2\2+\u009e\3\2\2\2-\u00a4\3\2\2\2/\u00ab"+
		"\3\2\2\2\61\u00b0\3\2\2\2\63\u00b5\3\2\2\2\65\u00c4\3\2\2\2\67\u00c6\3"+
		"\2\2\29\u00c8\3\2\2\2;\u00ca\3\2\2\2=\u00d1\3\2\2\2?\u00d3\3\2\2\2A\u00d5"+
		"\3\2\2\2C\u00d8\3\2\2\2E\u00db\3\2\2\2G\u00e7\3\2\2\2I\u00ef\3\2\2\2K"+
		"\u00f7\3\2\2\2M\u00fe\3\2\2\2O\u0105\3\2\2\2Q\u010c\3\2\2\2S\u0118\3\2"+
		"\2\2U\u0122\3\2\2\2WX\7*\2\2X\4\3\2\2\2YZ\7+\2\2Z\6\3\2\2\2[\\\7}\2\2"+
		"\\\b\3\2\2\2]^\7=\2\2^\n\3\2\2\2_`\7\177\2\2`\f\3\2\2\2ab\7e\2\2bc\7n"+
		"\2\2cd\7c\2\2de\7u\2\2ef\7u\2\2f\16\3\2\2\2gh\7g\2\2hi\7z\2\2ij\7v\2\2"+
		"jk\7g\2\2kl\7p\2\2lm\7f\2\2mn\7u\2\2n\20\3\2\2\2op\7.\2\2p\22\3\2\2\2"+
		"qr\7<\2\2r\24\3\2\2\2st\7>\2\2tu\7/\2\2u\26\3\2\2\2vw\7\60\2\2w\30\3\2"+
		"\2\2xy\7y\2\2yz\7j\2\2z{\7k\2\2{|\7n\2\2|}\7g\2\2}\32\3\2\2\2~\177\7f"+
		"\2\2\177\u0080\7q\2\2\u0080\34\3\2\2\2\u0081\u0082\7k\2\2\u0082\u0083"+
		"\7h\2\2\u0083\36\3\2\2\2\u0084\u0085\7v\2\2\u0085\u0086\7j\2\2\u0086\u0087"+
		"\7g\2\2\u0087\u0088\7p\2\2\u0088 \3\2\2\2\u0089\u008a\7g\2\2\u008a\u008b"+
		"\7n\2\2\u008b\u008c\7u\2\2\u008c\u008d\7g\2\2\u008d\"\3\2\2\2\u008e\u008f"+
		"\7n\2\2\u008f\u0090\7g\2\2\u0090\u0091\7v\2\2\u0091$\3\2\2\2\u0092\u0093"+
		"\7k\2\2\u0093\u0094\7p\2\2\u0094&\3\2\2\2\u0095\u0096\7p\2\2\u0096\u0097"+
		"\7g\2\2\u0097\u0098\7y\2\2\u0098(\3\2\2\2\u0099\u009a\7d\2\2\u009a\u009b"+
		"\7q\2\2\u009b\u009c\7q\2\2\u009c\u009d\7n\2\2\u009d*\3\2\2\2\u009e\u009f"+
		"\7k\2\2\u009f\u00a0\7p\2\2\u00a0\u00a1\7v\2\2\u00a1\u00a2\7\65\2\2\u00a2"+
		"\u00a3\7\64\2\2\u00a3,\3\2\2\2\u00a4\u00a5\7u\2\2\u00a5\u00a6\7v\2\2\u00a6"+
		"\u00a7\7t\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7i\2\2"+
		"\u00aa.\3\2\2\2\u00ab\u00ac\7w\2\2\u00ac\u00ad\7p\2\2\u00ad\u00ae\7k\2"+
		"\2\u00ae\u00af\7v\2\2\u00af\60\3\2\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2"+
		"\7t\2\2\u00b2\u00b3\7w\2\2\u00b3\u00b4\7g\2\2\u00b4\62\3\2\2\2\u00b5\u00b6"+
		"\7h\2\2\u00b6\u00b7\7c\2\2\u00b7\u00b8\7n\2\2\u00b8\u00b9\7u\2\2\u00b9"+
		"\u00ba\7g\2\2\u00ba\64\3\2\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7q\2\2\u00bd"+
		"\u00c5\7v\2\2\u00be\u00bf\7k\2\2\u00bf\u00c0\7u\2\2\u00c0\u00c1\7p\2\2"+
		"\u00c1\u00c2\7w\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c5\7n\2\2\u00c4\u00bb"+
		"\3\2\2\2\u00c4\u00be\3\2\2\2\u00c5\66\3\2\2\2\u00c6\u00c7\t\2\2\2\u00c7"+
		"8\3\2\2\2\u00c8\u00c9\7-\2\2\u00c9:\3\2\2\2\u00ca\u00cb\7c\2\2\u00cb\u00cc"+
		"\7p\2\2\u00cc\u00cd\7f\2\2\u00cd<\3\2\2\2\u00ce\u00d2\4>?\2\u00cf\u00d0"+
		"\7>\2\2\u00d0\u00d2\7?\2\2\u00d1\u00ce\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2"+
		">\3\2\2\2\u00d3\u00d4\7/\2\2\u00d4@\3\2\2\2\u00d5\u00d6\7*\2\2\u00d6\u00d7"+
		"\7,\2\2\u00d7B\3\2\2\2\u00d8\u00d9\7,\2\2\u00d9\u00da\7+\2\2\u00daD\3"+
		"\2\2\2\u00db\u00dc\7*\2\2\u00dc\u00dd\7,\2\2\u00dd\u00e1\3\2\2\2\u00de"+
		"\u00e0\13\2\2\2\u00df\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00e2\3"+
		"\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4"+
		"\u00e5\7,\2\2\u00e5\u00e6\7+\2\2\u00e6F\3\2\2\2\u00e7\u00e8\7\62\2\2\u00e8"+
		"\u00ec\t\3\2\2\u00e9\u00eb\t\4\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2"+
		"\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00edH\3\2\2\2\u00ee\u00ec"+
		"\3\2\2\2\u00ef\u00f0\7\62\2\2\u00f0\u00f4\t\5\2\2\u00f1\u00f3\t\4\2\2"+
		"\u00f2\u00f1\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5"+
		"\3\2\2\2\u00f5J\3\2\2\2\u00f6\u00f4\3\2\2\2\u00f7\u00fb\t\6\2\2\u00f8"+
		"\u00fa\t\4\2\2\u00f9\u00f8\3\2\2\2\u00fa\u00fd\3\2\2\2\u00fb\u00f9\3\2"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fcL\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0102"+
		"\t\7\2\2\u00ff\u0101\t\b\2\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102"+
		"\u0100\3\2\2\2\u0102\u0103\3\2\2\2\u0103N\3\2\2\2\u0104\u0102\3\2\2\2"+
		"\u0105\u0109\t\t\2\2\u0106\u0108\t\b\2\2\u0107\u0106\3\2\2\2\u0108\u010b"+
		"\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010aP\3\2\2\2\u010b"+
		"\u0109\3\2\2\2\u010c\u0112\7$\2\2\u010d\u010e\7^\2\2\u010e\u0111\7$\2"+
		"\2\u010f\u0111\13\2\2\2\u0110\u010d\3\2\2\2\u0110\u010f\3\2\2\2\u0111"+
		"\u0114\3\2\2\2\u0112\u0113\3\2\2\2\u0112\u0110\3\2\2\2\u0113\u0116\3\2"+
		"\2\2\u0114\u0112\3\2\2\2\u0115\u0117\t\n\2\2\u0116\u0115\3\2\2\2\u0117"+
		"R\3\2\2\2\u0118\u0119\7\61\2\2\u0119\u011a\7\61\2\2\u011a\u011e\3\2\2"+
		"\2\u011b\u011d\n\13\2\2\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e"+
		"\u011c\3\2\2\2\u011e\u011f\3\2\2\2\u011fT\3\2\2\2\u0120\u011e\3\2\2\2"+
		"\u0121\u0123\t\f\2\2\u0122\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0122"+
		"\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0127\b+\2\2\u0127"+
		"V\3\2\2\2\20\2\u00c4\u00d1\u00e1\u00ec\u00f4\u00fb\u0102\u0109\u0110\u0112"+
		"\u0116\u011e\u0124\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}