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
		T__24=25, POW=26, MULTI=27, DIV=28, MINUS=29, PLUS=30, LOWER=31, LOWER_EQUAL=32, 
		EQUAL=33, GREATER=34, GREATER_EQUAL=35, DIFFERENT_EQUAL=36, AND=37, OR=38, 
		NOT=39, ISNULL=40, VOID_OPERATOR=41, MULTILINE_OPEN_COMMENT=42, MULTILINE_CLOSE_COMMENT=43, 
		MULTILINE_COMMENT=44, INTEGER_BIN=45, INTEGER_HEX=46, INTEGER_DEC=47, 
		OBJECT_IDENTIFIER=48, TYPE_IDENTIFIER=49, STRING=50, SINGLE_LINE_COMMENT=51, 
		WS=52;
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
		"GREATER", "GREATER_EQUAL", "DIFFERENT_EQUAL", "AND", "OR", "NOT", "ISNULL", 
		"VOID_OPERATOR", "MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", 
		"MULTILINE_COMMENT", "INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", 
		"TYPE_IDENTIFIER", "STRING", "SINGLE_LINE_COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "';'", "'}'", "'class'", "'extends'", "','", 
		"':'", "'<-'", "'.'", "'while'", "'do'", "'if'", "'then'", "'else'", "'let'", 
		"'in'", "'new'", "'bool'", "'int32'", "'string'", "'unit'", "'true'", 
		"'false'", "'^'", "'*'", "'/'", "'-'", "'+'", "'<'", "'<='", "'='", "'>'", 
		"'>='", "'!='", "'and'", "'or'", "'not'", "'isnull'", "'()'", "'(*'", 
		"'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "POW", "MULTI", "DIV", "MINUS", "PLUS", "LOWER", "LOWER_EQUAL", 
		"EQUAL", "GREATER", "GREATER_EQUAL", "DIFFERENT_EQUAL", "AND", "OR", "NOT", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\66\u0150\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3#\3#"+
		"\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3(\3)\3)\3)\3)\3)"+
		"\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3-\3-\3-\3-\7-\u0108\n-\f-\16-\u010b"+
		"\13-\3-\3-\3-\3.\3.\3.\7.\u0113\n.\f.\16.\u0116\13.\3/\3/\3/\7/\u011b"+
		"\n/\f/\16/\u011e\13/\3\60\3\60\7\60\u0122\n\60\f\60\16\60\u0125\13\60"+
		"\3\61\3\61\7\61\u0129\n\61\f\61\16\61\u012c\13\61\3\62\3\62\7\62\u0130"+
		"\n\62\f\62\16\62\u0133\13\62\3\63\3\63\3\63\3\63\7\63\u0139\n\63\f\63"+
		"\16\63\u013c\13\63\3\63\5\63\u013f\n\63\3\64\3\64\3\64\3\64\7\64\u0145"+
		"\n\64\f\64\16\64\u0148\13\64\3\65\6\65\u014b\n\65\r\65\16\65\u014c\3\65"+
		"\3\65\4\u0109\u013a\2\66\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62"+
		"c\63e\64g\65i\66\3\2\f\4\2DDdd\5\2\62;C\\c|\4\2ZZzz\3\2\62;\3\2c|\6\2"+
		"\62;C\\aac|\3\2C\\\3\3$$\4\2\f\f\17\17\5\2\13\f\17\17\"\"\2\u0159\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3"+
		"\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2"+
		"\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\3k\3\2\2\2\5m\3\2\2\2\7"+
		"o\3\2\2\2\tq\3\2\2\2\13s\3\2\2\2\ru\3\2\2\2\17{\3\2\2\2\21\u0083\3\2\2"+
		"\2\23\u0085\3\2\2\2\25\u0087\3\2\2\2\27\u008a\3\2\2\2\31\u008c\3\2\2\2"+
		"\33\u0092\3\2\2\2\35\u0095\3\2\2\2\37\u0098\3\2\2\2!\u009d\3\2\2\2#\u00a2"+
		"\3\2\2\2%\u00a6\3\2\2\2\'\u00a9\3\2\2\2)\u00ad\3\2\2\2+\u00b2\3\2\2\2"+
		"-\u00b8\3\2\2\2/\u00bf\3\2\2\2\61\u00c4\3\2\2\2\63\u00c9\3\2\2\2\65\u00cf"+
		"\3\2\2\2\67\u00d1\3\2\2\29\u00d3\3\2\2\2;\u00d5\3\2\2\2=\u00d7\3\2\2\2"+
		"?\u00d9\3\2\2\2A\u00db\3\2\2\2C\u00de\3\2\2\2E\u00e0\3\2\2\2G\u00e2\3"+
		"\2\2\2I\u00e5\3\2\2\2K\u00e8\3\2\2\2M\u00ec\3\2\2\2O\u00ef\3\2\2\2Q\u00f3"+
		"\3\2\2\2S\u00fa\3\2\2\2U\u00fd\3\2\2\2W\u0100\3\2\2\2Y\u0103\3\2\2\2["+
		"\u010f\3\2\2\2]\u0117\3\2\2\2_\u011f\3\2\2\2a\u0126\3\2\2\2c\u012d\3\2"+
		"\2\2e\u0134\3\2\2\2g\u0140\3\2\2\2i\u014a\3\2\2\2kl\7*\2\2l\4\3\2\2\2"+
		"mn\7+\2\2n\6\3\2\2\2op\7}\2\2p\b\3\2\2\2qr\7=\2\2r\n\3\2\2\2st\7\177\2"+
		"\2t\f\3\2\2\2uv\7e\2\2vw\7n\2\2wx\7c\2\2xy\7u\2\2yz\7u\2\2z\16\3\2\2\2"+
		"{|\7g\2\2|}\7z\2\2}~\7v\2\2~\177\7g\2\2\177\u0080\7p\2\2\u0080\u0081\7"+
		"f\2\2\u0081\u0082\7u\2\2\u0082\20\3\2\2\2\u0083\u0084\7.\2\2\u0084\22"+
		"\3\2\2\2\u0085\u0086\7<\2\2\u0086\24\3\2\2\2\u0087\u0088\7>\2\2\u0088"+
		"\u0089\7/\2\2\u0089\26\3\2\2\2\u008a\u008b\7\60\2\2\u008b\30\3\2\2\2\u008c"+
		"\u008d\7y\2\2\u008d\u008e\7j\2\2\u008e\u008f\7k\2\2\u008f\u0090\7n\2\2"+
		"\u0090\u0091\7g\2\2\u0091\32\3\2\2\2\u0092\u0093\7f\2\2\u0093\u0094\7"+
		"q\2\2\u0094\34\3\2\2\2\u0095\u0096\7k\2\2\u0096\u0097\7h\2\2\u0097\36"+
		"\3\2\2\2\u0098\u0099\7v\2\2\u0099\u009a\7j\2\2\u009a\u009b\7g\2\2\u009b"+
		"\u009c\7p\2\2\u009c \3\2\2\2\u009d\u009e\7g\2\2\u009e\u009f\7n\2\2\u009f"+
		"\u00a0\7u\2\2\u00a0\u00a1\7g\2\2\u00a1\"\3\2\2\2\u00a2\u00a3\7n\2\2\u00a3"+
		"\u00a4\7g\2\2\u00a4\u00a5\7v\2\2\u00a5$\3\2\2\2\u00a6\u00a7\7k\2\2\u00a7"+
		"\u00a8\7p\2\2\u00a8&\3\2\2\2\u00a9\u00aa\7p\2\2\u00aa\u00ab\7g\2\2\u00ab"+
		"\u00ac\7y\2\2\u00ac(\3\2\2\2\u00ad\u00ae\7d\2\2\u00ae\u00af\7q\2\2\u00af"+
		"\u00b0\7q\2\2\u00b0\u00b1\7n\2\2\u00b1*\3\2\2\2\u00b2\u00b3\7k\2\2\u00b3"+
		"\u00b4\7p\2\2\u00b4\u00b5\7v\2\2\u00b5\u00b6\7\65\2\2\u00b6\u00b7\7\64"+
		"\2\2\u00b7,\3\2\2\2\u00b8\u00b9\7u\2\2\u00b9\u00ba\7v\2\2\u00ba\u00bb"+
		"\7t\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7p\2\2\u00bd\u00be\7i\2\2\u00be"+
		".\3\2\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1\7p\2\2\u00c1\u00c2\7k\2\2\u00c2"+
		"\u00c3\7v\2\2\u00c3\60\3\2\2\2\u00c4\u00c5\7v\2\2\u00c5\u00c6\7t\2\2\u00c6"+
		"\u00c7\7w\2\2\u00c7\u00c8\7g\2\2\u00c8\62\3\2\2\2\u00c9\u00ca\7h\2\2\u00ca"+
		"\u00cb\7c\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7u\2\2\u00cd\u00ce\7g\2\2"+
		"\u00ce\64\3\2\2\2\u00cf\u00d0\7`\2\2\u00d0\66\3\2\2\2\u00d1\u00d2\7,\2"+
		"\2\u00d28\3\2\2\2\u00d3\u00d4\7\61\2\2\u00d4:\3\2\2\2\u00d5\u00d6\7/\2"+
		"\2\u00d6<\3\2\2\2\u00d7\u00d8\7-\2\2\u00d8>\3\2\2\2\u00d9\u00da\7>\2\2"+
		"\u00da@\3\2\2\2\u00db\u00dc\7>\2\2\u00dc\u00dd\7?\2\2\u00ddB\3\2\2\2\u00de"+
		"\u00df\7?\2\2\u00dfD\3\2\2\2\u00e0\u00e1\7@\2\2\u00e1F\3\2\2\2\u00e2\u00e3"+
		"\7@\2\2\u00e3\u00e4\7?\2\2\u00e4H\3\2\2\2\u00e5\u00e6\7#\2\2\u00e6\u00e7"+
		"\7?\2\2\u00e7J\3\2\2\2\u00e8\u00e9\7c\2\2\u00e9\u00ea\7p\2\2\u00ea\u00eb"+
		"\7f\2\2\u00ebL\3\2\2\2\u00ec\u00ed\7q\2\2\u00ed\u00ee\7t\2\2\u00eeN\3"+
		"\2\2\2\u00ef\u00f0\7p\2\2\u00f0\u00f1\7q\2\2\u00f1\u00f2\7v\2\2\u00f2"+
		"P\3\2\2\2\u00f3\u00f4\7k\2\2\u00f4\u00f5\7u\2\2\u00f5\u00f6\7p\2\2\u00f6"+
		"\u00f7\7w\2\2\u00f7\u00f8\7n\2\2\u00f8\u00f9\7n\2\2\u00f9R\3\2\2\2\u00fa"+
		"\u00fb\7*\2\2\u00fb\u00fc\7+\2\2\u00fcT\3\2\2\2\u00fd\u00fe\7*\2\2\u00fe"+
		"\u00ff\7,\2\2\u00ffV\3\2\2\2\u0100\u0101\7,\2\2\u0101\u0102\7+\2\2\u0102"+
		"X\3\2\2\2\u0103\u0104\7*\2\2\u0104\u0105\7,\2\2\u0105\u0109\3\2\2\2\u0106"+
		"\u0108\13\2\2\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u010a\3"+
		"\2\2\2\u0109\u0107\3\2\2\2\u010a\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c"+
		"\u010d\7,\2\2\u010d\u010e\7+\2\2\u010eZ\3\2\2\2\u010f\u0110\7\62\2\2\u0110"+
		"\u0114\t\2\2\2\u0111\u0113\t\3\2\2\u0112\u0111\3\2\2\2\u0113\u0116\3\2"+
		"\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\\\3\2\2\2\u0116\u0114"+
		"\3\2\2\2\u0117\u0118\7\62\2\2\u0118\u011c\t\4\2\2\u0119\u011b\t\3\2\2"+
		"\u011a\u0119\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c\u011d"+
		"\3\2\2\2\u011d^\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0123\t\5\2\2\u0120"+
		"\u0122\t\3\2\2\u0121\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0121\3\2"+
		"\2\2\u0123\u0124\3\2\2\2\u0124`\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u012a"+
		"\t\6\2\2\u0127\u0129\t\7\2\2\u0128\u0127\3\2\2\2\u0129\u012c\3\2\2\2\u012a"+
		"\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012bb\3\2\2\2\u012c\u012a\3\2\2\2"+
		"\u012d\u0131\t\b\2\2\u012e\u0130\t\7\2\2\u012f\u012e\3\2\2\2\u0130\u0133"+
		"\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132d\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0134\u013a\7$\2\2\u0135\u0136\7^\2\2\u0136\u0139\7$\2"+
		"\2\u0137\u0139\13\2\2\2\u0138\u0135\3\2\2\2\u0138\u0137\3\2\2\2\u0139"+
		"\u013c\3\2\2\2\u013a\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013e\3\2"+
		"\2\2\u013c\u013a\3\2\2\2\u013d\u013f\t\t\2\2\u013e\u013d\3\2\2\2\u013f"+
		"f\3\2\2\2\u0140\u0141\7\61\2\2\u0141\u0142\7\61\2\2\u0142\u0146\3\2\2"+
		"\2\u0143\u0145\n\n\2\2\u0144\u0143\3\2\2\2\u0145\u0148\3\2\2\2\u0146\u0144"+
		"\3\2\2\2\u0146\u0147\3\2\2\2\u0147h\3\2\2\2\u0148\u0146\3\2\2\2\u0149"+
		"\u014b\t\13\2\2\u014a\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c\u014a\3"+
		"\2\2\2\u014c\u014d\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u014f\b\65\2\2\u014f"+
		"j\3\2\2\2\16\2\u0109\u0114\u011c\u0123\u012a\u0131\u0138\u013a\u013e\u0146"+
		"\u014c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}