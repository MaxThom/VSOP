// Generated from Parser\PARSER.g4 by ANTLR 4.7.1
package VSOP.Parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PARSERParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_code = 1, RULE_statement = 2, RULE_classHeader = 3, 
		RULE_classBody = 4, RULE_methodHeader = 5, RULE_methodBody = 6, RULE_formal = 7, 
		RULE_field = 8, RULE_assign = 9, RULE_whileStatement = 10, RULE_ifStatement = 11, 
		RULE_ifStat = 12, RULE_elseStat = 13, RULE_condition = 14, RULE_comparaiser = 15, 
		RULE_integer = 16, RULE_varType = 17, RULE_varValue = 18;
	public static final String[] ruleNames = {
		"program", "code", "statement", "classHeader", "classBody", "methodHeader", 
		"methodBody", "formal", "field", "assign", "whileStatement", "ifStatement", 
		"ifStat", "elseStat", "condition", "comparaiser", "integer", "varType", 
		"varValue"
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

	@Override
	public String getGrammarFileName() { return "PARSER.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PARSERParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<CodeContext> code() {
			return getRuleContexts(CodeContext.class);
		}
		public CodeContext code(int i) {
			return getRuleContext(CodeContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(38);
				code();
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__10) | (1L << T__12) | (1L << OBJECT_IDENTIFIER))) != 0) );
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

	public static class CodeContext extends ParserRuleContext {
		public ClassHeaderContext classHeader() {
			return getRuleContext(ClassHeaderContext.class,0);
		}
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public CodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_code; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitCode(this);
		}
	}

	public final CodeContext code() throws RecognitionException {
		CodeContext _localctx = new CodeContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_code);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				classHeader();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				methodHeader();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				statement();
				}
				break;
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
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_statement);
		try {
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				assign();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(49);
				ifStatement();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				whileStatement();
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

	public static class ClassHeaderContext extends ParserRuleContext {
		public List<TerminalNode> TYPE_IDENTIFIER() { return getTokens(PARSERParser.TYPE_IDENTIFIER); }
		public TerminalNode TYPE_IDENTIFIER(int i) {
			return getToken(PARSERParser.TYPE_IDENTIFIER, i);
		}
		public List<ClassBodyContext> classBody() {
			return getRuleContexts(ClassBodyContext.class);
		}
		public ClassBodyContext classBody(int i) {
			return getRuleContext(ClassBodyContext.class,i);
		}
		public ClassHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterClassHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitClassHeader(this);
		}
	}

	public final ClassHeaderContext classHeader() throws RecognitionException {
		ClassHeaderContext _localctx = new ClassHeaderContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__0);
			setState(54);
			match(TYPE_IDENTIFIER);
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(55);
				match(T__1);
				setState(56);
				match(TYPE_IDENTIFIER);
				}
			}

			setState(59);
			match(T__2);
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OBJECT_IDENTIFIER) {
				{
				{
				setState(60);
				classBody();
				}
				}
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(66);
			match(T__3);
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

	public static class ClassBodyContext extends ParserRuleContext {
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public FieldContext field() {
			return getRuleContext(FieldContext.class,0);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitClassBody(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classBody);
		try {
			setState(70);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				methodHeader();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69);
				field();
				}
				break;
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

	public static class MethodHeaderContext extends ParserRuleContext {
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<MethodBodyContext> methodBody() {
			return getRuleContexts(MethodBodyContext.class);
		}
		public MethodBodyContext methodBody(int i) {
			return getRuleContext(MethodBodyContext.class,i);
		}
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public MethodHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterMethodHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitMethodHeader(this);
		}
	}

	public final MethodHeaderContext methodHeader() throws RecognitionException {
		MethodHeaderContext _localctx = new MethodHeaderContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_methodHeader);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			match(OBJECT_IDENTIFIER);
			setState(73);
			match(T__4);
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				{
				setState(77); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(74);
						formal();
						setState(75);
						match(T__5);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(79); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				{
				setState(81);
				formal();
				}
				}
				}
				break;
			case 2:
				{
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OBJECT_IDENTIFIER) {
					{
					setState(83);
					formal();
					}
				}

				}
				break;
			}
			setState(88);
			match(T__6);
			setState(89);
			match(T__7);
			setState(90);
			varType();
			setState(91);
			match(T__2);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__10) | (1L << T__12) | (1L << OBJECT_IDENTIFIER))) != 0)) {
				{
				{
				setState(92);
				methodBody();
				}
				}
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(98);
			match(T__3);
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

	public static class MethodBodyContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitMethodBody(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			statement();
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

	public static class FormalContext extends ParserRuleContext {
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterFormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitFormal(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(OBJECT_IDENTIFIER);
			setState(103);
			match(T__7);
			setState(104);
			varType();
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

	public static class FieldContext extends ParserRuleContext {
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public FieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(OBJECT_IDENTIFIER);
			setState(107);
			match(T__7);
			setState(108);
			varType();
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(109);
				match(T__8);
				setState(110);
				varValue();
				}
			}

			setState(113);
			match(T__9);
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

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_assign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(OBJECT_IDENTIFIER);
			setState(116);
			match(T__7);
			setState(117);
			varType();
			setState(120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(118);
				match(T__8);
				setState(119);
				varValue();
				}
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

	public static class WhileStatementContext extends ParserRuleContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_whileStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__10);
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INTEGER_BIN) | (1L << INTEGER_HEX) | (1L << INTEGER_DEC) | (1L << OBJECT_IDENTIFIER) | (1L << STRING))) != 0)) {
				{
				{
				setState(123);
				condition();
				}
				}
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(129);
			match(T__11);
			setState(133);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(130);
					statement();
					}
					} 
				}
				setState(135);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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

	public static class IfStatementContext extends ParserRuleContext {
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public ElseStatContext elseStat() {
			return getRuleContext(ElseStatContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			ifStat();
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(137);
				elseStat();
				}
				break;
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

	public static class IfStatContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitIfStat(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			match(T__12);
			setState(141);
			condition();
			setState(142);
			match(T__13);
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(143);
					statement();
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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

	public static class ElseStatContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ElseStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterElseStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitElseStat(this);
		}
	}

	public final ElseStatContext elseStat() throws RecognitionException {
		ElseStatContext _localctx = new ElseStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_elseStat);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__14);
			setState(153);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(150);
					statement();
					}
					} 
				}
				setState(155);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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

	public static class ConditionContext extends ParserRuleContext {
		public List<ComparaiserContext> comparaiser() {
			return getRuleContexts(ComparaiserContext.class);
		}
		public ComparaiserContext comparaiser(int i) {
			return getRuleContext(ComparaiserContext.class,i);
		}
		public TerminalNode CONDITIONAL_OPERATOR() { return getToken(PARSERParser.CONDITIONAL_OPERATOR, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			comparaiser();
			setState(157);
			match(CONDITIONAL_OPERATOR);
			setState(158);
			comparaiser();
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

	public static class ComparaiserContext extends ParserRuleContext {
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode STRING() { return getToken(PARSERParser.STRING, 0); }
		public ComparaiserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparaiser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterComparaiser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitComparaiser(this);
		}
	}

	public final ComparaiserContext comparaiser() throws RecognitionException {
		ComparaiserContext _localctx = new ComparaiserContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_comparaiser);
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				integer();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(162);
				match(STRING);
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

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER_HEX() { return getToken(PARSERParser.INTEGER_HEX, 0); }
		public TerminalNode INTEGER_DEC() { return getToken(PARSERParser.INTEGER_DEC, 0); }
		public TerminalNode INTEGER_BIN() { return getToken(PARSERParser.INTEGER_BIN, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
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

	public static class VarTypeContext extends ParserRuleContext {
		public TerminalNode TYPE_IDENTIFIER() { return getToken(PARSERParser.TYPE_IDENTIFIER, 0); }
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitVarType(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << TYPE_IDENTIFIER))) != 0)) ) {
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

	public static class VarValueContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PARSERParser.STRING, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public VarValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterVarValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitVarValue(this);
		}
	}

	public final VarValueContext varValue() throws RecognitionException {
		VarValueContext _localctx = new VarValueContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_varValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				{
				setState(169);
				match(T__19);
				}
				break;
			case T__20:
				{
				setState(170);
				match(T__20);
				}
				break;
			case STRING:
				{
				setState(171);
				match(STRING);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				{
				setState(172);
				integer();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3$\u00b2\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\6\2*\n\2\r\2\16\2+\3\3\3\3\3\3\5\3\61\n\3\3\4"+
		"\3\4\3\4\5\4\66\n\4\3\5\3\5\3\5\3\5\5\5<\n\5\3\5\3\5\7\5@\n\5\f\5\16\5"+
		"C\13\5\3\5\3\5\3\6\3\6\5\6I\n\6\3\7\3\7\3\7\3\7\3\7\6\7P\n\7\r\7\16\7"+
		"Q\3\7\3\7\3\7\5\7W\n\7\5\7Y\n\7\3\7\3\7\3\7\3\7\3\7\7\7`\n\7\f\7\16\7"+
		"c\13\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\5\nr\n\n\3"+
		"\n\3\n\3\13\3\13\3\13\3\13\3\13\5\13{\n\13\3\f\3\f\7\f\177\n\f\f\f\16"+
		"\f\u0082\13\f\3\f\3\f\7\f\u0086\n\f\f\f\16\f\u0089\13\f\3\r\3\r\5\r\u008d"+
		"\n\r\3\16\3\16\3\16\3\16\7\16\u0093\n\16\f\16\16\16\u0096\13\16\3\17\3"+
		"\17\7\17\u009a\n\17\f\17\16\17\u009d\13\17\3\20\3\20\3\20\3\20\3\21\3"+
		"\21\3\21\5\21\u00a6\n\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\5\24"+
		"\u00b0\n\24\3\24\2\2\25\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2"+
		"\4\3\2\35\37\4\2\22\25!!\2\u00b6\2)\3\2\2\2\4\60\3\2\2\2\6\65\3\2\2\2"+
		"\b\67\3\2\2\2\nH\3\2\2\2\fJ\3\2\2\2\16f\3\2\2\2\20h\3\2\2\2\22l\3\2\2"+
		"\2\24u\3\2\2\2\26|\3\2\2\2\30\u008a\3\2\2\2\32\u008e\3\2\2\2\34\u0097"+
		"\3\2\2\2\36\u009e\3\2\2\2 \u00a5\3\2\2\2\"\u00a7\3\2\2\2$\u00a9\3\2\2"+
		"\2&\u00af\3\2\2\2(*\5\4\3\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\3"+
		"\3\2\2\2-\61\5\b\5\2.\61\5\f\7\2/\61\5\6\4\2\60-\3\2\2\2\60.\3\2\2\2\60"+
		"/\3\2\2\2\61\5\3\2\2\2\62\66\5\24\13\2\63\66\5\30\r\2\64\66\5\26\f\2\65"+
		"\62\3\2\2\2\65\63\3\2\2\2\65\64\3\2\2\2\66\7\3\2\2\2\678\7\3\2\28;\7!"+
		"\2\29:\7\4\2\2:<\7!\2\2;9\3\2\2\2;<\3\2\2\2<=\3\2\2\2=A\7\5\2\2>@\5\n"+
		"\6\2?>\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BD\3\2\2\2CA\3\2\2\2DE\7\6"+
		"\2\2E\t\3\2\2\2FI\5\f\7\2GI\5\22\n\2HF\3\2\2\2HG\3\2\2\2I\13\3\2\2\2J"+
		"K\7 \2\2KX\7\7\2\2LM\5\20\t\2MN\7\b\2\2NP\3\2\2\2OL\3\2\2\2PQ\3\2\2\2"+
		"QO\3\2\2\2QR\3\2\2\2RS\3\2\2\2ST\5\20\t\2TY\3\2\2\2UW\5\20\t\2VU\3\2\2"+
		"\2VW\3\2\2\2WY\3\2\2\2XO\3\2\2\2XV\3\2\2\2YZ\3\2\2\2Z[\7\t\2\2[\\\7\n"+
		"\2\2\\]\5$\23\2]a\7\5\2\2^`\5\16\b\2_^\3\2\2\2`c\3\2\2\2a_\3\2\2\2ab\3"+
		"\2\2\2bd\3\2\2\2ca\3\2\2\2de\7\6\2\2e\r\3\2\2\2fg\5\6\4\2g\17\3\2\2\2"+
		"hi\7 \2\2ij\7\n\2\2jk\5$\23\2k\21\3\2\2\2lm\7 \2\2mn\7\n\2\2nq\5$\23\2"+
		"op\7\13\2\2pr\5&\24\2qo\3\2\2\2qr\3\2\2\2rs\3\2\2\2st\7\f\2\2t\23\3\2"+
		"\2\2uv\7 \2\2vw\7\n\2\2wz\5$\23\2xy\7\13\2\2y{\5&\24\2zx\3\2\2\2z{\3\2"+
		"\2\2{\25\3\2\2\2|\u0080\7\r\2\2}\177\5\36\20\2~}\3\2\2\2\177\u0082\3\2"+
		"\2\2\u0080~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0083\3\2\2\2\u0082\u0080"+
		"\3\2\2\2\u0083\u0087\7\16\2\2\u0084\u0086\5\6\4\2\u0085\u0084\3\2\2\2"+
		"\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\27"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008c\5\32\16\2\u008b\u008d\5\34\17"+
		"\2\u008c\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\31\3\2\2\2\u008e\u008f"+
		"\7\17\2\2\u008f\u0090\5\36\20\2\u0090\u0094\7\20\2\2\u0091\u0093\5\6\4"+
		"\2\u0092\u0091\3\2\2\2\u0093\u0096\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095"+
		"\3\2\2\2\u0095\33\3\2\2\2\u0096\u0094\3\2\2\2\u0097\u009b\7\21\2\2\u0098"+
		"\u009a\5\6\4\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009b\u009c\3\2\2\2\u009c\35\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f"+
		"\5 \21\2\u009f\u00a0\7\31\2\2\u00a0\u00a1\5 \21\2\u00a1\37\3\2\2\2\u00a2"+
		"\u00a6\7 \2\2\u00a3\u00a6\5\"\22\2\u00a4\u00a6\7\"\2\2\u00a5\u00a2\3\2"+
		"\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6!\3\2\2\2\u00a7\u00a8"+
		"\t\2\2\2\u00a8#\3\2\2\2\u00a9\u00aa\t\3\2\2\u00aa%\3\2\2\2\u00ab\u00b0"+
		"\7\26\2\2\u00ac\u00b0\7\27\2\2\u00ad\u00b0\7\"\2\2\u00ae\u00b0\5\"\22"+
		"\2\u00af\u00ab\3\2\2\2\u00af\u00ac\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00ae"+
		"\3\2\2\2\u00b0\'\3\2\2\2\25+\60\65;AHQVXaqz\u0080\u0087\u008c\u0094\u009b"+
		"\u00a5\u00af";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}