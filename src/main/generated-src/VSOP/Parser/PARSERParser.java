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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, UN_OPERATOR=26, FACTOR_OPERATOR=27, TERM_OPERATOR=28, AND_OPERATOR=29, 
		CONDITIONAL_OPERATOR=30, NEGATIVE_OPERATOR=31, MULTILINE_OPEN_COMMENT=32, 
		MULTILINE_CLOSE_COMMENT=33, MULTILINE_COMMENT=34, INTEGER_BIN=35, INTEGER_HEX=36, 
		INTEGER_DEC=37, OBJECT_IDENTIFIER=38, TYPE_IDENTIFIER=39, STRING=40, SINGLE_LINE_COMMENT=41, 
		WS=42;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_block = 2, RULE_classDefinition = 3, 
		RULE_methodDefinition = 4, RULE_formal = 5, RULE_field = 6, RULE_callMethod = 7, 
		RULE_singleCallMethod = 8, RULE_caller = 9, RULE_callFunction = 10, RULE_argument = 11, 
		RULE_assign = 12, RULE_whileStatement = 13, RULE_ifStatement = 14, RULE_ifStat = 15, 
		RULE_elseStat = 16, RULE_let = 17, RULE_binaryOperation = 18, RULE_condition = 19, 
		RULE_term = 20, RULE_factor = 21, RULE_value = 22, RULE_unOperation = 23, 
		RULE_newObj = 24, RULE_unOperator = 25, RULE_termOperator = 26, RULE_comparaiser = 27, 
		RULE_integer = 28, RULE_varType = 29, RULE_varValue = 30;
	public static final String[] ruleNames = {
		"program", "statement", "block", "classDefinition", "methodDefinition", 
		"formal", "field", "callMethod", "singleCallMethod", "caller", "callFunction", 
		"argument", "assign", "whileStatement", "ifStatement", "ifStat", "elseStat", 
		"let", "binaryOperation", "condition", "term", "factor", "value", "unOperation", 
		"newObj", "unOperator", "termOperator", "comparaiser", "integer", "varType", 
		"varValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "';'", "'}'", "'class'", "'extends'", "','", 
		"':'", "'<-'", "'.'", "'while'", "'do'", "'if'", "'then'", "'else'", "'let'", 
		"'in'", "'new'", "'bool'", "'int32'", "'string'", "'unit'", "'true'", 
		"'false'", null, "'d zzdqasdw'", null, "'and'", null, "'-'", "'(*'", "'*)'"
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
			setState(63); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(62);
				classDefinition();
				}
				}
				setState(65); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__5 );
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
		public CallMethodContext callMethod() {
			return getRuleContext(CallMethodContext.class,0);
		}
		public NewObjContext newObj() {
			return getRuleContext(NewObjContext.class,0);
		}
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BinaryOperationContext binaryOperation() {
			return getRuleContext(BinaryOperationContext.class,0);
		}
		public UnOperationContext unOperation() {
			return getRuleContext(UnOperationContext.class,0);
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
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				ifStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				whileStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				let();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				callMethod();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(72);
				newObj();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(73);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(74);
				varValue();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(75);
				match(T__0);
				setState(76);
				statement();
				setState(77);
				match(T__1);
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(79);
				binaryOperation();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(80);
				unOperation();
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
			setState(83);
			match(T__2);
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(84);
				statement();
				}
				break;
			case 2:
				{
				{
				setState(90); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(90);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
						case 1:
							{
							{
							setState(85);
							statement();
							setState(86);
							match(T__3);
							}
							}
							break;
						case 2:
							{
							setState(88);
							whileStatement();
							}
							break;
						case 3:
							{
							setState(89);
							ifStatement();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(92); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(94);
				statement();
				}
				}
				break;
			}
			setState(98);
			match(T__4);
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
			setState(100);
			match(T__5);
			setState(101);
			match(TYPE_IDENTIFIER);
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(102);
				match(T__6);
				setState(103);
				match(TYPE_IDENTIFIER);
				}
			}

			setState(106);
			match(T__2);
			setState(111);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OBJECT_IDENTIFIER) {
				{
				setState(109);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(107);
					methodDefinition();
					}
					break;
				case 2:
					{
					setState(108);
					field();
					}
					break;
				}
				}
				setState(113);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(114);
			match(T__4);
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
			setState(116);
			match(OBJECT_IDENTIFIER);
			setState(117);
			match(T__0);
			setState(130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				{
				setState(121); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(118);
						formal();
						setState(119);
						match(T__7);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(123); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				{
				setState(125);
				formal();
				}
				}
				}
				break;
			case 2:
				{
				setState(128);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OBJECT_IDENTIFIER) {
					{
					setState(127);
					formal();
					}
				}

				}
				break;
			}
			setState(132);
			match(T__1);
			setState(133);
			match(T__8);
			setState(134);
			varType();
			setState(135);
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
			setState(137);
			match(OBJECT_IDENTIFIER);
			setState(138);
			match(T__8);
			setState(139);
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
			setState(141);
			match(OBJECT_IDENTIFIER);
			setState(142);
			match(T__8);
			setState(143);
			varType();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(144);
				match(T__9);
				setState(147);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__11:
				case T__13:
				case T__16:
				case T__18:
				case T__23:
				case T__24:
				case UN_OPERATOR:
				case NEGATIVE_OPERATOR:
				case INTEGER_BIN:
				case INTEGER_HEX:
				case INTEGER_DEC:
				case OBJECT_IDENTIFIER:
				case STRING:
					{
					setState(145);
					statement();
					}
					break;
				case T__2:
					{
					setState(146);
					block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(151);
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

	public static class CallMethodContext extends ParserRuleContext {
		public List<SingleCallMethodContext> singleCallMethod() {
			return getRuleContexts(SingleCallMethodContext.class);
		}
		public SingleCallMethodContext singleCallMethod(int i) {
			return getRuleContext(SingleCallMethodContext.class,i);
		}
		public CallMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterCallMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitCallMethod(this);
		}
	}

	public final CallMethodContext callMethod() throws RecognitionException {
		CallMethodContext _localctx = new CallMethodContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_callMethod);
		try {
			int _alt;
			setState(163);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(153);
				singleCallMethod();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(157); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(154);
						singleCallMethod();
						setState(155);
						match(T__10);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(159); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				{
				setState(161);
				singleCallMethod();
				}
				}
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

	public static class SingleCallMethodContext extends ParserRuleContext {
		public List<CallFunctionContext> callFunction() {
			return getRuleContexts(CallFunctionContext.class);
		}
		public CallFunctionContext callFunction(int i) {
			return getRuleContext(CallFunctionContext.class,i);
		}
		public List<CallerContext> caller() {
			return getRuleContexts(CallerContext.class);
		}
		public CallerContext caller(int i) {
			return getRuleContext(CallerContext.class,i);
		}
		public SingleCallMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleCallMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterSingleCallMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitSingleCallMethod(this);
		}
	}

	public final SingleCallMethodContext singleCallMethod() throws RecognitionException {
		SingleCallMethodContext _localctx = new SingleCallMethodContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_singleCallMethod);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(165);
					caller();
					}
					} 
				}
				setState(170);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(171);
			callFunction();
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(172);
					match(T__10);
					setState(173);
					callFunction();
					}
					} 
				}
				setState(178);
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

	public static class CallerContext extends ParserRuleContext {
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public NewObjContext newObj() {
			return getRuleContext(NewObjContext.class,0);
		}
		public CallerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caller; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterCaller(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitCaller(this);
		}
	}

	public final CallerContext caller() throws RecognitionException {
		CallerContext _localctx = new CallerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_caller);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT_IDENTIFIER:
				{
				setState(179);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case T__0:
				{
				{
				setState(180);
				match(T__0);
				setState(181);
				newObj();
				setState(182);
				match(T__1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(186);
			match(T__10);
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

	public static class CallFunctionContext extends ParserRuleContext {
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public CallFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterCallFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitCallFunction(this);
		}
	}

	public final CallFunctionContext callFunction() throws RecognitionException {
		CallFunctionContext _localctx = new CallFunctionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_callFunction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			match(OBJECT_IDENTIFIER);
			setState(189);
			match(T__0);
			setState(202);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				{
				setState(193); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(190);
						argument();
						setState(191);
						match(T__7);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(195); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(197);
				argument();
				}
				}
				break;
			case 2:
				{
				setState(200);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << UN_OPERATOR) | (1L << NEGATIVE_OPERATOR) | (1L << INTEGER_BIN) | (1L << INTEGER_HEX) | (1L << INTEGER_DEC) | (1L << OBJECT_IDENTIFIER) | (1L << STRING))) != 0)) {
					{
					setState(199);
					argument();
					}
				}

				}
				break;
			}
			setState(204);
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

	public static class ArgumentContext extends ParserRuleContext {
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public CallMethodContext callMethod() {
			return getRuleContext(CallMethodContext.class,0);
		}
		public NewObjContext newObj() {
			return getRuleContext(NewObjContext.class,0);
		}
		public BinaryOperationContext binaryOperation() {
			return getRuleContext(BinaryOperationContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_argument);
		try {
			setState(211);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(206);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(207);
				varValue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(208);
				callMethod();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(209);
				newObj();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(210);
				binaryOperation();
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

	public static class AssignContext extends ParserRuleContext {
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
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
		enterRule(_localctx, 24, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(OBJECT_IDENTIFIER);
			setState(214);
			match(T__9);
			setState(215);
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

	public static class WhileStatementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		enterRule(_localctx, 26, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
			match(T__11);
			setState(218);
			statement();
			setState(219);
			match(T__12);
			setState(222);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__11:
			case T__13:
			case T__16:
			case T__18:
			case T__23:
			case T__24:
			case UN_OPERATOR:
			case NEGATIVE_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(220);
				statement();
				}
				break;
			case T__2:
				{
				setState(221);
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
		enterRule(_localctx, 28, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			ifStat();
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(225);
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
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
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
		enterRule(_localctx, 30, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(228);
			match(T__13);
			setState(229);
			statement();
			setState(230);
			match(T__14);
			setState(233);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__11:
			case T__13:
			case T__16:
			case T__18:
			case T__23:
			case T__24:
			case UN_OPERATOR:
			case NEGATIVE_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(231);
				statement();
				}
				break;
			case T__2:
				{
				setState(232);
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
		enterRule(_localctx, 32, RULE_elseStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(T__15);
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__11:
			case T__13:
			case T__16:
			case T__18:
			case T__23:
			case T__24:
			case UN_OPERATOR:
			case NEGATIVE_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(236);
				statement();
				}
				break;
			case T__2:
				{
				setState(237);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
		enterRule(_localctx, 34, RULE_let);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(T__16);
			setState(241);
			match(OBJECT_IDENTIFIER);
			setState(242);
			match(T__8);
			setState(243);
			varType();
			setState(246);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(244);
				match(T__9);
				setState(245);
				statement();
				}
			}

			setState(248);
			match(T__17);
			setState(251);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__11:
			case T__13:
			case T__16:
			case T__18:
			case T__23:
			case T__24:
			case UN_OPERATOR:
			case NEGATIVE_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(249);
				statement();
				}
				break;
			case T__2:
				{
				setState(250);
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

	public static class BinaryOperationContext extends ParserRuleContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<TerminalNode> AND_OPERATOR() { return getTokens(PARSERParser.AND_OPERATOR); }
		public TerminalNode AND_OPERATOR(int i) {
			return getToken(PARSERParser.AND_OPERATOR, i);
		}
		public BinaryOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterBinaryOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitBinaryOperation(this);
		}
	}

	public final BinaryOperationContext binaryOperation() throws RecognitionException {
		BinaryOperationContext _localctx = new BinaryOperationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_binaryOperation);
		int _la;
		try {
			int _alt;
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(253);
				condition();
				setState(258);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(254);
						match(AND_OPERATOR);
						setState(255);
						condition();
						}
						} 
					}
					setState(260);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(261);
				match(T__0);
				setState(262);
				condition();
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND_OPERATOR) {
					{
					{
					setState(263);
					match(AND_OPERATOR);
					setState(264);
					condition();
					}
					}
					setState(269);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(270);
				match(T__1);
				}
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

	public static class ConditionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> CONDITIONAL_OPERATOR() { return getTokens(PARSERParser.CONDITIONAL_OPERATOR); }
		public TerminalNode CONDITIONAL_OPERATOR(int i) {
			return getToken(PARSERParser.CONDITIONAL_OPERATOR, i);
		}
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
		enterRule(_localctx, 38, RULE_condition);
		int _la;
		try {
			int _alt;
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				term();
				setState(279);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(275);
						match(CONDITIONAL_OPERATOR);
						setState(276);
						term();
						}
						} 
					}
					setState(281);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(282);
				match(T__0);
				setState(283);
				term();
				setState(288);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CONDITIONAL_OPERATOR) {
					{
					{
					setState(284);
					match(CONDITIONAL_OPERATOR);
					setState(285);
					term();
					}
					}
					setState(290);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(291);
				match(T__1);
				}
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

	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TermOperatorContext> termOperator() {
			return getRuleContexts(TermOperatorContext.class);
		}
		public TermOperatorContext termOperator(int i) {
			return getRuleContext(TermOperatorContext.class,i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_term);
		int _la;
		try {
			int _alt;
			setState(316);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				factor();
				setState(301);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(296);
						termOperator();
						setState(297);
						factor();
						}
						} 
					}
					setState(303);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(304);
				match(T__0);
				setState(305);
				factor();
				setState(311);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TERM_OPERATOR || _la==NEGATIVE_OPERATOR) {
					{
					{
					setState(306);
					termOperator();
					setState(307);
					factor();
					}
					}
					setState(313);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(314);
				match(T__1);
				}
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

	public static class FactorContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public List<TerminalNode> FACTOR_OPERATOR() { return getTokens(PARSERParser.FACTOR_OPERATOR); }
		public TerminalNode FACTOR_OPERATOR(int i) {
			return getToken(PARSERParser.FACTOR_OPERATOR, i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_factor);
		int _la;
		try {
			int _alt;
			setState(337);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(318);
				value();
				setState(323);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(319);
						match(FACTOR_OPERATOR);
						setState(320);
						value();
						}
						} 
					}
					setState(325);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(326);
				match(T__0);
				setState(327);
				value();
				setState(332);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FACTOR_OPERATOR) {
					{
					{
					setState(328);
					match(FACTOR_OPERATOR);
					setState(329);
					value();
					}
					}
					setState(334);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(335);
				match(T__1);
				}
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

	public static class ValueContext extends ParserRuleContext {
		public UnOperationContext unOperation() {
			return getRuleContext(UnOperationContext.class,0);
		}
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public CallMethodContext callMethod() {
			return getRuleContext(CallMethodContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_value);
		try {
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				unOperation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(340);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(341);
				varValue();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(342);
				callMethod();
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

	public static class UnOperationContext extends ParserRuleContext {
		public UnOperatorContext unOperator() {
			return getRuleContext(UnOperatorContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public UnOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterUnOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitUnOperation(this);
		}
	}

	public final UnOperationContext unOperation() throws RecognitionException {
		UnOperationContext _localctx = new UnOperationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_unOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			unOperator();
			setState(348);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(346);
				condition();
				}
				break;
			case 2:
				{
				setState(347);
				statement();
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

	public static class NewObjContext extends ParserRuleContext {
		public TerminalNode TYPE_IDENTIFIER() { return getToken(PARSERParser.TYPE_IDENTIFIER, 0); }
		public NewObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newObj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterNewObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitNewObj(this);
		}
	}

	public final NewObjContext newObj() throws RecognitionException {
		NewObjContext _localctx = new NewObjContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_newObj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(350);
			match(T__18);
			setState(351);
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

	public static class UnOperatorContext extends ParserRuleContext {
		public TerminalNode UN_OPERATOR() { return getToken(PARSERParser.UN_OPERATOR, 0); }
		public TerminalNode NEGATIVE_OPERATOR() { return getToken(PARSERParser.NEGATIVE_OPERATOR, 0); }
		public UnOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterUnOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitUnOperator(this);
		}
	}

	public final UnOperatorContext unOperator() throws RecognitionException {
		UnOperatorContext _localctx = new UnOperatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			_la = _input.LA(1);
			if ( !(_la==UN_OPERATOR || _la==NEGATIVE_OPERATOR) ) {
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

	public static class TermOperatorContext extends ParserRuleContext {
		public TerminalNode TERM_OPERATOR() { return getToken(PARSERParser.TERM_OPERATOR, 0); }
		public TerminalNode NEGATIVE_OPERATOR() { return getToken(PARSERParser.NEGATIVE_OPERATOR, 0); }
		public TermOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterTermOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitTermOperator(this);
		}
	}

	public final TermOperatorContext termOperator() throws RecognitionException {
		TermOperatorContext _localctx = new TermOperatorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_termOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			_la = _input.LA(1);
			if ( !(_la==TERM_OPERATOR || _la==NEGATIVE_OPERATOR) ) {
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
		enterRule(_localctx, 54, RULE_comparaiser);
		try {
			setState(360);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(357);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(358);
				integer();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(359);
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
		enterRule(_localctx, 56, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
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
		enterRule(_localctx, 58, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__19) | (1L << T__20) | (1L << T__21) | (1L << T__22) | (1L << TYPE_IDENTIFIER))) != 0)) ) {
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
		enterRule(_localctx, 60, RULE_varValue);
		try {
			setState(370);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(366);
				match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(367);
				match(T__24);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(368);
				match(STRING);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				enterOuterAlt(_localctx, 4);
				{
				setState(369);
				integer();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3,\u0177\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\6\2B\n\2\r\2\16\2C\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3T\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4]\n\4\r\4\16\4^\3\4\3\4"+
		"\5\4c\n\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5k\n\5\3\5\3\5\3\5\7\5p\n\5\f\5\16"+
		"\5s\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\6\6|\n\6\r\6\16\6}\3\6\3\6\3\6\5"+
		"\6\u0083\n\6\5\6\u0085\n\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\5\b\u0096\n\b\5\b\u0098\n\b\3\b\3\b\3\t\3\t\3\t\3\t\6"+
		"\t\u00a0\n\t\r\t\16\t\u00a1\3\t\3\t\5\t\u00a6\n\t\3\n\7\n\u00a9\n\n\f"+
		"\n\16\n\u00ac\13\n\3\n\3\n\3\n\7\n\u00b1\n\n\f\n\16\n\u00b4\13\n\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u00bb\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\6\f"+
		"\u00c4\n\f\r\f\16\f\u00c5\3\f\3\f\3\f\5\f\u00cb\n\f\5\f\u00cd\n\f\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\5\r\u00d6\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\5\17\u00e1\n\17\3\20\3\20\5\20\u00e5\n\20\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00ec\n\21\3\22\3\22\3\22\5\22\u00f1\n\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u00f9\n\23\3\23\3\23\3\23\5\23\u00fe\n\23\3\24"+
		"\3\24\3\24\7\24\u0103\n\24\f\24\16\24\u0106\13\24\3\24\3\24\3\24\3\24"+
		"\7\24\u010c\n\24\f\24\16\24\u010f\13\24\3\24\3\24\5\24\u0113\n\24\3\25"+
		"\3\25\3\25\7\25\u0118\n\25\f\25\16\25\u011b\13\25\3\25\3\25\3\25\3\25"+
		"\7\25\u0121\n\25\f\25\16\25\u0124\13\25\3\25\3\25\5\25\u0128\n\25\3\26"+
		"\3\26\3\26\3\26\7\26\u012e\n\26\f\26\16\26\u0131\13\26\3\26\3\26\3\26"+
		"\3\26\3\26\7\26\u0138\n\26\f\26\16\26\u013b\13\26\3\26\3\26\5\26\u013f"+
		"\n\26\3\27\3\27\3\27\7\27\u0144\n\27\f\27\16\27\u0147\13\27\3\27\3\27"+
		"\3\27\3\27\7\27\u014d\n\27\f\27\16\27\u0150\13\27\3\27\3\27\5\27\u0154"+
		"\n\27\3\30\3\30\3\30\3\30\5\30\u015a\n\30\3\31\3\31\3\31\5\31\u015f\n"+
		"\31\3\32\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\5\35\u016b\n\35"+
		"\3\36\3\36\3\37\3\37\3 \3 \3 \3 \5 \u0175\n \3 \2\2!\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>\2\6\4\2\34\34!!\4\2\36"+
		"\36!!\3\2%\'\4\2\26\31))\2\u0196\2A\3\2\2\2\4S\3\2\2\2\6U\3\2\2\2\bf\3"+
		"\2\2\2\nv\3\2\2\2\f\u008b\3\2\2\2\16\u008f\3\2\2\2\20\u00a5\3\2\2\2\22"+
		"\u00aa\3\2\2\2\24\u00ba\3\2\2\2\26\u00be\3\2\2\2\30\u00d5\3\2\2\2\32\u00d7"+
		"\3\2\2\2\34\u00db\3\2\2\2\36\u00e2\3\2\2\2 \u00e6\3\2\2\2\"\u00ed\3\2"+
		"\2\2$\u00f2\3\2\2\2&\u0112\3\2\2\2(\u0127\3\2\2\2*\u013e\3\2\2\2,\u0153"+
		"\3\2\2\2.\u0159\3\2\2\2\60\u015b\3\2\2\2\62\u0160\3\2\2\2\64\u0163\3\2"+
		"\2\2\66\u0165\3\2\2\28\u016a\3\2\2\2:\u016c\3\2\2\2<\u016e\3\2\2\2>\u0174"+
		"\3\2\2\2@B\5\b\5\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\3\3\2\2\2"+
		"ET\5\32\16\2FT\5\36\20\2GT\5\34\17\2HT\5$\23\2IT\5\20\t\2JT\5\62\32\2"+
		"KT\7(\2\2LT\5> \2MN\7\3\2\2NO\5\4\3\2OP\7\4\2\2PT\3\2\2\2QT\5&\24\2RT"+
		"\5\60\31\2SE\3\2\2\2SF\3\2\2\2SG\3\2\2\2SH\3\2\2\2SI\3\2\2\2SJ\3\2\2\2"+
		"SK\3\2\2\2SL\3\2\2\2SM\3\2\2\2SQ\3\2\2\2SR\3\2\2\2T\5\3\2\2\2Ub\7\5\2"+
		"\2Vc\5\4\3\2WX\5\4\3\2XY\7\6\2\2Y]\3\2\2\2Z]\5\34\17\2[]\5\36\20\2\\W"+
		"\3\2\2\2\\Z\3\2\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_`\3\2\2"+
		"\2`a\5\4\3\2ac\3\2\2\2bV\3\2\2\2b\\\3\2\2\2bc\3\2\2\2cd\3\2\2\2de\7\7"+
		"\2\2e\7\3\2\2\2fg\7\b\2\2gj\7)\2\2hi\7\t\2\2ik\7)\2\2jh\3\2\2\2jk\3\2"+
		"\2\2kl\3\2\2\2lq\7\5\2\2mp\5\n\6\2np\5\16\b\2om\3\2\2\2on\3\2\2\2ps\3"+
		"\2\2\2qo\3\2\2\2qr\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7\7\2\2u\t\3\2\2\2vw"+
		"\7(\2\2w\u0084\7\3\2\2xy\5\f\7\2yz\7\n\2\2z|\3\2\2\2{x\3\2\2\2|}\3\2\2"+
		"\2}{\3\2\2\2}~\3\2\2\2~\177\3\2\2\2\177\u0080\5\f\7\2\u0080\u0085\3\2"+
		"\2\2\u0081\u0083\5\f\7\2\u0082\u0081\3\2\2\2\u0082\u0083\3\2\2\2\u0083"+
		"\u0085\3\2\2\2\u0084{\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\3\2\2\2"+
		"\u0086\u0087\7\4\2\2\u0087\u0088\7\13\2\2\u0088\u0089\5<\37\2\u0089\u008a"+
		"\5\6\4\2\u008a\13\3\2\2\2\u008b\u008c\7(\2\2\u008c\u008d\7\13\2\2\u008d"+
		"\u008e\5<\37\2\u008e\r\3\2\2\2\u008f\u0090\7(\2\2\u0090\u0091\7\13\2\2"+
		"\u0091\u0097\5<\37\2\u0092\u0095\7\f\2\2\u0093\u0096\5\4\3\2\u0094\u0096"+
		"\5\6\4\2\u0095\u0093\3\2\2\2\u0095\u0094\3\2\2\2\u0096\u0098\3\2\2\2\u0097"+
		"\u0092\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\6"+
		"\2\2\u009a\17\3\2\2\2\u009b\u00a6\5\22\n\2\u009c\u009d\5\22\n\2\u009d"+
		"\u009e\7\r\2\2\u009e\u00a0\3\2\2\2\u009f\u009c\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\5\22\n\2\u00a4\u00a6\3\2\2\2\u00a5\u009b\3\2\2\2\u00a5\u009f\3"+
		"\2\2\2\u00a6\21\3\2\2\2\u00a7\u00a9\5\24\13\2\u00a8\u00a7\3\2\2\2\u00a9"+
		"\u00ac\3\2\2\2\u00aa\u00a8\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ad\3\2"+
		"\2\2\u00ac\u00aa\3\2\2\2\u00ad\u00b2\5\26\f\2\u00ae\u00af\7\r\2\2\u00af"+
		"\u00b1\5\26\f\2\u00b0\u00ae\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3"+
		"\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\23\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5"+
		"\u00bb\7(\2\2\u00b6\u00b7\7\3\2\2\u00b7\u00b8\5\62\32\2\u00b8\u00b9\7"+
		"\4\2\2\u00b9\u00bb\3\2\2\2\u00ba\u00b5\3\2\2\2\u00ba\u00b6\3\2\2\2\u00bb"+
		"\u00bc\3\2\2\2\u00bc\u00bd\7\r\2\2\u00bd\25\3\2\2\2\u00be\u00bf\7(\2\2"+
		"\u00bf\u00cc\7\3\2\2\u00c0\u00c1\5\30\r\2\u00c1\u00c2\7\n\2\2\u00c2\u00c4"+
		"\3\2\2\2\u00c3\u00c0\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\5\30\r\2\u00c8\u00cd\3"+
		"\2\2\2\u00c9\u00cb\5\30\r\2\u00ca\u00c9\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb"+
		"\u00cd\3\2\2\2\u00cc\u00c3\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cd\u00ce\3\2"+
		"\2\2\u00ce\u00cf\7\4\2\2\u00cf\27\3\2\2\2\u00d0\u00d6\7(\2\2\u00d1\u00d6"+
		"\5> \2\u00d2\u00d6\5\20\t\2\u00d3\u00d6\5\62\32\2\u00d4\u00d6\5&\24\2"+
		"\u00d5\u00d0\3\2\2\2\u00d5\u00d1\3\2\2\2\u00d5\u00d2\3\2\2\2\u00d5\u00d3"+
		"\3\2\2\2\u00d5\u00d4\3\2\2\2\u00d6\31\3\2\2\2\u00d7\u00d8\7(\2\2\u00d8"+
		"\u00d9\7\f\2\2\u00d9\u00da\5\4\3\2\u00da\33\3\2\2\2\u00db\u00dc\7\16\2"+
		"\2\u00dc\u00dd\5\4\3\2\u00dd\u00e0\7\17\2\2\u00de\u00e1\5\4\3\2\u00df"+
		"\u00e1\5\6\4\2\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\35\3\2\2"+
		"\2\u00e2\u00e4\5 \21\2\u00e3\u00e5\5\"\22\2\u00e4\u00e3\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\37\3\2\2\2\u00e6\u00e7\7\20\2\2\u00e7\u00e8\5\4\3"+
		"\2\u00e8\u00eb\7\21\2\2\u00e9\u00ec\5\4\3\2\u00ea\u00ec\5\6\4\2\u00eb"+
		"\u00e9\3\2\2\2\u00eb\u00ea\3\2\2\2\u00ec!\3\2\2\2\u00ed\u00f0\7\22\2\2"+
		"\u00ee\u00f1\5\4\3\2\u00ef\u00f1\5\6\4\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef"+
		"\3\2\2\2\u00f1#\3\2\2\2\u00f2\u00f3\7\23\2\2\u00f3\u00f4\7(\2\2\u00f4"+
		"\u00f5\7\13\2\2\u00f5\u00f8\5<\37\2\u00f6\u00f7\7\f\2\2\u00f7\u00f9\5"+
		"\4\3\2\u00f8\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00fa\3\2\2\2\u00fa"+
		"\u00fd\7\24\2\2\u00fb\u00fe\5\4\3\2\u00fc\u00fe\5\6\4\2\u00fd\u00fb\3"+
		"\2\2\2\u00fd\u00fc\3\2\2\2\u00fe%\3\2\2\2\u00ff\u0104\5(\25\2\u0100\u0101"+
		"\7\37\2\2\u0101\u0103\5(\25\2\u0102\u0100\3\2\2\2\u0103\u0106\3\2\2\2"+
		"\u0104\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0113\3\2\2\2\u0106\u0104"+
		"\3\2\2\2\u0107\u0108\7\3\2\2\u0108\u010d\5(\25\2\u0109\u010a\7\37\2\2"+
		"\u010a\u010c\5(\25\2\u010b\u0109\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b"+
		"\3\2\2\2\u010d\u010e\3\2\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110"+
		"\u0111\7\4\2\2\u0111\u0113\3\2\2\2\u0112\u00ff\3\2\2\2\u0112\u0107\3\2"+
		"\2\2\u0113\'\3\2\2\2\u0114\u0119\5*\26\2\u0115\u0116\7 \2\2\u0116\u0118"+
		"\5*\26\2\u0117\u0115\3\2\2\2\u0118\u011b\3\2\2\2\u0119\u0117\3\2\2\2\u0119"+
		"\u011a\3\2\2\2\u011a\u0128\3\2\2\2\u011b\u0119\3\2\2\2\u011c\u011d\7\3"+
		"\2\2\u011d\u0122\5*\26\2\u011e\u011f\7 \2\2\u011f\u0121\5*\26\2\u0120"+
		"\u011e\3\2\2\2\u0121\u0124\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2"+
		"\2\2\u0123\u0125\3\2\2\2\u0124\u0122\3\2\2\2\u0125\u0126\7\4\2\2\u0126"+
		"\u0128\3\2\2\2\u0127\u0114\3\2\2\2\u0127\u011c\3\2\2\2\u0128)\3\2\2\2"+
		"\u0129\u012f\5,\27\2\u012a\u012b\5\66\34\2\u012b\u012c\5,\27\2\u012c\u012e"+
		"\3\2\2\2\u012d\u012a\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f"+
		"\u0130\3\2\2\2\u0130\u013f\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133\7\3"+
		"\2\2\u0133\u0139\5,\27\2\u0134\u0135\5\66\34\2\u0135\u0136\5,\27\2\u0136"+
		"\u0138\3\2\2\2\u0137\u0134\3\2\2\2\u0138\u013b\3\2\2\2\u0139\u0137\3\2"+
		"\2\2\u0139\u013a\3\2\2\2\u013a\u013c\3\2\2\2\u013b\u0139\3\2\2\2\u013c"+
		"\u013d\7\4\2\2\u013d\u013f\3\2\2\2\u013e\u0129\3\2\2\2\u013e\u0132\3\2"+
		"\2\2\u013f+\3\2\2\2\u0140\u0145\5.\30\2\u0141\u0142\7\35\2\2\u0142\u0144"+
		"\5.\30\2\u0143\u0141\3\2\2\2\u0144\u0147\3\2\2\2\u0145\u0143\3\2\2\2\u0145"+
		"\u0146\3\2\2\2\u0146\u0154\3\2\2\2\u0147\u0145\3\2\2\2\u0148\u0149\7\3"+
		"\2\2\u0149\u014e\5.\30\2\u014a\u014b\7\35\2\2\u014b\u014d\5.\30\2\u014c"+
		"\u014a\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e\u014f\3\2"+
		"\2\2\u014f\u0151\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0152\7\4\2\2\u0152"+
		"\u0154\3\2\2\2\u0153\u0140\3\2\2\2\u0153\u0148\3\2\2\2\u0154-\3\2\2\2"+
		"\u0155\u015a\5\60\31\2\u0156\u015a\7(\2\2\u0157\u015a\5> \2\u0158\u015a"+
		"\5\20\t\2\u0159\u0155\3\2\2\2\u0159\u0156\3\2\2\2\u0159\u0157\3\2\2\2"+
		"\u0159\u0158\3\2\2\2\u015a/\3\2\2\2\u015b\u015e\5\64\33\2\u015c\u015f"+
		"\5(\25\2\u015d\u015f\5\4\3\2\u015e\u015c\3\2\2\2\u015e\u015d\3\2\2\2\u015f"+
		"\61\3\2\2\2\u0160\u0161\7\25\2\2\u0161\u0162\7)\2\2\u0162\63\3\2\2\2\u0163"+
		"\u0164\t\2\2\2\u0164\65\3\2\2\2\u0165\u0166\t\3\2\2\u0166\67\3\2\2\2\u0167"+
		"\u016b\7(\2\2\u0168\u016b\5:\36\2\u0169\u016b\7*\2\2\u016a\u0167\3\2\2"+
		"\2\u016a\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016b9\3\2\2\2\u016c\u016d"+
		"\t\4\2\2\u016d;\3\2\2\2\u016e\u016f\t\5\2\2\u016f=\3\2\2\2\u0170\u0175"+
		"\7\32\2\2\u0171\u0175\7\33\2\2\u0172\u0175\7*\2\2\u0173\u0175\5:\36\2"+
		"\u0174\u0170\3\2\2\2\u0174\u0171\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0173"+
		"\3\2\2\2\u0175?\3\2\2\2.CS\\^bjoq}\u0082\u0084\u0095\u0097\u00a1\u00a5"+
		"\u00aa\u00b2\u00ba\u00c5\u00ca\u00cc\u00d5\u00e0\u00e4\u00eb\u00f0\u00f8"+
		"\u00fd\u0104\u010d\u0112\u0119\u0122\u0127\u012f\u0139\u013e\u0145\u014e"+
		"\u0153\u0159\u015e\u016a\u0174";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}