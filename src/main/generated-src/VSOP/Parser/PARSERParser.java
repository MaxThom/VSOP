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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, ARITHMETIC_OPERATOR=24, 
		CONDITIONAL_OPERATOR=25, MULTILINE_OPEN_COMMENT=26, MULTILINE_CLOSE_COMMENT=27, 
		MULTILINE_COMMENT=28, INTEGER_BIN=29, INTEGER_HEX=30, INTEGER_DEC=31, 
		OBJECT_IDENTIFIER=32, TYPE_IDENTIFIER=33, STRING=34, SINGLE_LINE_COMMENT=35, 
		WS=36;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_block = 2, RULE_classDefinition = 3, 
		RULE_methodDefinition = 4, RULE_formal = 5, RULE_field = 6, RULE_assign = 7, 
		RULE_whileStatement = 8, RULE_ifStatement = 9, RULE_ifStat = 10, RULE_elseStat = 11, 
		RULE_let = 12, RULE_condition = 13, RULE_comparaiser = 14, RULE_integer = 15, 
		RULE_varType = 16, RULE_varValue = 17;
	public static final String[] ruleNames = {
		"program", "statement", "block", "classDefinition", "methodDefinition", 
		"formal", "field", "assign", "whileStatement", "ifStatement", "ifStat", 
		"elseStat", "let", "condition", "comparaiser", "integer", "varType", "varValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "';'", "'}'", "'class'", "'extends'", "'('", "','", "')'", 
		"':'", "'<-'", "'while'", "'do'", "'if'", "'then'", "'else'", "'let'", 
		"'in'", "'bool'", "'int32'", "'string'", "'unit'", "'true'", "'false'", 
		null, null, "'(*'", "'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"ARITHMETIC_OPERATOR", "CONDITIONAL_OPERATOR", "MULTILINE_OPEN_COMMENT", 
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
		public List<ClassDefinitionContext> classDefinition() {
			return getRuleContexts(ClassDefinitionContext.class);
		}
		public ClassDefinitionContext classDefinition(int i) {
			return getRuleContext(ClassDefinitionContext.class,i);
		}
		public List<MethodDefinitionContext> methodDefinition() {
			return getRuleContexts(MethodDefinitionContext.class);
		}
		public MethodDefinitionContext methodDefinition(int i) {
			return getRuleContext(MethodDefinitionContext.class,i);
		}
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
				setState(39);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(36);
					classDefinition();
					}
					break;
				case 2:
					{
					setState(37);
					methodDefinition();
					}
					break;
				case 3:
					{
					setState(38);
					statement();
					}
					break;
				}
				}
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__10) | (1L << T__12) | (1L << T__15) | (1L << OBJECT_IDENTIFIER))) != 0) );
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
		public LetContext let() {
			return getRuleContext(LetContext.class,0);
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
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(47);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(43);
				assign();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				ifStatement();
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
				whileStatement();
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 4);
				{
				setState(46);
				let();
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<WhileStatementContext> whileStatement() {
			return getRuleContexts(WhileStatementContext.class);
		}
		public WhileStatementContext whileStatement(int i) {
			return getRuleContext(WhileStatementContext.class,i);
		}
		public List<IfStatementContext> ifStatement() {
			return getRuleContexts(IfStatementContext.class);
		}
		public IfStatementContext ifStatement(int i) {
			return getRuleContext(IfStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_block);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			match(T__0);
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(50);
				statement();
				}
				break;
			case 2:
				{
				{
				setState(56); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(56);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
						case 1:
							{
							{
							setState(51);
							statement();
							setState(52);
							match(T__1);
							}
							}
							break;
						case 2:
							{
							setState(54);
							whileStatement();
							}
							break;
						case 3:
							{
							setState(55);
							ifStatement();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(58); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(60);
				statement();
				}
				}
				break;
			}
			setState(64);
			match(T__2);
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

	public static class ClassDefinitionContext extends ParserRuleContext {
		public List<TerminalNode> TYPE_IDENTIFIER() { return getTokens(PARSERParser.TYPE_IDENTIFIER); }
		public TerminalNode TYPE_IDENTIFIER(int i) {
			return getToken(PARSERParser.TYPE_IDENTIFIER, i);
		}
		public List<MethodDefinitionContext> methodDefinition() {
			return getRuleContexts(MethodDefinitionContext.class);
		}
		public MethodDefinitionContext methodDefinition(int i) {
			return getRuleContext(MethodDefinitionContext.class,i);
		}
		public List<FieldContext> field() {
			return getRuleContexts(FieldContext.class);
		}
		public FieldContext field(int i) {
			return getRuleContext(FieldContext.class,i);
		}
		public ClassDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterClassDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitClassDefinition(this);
		}
	}

	public final ClassDefinitionContext classDefinition() throws RecognitionException {
		ClassDefinitionContext _localctx = new ClassDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__3);
			setState(67);
			match(TYPE_IDENTIFIER);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(68);
				match(T__4);
				setState(69);
				match(TYPE_IDENTIFIER);
				}
			}

			setState(72);
			match(T__0);
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OBJECT_IDENTIFIER) {
				{
				setState(75);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(73);
					methodDefinition();
					}
					break;
				case 2:
					{
					setState(74);
					field();
					}
					break;
				}
				}
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(80);
			match(T__2);
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

	public static class MethodDefinitionContext extends ParserRuleContext {
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<FormalContext> formal() {
			return getRuleContexts(FormalContext.class);
		}
		public FormalContext formal(int i) {
			return getRuleContext(FormalContext.class,i);
		}
		public MethodDefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDefinition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterMethodDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitMethodDefinition(this);
		}
	}

	public final MethodDefinitionContext methodDefinition() throws RecognitionException {
		MethodDefinitionContext _localctx = new MethodDefinitionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_methodDefinition);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(OBJECT_IDENTIFIER);
			setState(83);
			match(T__5);
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				{
				setState(87); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(84);
						formal();
						setState(85);
						match(T__6);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(89); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				{
				setState(91);
				formal();
				}
				}
				}
				break;
			case 2:
				{
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OBJECT_IDENTIFIER) {
					{
					setState(93);
					formal();
					}
				}

				}
				break;
			}
			setState(98);
			match(T__7);
			setState(99);
			match(T__8);
			setState(100);
			varType();
			setState(101);
			block();
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
		enterRule(_localctx, 10, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			match(OBJECT_IDENTIFIER);
			setState(104);
			match(T__8);
			setState(105);
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
		enterRule(_localctx, 12, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(OBJECT_IDENTIFIER);
			setState(108);
			match(T__8);
			setState(109);
			varType();
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(110);
				match(T__9);
				setState(111);
				varValue();
				}
			}

			setState(114);
			match(T__1);
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
		public List<TerminalNode> OBJECT_IDENTIFIER() { return getTokens(PARSERParser.OBJECT_IDENTIFIER); }
		public TerminalNode OBJECT_IDENTIFIER(int i) {
			return getToken(PARSERParser.OBJECT_IDENTIFIER, i);
		}
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
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
		enterRule(_localctx, 14, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(OBJECT_IDENTIFIER);
			setState(117);
			match(T__9);
			setState(121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				setState(118);
				varValue();
				}
				break;
			case 2:
				{
				setState(119);
				statement();
				}
				break;
			case 3:
				{
				setState(120);
				match(OBJECT_IDENTIFIER);
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

	public static class WhileStatementContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 16, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			match(T__10);
			setState(124);
			condition();
			setState(125);
			match(T__11);
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__12:
			case T__15:
			case OBJECT_IDENTIFIER:
				{
				setState(126);
				statement();
				}
				break;
			case T__0:
				{
				setState(127);
				block();
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
		enterRule(_localctx, 18, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			ifStat();
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(131);
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 20, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(T__12);
			setState(135);
			condition();
			setState(136);
			match(T__13);
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__12:
			case T__15:
			case OBJECT_IDENTIFIER:
				{
				setState(137);
				statement();
				}
				break;
			case T__0:
				{
				setState(138);
				block();
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

	public static class ElseStatContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 22, RULE_elseStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(T__14);
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
			case T__12:
			case T__15:
			case OBJECT_IDENTIFIER:
				{
				setState(142);
				statement();
				}
				break;
			case T__0:
				{
				setState(143);
				block();
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

	public static class LetContext extends ParserRuleContext {
		public List<TerminalNode> OBJECT_IDENTIFIER() { return getTokens(PARSERParser.OBJECT_IDENTIFIER); }
		public TerminalNode OBJECT_IDENTIFIER(int i) {
			return getToken(PARSERParser.OBJECT_IDENTIFIER, i);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public LetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_let; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitLet(this);
		}
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_let);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__15);
			setState(147);
			match(OBJECT_IDENTIFIER);
			setState(148);
			match(T__8);
			setState(149);
			varType();
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(150);
				match(T__9);
				setState(151);
				varValue();
				}
				break;
			case 2:
				{
				setState(152);
				statement();
				}
				break;
			case 3:
				{
				setState(153);
				match(OBJECT_IDENTIFIER);
				}
				break;
			}
			setState(156);
			match(T__16);
			setState(157);
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
		enterRule(_localctx, 26, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			comparaiser();
			setState(160);
			match(CONDITIONAL_OPERATOR);
			setState(161);
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
		enterRule(_localctx, 28, RULE_comparaiser);
		try {
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(164);
				integer();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(165);
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
		enterRule(_localctx, 30, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
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
		enterRule(_localctx, 32, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << TYPE_IDENTIFIER))) != 0)) ) {
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
		enterRule(_localctx, 34, RULE_varValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__21:
				{
				setState(172);
				match(T__21);
				}
				break;
			case T__22:
				{
				setState(173);
				match(T__22);
				}
				break;
			case STRING:
				{
				setState(174);
				match(STRING);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				{
				setState(175);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3&\u00b5\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\6\2*\n\2\r\2\16\2+\3\3\3\3\3\3\3\3\5\3\62\n\3\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4;\n\4\r\4\16\4<\3\4\3\4\5\4A\n\4\3\4\3\4"+
		"\3\5\3\5\3\5\3\5\5\5I\n\5\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5\3\5\3\5"+
		"\3\6\3\6\3\6\3\6\3\6\6\6Z\n\6\r\6\16\6[\3\6\3\6\3\6\5\6a\n\6\5\6c\n\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\bs\n\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\t\3\t\5\t|\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u0083\n\n\3"+
		"\13\3\13\5\13\u0087\n\13\3\f\3\f\3\f\3\f\3\f\5\f\u008e\n\f\3\r\3\r\3\r"+
		"\5\r\u0093\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u009d\n\16"+
		"\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\5\20\u00a9\n\20\3\21"+
		"\3\21\3\22\3\22\3\23\3\23\3\23\3\23\5\23\u00b3\n\23\3\23\2\2\24\2\4\6"+
		"\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\4\3\2\37!\4\2\24\27##\2\u00c2"+
		"\2)\3\2\2\2\4\61\3\2\2\2\6\63\3\2\2\2\bD\3\2\2\2\nT\3\2\2\2\fi\3\2\2\2"+
		"\16m\3\2\2\2\20v\3\2\2\2\22}\3\2\2\2\24\u0084\3\2\2\2\26\u0088\3\2\2\2"+
		"\30\u008f\3\2\2\2\32\u0094\3\2\2\2\34\u00a1\3\2\2\2\36\u00a8\3\2\2\2 "+
		"\u00aa\3\2\2\2\"\u00ac\3\2\2\2$\u00b2\3\2\2\2&*\5\b\5\2\'*\5\n\6\2(*\5"+
		"\4\3\2)&\3\2\2\2)\'\3\2\2\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\3"+
		"\3\2\2\2-\62\5\20\t\2.\62\5\24\13\2/\62\5\22\n\2\60\62\5\32\16\2\61-\3"+
		"\2\2\2\61.\3\2\2\2\61/\3\2\2\2\61\60\3\2\2\2\62\5\3\2\2\2\63@\7\3\2\2"+
		"\64A\5\4\3\2\65\66\5\4\3\2\66\67\7\4\2\2\67;\3\2\2\28;\5\22\n\29;\5\24"+
		"\13\2:\65\3\2\2\2:8\3\2\2\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=>"+
		"\3\2\2\2>?\5\4\3\2?A\3\2\2\2@\64\3\2\2\2@:\3\2\2\2@A\3\2\2\2AB\3\2\2\2"+
		"BC\7\5\2\2C\7\3\2\2\2DE\7\6\2\2EH\7#\2\2FG\7\7\2\2GI\7#\2\2HF\3\2\2\2"+
		"HI\3\2\2\2IJ\3\2\2\2JO\7\3\2\2KN\5\n\6\2LN\5\16\b\2MK\3\2\2\2ML\3\2\2"+
		"\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2PR\3\2\2\2QO\3\2\2\2RS\7\5\2\2S\t\3\2"+
		"\2\2TU\7\"\2\2Ub\7\b\2\2VW\5\f\7\2WX\7\t\2\2XZ\3\2\2\2YV\3\2\2\2Z[\3\2"+
		"\2\2[Y\3\2\2\2[\\\3\2\2\2\\]\3\2\2\2]^\5\f\7\2^c\3\2\2\2_a\5\f\7\2`_\3"+
		"\2\2\2`a\3\2\2\2ac\3\2\2\2bY\3\2\2\2b`\3\2\2\2cd\3\2\2\2de\7\n\2\2ef\7"+
		"\13\2\2fg\5\"\22\2gh\5\6\4\2h\13\3\2\2\2ij\7\"\2\2jk\7\13\2\2kl\5\"\22"+
		"\2l\r\3\2\2\2mn\7\"\2\2no\7\13\2\2or\5\"\22\2pq\7\f\2\2qs\5$\23\2rp\3"+
		"\2\2\2rs\3\2\2\2st\3\2\2\2tu\7\4\2\2u\17\3\2\2\2vw\7\"\2\2w{\7\f\2\2x"+
		"|\5$\23\2y|\5\4\3\2z|\7\"\2\2{x\3\2\2\2{y\3\2\2\2{z\3\2\2\2|\21\3\2\2"+
		"\2}~\7\r\2\2~\177\5\34\17\2\177\u0082\7\16\2\2\u0080\u0083\5\4\3\2\u0081"+
		"\u0083\5\6\4\2\u0082\u0080\3\2\2\2\u0082\u0081\3\2\2\2\u0083\23\3\2\2"+
		"\2\u0084\u0086\5\26\f\2\u0085\u0087\5\30\r\2\u0086\u0085\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\25\3\2\2\2\u0088\u0089\7\17\2\2\u0089\u008a\5\34"+
		"\17\2\u008a\u008d\7\20\2\2\u008b\u008e\5\4\3\2\u008c\u008e\5\6\4\2\u008d"+
		"\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\27\3\2\2\2\u008f\u0092\7\21\2"+
		"\2\u0090\u0093\5\4\3\2\u0091\u0093\5\6\4\2\u0092\u0090\3\2\2\2\u0092\u0091"+
		"\3\2\2\2\u0093\31\3\2\2\2\u0094\u0095\7\22\2\2\u0095\u0096\7\"\2\2\u0096"+
		"\u0097\7\13\2\2\u0097\u009c\5\"\22\2\u0098\u0099\7\f\2\2\u0099\u009d\5"+
		"$\23\2\u009a\u009d\5\4\3\2\u009b\u009d\7\"\2\2\u009c\u0098\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2"+
		"\2\2\u009e\u009f\7\23\2\2\u009f\u00a0\5\4\3\2\u00a0\33\3\2\2\2\u00a1\u00a2"+
		"\5\36\20\2\u00a2\u00a3\7\33\2\2\u00a3\u00a4\5\36\20\2\u00a4\35\3\2\2\2"+
		"\u00a5\u00a9\7\"\2\2\u00a6\u00a9\5 \21\2\u00a7\u00a9\7$\2\2\u00a8\u00a5"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\37\3\2\2\2\u00aa"+
		"\u00ab\t\2\2\2\u00ab!\3\2\2\2\u00ac\u00ad\t\3\2\2\u00ad#\3\2\2\2\u00ae"+
		"\u00b3\7\30\2\2\u00af\u00b3\7\31\2\2\u00b0\u00b3\7$\2\2\u00b1\u00b3\5"+
		" \21\2\u00b2\u00ae\3\2\2\2\u00b2\u00af\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b1\3\2\2\2\u00b3%\3\2\2\2\27)+\61:<@HMO[`br{\u0082\u0086\u008d\u0092"+
		"\u009c\u00a8\u00b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}