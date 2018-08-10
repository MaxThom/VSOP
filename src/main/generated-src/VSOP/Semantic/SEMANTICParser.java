// Generated from Semantic\SEMANTIC.g4 by ANTLR 4.7.1
package VSOP.Semantic;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SEMANTICParser extends Parser {
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

	@Override
	public String getGrammarFileName() { return "SEMANTIC.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SEMANTICParser(TokenStream input) {
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitProgram(this);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(SEMANTICParser.OBJECT_IDENTIFIER, 0); }
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitStatement(this);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitBlock(this);
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
			{
			setState(101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(86);
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
				case VOID_OPERATOR:
				case INTEGER_BIN:
				case INTEGER_HEX:
				case INTEGER_DEC:
				case OBJECT_IDENTIFIER:
				case STRING:
					{
					setState(84);
					statement();
					}
					break;
				case T__2:
					{
					setState(85);
					block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				{
				{
				setState(93); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(93);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
						case 1:
							{
							{
							setState(88);
							statement();
							setState(89);
							match(T__3);
							}
							}
							break;
						case 2:
							{
							setState(91);
							whileStatement();
							}
							break;
						case 3:
							{
							setState(92);
							ifStatement();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(95); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(99);
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
				case VOID_OPERATOR:
				case INTEGER_BIN:
				case INTEGER_HEX:
				case INTEGER_DEC:
				case OBJECT_IDENTIFIER:
				case STRING:
					{
					setState(97);
					statement();
					}
					break;
				case T__2:
					{
					setState(98);
					block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				}
				break;
			}
			}
			setState(103);
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
		public List<TerminalNode> TYPE_IDENTIFIER() { return getTokens(SEMANTICParser.TYPE_IDENTIFIER); }
		public TerminalNode TYPE_IDENTIFIER(int i) {
			return getToken(SEMANTICParser.TYPE_IDENTIFIER, i);
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterClassDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitClassDefinition(this);
		}
	}

	public final ClassDefinitionContext classDefinition() throws RecognitionException {
		ClassDefinitionContext _localctx = new ClassDefinitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classDefinition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(T__5);
			setState(106);
			match(TYPE_IDENTIFIER);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(107);
				match(T__6);
				setState(108);
				match(TYPE_IDENTIFIER);
				}
			}

			setState(111);
			match(T__2);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OBJECT_IDENTIFIER) {
				{
				setState(114);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(112);
					methodDefinition();
					}
					break;
				case 2:
					{
					setState(113);
					field();
					}
					break;
				}
				}
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(119);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(SEMANTICParser.OBJECT_IDENTIFIER, 0); }
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterMethodDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitMethodDefinition(this);
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
			setState(121);
			match(OBJECT_IDENTIFIER);
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(122);
				match(T__0);
				{
				setState(135);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					{
					setState(126); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(123);
							formal();
							setState(124);
							match(T__7);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(128); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					{
					setState(130);
					formal();
					}
					}
					}
					break;
				case 2:
					{
					setState(133);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==OBJECT_IDENTIFIER) {
						{
						setState(132);
						formal();
						}
					}

					}
					break;
				}
				setState(137);
				match(T__1);
				}
				}
				break;
			case VOID_OPERATOR:
				{
				{
				setState(138);
				match(VOID_OPERATOR);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(141);
			match(T__8);
			setState(142);
			varType();
			setState(143);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(SEMANTICParser.OBJECT_IDENTIFIER, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public FormalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterFormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitFormal(this);
		}
	}

	public final FormalContext formal() throws RecognitionException {
		FormalContext _localctx = new FormalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_formal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(OBJECT_IDENTIFIER);
			setState(146);
			match(T__8);
			setState(147);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(SEMANTICParser.OBJECT_IDENTIFIER, 0); }
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitField(this);
		}
	}

	public final FieldContext field() throws RecognitionException {
		FieldContext _localctx = new FieldContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(OBJECT_IDENTIFIER);
			setState(150);
			match(T__8);
			setState(151);
			varType();
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(152);
				match(T__9);
				setState(155);
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
				case VOID_OPERATOR:
				case INTEGER_BIN:
				case INTEGER_HEX:
				case INTEGER_DEC:
				case OBJECT_IDENTIFIER:
				case STRING:
					{
					setState(153);
					statement();
					}
					break;
				case T__2:
					{
					setState(154);
					block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(159);
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterCallMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitCallMethod(this);
		}
	}

	public final CallMethodContext callMethod() throws RecognitionException {
		CallMethodContext _localctx = new CallMethodContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_callMethod);
		try {
			int _alt;
			setState(171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(161);
				singleCallMethod();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(165); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(162);
						singleCallMethod();
						setState(163);
						match(T__10);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(167); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				{
				setState(169);
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterSingleCallMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitSingleCallMethod(this);
		}
	}

	public final SingleCallMethodContext singleCallMethod() throws RecognitionException {
		SingleCallMethodContext _localctx = new SingleCallMethodContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_singleCallMethod);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(173);
					caller();
					}
					} 
				}
				setState(178);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(179);
			callFunction();
			setState(184);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(180);
					match(T__10);
					setState(181);
					callFunction();
					}
					} 
				}
				setState(186);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(SEMANTICParser.OBJECT_IDENTIFIER, 0); }
		public NewObjContext newObj() {
			return getRuleContext(NewObjContext.class,0);
		}
		public CallerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caller; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterCaller(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitCaller(this);
		}
	}

	public final CallerContext caller() throws RecognitionException {
		CallerContext _localctx = new CallerContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_caller);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT_IDENTIFIER:
				{
				setState(187);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case T__0:
				{
				{
				setState(188);
				match(T__0);
				setState(189);
				newObj();
				setState(190);
				match(T__1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(194);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(SEMANTICParser.OBJECT_IDENTIFIER, 0); }
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterCallFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitCallFunction(this);
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
			setState(196);
			match(OBJECT_IDENTIFIER);
			setState(214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				{
				setState(197);
				match(T__0);
				setState(210);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					{
					setState(201); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(198);
							argument();
							setState(199);
							match(T__7);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(203); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(205);
					argument();
					}
					}
					break;
				case 2:
					{
					setState(208);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__13) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << UN_OPERATOR) | (1L << NEGATIVE_OPERATOR) | (1L << VOID_OPERATOR) | (1L << INTEGER_BIN) | (1L << INTEGER_HEX) | (1L << INTEGER_DEC) | (1L << OBJECT_IDENTIFIER) | (1L << STRING))) != 0)) {
						{
						setState(207);
						argument();
						}
					}

					}
					break;
				}
				setState(212);
				match(T__1);
				}
				}
				break;
			case VOID_OPERATOR:
				{
				{
				setState(213);
				match(VOID_OPERATOR);
				}
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

	public static class ArgumentContext extends ParserRuleContext {
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(SEMANTICParser.OBJECT_IDENTIFIER, 0); }
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitArgument(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_argument);
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(216);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				varValue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(218);
				callMethod();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(219);
				newObj();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(220);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(SEMANTICParser.OBJECT_IDENTIFIER, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitAssign(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(OBJECT_IDENTIFIER);
			setState(224);
			match(T__9);
			setState(225);
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(T__11);
			setState(228);
			statement();
			setState(229);
			match(T__12);
			setState(232);
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
			case VOID_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(230);
				statement();
				}
				break;
			case T__2:
				{
				setState(231);
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			ifStat();
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(235);
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitIfStat(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(T__13);
			setState(239);
			statement();
			setState(240);
			match(T__14);
			setState(243);
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
			case VOID_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(241);
				statement();
				}
				break;
			case T__2:
				{
				setState(242);
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterElseStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitElseStat(this);
		}
	}

	public final ElseStatContext elseStat() throws RecognitionException {
		ElseStatContext _localctx = new ElseStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_elseStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			match(T__15);
			setState(248);
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
			case VOID_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(246);
				statement();
				}
				break;
			case T__2:
				{
				setState(247);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(SEMANTICParser.OBJECT_IDENTIFIER, 0); }
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterLet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitLet(this);
		}
	}

	public final LetContext let() throws RecognitionException {
		LetContext _localctx = new LetContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_let);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(T__16);
			setState(251);
			match(OBJECT_IDENTIFIER);
			setState(252);
			match(T__8);
			setState(253);
			varType();
			setState(256);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(254);
				match(T__9);
				setState(255);
				statement();
				}
			}

			setState(258);
			match(T__17);
			setState(261);
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
			case VOID_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(259);
				statement();
				}
				break;
			case T__2:
				{
				setState(260);
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
		public List<TerminalNode> AND_OPERATOR() { return getTokens(SEMANTICParser.AND_OPERATOR); }
		public TerminalNode AND_OPERATOR(int i) {
			return getToken(SEMANTICParser.AND_OPERATOR, i);
		}
		public BinaryOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterBinaryOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitBinaryOperation(this);
		}
	}

	public final BinaryOperationContext binaryOperation() throws RecognitionException {
		BinaryOperationContext _localctx = new BinaryOperationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_binaryOperation);
		int _la;
		try {
			int _alt;
			setState(282);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(263);
				condition();
				setState(268);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(264);
						match(AND_OPERATOR);
						setState(265);
						condition();
						}
						} 
					}
					setState(270);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(271);
				match(T__0);
				setState(272);
				condition();
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND_OPERATOR) {
					{
					{
					setState(273);
					match(AND_OPERATOR);
					setState(274);
					condition();
					}
					}
					setState(279);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(280);
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
		public List<TerminalNode> CONDITIONAL_OPERATOR() { return getTokens(SEMANTICParser.CONDITIONAL_OPERATOR); }
		public TerminalNode CONDITIONAL_OPERATOR(int i) {
			return getToken(SEMANTICParser.CONDITIONAL_OPERATOR, i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_condition);
		int _la;
		try {
			int _alt;
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				term();
				setState(289);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(285);
						match(CONDITIONAL_OPERATOR);
						setState(286);
						term();
						}
						} 
					}
					setState(291);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(292);
				match(T__0);
				setState(293);
				term();
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CONDITIONAL_OPERATOR) {
					{
					{
					setState(294);
					match(CONDITIONAL_OPERATOR);
					setState(295);
					term();
					}
					}
					setState(300);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(301);
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
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_term);
		int _la;
		try {
			int _alt;
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				factor();
				setState(311);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(306);
						termOperator();
						setState(307);
						factor();
						}
						} 
					}
					setState(313);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(314);
				match(T__0);
				setState(315);
				factor();
				setState(321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TERM_OPERATOR || _la==NEGATIVE_OPERATOR) {
					{
					{
					setState(316);
					termOperator();
					setState(317);
					factor();
					}
					}
					setState(323);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(324);
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
		public List<TerminalNode> FACTOR_OPERATOR() { return getTokens(SEMANTICParser.FACTOR_OPERATOR); }
		public TerminalNode FACTOR_OPERATOR(int i) {
			return getToken(SEMANTICParser.FACTOR_OPERATOR, i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_factor);
		int _la;
		try {
			int _alt;
			setState(347);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,43,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(328);
				value();
				setState(333);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(329);
						match(FACTOR_OPERATOR);
						setState(330);
						value();
						}
						} 
					}
					setState(335);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
				}
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(336);
				match(T__0);
				setState(337);
				value();
				setState(342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FACTOR_OPERATOR) {
					{
					{
					setState(338);
					match(FACTOR_OPERATOR);
					setState(339);
					value();
					}
					}
					setState(344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(345);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(SEMANTICParser.OBJECT_IDENTIFIER, 0); }
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public CallMethodContext callMethod() {
			return getRuleContext(CallMethodContext.class,0);
		}
		public NewObjContext newObj() {
			return getRuleContext(NewObjContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_value);
		try {
			setState(355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				unOperation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(351);
				varValue();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(352);
				callMethod();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(353);
				newObj();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(354);
				ifStatement();
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public UnOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterUnOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitUnOperation(this);
		}
	}

	public final UnOperationContext unOperation() throws RecognitionException {
		UnOperationContext _localctx = new UnOperationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_unOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			unOperator();
			{
			setState(358);
			statement();
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
		public TerminalNode TYPE_IDENTIFIER() { return getToken(SEMANTICParser.TYPE_IDENTIFIER, 0); }
		public NewObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newObj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterNewObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitNewObj(this);
		}
	}

	public final NewObjContext newObj() throws RecognitionException {
		NewObjContext _localctx = new NewObjContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_newObj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			match(T__18);
			setState(361);
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
		public TerminalNode UN_OPERATOR() { return getToken(SEMANTICParser.UN_OPERATOR, 0); }
		public TerminalNode NEGATIVE_OPERATOR() { return getToken(SEMANTICParser.NEGATIVE_OPERATOR, 0); }
		public UnOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterUnOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitUnOperator(this);
		}
	}

	public final UnOperatorContext unOperator() throws RecognitionException {
		UnOperatorContext _localctx = new UnOperatorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_unOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
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
		public TerminalNode TERM_OPERATOR() { return getToken(SEMANTICParser.TERM_OPERATOR, 0); }
		public TerminalNode NEGATIVE_OPERATOR() { return getToken(SEMANTICParser.NEGATIVE_OPERATOR, 0); }
		public TermOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterTermOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitTermOperator(this);
		}
	}

	public final TermOperatorContext termOperator() throws RecognitionException {
		TermOperatorContext _localctx = new TermOperatorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_termOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(SEMANTICParser.OBJECT_IDENTIFIER, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode STRING() { return getToken(SEMANTICParser.STRING, 0); }
		public ComparaiserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparaiser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterComparaiser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitComparaiser(this);
		}
	}

	public final ComparaiserContext comparaiser() throws RecognitionException {
		ComparaiserContext _localctx = new ComparaiserContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_comparaiser);
		try {
			setState(370);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(367);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(368);
				integer();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(369);
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
		public TerminalNode INTEGER_HEX() { return getToken(SEMANTICParser.INTEGER_HEX, 0); }
		public TerminalNode INTEGER_DEC() { return getToken(SEMANTICParser.INTEGER_DEC, 0); }
		public TerminalNode INTEGER_BIN() { return getToken(SEMANTICParser.INTEGER_BIN, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(372);
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
		public TerminalNode TYPE_IDENTIFIER() { return getToken(SEMANTICParser.TYPE_IDENTIFIER, 0); }
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitVarType(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(374);
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
		public TerminalNode STRING() { return getToken(SEMANTICParser.STRING, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode VOID_OPERATOR() { return getToken(SEMANTICParser.VOID_OPERATOR, 0); }
		public VarValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterVarValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitVarValue(this);
		}
	}

	public final VarValueContext varValue() throws RecognitionException {
		VarValueContext _localctx = new VarValueContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_varValue);
		try {
			setState(381);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(376);
				match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				match(T__24);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(378);
				match(STRING);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				enterOuterAlt(_localctx, 4);
				{
				setState(379);
				integer();
				}
				break;
			case VOID_OPERATOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(380);
				match(VOID_OPERATOR);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3-\u0182\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \3\2"+
		"\6\2B\n\2\r\2\16\2C\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\5\3T\n\3\3\4\3\4\3\4\5\4Y\n\4\3\4\3\4\3\4\3\4\3\4\6\4`\n\4\r\4"+
		"\16\4a\3\4\3\4\5\4f\n\4\5\4h\n\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5p\n\5\3\5"+
		"\3\5\3\5\7\5u\n\5\f\5\16\5x\13\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\6\6\u0081"+
		"\n\6\r\6\16\6\u0082\3\6\3\6\3\6\5\6\u0088\n\6\5\6\u008a\n\6\3\6\3\6\5"+
		"\6\u008e\n\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\5"+
		"\b\u009e\n\b\5\b\u00a0\n\b\3\b\3\b\3\t\3\t\3\t\3\t\6\t\u00a8\n\t\r\t\16"+
		"\t\u00a9\3\t\3\t\5\t\u00ae\n\t\3\n\7\n\u00b1\n\n\f\n\16\n\u00b4\13\n\3"+
		"\n\3\n\3\n\7\n\u00b9\n\n\f\n\16\n\u00bc\13\n\3\13\3\13\3\13\3\13\3\13"+
		"\5\13\u00c3\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\6\f\u00cc\n\f\r\f\16\f"+
		"\u00cd\3\f\3\f\3\f\5\f\u00d3\n\f\5\f\u00d5\n\f\3\f\3\f\5\f\u00d9\n\f\3"+
		"\r\3\r\3\r\3\r\3\r\5\r\u00e0\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3"+
		"\17\3\17\5\17\u00eb\n\17\3\20\3\20\5\20\u00ef\n\20\3\21\3\21\3\21\3\21"+
		"\3\21\5\21\u00f6\n\21\3\22\3\22\3\22\5\22\u00fb\n\22\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\5\23\u0103\n\23\3\23\3\23\3\23\5\23\u0108\n\23\3\24\3\24"+
		"\3\24\7\24\u010d\n\24\f\24\16\24\u0110\13\24\3\24\3\24\3\24\3\24\7\24"+
		"\u0116\n\24\f\24\16\24\u0119\13\24\3\24\3\24\5\24\u011d\n\24\3\25\3\25"+
		"\3\25\7\25\u0122\n\25\f\25\16\25\u0125\13\25\3\25\3\25\3\25\3\25\7\25"+
		"\u012b\n\25\f\25\16\25\u012e\13\25\3\25\3\25\5\25\u0132\n\25\3\26\3\26"+
		"\3\26\3\26\7\26\u0138\n\26\f\26\16\26\u013b\13\26\3\26\3\26\3\26\3\26"+
		"\3\26\7\26\u0142\n\26\f\26\16\26\u0145\13\26\3\26\3\26\5\26\u0149\n\26"+
		"\3\27\3\27\3\27\7\27\u014e\n\27\f\27\16\27\u0151\13\27\3\27\3\27\3\27"+
		"\3\27\7\27\u0157\n\27\f\27\16\27\u015a\13\27\3\27\3\27\5\27\u015e\n\27"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u0166\n\30\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\5\35\u0175\n\35\3\36\3\36\3\37"+
		"\3\37\3 \3 \3 \3 \3 \5 \u0180\n \3 \2\2!\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36 \"$&(*,.\60\62\64\668:<>\2\6\4\2\34\34!!\4\2\36\36!!\3\2&(\4"+
		"\2\26\31**\2\u01a7\2A\3\2\2\2\4S\3\2\2\2\6U\3\2\2\2\bk\3\2\2\2\n{\3\2"+
		"\2\2\f\u0093\3\2\2\2\16\u0097\3\2\2\2\20\u00ad\3\2\2\2\22\u00b2\3\2\2"+
		"\2\24\u00c2\3\2\2\2\26\u00c6\3\2\2\2\30\u00df\3\2\2\2\32\u00e1\3\2\2\2"+
		"\34\u00e5\3\2\2\2\36\u00ec\3\2\2\2 \u00f0\3\2\2\2\"\u00f7\3\2\2\2$\u00fc"+
		"\3\2\2\2&\u011c\3\2\2\2(\u0131\3\2\2\2*\u0148\3\2\2\2,\u015d\3\2\2\2."+
		"\u0165\3\2\2\2\60\u0167\3\2\2\2\62\u016a\3\2\2\2\64\u016d\3\2\2\2\66\u016f"+
		"\3\2\2\28\u0174\3\2\2\2:\u0176\3\2\2\2<\u0178\3\2\2\2>\u017f\3\2\2\2@"+
		"B\5\b\5\2A@\3\2\2\2BC\3\2\2\2CA\3\2\2\2CD\3\2\2\2D\3\3\2\2\2ET\5\32\16"+
		"\2FT\5\36\20\2GT\5\34\17\2HT\5$\23\2IT\5\20\t\2JT\5\62\32\2KT\7)\2\2L"+
		"T\5> \2MN\7\3\2\2NO\5\4\3\2OP\7\4\2\2PT\3\2\2\2QT\5&\24\2RT\5\60\31\2"+
		"SE\3\2\2\2SF\3\2\2\2SG\3\2\2\2SH\3\2\2\2SI\3\2\2\2SJ\3\2\2\2SK\3\2\2\2"+
		"SL\3\2\2\2SM\3\2\2\2SQ\3\2\2\2SR\3\2\2\2T\5\3\2\2\2Ug\7\5\2\2VY\5\4\3"+
		"\2WY\5\6\4\2XV\3\2\2\2XW\3\2\2\2Yh\3\2\2\2Z[\5\4\3\2[\\\7\6\2\2\\`\3\2"+
		"\2\2]`\5\34\17\2^`\5\36\20\2_Z\3\2\2\2_]\3\2\2\2_^\3\2\2\2`a\3\2\2\2a"+
		"_\3\2\2\2ab\3\2\2\2be\3\2\2\2cf\5\4\3\2df\5\6\4\2ec\3\2\2\2ed\3\2\2\2"+
		"fh\3\2\2\2gX\3\2\2\2g_\3\2\2\2gh\3\2\2\2hi\3\2\2\2ij\7\7\2\2j\7\3\2\2"+
		"\2kl\7\b\2\2lo\7*\2\2mn\7\t\2\2np\7*\2\2om\3\2\2\2op\3\2\2\2pq\3\2\2\2"+
		"qv\7\5\2\2ru\5\n\6\2su\5\16\b\2tr\3\2\2\2ts\3\2\2\2ux\3\2\2\2vt\3\2\2"+
		"\2vw\3\2\2\2wy\3\2\2\2xv\3\2\2\2yz\7\7\2\2z\t\3\2\2\2{\u008d\7)\2\2|\u0089"+
		"\7\3\2\2}~\5\f\7\2~\177\7\n\2\2\177\u0081\3\2\2\2\u0080}\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\3\2"+
		"\2\2\u0084\u0085\5\f\7\2\u0085\u008a\3\2\2\2\u0086\u0088\5\f\7\2\u0087"+
		"\u0086\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0080\3\2"+
		"\2\2\u0089\u0087\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008e\7\4\2\2\u008c"+
		"\u008e\7\"\2\2\u008d|\3\2\2\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2"+
		"\u008f\u0090\7\13\2\2\u0090\u0091\5<\37\2\u0091\u0092\5\6\4\2\u0092\13"+
		"\3\2\2\2\u0093\u0094\7)\2\2\u0094\u0095\7\13\2\2\u0095\u0096\5<\37\2\u0096"+
		"\r\3\2\2\2\u0097\u0098\7)\2\2\u0098\u0099\7\13\2\2\u0099\u009f\5<\37\2"+
		"\u009a\u009d\7\f\2\2\u009b\u009e\5\4\3\2\u009c\u009e\5\6\4\2\u009d\u009b"+
		"\3\2\2\2\u009d\u009c\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009a\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7\6\2\2\u00a2\17\3\2\2"+
		"\2\u00a3\u00ae\5\22\n\2\u00a4\u00a5\5\22\n\2\u00a5\u00a6\7\r\2\2\u00a6"+
		"\u00a8\3\2\2\2\u00a7\u00a4\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00a7\3\2"+
		"\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\u00ac\5\22\n\2\u00ac"+
		"\u00ae\3\2\2\2\u00ad\u00a3\3\2\2\2\u00ad\u00a7\3\2\2\2\u00ae\21\3\2\2"+
		"\2\u00af\u00b1\5\24\13\2\u00b0\u00af\3\2\2\2\u00b1\u00b4\3\2\2\2\u00b2"+
		"\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00b2\3\2"+
		"\2\2\u00b5\u00ba\5\26\f\2\u00b6\u00b7\7\r\2\2\u00b7\u00b9\5\26\f\2\u00b8"+
		"\u00b6\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2\2\2\u00ba\u00bb\3\2"+
		"\2\2\u00bb\23\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bd\u00c3\7)\2\2\u00be\u00bf"+
		"\7\3\2\2\u00bf\u00c0\5\62\32\2\u00c0\u00c1\7\4\2\2\u00c1\u00c3\3\2\2\2"+
		"\u00c2\u00bd\3\2\2\2\u00c2\u00be\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5"+
		"\7\r\2\2\u00c5\25\3\2\2\2\u00c6\u00d8\7)\2\2\u00c7\u00d4\7\3\2\2\u00c8"+
		"\u00c9\5\30\r\2\u00c9\u00ca\7\n\2\2\u00ca\u00cc\3\2\2\2\u00cb\u00c8\3"+
		"\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d0\5\30\r\2\u00d0\u00d5\3\2\2\2\u00d1\u00d3\5"+
		"\30\r\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d5\3\2\2\2\u00d4"+
		"\u00cb\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d9\7\4"+
		"\2\2\u00d7\u00d9\7\"\2\2\u00d8\u00c7\3\2\2\2\u00d8\u00d7\3\2\2\2\u00d9"+
		"\27\3\2\2\2\u00da\u00e0\7)\2\2\u00db\u00e0\5> \2\u00dc\u00e0\5\20\t\2"+
		"\u00dd\u00e0\5\62\32\2\u00de\u00e0\5&\24\2\u00df\u00da\3\2\2\2\u00df\u00db"+
		"\3\2\2\2\u00df\u00dc\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00de\3\2\2\2\u00e0"+
		"\31\3\2\2\2\u00e1\u00e2\7)\2\2\u00e2\u00e3\7\f\2\2\u00e3\u00e4\5\4\3\2"+
		"\u00e4\33\3\2\2\2\u00e5\u00e6\7\16\2\2\u00e6\u00e7\5\4\3\2\u00e7\u00ea"+
		"\7\17\2\2\u00e8\u00eb\5\4\3\2\u00e9\u00eb\5\6\4\2\u00ea\u00e8\3\2\2\2"+
		"\u00ea\u00e9\3\2\2\2\u00eb\35\3\2\2\2\u00ec\u00ee\5 \21\2\u00ed\u00ef"+
		"\5\"\22\2\u00ee\u00ed\3\2\2\2\u00ee\u00ef\3\2\2\2\u00ef\37\3\2\2\2\u00f0"+
		"\u00f1\7\20\2\2\u00f1\u00f2\5\4\3\2\u00f2\u00f5\7\21\2\2\u00f3\u00f6\5"+
		"\4\3\2\u00f4\u00f6\5\6\4\2\u00f5\u00f3\3\2\2\2\u00f5\u00f4\3\2\2\2\u00f6"+
		"!\3\2\2\2\u00f7\u00fa\7\22\2\2\u00f8\u00fb\5\4\3\2\u00f9\u00fb\5\6\4\2"+
		"\u00fa\u00f8\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb#\3\2\2\2\u00fc\u00fd\7"+
		"\23\2\2\u00fd\u00fe\7)\2\2\u00fe\u00ff\7\13\2\2\u00ff\u0102\5<\37\2\u0100"+
		"\u0101\7\f\2\2\u0101\u0103\5\4\3\2\u0102\u0100\3\2\2\2\u0102\u0103\3\2"+
		"\2\2\u0103\u0104\3\2\2\2\u0104\u0107\7\24\2\2\u0105\u0108\5\4\3\2\u0106"+
		"\u0108\5\6\4\2\u0107\u0105\3\2\2\2\u0107\u0106\3\2\2\2\u0108%\3\2\2\2"+
		"\u0109\u010e\5(\25\2\u010a\u010b\7\37\2\2\u010b\u010d\5(\25\2\u010c\u010a"+
		"\3\2\2\2\u010d\u0110\3\2\2\2\u010e\u010c\3\2\2\2\u010e\u010f\3\2\2\2\u010f"+
		"\u011d\3\2\2\2\u0110\u010e\3\2\2\2\u0111\u0112\7\3\2\2\u0112\u0117\5("+
		"\25\2\u0113\u0114\7\37\2\2\u0114\u0116\5(\25\2\u0115\u0113\3\2\2\2\u0116"+
		"\u0119\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118\u011a\3\2"+
		"\2\2\u0119\u0117\3\2\2\2\u011a\u011b\7\4\2\2\u011b\u011d\3\2\2\2\u011c"+
		"\u0109\3\2\2\2\u011c\u0111\3\2\2\2\u011d\'\3\2\2\2\u011e\u0123\5*\26\2"+
		"\u011f\u0120\7 \2\2\u0120\u0122\5*\26\2\u0121\u011f\3\2\2\2\u0122\u0125"+
		"\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0132\3\2\2\2\u0125"+
		"\u0123\3\2\2\2\u0126\u0127\7\3\2\2\u0127\u012c\5*\26\2\u0128\u0129\7 "+
		"\2\2\u0129\u012b\5*\26\2\u012a\u0128\3\2\2\2\u012b\u012e\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012c\u012d\3\2\2\2\u012d\u012f\3\2\2\2\u012e\u012c\3\2"+
		"\2\2\u012f\u0130\7\4\2\2\u0130\u0132\3\2\2\2\u0131\u011e\3\2\2\2\u0131"+
		"\u0126\3\2\2\2\u0132)\3\2\2\2\u0133\u0139\5,\27\2\u0134\u0135\5\66\34"+
		"\2\u0135\u0136\5,\27\2\u0136\u0138\3\2\2\2\u0137\u0134\3\2\2\2\u0138\u013b"+
		"\3\2\2\2\u0139\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u0149\3\2\2\2\u013b"+
		"\u0139\3\2\2\2\u013c\u013d\7\3\2\2\u013d\u0143\5,\27\2\u013e\u013f\5\66"+
		"\34\2\u013f\u0140\5,\27\2\u0140\u0142\3\2\2\2\u0141\u013e\3\2\2\2\u0142"+
		"\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0146\3\2"+
		"\2\2\u0145\u0143\3\2\2\2\u0146\u0147\7\4\2\2\u0147\u0149\3\2\2\2\u0148"+
		"\u0133\3\2\2\2\u0148\u013c\3\2\2\2\u0149+\3\2\2\2\u014a\u014f\5.\30\2"+
		"\u014b\u014c\7\35\2\2\u014c\u014e\5.\30\2\u014d\u014b\3\2\2\2\u014e\u0151"+
		"\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u015e\3\2\2\2\u0151"+
		"\u014f\3\2\2\2\u0152\u0153\7\3\2\2\u0153\u0158\5.\30\2\u0154\u0155\7\35"+
		"\2\2\u0155\u0157\5.\30\2\u0156\u0154\3\2\2\2\u0157\u015a\3\2\2\2\u0158"+
		"\u0156\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015b\3\2\2\2\u015a\u0158\3\2"+
		"\2\2\u015b\u015c\7\4\2\2\u015c\u015e\3\2\2\2\u015d\u014a\3\2\2\2\u015d"+
		"\u0152\3\2\2\2\u015e-\3\2\2\2\u015f\u0166\5\60\31\2\u0160\u0166\7)\2\2"+
		"\u0161\u0166\5> \2\u0162\u0166\5\20\t\2\u0163\u0166\5\62\32\2\u0164\u0166"+
		"\5\36\20\2\u0165\u015f\3\2\2\2\u0165\u0160\3\2\2\2\u0165\u0161\3\2\2\2"+
		"\u0165\u0162\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0164\3\2\2\2\u0166/\3"+
		"\2\2\2\u0167\u0168\5\64\33\2\u0168\u0169\5\4\3\2\u0169\61\3\2\2\2\u016a"+
		"\u016b\7\25\2\2\u016b\u016c\7*\2\2\u016c\63\3\2\2\2\u016d\u016e\t\2\2"+
		"\2\u016e\65\3\2\2\2\u016f\u0170\t\3\2\2\u0170\67\3\2\2\2\u0171\u0175\7"+
		")\2\2\u0172\u0175\5:\36\2\u0173\u0175\7+\2\2\u0174\u0171\3\2\2\2\u0174"+
		"\u0172\3\2\2\2\u0174\u0173\3\2\2\2\u01759\3\2\2\2\u0176\u0177\t\4\2\2"+
		"\u0177;\3\2\2\2\u0178\u0179\t\5\2\2\u0179=\3\2\2\2\u017a\u0180\7\32\2"+
		"\2\u017b\u0180\7\33\2\2\u017c\u0180\7+\2\2\u017d\u0180\5:\36\2\u017e\u0180"+
		"\7\"\2\2\u017f\u017a\3\2\2\2\u017f\u017b\3\2\2\2\u017f\u017c\3\2\2\2\u017f"+
		"\u017d\3\2\2\2\u017f\u017e\3\2\2\2\u0180?\3\2\2\2\61CSX_aegotv\u0082\u0087"+
		"\u0089\u008d\u009d\u009f\u00a9\u00ad\u00b2\u00ba\u00c2\u00cd\u00d2\u00d4"+
		"\u00d8\u00df\u00ea\u00ee\u00f5\u00fa\u0102\u0107\u010e\u0117\u011c\u0123"+
		"\u012c\u0131\u0139\u0143\u0148\u014f\u0158\u015d\u0165\u0174\u017f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}