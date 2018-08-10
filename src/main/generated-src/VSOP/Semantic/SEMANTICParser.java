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
		T__24=25, POW=26, MULTI=27, DIV=28, MINUS=29, PLUS=30, LOWER_EQUAL=31, 
		EQUAL=32, LOWER=33, AND=34, NOT=35, ISNULL=36, VOID_OPERATOR=37, MULTILINE_OPEN_COMMENT=38, 
		MULTILINE_CLOSE_COMMENT=39, MULTILINE_COMMENT=40, INTEGER_BIN=41, INTEGER_HEX=42, 
		INTEGER_DEC=43, OBJECT_IDENTIFIER=44, TYPE_IDENTIFIER=45, STRING=46, SINGLE_LINE_COMMENT=47, 
		WS=48;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_block = 2, RULE_classDefinition = 3, 
		RULE_methodDefinition = 4, RULE_formal = 5, RULE_field = 6, RULE_callMethod = 7, 
		RULE_singleCallMethod = 8, RULE_caller = 9, RULE_callFunction = 10, RULE_argument = 11, 
		RULE_assign = 12, RULE_whileStatement = 13, RULE_ifStatement = 14, RULE_ifStat = 15, 
		RULE_elseStat = 16, RULE_let = 17, RULE_newObj = 18, RULE_binaryOperation = 19, 
		RULE_expr1 = 20, RULE_expr2 = 21, RULE_expr3 = 22, RULE_expr4 = 23, RULE_expr5 = 24, 
		RULE_expr6 = 25, RULE_expr7 = 26, RULE_expr8 = 27, RULE_termOperator = 28, 
		RULE_factorOperator = 29, RULE_comparatorOperator = 30, RULE_integer = 31, 
		RULE_varType = 32, RULE_varValue = 33;
	public static final String[] ruleNames = {
		"program", "statement", "block", "classDefinition", "methodDefinition", 
		"formal", "field", "callMethod", "singleCallMethod", "caller", "callFunction", 
		"argument", "assign", "whileStatement", "ifStatement", "ifStat", "elseStat", 
		"let", "newObj", "binaryOperation", "expr1", "expr2", "expr3", "expr4", 
		"expr5", "expr6", "expr7", "expr8", "termOperator", "factorOperator", 
		"comparatorOperator", "integer", "varType", "varValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'{'", "';'", "'}'", "'class'", "'extends'", "','", 
		"':'", "'<-'", "'.'", "'while'", "'do'", "'if'", "'then'", "'else'", "'let'", 
		"'in'", "'new'", "'bool'", "'int32'", "'string'", "'unit'", "'true'", 
		"'false'", "'^'", "'*'", "'/'", "'-'", "'+'", "'<='", "'='", "'<'", "'and'", 
		"'not'", "'isnull'", "'()'", "'(*'", "'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "POW", "MULTI", "DIV", "MINUS", "PLUS", "LOWER_EQUAL", "EQUAL", 
		"LOWER", "AND", "NOT", "ISNULL", "VOID_OPERATOR", "MULTILINE_OPEN_COMMENT", 
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
			setState(69); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(68);
				classDefinition();
				}
				}
				setState(71); 
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
			setState(86);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				ifStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				whileStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				let();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(77);
				callMethod();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(78);
				newObj();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(79);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(80);
				varValue();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(81);
				match(T__0);
				setState(82);
				statement();
				setState(83);
				match(T__1);
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(85);
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
			setState(88);
			match(T__2);
			{
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(91);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__11:
				case T__13:
				case T__16:
				case T__18:
				case T__23:
				case T__24:
				case MINUS:
				case NOT:
				case ISNULL:
				case VOID_OPERATOR:
				case INTEGER_BIN:
				case INTEGER_HEX:
				case INTEGER_DEC:
				case OBJECT_IDENTIFIER:
				case STRING:
					{
					setState(89);
					statement();
					}
					break;
				case T__2:
					{
					setState(90);
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
				setState(98); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(98);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
						case 1:
							{
							{
							setState(93);
							statement();
							setState(94);
							match(T__3);
							}
							}
							break;
						case 2:
							{
							setState(96);
							whileStatement();
							}
							break;
						case 3:
							{
							setState(97);
							ifStatement();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(100); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(104);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__11:
				case T__13:
				case T__16:
				case T__18:
				case T__23:
				case T__24:
				case MINUS:
				case NOT:
				case ISNULL:
				case VOID_OPERATOR:
				case INTEGER_BIN:
				case INTEGER_HEX:
				case INTEGER_DEC:
				case OBJECT_IDENTIFIER:
				case STRING:
					{
					setState(102);
					statement();
					}
					break;
				case T__2:
					{
					setState(103);
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
			setState(108);
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
			setState(110);
			match(T__5);
			setState(111);
			match(TYPE_IDENTIFIER);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(112);
				match(T__6);
				setState(113);
				match(TYPE_IDENTIFIER);
				}
			}

			setState(116);
			match(T__2);
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OBJECT_IDENTIFIER) {
				{
				setState(119);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(117);
					methodDefinition();
					}
					break;
				case 2:
					{
					setState(118);
					field();
					}
					break;
				}
				}
				setState(123);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(124);
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
			setState(126);
			match(OBJECT_IDENTIFIER);
			setState(144);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(127);
				match(T__0);
				{
				setState(140);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					{
					setState(131); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(128);
							formal();
							setState(129);
							match(T__7);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(133); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					{
					setState(135);
					formal();
					}
					}
					}
					break;
				case 2:
					{
					setState(138);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==OBJECT_IDENTIFIER) {
						{
						setState(137);
						formal();
						}
					}

					}
					break;
				}
				setState(142);
				match(T__1);
				}
				}
				break;
			case VOID_OPERATOR:
				{
				{
				setState(143);
				match(VOID_OPERATOR);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(146);
			match(T__8);
			setState(147);
			varType();
			setState(148);
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
			setState(150);
			match(OBJECT_IDENTIFIER);
			setState(151);
			match(T__8);
			setState(152);
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
			setState(154);
			match(OBJECT_IDENTIFIER);
			setState(155);
			match(T__8);
			setState(156);
			varType();
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(157);
				match(T__9);
				setState(160);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__0:
				case T__11:
				case T__13:
				case T__16:
				case T__18:
				case T__23:
				case T__24:
				case MINUS:
				case NOT:
				case ISNULL:
				case VOID_OPERATOR:
				case INTEGER_BIN:
				case INTEGER_HEX:
				case INTEGER_DEC:
				case OBJECT_IDENTIFIER:
				case STRING:
					{
					setState(158);
					statement();
					}
					break;
				case T__2:
					{
					setState(159);
					block();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
			}

			setState(164);
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
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(166);
				singleCallMethod();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(170); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(167);
						singleCallMethod();
						setState(168);
						match(T__10);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(172); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				{
				setState(174);
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
			setState(181);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(178);
					caller();
					}
					} 
				}
				setState(183);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(184);
			callFunction();
			setState(189);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(185);
					match(T__10);
					setState(186);
					callFunction();
					}
					} 
				}
				setState(191);
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
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT_IDENTIFIER:
				{
				setState(192);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case T__0:
				{
				{
				setState(193);
				match(T__0);
				setState(194);
				newObj();
				setState(195);
				match(T__1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(199);
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
			setState(201);
			match(OBJECT_IDENTIFIER);
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				{
				setState(202);
				match(T__0);
				setState(215);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					{
					setState(206); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(203);
							argument();
							setState(204);
							match(T__7);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(208); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(210);
					argument();
					}
					}
					break;
				case 2:
					{
					setState(213);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__13) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << MINUS) | (1L << NOT) | (1L << ISNULL) | (1L << VOID_OPERATOR) | (1L << INTEGER_BIN) | (1L << INTEGER_HEX) | (1L << INTEGER_DEC) | (1L << OBJECT_IDENTIFIER) | (1L << STRING))) != 0)) {
						{
						setState(212);
						argument();
						}
					}

					}
					break;
				}
				setState(217);
				match(T__1);
				}
				}
				break;
			case VOID_OPERATOR:
				{
				{
				setState(218);
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
			setState(226);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(221);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222);
				varValue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(223);
				callMethod();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(224);
				newObj();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(225);
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
			setState(228);
			match(OBJECT_IDENTIFIER);
			setState(229);
			match(T__9);
			setState(230);
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
			setState(232);
			match(T__11);
			setState(233);
			statement();
			setState(234);
			match(T__12);
			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__11:
			case T__13:
			case T__16:
			case T__18:
			case T__23:
			case T__24:
			case MINUS:
			case NOT:
			case ISNULL:
			case VOID_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(235);
				statement();
				}
				break;
			case T__2:
				{
				setState(236);
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
			setState(239);
			ifStat();
			setState(241);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(240);
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
			setState(243);
			match(T__13);
			setState(244);
			statement();
			setState(245);
			match(T__14);
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
			case MINUS:
			case NOT:
			case ISNULL:
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
			setState(250);
			match(T__15);
			setState(253);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__11:
			case T__13:
			case T__16:
			case T__18:
			case T__23:
			case T__24:
			case MINUS:
			case NOT:
			case ISNULL:
			case VOID_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(251);
				statement();
				}
				break;
			case T__2:
				{
				setState(252);
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
			setState(255);
			match(T__16);
			setState(256);
			match(OBJECT_IDENTIFIER);
			setState(257);
			match(T__8);
			setState(258);
			varType();
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(259);
				match(T__9);
				setState(260);
				statement();
				}
			}

			setState(263);
			match(T__17);
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__11:
			case T__13:
			case T__16:
			case T__18:
			case T__23:
			case T__24:
			case MINUS:
			case NOT:
			case ISNULL:
			case VOID_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(264);
				statement();
				}
				break;
			case T__2:
				{
				setState(265);
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
		enterRule(_localctx, 36, RULE_newObj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
			match(T__18);
			setState(269);
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

	public static class BinaryOperationContext extends ParserRuleContext {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
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
		enterRule(_localctx, 38, RULE_binaryOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			expr1(0);
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

	public static class Expr1Context extends ParserRuleContext {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public TerminalNode AND() { return getToken(SEMANTICParser.AND, 0); }
		public Expr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterExpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitExpr1(this);
		}
	}

	public final Expr1Context expr1() throws RecognitionException {
		return expr1(0);
	}

	private Expr1Context expr1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr1Context _localctx = new Expr1Context(_ctx, _parentState);
		Expr1Context _prevctx = _localctx;
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_expr1, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(274);
			expr2();
			}
			_ctx.stop = _input.LT(-1);
			setState(281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr1Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr1);
					setState(276);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(277);
					match(AND);
					setState(278);
					expr2();
					}
					} 
				}
				setState(283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Expr2Context extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(SEMANTICParser.NOT, 0); }
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterExpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitExpr2(this);
		}
	}

	public final Expr2Context expr2() throws RecognitionException {
		Expr2Context _localctx = new Expr2Context(_ctx, getState());
		enterRule(_localctx, 42, RULE_expr2);
		try {
			setState(287);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(284);
				match(NOT);
				setState(285);
				expr2();
				}
				break;
			case T__0:
			case T__13:
			case T__18:
			case T__23:
			case T__24:
			case MINUS:
			case ISNULL:
			case VOID_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				expr3();
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

	public static class Expr3Context extends ParserRuleContext {
		public List<Expr4Context> expr4() {
			return getRuleContexts(Expr4Context.class);
		}
		public Expr4Context expr4(int i) {
			return getRuleContext(Expr4Context.class,i);
		}
		public ComparatorOperatorContext comparatorOperator() {
			return getRuleContext(ComparatorOperatorContext.class,0);
		}
		public Expr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterExpr3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitExpr3(this);
		}
	}

	public final Expr3Context expr3() throws RecognitionException {
		Expr3Context _localctx = new Expr3Context(_ctx, getState());
		enterRule(_localctx, 44, RULE_expr3);
		try {
			setState(294);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				expr4(0);
				setState(290);
				comparatorOperator();
				setState(291);
				expr4(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				expr4(0);
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

	public static class Expr4Context extends ParserRuleContext {
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public Expr4Context expr4() {
			return getRuleContext(Expr4Context.class,0);
		}
		public TermOperatorContext termOperator() {
			return getRuleContext(TermOperatorContext.class,0);
		}
		public Expr4Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr4; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterExpr4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitExpr4(this);
		}
	}

	public final Expr4Context expr4() throws RecognitionException {
		return expr4(0);
	}

	private Expr4Context expr4(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr4Context _localctx = new Expr4Context(_ctx, _parentState);
		Expr4Context _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_expr4, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(297);
			expr5(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(305);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr4Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr4);
					setState(299);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(300);
					termOperator();
					setState(301);
					expr5(0);
					}
					} 
				}
				setState(307);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Expr5Context extends ParserRuleContext {
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public Expr5Context expr5() {
			return getRuleContext(Expr5Context.class,0);
		}
		public FactorOperatorContext factorOperator() {
			return getRuleContext(FactorOperatorContext.class,0);
		}
		public Expr5Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr5; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterExpr5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitExpr5(this);
		}
	}

	public final Expr5Context expr5() throws RecognitionException {
		return expr5(0);
	}

	private Expr5Context expr5(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr5Context _localctx = new Expr5Context(_ctx, _parentState);
		Expr5Context _prevctx = _localctx;
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_expr5, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(309);
			expr6();
			}
			_ctx.stop = _input.LT(-1);
			setState(317);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr5Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr5);
					setState(311);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(312);
					factorOperator();
					setState(313);
					expr6();
					}
					} 
				}
				setState(319);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Expr6Context extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(SEMANTICParser.MINUS, 0); }
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public TerminalNode ISNULL() { return getToken(SEMANTICParser.ISNULL, 0); }
		public Expr7Context expr7() {
			return getRuleContext(Expr7Context.class,0);
		}
		public Expr6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr6; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterExpr6(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitExpr6(this);
		}
	}

	public final Expr6Context expr6() throws RecognitionException {
		Expr6Context _localctx = new Expr6Context(_ctx, getState());
		enterRule(_localctx, 50, RULE_expr6);
		try {
			setState(325);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				match(MINUS);
				setState(321);
				expr6();
				}
				break;
			case ISNULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(322);
				match(ISNULL);
				setState(323);
				expr6();
				}
				break;
			case T__0:
			case T__13:
			case T__18:
			case T__23:
			case T__24:
			case VOID_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(324);
				expr7();
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

	public static class Expr7Context extends ParserRuleContext {
		public Expr8Context expr8() {
			return getRuleContext(Expr8Context.class,0);
		}
		public TerminalNode POW() { return getToken(SEMANTICParser.POW, 0); }
		public Expr7Context expr7() {
			return getRuleContext(Expr7Context.class,0);
		}
		public Expr7Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr7; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterExpr7(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitExpr7(this);
		}
	}

	public final Expr7Context expr7() throws RecognitionException {
		Expr7Context _localctx = new Expr7Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_expr7);
		try {
			setState(332);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(327);
				expr8();
				setState(328);
				match(POW);
				setState(329);
				expr7();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(331);
				expr8();
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

	public static class Expr8Context extends ParserRuleContext {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(SEMANTICParser.OBJECT_IDENTIFIER, 0); }
		public CallMethodContext callMethod() {
			return getRuleContext(CallMethodContext.class,0);
		}
		public NewObjContext newObj() {
			return getRuleContext(NewObjContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public Expr8Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr8; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterExpr8(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitExpr8(this);
		}
	}

	public final Expr8Context expr8() throws RecognitionException {
		Expr8Context _localctx = new Expr8Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_expr8);
		try {
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(334);
				match(T__0);
				setState(335);
				expr1(0);
				setState(336);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(338);
				varValue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(339);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(340);
				callMethod();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(341);
				newObj();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(342);
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

	public static class TermOperatorContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(SEMANTICParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(SEMANTICParser.PLUS, 0); }
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
		enterRule(_localctx, 56, RULE_termOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_la = _input.LA(1);
			if ( !(_la==MINUS || _la==PLUS) ) {
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

	public static class FactorOperatorContext extends ParserRuleContext {
		public TerminalNode MULTI() { return getToken(SEMANTICParser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(SEMANTICParser.DIV, 0); }
		public FactorOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factorOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterFactorOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitFactorOperator(this);
		}
	}

	public final FactorOperatorContext factorOperator() throws RecognitionException {
		FactorOperatorContext _localctx = new FactorOperatorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_factorOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			_la = _input.LA(1);
			if ( !(_la==MULTI || _la==DIV) ) {
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

	public static class ComparatorOperatorContext extends ParserRuleContext {
		public TerminalNode LOWER() { return getToken(SEMANTICParser.LOWER, 0); }
		public TerminalNode LOWER_EQUAL() { return getToken(SEMANTICParser.LOWER_EQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(SEMANTICParser.EQUAL, 0); }
		public ComparatorOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparatorOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).enterComparatorOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SEMANTICListener ) ((SEMANTICListener)listener).exitComparatorOperator(this);
		}
	}

	public final ComparatorOperatorContext comparatorOperator() throws RecognitionException {
		ComparatorOperatorContext _localctx = new ComparatorOperatorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_comparatorOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOWER_EQUAL) | (1L << EQUAL) | (1L << LOWER))) != 0)) ) {
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
		enterRule(_localctx, 62, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
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
		enterRule(_localctx, 64, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
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
		enterRule(_localctx, 66, RULE_varValue);
		try {
			setState(360);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(355);
				match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(356);
				match(T__24);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(357);
				match(STRING);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				enterOuterAlt(_localctx, 4);
				{
				setState(358);
				integer();
				}
				break;
			case VOID_OPERATOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(359);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 20:
			return expr1_sempred((Expr1Context)_localctx, predIndex);
		case 23:
			return expr4_sempred((Expr4Context)_localctx, predIndex);
		case 24:
			return expr5_sempred((Expr5Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr1_sempred(Expr1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr4_sempred(Expr4Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr5_sempred(Expr5Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\62\u016d\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\3\2\6\2H\n\2\r\2\16\2I\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3Y\n\3\3\4\3\4\3\4\5\4^\n\4\3\4\3\4\3\4\3\4\3"+
		"\4\6\4e\n\4\r\4\16\4f\3\4\3\4\5\4k\n\4\5\4m\n\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\5\5u\n\5\3\5\3\5\3\5\7\5z\n\5\f\5\16\5}\13\5\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\3\6\6\6\u0086\n\6\r\6\16\6\u0087\3\6\3\6\3\6\5\6\u008d\n\6\5\6\u008f"+
		"\n\6\3\6\3\6\5\6\u0093\n\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u00a3\n\b\5\b\u00a5\n\b\3\b\3\b\3\t\3\t\3\t\3\t\6\t\u00ad"+
		"\n\t\r\t\16\t\u00ae\3\t\3\t\5\t\u00b3\n\t\3\n\7\n\u00b6\n\n\f\n\16\n\u00b9"+
		"\13\n\3\n\3\n\3\n\7\n\u00be\n\n\f\n\16\n\u00c1\13\n\3\13\3\13\3\13\3\13"+
		"\3\13\5\13\u00c8\n\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\6\f\u00d1\n\f\r\f"+
		"\16\f\u00d2\3\f\3\f\3\f\5\f\u00d8\n\f\5\f\u00da\n\f\3\f\3\f\5\f\u00de"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u00e5\n\r\3\16\3\16\3\16\3\16\3\17\3\17\3"+
		"\17\3\17\3\17\5\17\u00f0\n\17\3\20\3\20\5\20\u00f4\n\20\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u00fb\n\21\3\22\3\22\3\22\5\22\u0100\n\22\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\5\23\u0108\n\23\3\23\3\23\3\23\5\23\u010d\n\23\3\24"+
		"\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u011a\n\26\f\26"+
		"\16\26\u011d\13\26\3\27\3\27\3\27\5\27\u0122\n\27\3\30\3\30\3\30\3\30"+
		"\3\30\5\30\u0129\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0132\n"+
		"\31\f\31\16\31\u0135\13\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u013e"+
		"\n\32\f\32\16\32\u0141\13\32\3\33\3\33\3\33\3\33\3\33\5\33\u0148\n\33"+
		"\3\34\3\34\3\34\3\34\3\34\5\34\u014f\n\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\5\35\u015a\n\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3"+
		"\"\3#\3#\3#\3#\3#\5#\u016b\n#\3#\2\5*\60\62$\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BD\2\7\3\2\37 \3\2\35\36\3\2!#\3"+
		"\2+-\4\2\26\31//\2\u0188\2G\3\2\2\2\4X\3\2\2\2\6Z\3\2\2\2\bp\3\2\2\2\n"+
		"\u0080\3\2\2\2\f\u0098\3\2\2\2\16\u009c\3\2\2\2\20\u00b2\3\2\2\2\22\u00b7"+
		"\3\2\2\2\24\u00c7\3\2\2\2\26\u00cb\3\2\2\2\30\u00e4\3\2\2\2\32\u00e6\3"+
		"\2\2\2\34\u00ea\3\2\2\2\36\u00f1\3\2\2\2 \u00f5\3\2\2\2\"\u00fc\3\2\2"+
		"\2$\u0101\3\2\2\2&\u010e\3\2\2\2(\u0111\3\2\2\2*\u0113\3\2\2\2,\u0121"+
		"\3\2\2\2.\u0128\3\2\2\2\60\u012a\3\2\2\2\62\u0136\3\2\2\2\64\u0147\3\2"+
		"\2\2\66\u014e\3\2\2\28\u0159\3\2\2\2:\u015b\3\2\2\2<\u015d\3\2\2\2>\u015f"+
		"\3\2\2\2@\u0161\3\2\2\2B\u0163\3\2\2\2D\u016a\3\2\2\2FH\5\b\5\2GF\3\2"+
		"\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\3\3\2\2\2KY\5\32\16\2LY\5\36\20\2"+
		"MY\5\34\17\2NY\5$\23\2OY\5\20\t\2PY\5&\24\2QY\7.\2\2RY\5D#\2ST\7\3\2\2"+
		"TU\5\4\3\2UV\7\4\2\2VY\3\2\2\2WY\5(\25\2XK\3\2\2\2XL\3\2\2\2XM\3\2\2\2"+
		"XN\3\2\2\2XO\3\2\2\2XP\3\2\2\2XQ\3\2\2\2XR\3\2\2\2XS\3\2\2\2XW\3\2\2\2"+
		"Y\5\3\2\2\2Zl\7\5\2\2[^\5\4\3\2\\^\5\6\4\2][\3\2\2\2]\\\3\2\2\2^m\3\2"+
		"\2\2_`\5\4\3\2`a\7\6\2\2ae\3\2\2\2be\5\34\17\2ce\5\36\20\2d_\3\2\2\2d"+
		"b\3\2\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2\2fg\3\2\2\2gj\3\2\2\2hk\5\4\3\2"+
		"ik\5\6\4\2jh\3\2\2\2ji\3\2\2\2km\3\2\2\2l]\3\2\2\2ld\3\2\2\2lm\3\2\2\2"+
		"mn\3\2\2\2no\7\7\2\2o\7\3\2\2\2pq\7\b\2\2qt\7/\2\2rs\7\t\2\2su\7/\2\2"+
		"tr\3\2\2\2tu\3\2\2\2uv\3\2\2\2v{\7\5\2\2wz\5\n\6\2xz\5\16\b\2yw\3\2\2"+
		"\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|~\3\2\2\2}{\3\2\2\2~\177\7"+
		"\7\2\2\177\t\3\2\2\2\u0080\u0092\7.\2\2\u0081\u008e\7\3\2\2\u0082\u0083"+
		"\5\f\7\2\u0083\u0084\7\n\2\2\u0084\u0086\3\2\2\2\u0085\u0082\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u0089\3\2"+
		"\2\2\u0089\u008a\5\f\7\2\u008a\u008f\3\2\2\2\u008b\u008d\5\f\7\2\u008c"+
		"\u008b\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008f\3\2\2\2\u008e\u0085\3\2"+
		"\2\2\u008e\u008c\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0093\7\4\2\2\u0091"+
		"\u0093\7\'\2\2\u0092\u0081\3\2\2\2\u0092\u0091\3\2\2\2\u0093\u0094\3\2"+
		"\2\2\u0094\u0095\7\13\2\2\u0095\u0096\5B\"\2\u0096\u0097\5\6\4\2\u0097"+
		"\13\3\2\2\2\u0098\u0099\7.\2\2\u0099\u009a\7\13\2\2\u009a\u009b\5B\"\2"+
		"\u009b\r\3\2\2\2\u009c\u009d\7.\2\2\u009d\u009e\7\13\2\2\u009e\u00a4\5"+
		"B\"\2\u009f\u00a2\7\f\2\2\u00a0\u00a3\5\4\3\2\u00a1\u00a3\5\6\4\2\u00a2"+
		"\u00a0\3\2\2\2\u00a2\u00a1\3\2\2\2\u00a3\u00a5\3\2\2\2\u00a4\u009f\3\2"+
		"\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a7\7\6\2\2\u00a7"+
		"\17\3\2\2\2\u00a8\u00b3\5\22\n\2\u00a9\u00aa\5\22\n\2\u00aa\u00ab\7\r"+
		"\2\2\u00ab\u00ad\3\2\2\2\u00ac\u00a9\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00b1\5\22"+
		"\n\2\u00b1\u00b3\3\2\2\2\u00b2\u00a8\3\2\2\2\u00b2\u00ac\3\2\2\2\u00b3"+
		"\21\3\2\2\2\u00b4\u00b6\5\24\13\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00bf\5\26\f\2\u00bb\u00bc\7\r\2\2\u00bc\u00be\5"+
		"\26\f\2\u00bd\u00bb\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf"+
		"\u00c0\3\2\2\2\u00c0\23\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c8\7.\2\2"+
		"\u00c3\u00c4\7\3\2\2\u00c4\u00c5\5&\24\2\u00c5\u00c6\7\4\2\2\u00c6\u00c8"+
		"\3\2\2\2\u00c7\u00c2\3\2\2\2\u00c7\u00c3\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9"+
		"\u00ca\7\r\2\2\u00ca\25\3\2\2\2\u00cb\u00dd\7.\2\2\u00cc\u00d9\7\3\2\2"+
		"\u00cd\u00ce\5\30\r\2\u00ce\u00cf\7\n\2\2\u00cf\u00d1\3\2\2\2\u00d0\u00cd"+
		"\3\2\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d5\5\30\r\2\u00d5\u00da\3\2\2\2\u00d6\u00d8\5"+
		"\30\r\2\u00d7\u00d6\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00da\3\2\2\2\u00d9"+
		"\u00d0\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00de\7\4"+
		"\2\2\u00dc\u00de\7\'\2\2\u00dd\u00cc\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de"+
		"\27\3\2\2\2\u00df\u00e5\7.\2\2\u00e0\u00e5\5D#\2\u00e1\u00e5\5\20\t\2"+
		"\u00e2\u00e5\5&\24\2\u00e3\u00e5\5(\25\2\u00e4\u00df\3\2\2\2\u00e4\u00e0"+
		"\3\2\2\2\u00e4\u00e1\3\2\2\2\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5"+
		"\31\3\2\2\2\u00e6\u00e7\7.\2\2\u00e7\u00e8\7\f\2\2\u00e8\u00e9\5\4\3\2"+
		"\u00e9\33\3\2\2\2\u00ea\u00eb\7\16\2\2\u00eb\u00ec\5\4\3\2\u00ec\u00ef"+
		"\7\17\2\2\u00ed\u00f0\5\4\3\2\u00ee\u00f0\5\6\4\2\u00ef\u00ed\3\2\2\2"+
		"\u00ef\u00ee\3\2\2\2\u00f0\35\3\2\2\2\u00f1\u00f3\5 \21\2\u00f2\u00f4"+
		"\5\"\22\2\u00f3\u00f2\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\37\3\2\2\2\u00f5"+
		"\u00f6\7\20\2\2\u00f6\u00f7\5\4\3\2\u00f7\u00fa\7\21\2\2\u00f8\u00fb\5"+
		"\4\3\2\u00f9\u00fb\5\6\4\2\u00fa\u00f8\3\2\2\2\u00fa\u00f9\3\2\2\2\u00fb"+
		"!\3\2\2\2\u00fc\u00ff\7\22\2\2\u00fd\u0100\5\4\3\2\u00fe\u0100\5\6\4\2"+
		"\u00ff\u00fd\3\2\2\2\u00ff\u00fe\3\2\2\2\u0100#\3\2\2\2\u0101\u0102\7"+
		"\23\2\2\u0102\u0103\7.\2\2\u0103\u0104\7\13\2\2\u0104\u0107\5B\"\2\u0105"+
		"\u0106\7\f\2\2\u0106\u0108\5\4\3\2\u0107\u0105\3\2\2\2\u0107\u0108\3\2"+
		"\2\2\u0108\u0109\3\2\2\2\u0109\u010c\7\24\2\2\u010a\u010d\5\4\3\2\u010b"+
		"\u010d\5\6\4\2\u010c\u010a\3\2\2\2\u010c\u010b\3\2\2\2\u010d%\3\2\2\2"+
		"\u010e\u010f\7\25\2\2\u010f\u0110\7/\2\2\u0110\'\3\2\2\2\u0111\u0112\5"+
		"*\26\2\u0112)\3\2\2\2\u0113\u0114\b\26\1\2\u0114\u0115\5,\27\2\u0115\u011b"+
		"\3\2\2\2\u0116\u0117\f\4\2\2\u0117\u0118\7$\2\2\u0118\u011a\5,\27\2\u0119"+
		"\u0116\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u0119\3\2\2\2\u011b\u011c\3\2"+
		"\2\2\u011c+\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u011f\7%\2\2\u011f\u0122"+
		"\5,\27\2\u0120\u0122\5.\30\2\u0121\u011e\3\2\2\2\u0121\u0120\3\2\2\2\u0122"+
		"-\3\2\2\2\u0123\u0124\5\60\31\2\u0124\u0125\5> \2\u0125\u0126\5\60\31"+
		"\2\u0126\u0129\3\2\2\2\u0127\u0129\5\60\31\2\u0128\u0123\3\2\2\2\u0128"+
		"\u0127\3\2\2\2\u0129/\3\2\2\2\u012a\u012b\b\31\1\2\u012b\u012c\5\62\32"+
		"\2\u012c\u0133\3\2\2\2\u012d\u012e\f\4\2\2\u012e\u012f\5:\36\2\u012f\u0130"+
		"\5\62\32\2\u0130\u0132\3\2\2\2\u0131\u012d\3\2\2\2\u0132\u0135\3\2\2\2"+
		"\u0133\u0131\3\2\2\2\u0133\u0134\3\2\2\2\u0134\61\3\2\2\2\u0135\u0133"+
		"\3\2\2\2\u0136\u0137\b\32\1\2\u0137\u0138\5\64\33\2\u0138\u013f\3\2\2"+
		"\2\u0139\u013a\f\4\2\2\u013a\u013b\5<\37\2\u013b\u013c\5\64\33\2\u013c"+
		"\u013e\3\2\2\2\u013d\u0139\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2"+
		"\2\2\u013f\u0140\3\2\2\2\u0140\63\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143"+
		"\7\37\2\2\u0143\u0148\5\64\33\2\u0144\u0145\7&\2\2\u0145\u0148\5\64\33"+
		"\2\u0146\u0148\5\66\34\2\u0147\u0142\3\2\2\2\u0147\u0144\3\2\2\2\u0147"+
		"\u0146\3\2\2\2\u0148\65\3\2\2\2\u0149\u014a\58\35\2\u014a\u014b\7\34\2"+
		"\2\u014b\u014c\5\66\34\2\u014c\u014f\3\2\2\2\u014d\u014f\58\35\2\u014e"+
		"\u0149\3\2\2\2\u014e\u014d\3\2\2\2\u014f\67\3\2\2\2\u0150\u0151\7\3\2"+
		"\2\u0151\u0152\5*\26\2\u0152\u0153\7\4\2\2\u0153\u015a\3\2\2\2\u0154\u015a"+
		"\5D#\2\u0155\u015a\7.\2\2\u0156\u015a\5\20\t\2\u0157\u015a\5&\24\2\u0158"+
		"\u015a\5\36\20\2\u0159\u0150\3\2\2\2\u0159\u0154\3\2\2\2\u0159\u0155\3"+
		"\2\2\2\u0159\u0156\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u0158\3\2\2\2\u015a"+
		"9\3\2\2\2\u015b\u015c\t\2\2\2\u015c;\3\2\2\2\u015d\u015e\t\3\2\2\u015e"+
		"=\3\2\2\2\u015f\u0160\t\4\2\2\u0160?\3\2\2\2\u0161\u0162\t\5\2\2\u0162"+
		"A\3\2\2\2\u0163\u0164\t\6\2\2\u0164C\3\2\2\2\u0165\u016b\7\32\2\2\u0166"+
		"\u016b\7\33\2\2\u0167\u016b\7\60\2\2\u0168\u016b\5@!\2\u0169\u016b\7\'"+
		"\2\2\u016a\u0165\3\2\2\2\u016a\u0166\3\2\2\2\u016a\u0167\3\2\2\2\u016a"+
		"\u0168\3\2\2\2\u016a\u0169\3\2\2\2\u016bE\3\2\2\2+IX]dfjlty{\u0087\u008c"+
		"\u008e\u0092\u00a2\u00a4\u00ae\u00b2\u00b7\u00bf\u00c7\u00d2\u00d7\u00d9"+
		"\u00dd\u00e4\u00ef\u00f3\u00fa\u00ff\u0107\u010c\u011b\u0121\u0128\u0133"+
		"\u013f\u0147\u014e\u0159\u016a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}