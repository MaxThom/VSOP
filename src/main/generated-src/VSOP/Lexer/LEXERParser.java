// Generated from Lexer\LEXER.g4 by ANTLR 4.7.1
package VSOP.Lexer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class LEXERParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		KEYWORD=1, MULTILINE_OPEN_COMMENT=2, MULTILINE_CLOSE_COMMENT=3, INTEGER_BIN=4, 
		INTEGER_HEX=5, INTEGER_DEC=6, OBJECT_IDENTIFIER=7, TYPE_IDENTIFIER=8, 
		STRING=9, SINGLE_LINE_COMMENT=10, OPERATOR=11, WS=12;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_keyword = 2, RULE_integer = 3, 
		RULE_objectIdentifier = 4, RULE_typeIdentifier = 5, RULE_string = 6, RULE_singleLineComment = 7, 
		RULE_multiLineComment = 8, RULE_operator = 9;
	public static final String[] ruleNames = {
		"program", "statement", "keyword", "integer", "objectIdentifier", "typeIdentifier", 
		"string", "singleLineComment", "multiLineComment", "operator"
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

	@Override
	public String getGrammarFileName() { return "LEXER.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LEXERParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(20);
				statement();
				}
				}
				setState(23); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << KEYWORD) | (1L << MULTILINE_OPEN_COMMENT) | (1L << MULTILINE_CLOSE_COMMENT) | (1L << INTEGER_BIN) | (1L << INTEGER_HEX) | (1L << INTEGER_DEC) | (1L << OBJECT_IDENTIFIER) | (1L << TYPE_IDENTIFIER) | (1L << STRING) | (1L << SINGLE_LINE_COMMENT) | (1L << OPERATOR))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public KeywordContext keyword() {
			return getRuleContext(KeywordContext.class,0);
		}
		public OperatorContext operator() {
			return getRuleContext(OperatorContext.class,0);
		}
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public ObjectIdentifierContext objectIdentifier() {
			return getRuleContext(ObjectIdentifierContext.class,0);
		}
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public SingleLineCommentContext singleLineComment() {
			return getRuleContext(SingleLineCommentContext.class,0);
		}
		public MultiLineCommentContext multiLineComment() {
			return getRuleContext(MultiLineCommentContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case KEYWORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(25);
				keyword();
				}
				break;
			case OPERATOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(26);
				operator();
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				enterOuterAlt(_localctx, 3);
				{
				setState(27);
				integer();
				}
				break;
			case OBJECT_IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(28);
				objectIdentifier();
				}
				break;
			case TYPE_IDENTIFIER:
				enterOuterAlt(_localctx, 5);
				{
				setState(29);
				typeIdentifier();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 6);
				{
				setState(30);
				string();
				}
				break;
			case SINGLE_LINE_COMMENT:
				enterOuterAlt(_localctx, 7);
				{
				setState(31);
				singleLineComment();
				}
				break;
			case MULTILINE_OPEN_COMMENT:
			case MULTILINE_CLOSE_COMMENT:
				enterOuterAlt(_localctx, 8);
				{
				setState(32);
				multiLineComment();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode KEYWORD() { return getToken(LEXERParser.KEYWORD, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).enterKeyword(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).exitKeyword(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_keyword);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			match(KEYWORD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER_BIN() { return getToken(LEXERParser.INTEGER_BIN, 0); }
		public TerminalNode INTEGER_HEX() { return getToken(LEXERParser.INTEGER_HEX, 0); }
		public TerminalNode INTEGER_DEC() { return getToken(LEXERParser.INTEGER_DEC, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER_BIN) | (1L << INTEGER_HEX) | (1L << INTEGER_DEC))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectIdentifierContext extends ParserRuleContext {
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(LEXERParser.OBJECT_IDENTIFIER, 0); }
		public ObjectIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).enterObjectIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).exitObjectIdentifier(this);
		}
	}

	public final ObjectIdentifierContext objectIdentifier() throws RecognitionException {
		ObjectIdentifierContext _localctx = new ObjectIdentifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_objectIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39);
			match(OBJECT_IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeIdentifierContext extends ParserRuleContext {
		public TerminalNode TYPE_IDENTIFIER() { return getToken(LEXERParser.TYPE_IDENTIFIER, 0); }
		public TypeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).enterTypeIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).exitTypeIdentifier(this);
		}
	}

	public final TypeIdentifierContext typeIdentifier() throws RecognitionException {
		TypeIdentifierContext _localctx = new TypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_typeIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(TYPE_IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(LEXERParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SingleLineCommentContext extends ParserRuleContext {
		public TerminalNode SINGLE_LINE_COMMENT() { return getToken(LEXERParser.SINGLE_LINE_COMMENT, 0); }
		public SingleLineCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleLineComment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).enterSingleLineComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).exitSingleLineComment(this);
		}
	}

	public final SingleLineCommentContext singleLineComment() throws RecognitionException {
		SingleLineCommentContext _localctx = new SingleLineCommentContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_singleLineComment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(SINGLE_LINE_COMMENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MultiLineCommentContext extends ParserRuleContext {
		public TerminalNode MULTILINE_OPEN_COMMENT() { return getToken(LEXERParser.MULTILINE_OPEN_COMMENT, 0); }
		public TerminalNode MULTILINE_CLOSE_COMMENT() { return getToken(LEXERParser.MULTILINE_CLOSE_COMMENT, 0); }
		public MultiLineCommentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiLineComment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).enterMultiLineComment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).exitMultiLineComment(this);
		}
	}

	public final MultiLineCommentContext multiLineComment() throws RecognitionException {
		MultiLineCommentContext _localctx = new MultiLineCommentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_multiLineComment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			_la = _input.LA(1);
			if ( !(_la==MULTILINE_OPEN_COMMENT || _la==MULTILINE_CLOSE_COMMENT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OperatorContext extends ParserRuleContext {
		public TerminalNode OPERATOR() { return getToken(LEXERParser.OPERATOR, 0); }
		public OperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).enterOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof LEXERListener ) ((LEXERListener)listener).exitOperator(this);
		}
	}

	public final OperatorContext operator() throws RecognitionException {
		OperatorContext _localctx = new OperatorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_operator);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(OPERATOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\16\66\4\2\t\2\4\3"+
		"\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13"+
		"\3\2\6\2\30\n\2\r\2\16\2\31\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3$\n\3\3"+
		"\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\2\2\f\2\4\6\b\n\f\16\20\22\24\2\4\3\2\6\b\3\2\4\5\2\63\2\27\3\2\2\2\4"+
		"#\3\2\2\2\6%\3\2\2\2\b\'\3\2\2\2\n)\3\2\2\2\f+\3\2\2\2\16-\3\2\2\2\20"+
		"/\3\2\2\2\22\61\3\2\2\2\24\63\3\2\2\2\26\30\5\4\3\2\27\26\3\2\2\2\30\31"+
		"\3\2\2\2\31\27\3\2\2\2\31\32\3\2\2\2\32\3\3\2\2\2\33$\5\6\4\2\34$\5\24"+
		"\13\2\35$\5\b\5\2\36$\5\n\6\2\37$\5\f\7\2 $\5\16\b\2!$\5\20\t\2\"$\5\22"+
		"\n\2#\33\3\2\2\2#\34\3\2\2\2#\35\3\2\2\2#\36\3\2\2\2#\37\3\2\2\2# \3\2"+
		"\2\2#!\3\2\2\2#\"\3\2\2\2$\5\3\2\2\2%&\7\3\2\2&\7\3\2\2\2\'(\t\2\2\2("+
		"\t\3\2\2\2)*\7\t\2\2*\13\3\2\2\2+,\7\n\2\2,\r\3\2\2\2-.\7\13\2\2.\17\3"+
		"\2\2\2/\60\7\f\2\2\60\21\3\2\2\2\61\62\t\3\2\2\62\23\3\2\2\2\63\64\7\r"+
		"\2\2\64\25\3\2\2\2\4\31#";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}