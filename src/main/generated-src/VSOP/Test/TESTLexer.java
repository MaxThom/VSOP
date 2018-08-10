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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		UN_OPERATOR=10, FACTOR_OPERATOR=11, TERM_OPERATOR=12, AND_OPERATOR=13, 
		CONDITIONAL_OPERATOR=14, NEGATIVE_OPERATOR=15, VOID_OPERATOR=16, MULTILINE_OPEN_COMMENT=17, 
		MULTILINE_CLOSE_COMMENT=18, MULTILINE_COMMENT=19, INTEGER_BIN=20, INTEGER_HEX=21, 
		INTEGER_DEC=22, OBJECT_IDENTIFIER=23, TYPE_IDENTIFIER=24, STRING=25, SINGLE_LINE_COMMENT=26, 
		WS=27;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"UN_OPERATOR", "FACTOR_OPERATOR", "TERM_OPERATOR", "AND_OPERATOR", "CONDITIONAL_OPERATOR", 
		"NEGATIVE_OPERATOR", "VOID_OPERATOR", "MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", 
		"MULTILINE_COMMENT", "INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", 
		"TYPE_IDENTIFIER", "STRING", "SINGLE_LINE_COMMENT", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'new'", "'bool'", "'int32'", "'string'", "'unit'", 
		"'true'", "'false'", null, "'d zzdqasdw'", null, "'and'", null, "'-'", 
		"'()'", "'(*'", "'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "UN_OPERATOR", 
		"FACTOR_OPERATOR", "TERM_OPERATOR", "AND_OPERATOR", "CONDITIONAL_OPERATOR", 
		"NEGATIVE_OPERATOR", "VOID_OPERATOR", "MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\35\u00dc\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13m\n\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\5\17\u0083\n\17\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\7\24\u0094\n\24\f\24\16\24\u0097\13\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\7\25\u009f\n\25\f\25\16\25\u00a2\13\25\3\26\3\26"+
		"\3\26\7\26\u00a7\n\26\f\26\16\26\u00aa\13\26\3\27\3\27\7\27\u00ae\n\27"+
		"\f\27\16\27\u00b1\13\27\3\30\3\30\7\30\u00b5\n\30\f\30\16\30\u00b8\13"+
		"\30\3\31\3\31\7\31\u00bc\n\31\f\31\16\31\u00bf\13\31\3\32\3\32\3\32\3"+
		"\32\7\32\u00c5\n\32\f\32\16\32\u00c8\13\32\3\32\5\32\u00cb\n\32\3\33\3"+
		"\33\3\33\3\33\7\33\u00d1\n\33\f\33\16\33\u00d4\13\33\3\34\6\34\u00d7\n"+
		"\34\r\34\16\34\u00d8\3\34\3\34\4\u0095\u00c6\2\35\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\35\3\2\r\5\2,-\61\61``\4\2DDdd\5"+
		"\2\62;C\\c|\4\2ZZzz\3\2\62;\3\2c|\6\2\62;C\\aac|\3\2C\\\3\3$$\4\2\f\f"+
		"\17\17\5\2\13\f\17\17\"\"\2\u00e7\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2"+
		"\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2"+
		"\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2"+
		"\2\2\2\67\3\2\2\2\39\3\2\2\2\5;\3\2\2\2\7=\3\2\2\2\tA\3\2\2\2\13F\3\2"+
		"\2\2\rL\3\2\2\2\17S\3\2\2\2\21X\3\2\2\2\23]\3\2\2\2\25l\3\2\2\2\27n\3"+
		"\2\2\2\31y\3\2\2\2\33{\3\2\2\2\35\u0082\3\2\2\2\37\u0084\3\2\2\2!\u0086"+
		"\3\2\2\2#\u0089\3\2\2\2%\u008c\3\2\2\2\'\u008f\3\2\2\2)\u009b\3\2\2\2"+
		"+\u00a3\3\2\2\2-\u00ab\3\2\2\2/\u00b2\3\2\2\2\61\u00b9\3\2\2\2\63\u00c0"+
		"\3\2\2\2\65\u00cc\3\2\2\2\67\u00d6\3\2\2\29:\7*\2\2:\4\3\2\2\2;<\7+\2"+
		"\2<\6\3\2\2\2=>\7p\2\2>?\7g\2\2?@\7y\2\2@\b\3\2\2\2AB\7d\2\2BC\7q\2\2"+
		"CD\7q\2\2DE\7n\2\2E\n\3\2\2\2FG\7k\2\2GH\7p\2\2HI\7v\2\2IJ\7\65\2\2JK"+
		"\7\64\2\2K\f\3\2\2\2LM\7u\2\2MN\7v\2\2NO\7t\2\2OP\7k\2\2PQ\7p\2\2QR\7"+
		"i\2\2R\16\3\2\2\2ST\7w\2\2TU\7p\2\2UV\7k\2\2VW\7v\2\2W\20\3\2\2\2XY\7"+
		"v\2\2YZ\7t\2\2Z[\7w\2\2[\\\7g\2\2\\\22\3\2\2\2]^\7h\2\2^_\7c\2\2_`\7n"+
		"\2\2`a\7u\2\2ab\7g\2\2b\24\3\2\2\2cd\7p\2\2de\7q\2\2em\7v\2\2fg\7k\2\2"+
		"gh\7u\2\2hi\7p\2\2ij\7w\2\2jk\7n\2\2km\7n\2\2lc\3\2\2\2lf\3\2\2\2m\26"+
		"\3\2\2\2no\7f\2\2op\7\"\2\2pq\7|\2\2qr\7|\2\2rs\7f\2\2st\7s\2\2tu\7c\2"+
		"\2uv\7u\2\2vw\7f\2\2wx\7y\2\2x\30\3\2\2\2yz\t\2\2\2z\32\3\2\2\2{|\7c\2"+
		"\2|}\7p\2\2}~\7f\2\2~\34\3\2\2\2\177\u0083\4>?\2\u0080\u0081\7>\2\2\u0081"+
		"\u0083\7?\2\2\u0082\177\3\2\2\2\u0082\u0080\3\2\2\2\u0083\36\3\2\2\2\u0084"+
		"\u0085\7/\2\2\u0085 \3\2\2\2\u0086\u0087\7*\2\2\u0087\u0088\7+\2\2\u0088"+
		"\"\3\2\2\2\u0089\u008a\7*\2\2\u008a\u008b\7,\2\2\u008b$\3\2\2\2\u008c"+
		"\u008d\7,\2\2\u008d\u008e\7+\2\2\u008e&\3\2\2\2\u008f\u0090\7*\2\2\u0090"+
		"\u0091\7,\2\2\u0091\u0095\3\2\2\2\u0092\u0094\13\2\2\2\u0093\u0092\3\2"+
		"\2\2\u0094\u0097\3\2\2\2\u0095\u0096\3\2\2\2\u0095\u0093\3\2\2\2\u0096"+
		"\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\7,\2\2\u0099\u009a\7+\2"+
		"\2\u009a(\3\2\2\2\u009b\u009c\7\62\2\2\u009c\u00a0\t\3\2\2\u009d\u009f"+
		"\t\4\2\2\u009e\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0"+
		"\u00a1\3\2\2\2\u00a1*\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\7\62\2\2"+
		"\u00a4\u00a8\t\5\2\2\u00a5\u00a7\t\4\2\2\u00a6\u00a5\3\2\2\2\u00a7\u00aa"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9,\3\2\2\2\u00aa"+
		"\u00a8\3\2\2\2\u00ab\u00af\t\6\2\2\u00ac\u00ae\t\4\2\2\u00ad\u00ac\3\2"+
		"\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		".\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b6\t\7\2\2\u00b3\u00b5\t\b\2\2"+
		"\u00b4\u00b3\3\2\2\2\u00b5\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7"+
		"\3\2\2\2\u00b7\60\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b9\u00bd\t\t\2\2\u00ba"+
		"\u00bc\t\b\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2"+
		"\2\2\u00bd\u00be\3\2\2\2\u00be\62\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c6"+
		"\7$\2\2\u00c1\u00c2\7^\2\2\u00c2\u00c5\7$\2\2\u00c3\u00c5\13\2\2\2\u00c4"+
		"\u00c1\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c7\3\2"+
		"\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9"+
		"\u00cb\t\n\2\2\u00ca\u00c9\3\2\2\2\u00cb\64\3\2\2\2\u00cc\u00cd\7\61\2"+
		"\2\u00cd\u00ce\7\61\2\2\u00ce\u00d2\3\2\2\2\u00cf\u00d1\n\13\2\2\u00d0"+
		"\u00cf\3\2\2\2\u00d1\u00d4\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2"+
		"\2\2\u00d3\66\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d7\t\f\2\2\u00d6\u00d5"+
		"\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9"+
		"\u00da\3\2\2\2\u00da\u00db\b\34\2\2\u00db8\3\2\2\2\20\2l\u0082\u0095\u00a0"+
		"\u00a8\u00af\u00b6\u00bd\u00c4\u00c6\u00ca\u00d2\u00d8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}