// Generated from Semantic\SEMANTIC.g4 by ANTLR 4.7.1
package VSOP.Semantic;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SEMANTICLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, POW=26, MULTI=27, DIV=28, MINUS=29, PLUS=30, LOWER=31, LOWER_EQUAL=32, 
		EQUAL=33, GREATER=34, GREATER_EQUAL=35, DIFFERENT_EQUAL=36, AND=37, NOT=38, 
		ISNULL=39, VOID_OPERATOR=40, MULTILINE_OPEN_COMMENT=41, MULTILINE_CLOSE_COMMENT=42, 
		MULTILINE_COMMENT=43, INTEGER_BIN=44, INTEGER_HEX=45, INTEGER_DEC=46, 
		OBJECT_IDENTIFIER=47, TYPE_IDENTIFIER=48, STRING=49, SINGLE_LINE_COMMENT=50, 
		WS=51;
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
		"POW", "MULTI", "DIV", "MINUS", "PLUS", "LOWER", "LOWER_EQUAL", "EQUAL", 
		"GREATER", "GREATER_EQUAL", "DIFFERENT_EQUAL", "AND", "NOT", "ISNULL", 
		"VOID_OPERATOR", "MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", 
		"MULTILINE_COMMENT", "INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", 
		"TYPE_IDENTIFIER", "STRING", "SINGLE_LINE_COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "';'", "'}'", "'class'", "'extends'", "','", 
		"':'", "'<-'", "'.'", "'while'", "'do'", "'if'", "'then'", "'else'", "'let'", 
		"'in'", "'new'", "'bool'", "'int32'", "'string'", "'unit'", "'true'", 
		"'false'", "'^'", "'*'", "'/'", "'-'", "'+'", "'<'", "'<='", "'='", "'>'", 
		"'>='", "'!='", "'and'", "'not'", "'isnull'", "'()'", "'(*'", "'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "POW", "MULTI", "DIV", "MINUS", "PLUS", "LOWER", "LOWER_EQUAL", 
		"EQUAL", "GREATER", "GREATER_EQUAL", "DIFFERENT_EQUAL", "AND", "NOT", 
		"ISNULL", "VOID_OPERATOR", "MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", 
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


	public SEMANTICLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SEMANTIC.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\65\u014b\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\31"+
		"\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34\3\34"+
		"\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3"+
		"%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3)\3)\3)\3*\3"+
		"*\3*\3+\3+\3+\3,\3,\3,\3,\7,\u0103\n,\f,\16,\u0106\13,\3,\3,\3,\3-\3-"+
		"\3-\7-\u010e\n-\f-\16-\u0111\13-\3.\3.\3.\7.\u0116\n.\f.\16.\u0119\13"+
		".\3/\3/\7/\u011d\n/\f/\16/\u0120\13/\3\60\3\60\7\60\u0124\n\60\f\60\16"+
		"\60\u0127\13\60\3\61\3\61\7\61\u012b\n\61\f\61\16\61\u012e\13\61\3\62"+
		"\3\62\3\62\3\62\7\62\u0134\n\62\f\62\16\62\u0137\13\62\3\62\5\62\u013a"+
		"\n\62\3\63\3\63\3\63\3\63\7\63\u0140\n\63\f\63\16\63\u0143\13\63\3\64"+
		"\6\64\u0146\n\64\r\64\16\64\u0147\3\64\3\64\4\u0104\u0135\2\65\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65\3\2\f\4\2DDdd\5\2\62"+
		";C\\c|\4\2ZZzz\3\2\62;\3\2c|\6\2\62;C\\aac|\3\2C\\\3\3$$\4\2\f\f\17\17"+
		"\5\2\13\f\17\17\"\"\2\u0154\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C"+
		"\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2"+
		"\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2"+
		"\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\3i"+
		"\3\2\2\2\5k\3\2\2\2\7m\3\2\2\2\to\3\2\2\2\13q\3\2\2\2\rs\3\2\2\2\17y\3"+
		"\2\2\2\21\u0081\3\2\2\2\23\u0083\3\2\2\2\25\u0085\3\2\2\2\27\u0088\3\2"+
		"\2\2\31\u008a\3\2\2\2\33\u0090\3\2\2\2\35\u0093\3\2\2\2\37\u0096\3\2\2"+
		"\2!\u009b\3\2\2\2#\u00a0\3\2\2\2%\u00a4\3\2\2\2\'\u00a7\3\2\2\2)\u00ab"+
		"\3\2\2\2+\u00b0\3\2\2\2-\u00b6\3\2\2\2/\u00bd\3\2\2\2\61\u00c2\3\2\2\2"+
		"\63\u00c7\3\2\2\2\65\u00cd\3\2\2\2\67\u00cf\3\2\2\29\u00d1\3\2\2\2;\u00d3"+
		"\3\2\2\2=\u00d5\3\2\2\2?\u00d7\3\2\2\2A\u00d9\3\2\2\2C\u00dc\3\2\2\2E"+
		"\u00de\3\2\2\2G\u00e0\3\2\2\2I\u00e3\3\2\2\2K\u00e6\3\2\2\2M\u00ea\3\2"+
		"\2\2O\u00ee\3\2\2\2Q\u00f5\3\2\2\2S\u00f8\3\2\2\2U\u00fb\3\2\2\2W\u00fe"+
		"\3\2\2\2Y\u010a\3\2\2\2[\u0112\3\2\2\2]\u011a\3\2\2\2_\u0121\3\2\2\2a"+
		"\u0128\3\2\2\2c\u012f\3\2\2\2e\u013b\3\2\2\2g\u0145\3\2\2\2ij\7*\2\2j"+
		"\4\3\2\2\2kl\7+\2\2l\6\3\2\2\2mn\7}\2\2n\b\3\2\2\2op\7=\2\2p\n\3\2\2\2"+
		"qr\7\177\2\2r\f\3\2\2\2st\7e\2\2tu\7n\2\2uv\7c\2\2vw\7u\2\2wx\7u\2\2x"+
		"\16\3\2\2\2yz\7g\2\2z{\7z\2\2{|\7v\2\2|}\7g\2\2}~\7p\2\2~\177\7f\2\2\177"+
		"\u0080\7u\2\2\u0080\20\3\2\2\2\u0081\u0082\7.\2\2\u0082\22\3\2\2\2\u0083"+
		"\u0084\7<\2\2\u0084\24\3\2\2\2\u0085\u0086\7>\2\2\u0086\u0087\7/\2\2\u0087"+
		"\26\3\2\2\2\u0088\u0089\7\60\2\2\u0089\30\3\2\2\2\u008a\u008b\7y\2\2\u008b"+
		"\u008c\7j\2\2\u008c\u008d\7k\2\2\u008d\u008e\7n\2\2\u008e\u008f\7g\2\2"+
		"\u008f\32\3\2\2\2\u0090\u0091\7f\2\2\u0091\u0092\7q\2\2\u0092\34\3\2\2"+
		"\2\u0093\u0094\7k\2\2\u0094\u0095\7h\2\2\u0095\36\3\2\2\2\u0096\u0097"+
		"\7v\2\2\u0097\u0098\7j\2\2\u0098\u0099\7g\2\2\u0099\u009a\7p\2\2\u009a"+
		" \3\2\2\2\u009b\u009c\7g\2\2\u009c\u009d\7n\2\2\u009d\u009e\7u\2\2\u009e"+
		"\u009f\7g\2\2\u009f\"\3\2\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7g\2\2\u00a2"+
		"\u00a3\7v\2\2\u00a3$\3\2\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7p\2\2\u00a6"+
		"&\3\2\2\2\u00a7\u00a8\7p\2\2\u00a8\u00a9\7g\2\2\u00a9\u00aa\7y\2\2\u00aa"+
		"(\3\2\2\2\u00ab\u00ac\7d\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae\7q\2\2\u00ae"+
		"\u00af\7n\2\2\u00af*\3\2\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7p\2\2\u00b2"+
		"\u00b3\7v\2\2\u00b3\u00b4\7\65\2\2\u00b4\u00b5\7\64\2\2\u00b5,\3\2\2\2"+
		"\u00b6\u00b7\7u\2\2\u00b7\u00b8\7v\2\2\u00b8\u00b9\7t\2\2\u00b9\u00ba"+
		"\7k\2\2\u00ba\u00bb\7p\2\2\u00bb\u00bc\7i\2\2\u00bc.\3\2\2\2\u00bd\u00be"+
		"\7w\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1\7v\2\2\u00c1"+
		"\60\3\2\2\2\u00c2\u00c3\7v\2\2\u00c3\u00c4\7t\2\2\u00c4\u00c5\7w\2\2\u00c5"+
		"\u00c6\7g\2\2\u00c6\62\3\2\2\2\u00c7\u00c8\7h\2\2\u00c8\u00c9\7c\2\2\u00c9"+
		"\u00ca\7n\2\2\u00ca\u00cb\7u\2\2\u00cb\u00cc\7g\2\2\u00cc\64\3\2\2\2\u00cd"+
		"\u00ce\7`\2\2\u00ce\66\3\2\2\2\u00cf\u00d0\7,\2\2\u00d08\3\2\2\2\u00d1"+
		"\u00d2\7\61\2\2\u00d2:\3\2\2\2\u00d3\u00d4\7/\2\2\u00d4<\3\2\2\2\u00d5"+
		"\u00d6\7-\2\2\u00d6>\3\2\2\2\u00d7\u00d8\7>\2\2\u00d8@\3\2\2\2\u00d9\u00da"+
		"\7>\2\2\u00da\u00db\7?\2\2\u00dbB\3\2\2\2\u00dc\u00dd\7?\2\2\u00ddD\3"+
		"\2\2\2\u00de\u00df\7@\2\2\u00dfF\3\2\2\2\u00e0\u00e1\7@\2\2\u00e1\u00e2"+
		"\7?\2\2\u00e2H\3\2\2\2\u00e3\u00e4\7#\2\2\u00e4\u00e5\7?\2\2\u00e5J\3"+
		"\2\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8\7p\2\2\u00e8\u00e9\7f\2\2\u00e9"+
		"L\3\2\2\2\u00ea\u00eb\7p\2\2\u00eb\u00ec\7q\2\2\u00ec\u00ed\7v\2\2\u00ed"+
		"N\3\2\2\2\u00ee\u00ef\7k\2\2\u00ef\u00f0\7u\2\2\u00f0\u00f1\7p\2\2\u00f1"+
		"\u00f2\7w\2\2\u00f2\u00f3\7n\2\2\u00f3\u00f4\7n\2\2\u00f4P\3\2\2\2\u00f5"+
		"\u00f6\7*\2\2\u00f6\u00f7\7+\2\2\u00f7R\3\2\2\2\u00f8\u00f9\7*\2\2\u00f9"+
		"\u00fa\7,\2\2\u00faT\3\2\2\2\u00fb\u00fc\7,\2\2\u00fc\u00fd\7+\2\2\u00fd"+
		"V\3\2\2\2\u00fe\u00ff\7*\2\2\u00ff\u0100\7,\2\2\u0100\u0104\3\2\2\2\u0101"+
		"\u0103\13\2\2\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104\u0105\3"+
		"\2\2\2\u0104\u0102\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2\2\2\u0107"+
		"\u0108\7,\2\2\u0108\u0109\7+\2\2\u0109X\3\2\2\2\u010a\u010b\7\62\2\2\u010b"+
		"\u010f\t\2\2\2\u010c\u010e\t\3\2\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2"+
		"\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110Z\3\2\2\2\u0111\u010f"+
		"\3\2\2\2\u0112\u0113\7\62\2\2\u0113\u0117\t\4\2\2\u0114\u0116\t\3\2\2"+
		"\u0115\u0114\3\2\2\2\u0116\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118"+
		"\3\2\2\2\u0118\\\3\2\2\2\u0119\u0117\3\2\2\2\u011a\u011e\t\5\2\2\u011b"+
		"\u011d\t\3\2\2\u011c\u011b\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2"+
		"\2\2\u011e\u011f\3\2\2\2\u011f^\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0125"+
		"\t\6\2\2\u0122\u0124\t\7\2\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126`\3\2\2\2\u0127\u0125\3\2\2\2"+
		"\u0128\u012c\t\b\2\2\u0129\u012b\t\7\2\2\u012a\u0129\3\2\2\2\u012b\u012e"+
		"\3\2\2\2\u012c\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012db\3\2\2\2\u012e"+
		"\u012c\3\2\2\2\u012f\u0135\7$\2\2\u0130\u0131\7^\2\2\u0131\u0134\7$\2"+
		"\2\u0132\u0134\13\2\2\2\u0133\u0130\3\2\2\2\u0133\u0132\3\2\2\2\u0134"+
		"\u0137\3\2\2\2\u0135\u0136\3\2\2\2\u0135\u0133\3\2\2\2\u0136\u0139\3\2"+
		"\2\2\u0137\u0135\3\2\2\2\u0138\u013a\t\t\2\2\u0139\u0138\3\2\2\2\u013a"+
		"d\3\2\2\2\u013b\u013c\7\61\2\2\u013c\u013d\7\61\2\2\u013d\u0141\3\2\2"+
		"\2\u013e\u0140\n\n\2\2\u013f\u013e\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f"+
		"\3\2\2\2\u0141\u0142\3\2\2\2\u0142f\3\2\2\2\u0143\u0141\3\2\2\2\u0144"+
		"\u0146\t\13\2\2\u0145\u0144\3\2\2\2\u0146\u0147\3\2\2\2\u0147\u0145\3"+
		"\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\b\64\2\2\u014a"+
		"h\3\2\2\2\16\2\u0104\u010f\u0117\u011e\u0125\u012c\u0133\u0135\u0139\u0141"+
		"\u0147\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}