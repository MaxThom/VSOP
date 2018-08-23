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
		T__24=25, POW=26, MULTI=27, DIV=28, MINUS=29, PLUS=30, LOWER=31, LOWER_EQUAL=32, 
		EQUAL=33, GREATER=34, GREATER_EQUAL=35, DIFFERENT_EQUAL=36, AND=37, OR=38, 
		NOT=39, ISNULL=40, VOID_OPERATOR=41, MULTILINE_OPEN_COMMENT=42, MULTILINE_CLOSE_COMMENT=43, 
		MULTILINE_COMMENT=44, INTEGER_BIN=45, INTEGER_HEX=46, INTEGER_DEC=47, 
		OBJECT_IDENTIFIER=48, TYPE_IDENTIFIER=49, STRING=50, SINGLE_LINE_COMMENT=51, 
		WS=52;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_block = 2, RULE_classDefinition = 3, 
		RULE_methodDefinition = 4, RULE_formal = 5, RULE_field = 6, RULE_callMethod = 7, 
		RULE_singleCallMethod = 8, RULE_caller = 9, RULE_callFunction = 10, RULE_argument = 11, 
		RULE_assign = 12, RULE_whileStatement = 13, RULE_ifStatement = 14, RULE_ifStat = 15, 
		RULE_elseStat = 16, RULE_let = 17, RULE_newObj = 18, RULE_binaryOperation = 19, 
		RULE_expr1 = 20, RULE_exprOr = 21, RULE_expr2 = 22, RULE_expr3 = 23, RULE_expr4 = 24, 
		RULE_expr5 = 25, RULE_expr6 = 26, RULE_expr7 = 27, RULE_expr8 = 28, RULE_termOperator = 29, 
		RULE_factorOperator = 30, RULE_comparatorOperator = 31, RULE_integer = 32, 
		RULE_varType = 33, RULE_varValue = 34;
	public static final String[] ruleNames = {
		"program", "statement", "block", "classDefinition", "methodDefinition", 
		"formal", "field", "callMethod", "singleCallMethod", "caller", "callFunction", 
		"argument", "assign", "whileStatement", "ifStatement", "ifStat", "elseStat", 
		"let", "newObj", "binaryOperation", "expr1", "exprOr", "expr2", "expr3", 
		"expr4", "expr5", "expr6", "expr7", "expr8", "termOperator", "factorOperator", 
		"comparatorOperator", "integer", "varType", "varValue"
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
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				classDefinition();
				}
				}
				setState(73); 
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
			setState(88);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				ifStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(77);
				whileStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(78);
				let();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(79);
				callMethod();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(80);
				newObj();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(81);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(82);
				varValue();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				{
				setState(83);
				match(T__0);
				setState(84);
				statement();
				setState(85);
				match(T__1);
				}
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(87);
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
			setState(90);
			match(T__2);
			{
			setState(108);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				setState(93);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(91);
					statement();
					}
					break;
				case 2:
					{
					setState(92);
					block();
					}
					break;
				}
				}
				break;
			case 2:
				{
				{
				setState(100); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(100);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
						case 1:
							{
							{
							setState(95);
							statement();
							setState(96);
							match(T__3);
							}
							}
							break;
						case 2:
							{
							setState(98);
							whileStatement();
							}
							break;
						case 3:
							{
							setState(99);
							ifStatement();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(102); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(106);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(104);
					statement();
					}
					break;
				case 2:
					{
					setState(105);
					block();
					}
					break;
				}
				}
				}
				break;
			}
			}
			setState(110);
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
			setState(112);
			match(T__5);
			setState(113);
			match(TYPE_IDENTIFIER);
			setState(116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(114);
				match(T__6);
				setState(115);
				match(TYPE_IDENTIFIER);
				}
			}

			setState(118);
			match(T__2);
			setState(123);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OBJECT_IDENTIFIER) {
				{
				setState(121);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(119);
					methodDefinition();
					}
					break;
				case 2:
					{
					setState(120);
					field();
					}
					break;
				}
				}
				setState(125);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(126);
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
			setState(128);
			match(OBJECT_IDENTIFIER);
			setState(146);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				setState(129);
				match(T__0);
				{
				setState(142);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					{
					setState(133); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(130);
							formal();
							setState(131);
							match(T__7);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(135); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					{
					setState(137);
					formal();
					}
					}
					}
					break;
				case 2:
					{
					setState(140);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==OBJECT_IDENTIFIER) {
						{
						setState(139);
						formal();
						}
					}

					}
					break;
				}
				setState(144);
				match(T__1);
				}
				}
				break;
			case VOID_OPERATOR:
				{
				{
				setState(145);
				match(VOID_OPERATOR);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(148);
			match(T__8);
			setState(149);
			varType();
			setState(150);
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
			setState(152);
			match(OBJECT_IDENTIFIER);
			setState(153);
			match(T__8);
			setState(154);
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
			setState(156);
			match(OBJECT_IDENTIFIER);
			setState(157);
			match(T__8);
			setState(158);
			varType();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(159);
				match(T__9);
				setState(162);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(160);
					statement();
					}
					break;
				case 2:
					{
					setState(161);
					block();
					}
					break;
				}
				}
			}

			setState(166);
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
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(168);
				singleCallMethod();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(172); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(169);
						singleCallMethod();
						setState(170);
						match(T__10);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(174); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				{
				setState(176);
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
			setState(183);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(180);
					caller();
					}
					} 
				}
				setState(185);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(186);
			callFunction();
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(187);
					match(T__10);
					setState(188);
					callFunction();
					}
					} 
				}
				setState(193);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public NewObjContext newObj() {
			return getRuleContext(NewObjContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
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
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(194);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case 2:
				{
				{
				setState(195);
				match(T__0);
				setState(196);
				newObj();
				setState(197);
				match(T__1);
				}
				}
				break;
			case 3:
				{
				{
				setState(199);
				match(T__0);
				setState(200);
				ifStatement();
				setState(201);
				match(T__1);
				}
				}
				break;
			}
			setState(205);
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
			setState(207);
			match(OBJECT_IDENTIFIER);
			setState(225);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				{
				{
				setState(208);
				match(T__0);
				setState(221);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
				case 1:
					{
					{
					setState(212); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(209);
							argument();
							setState(210);
							match(T__7);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(214); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(216);
					argument();
					}
					}
					break;
				case 2:
					{
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__11) | (1L << T__13) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << MINUS) | (1L << NOT) | (1L << ISNULL) | (1L << VOID_OPERATOR) | (1L << INTEGER_BIN) | (1L << INTEGER_HEX) | (1L << INTEGER_DEC) | (1L << OBJECT_IDENTIFIER) | (1L << STRING))) != 0)) {
						{
						setState(218);
						argument();
						}
					}

					}
					break;
				}
				setState(223);
				match(T__1);
				}
				}
				break;
			case VOID_OPERATOR:
				{
				{
				setState(224);
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
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
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
			setState(229);
			match(OBJECT_IDENTIFIER);
			setState(230);
			match(T__9);
			setState(231);
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
			setState(233);
			match(T__11);
			setState(234);
			statement();
			setState(235);
			match(T__12);
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				{
				setState(236);
				statement();
				}
				break;
			case 2:
				{
				setState(237);
				block();
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
			setState(240);
			ifStat();
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(241);
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
			setState(244);
			match(T__13);
			setState(245);
			statement();
			setState(246);
			match(T__14);
			setState(249);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(247);
				statement();
				}
				break;
			case 2:
				{
				setState(248);
				block();
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
			setState(251);
			match(T__15);
			setState(254);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				setState(252);
				statement();
				}
				break;
			case 2:
				{
				setState(253);
				block();
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
			setState(256);
			match(T__16);
			setState(257);
			match(OBJECT_IDENTIFIER);
			setState(258);
			match(T__8);
			setState(259);
			varType();
			setState(262);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(260);
				match(T__9);
				setState(261);
				statement();
				}
			}

			setState(264);
			match(T__17);
			setState(267);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(265);
				statement();
				}
				break;
			case 2:
				{
				setState(266);
				block();
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
		enterRule(_localctx, 36, RULE_newObj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			match(T__18);
			setState(270);
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
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterBinaryOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitBinaryOperation(this);
		}
	}

	public final BinaryOperationContext binaryOperation() throws RecognitionException {
		BinaryOperationContext _localctx = new BinaryOperationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_binaryOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
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
		public ExprOrContext exprOr() {
			return getRuleContext(ExprOrContext.class,0);
		}
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public TerminalNode AND() { return getToken(PARSERParser.AND, 0); }
		public Expr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterExpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitExpr1(this);
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
			setState(275);
			exprOr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr1Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr1);
					setState(277);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(278);
					match(AND);
					setState(279);
					exprOr(0);
					}
					} 
				}
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
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

	public static class ExprOrContext extends ParserRuleContext {
		public Expr2Context expr2() {
			return getRuleContext(Expr2Context.class,0);
		}
		public ExprOrContext exprOr() {
			return getRuleContext(ExprOrContext.class,0);
		}
		public TerminalNode OR() { return getToken(PARSERParser.OR, 0); }
		public ExprOrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprOr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterExprOr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitExprOr(this);
		}
	}

	public final ExprOrContext exprOr() throws RecognitionException {
		return exprOr(0);
	}

	private ExprOrContext exprOr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprOrContext _localctx = new ExprOrContext(_ctx, _parentState);
		ExprOrContext _prevctx = _localctx;
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_exprOr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(286);
			expr2();
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExprOrContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exprOr);
					setState(288);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(289);
					match(OR);
					setState(290);
					expr2();
					}
					} 
				}
				setState(295);
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
		public TerminalNode NOT() { return getToken(PARSERParser.NOT, 0); }
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
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterExpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitExpr2(this);
		}
	}

	public final Expr2Context expr2() throws RecognitionException {
		Expr2Context _localctx = new Expr2Context(_ctx, getState());
		enterRule(_localctx, 44, RULE_expr2);
		try {
			setState(299);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(NOT);
				setState(297);
				expr2();
				}
				break;
			case T__0:
			case T__2:
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
				setState(298);
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
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterExpr3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitExpr3(this);
		}
	}

	public final Expr3Context expr3() throws RecognitionException {
		Expr3Context _localctx = new Expr3Context(_ctx, getState());
		enterRule(_localctx, 46, RULE_expr3);
		try {
			setState(306);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(301);
				expr4(0);
				setState(302);
				comparatorOperator();
				setState(303);
				expr4(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
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
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterExpr4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitExpr4(this);
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_expr4, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(309);
			expr5(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(317);
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
					setState(311);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(312);
					termOperator();
					setState(313);
					expr5(0);
					}
					} 
				}
				setState(319);
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
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterExpr5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitExpr5(this);
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
		int _startState = 50;
		enterRecursionRule(_localctx, 50, RULE_expr5, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(321);
			expr6();
			}
			_ctx.stop = _input.LT(-1);
			setState(329);
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
					setState(323);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(324);
					factorOperator();
					setState(325);
					expr6();
					}
					} 
				}
				setState(331);
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
		public TerminalNode MINUS() { return getToken(PARSERParser.MINUS, 0); }
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public TerminalNode ISNULL() { return getToken(PARSERParser.ISNULL, 0); }
		public Expr7Context expr7() {
			return getRuleContext(Expr7Context.class,0);
		}
		public Expr6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr6; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterExpr6(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitExpr6(this);
		}
	}

	public final Expr6Context expr6() throws RecognitionException {
		Expr6Context _localctx = new Expr6Context(_ctx, getState());
		enterRule(_localctx, 52, RULE_expr6);
		try {
			setState(337);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(332);
				match(MINUS);
				setState(333);
				expr6();
				}
				break;
			case ISNULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(334);
				match(ISNULL);
				setState(335);
				expr6();
				}
				break;
			case T__0:
			case T__2:
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
				setState(336);
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
		public TerminalNode POW() { return getToken(PARSERParser.POW, 0); }
		public Expr7Context expr7() {
			return getRuleContext(Expr7Context.class,0);
		}
		public Expr7Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr7; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterExpr7(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitExpr7(this);
		}
	}

	public final Expr7Context expr7() throws RecognitionException {
		Expr7Context _localctx = new Expr7Context(_ctx, getState());
		enterRule(_localctx, 54, RULE_expr7);
		try {
			setState(344);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(339);
				expr8();
				setState(340);
				match(POW);
				setState(341);
				expr7();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(343);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public CallMethodContext callMethod() {
			return getRuleContext(CallMethodContext.class,0);
		}
		public NewObjContext newObj() {
			return getRuleContext(NewObjContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Expr8Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr8; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterExpr8(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitExpr8(this);
		}
	}

	public final Expr8Context expr8() throws RecognitionException {
		Expr8Context _localctx = new Expr8Context(_ctx, getState());
		enterRule(_localctx, 56, RULE_expr8);
		try {
			setState(356);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(346);
				match(T__0);
				setState(347);
				expr1(0);
				setState(348);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				varValue();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(351);
				match(OBJECT_IDENTIFIER);
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
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(355);
				block();
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
		public TerminalNode MINUS() { return getToken(PARSERParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(PARSERParser.PLUS, 0); }
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
		enterRule(_localctx, 58, RULE_termOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(358);
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
		public TerminalNode MULTI() { return getToken(PARSERParser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(PARSERParser.DIV, 0); }
		public FactorOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factorOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterFactorOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitFactorOperator(this);
		}
	}

	public final FactorOperatorContext factorOperator() throws RecognitionException {
		FactorOperatorContext _localctx = new FactorOperatorContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_factorOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
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
		public TerminalNode LOWER() { return getToken(PARSERParser.LOWER, 0); }
		public TerminalNode LOWER_EQUAL() { return getToken(PARSERParser.LOWER_EQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(PARSERParser.EQUAL, 0); }
		public TerminalNode GREATER() { return getToken(PARSERParser.GREATER, 0); }
		public TerminalNode GREATER_EQUAL() { return getToken(PARSERParser.GREATER_EQUAL, 0); }
		public TerminalNode DIFFERENT_EQUAL() { return getToken(PARSERParser.DIFFERENT_EQUAL, 0); }
		public ComparatorOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparatorOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).enterComparatorOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PARSERListener ) ((PARSERListener)listener).exitComparatorOperator(this);
		}
	}

	public final ComparatorOperatorContext comparatorOperator() throws RecognitionException {
		ComparatorOperatorContext _localctx = new ComparatorOperatorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_comparatorOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << LOWER) | (1L << LOWER_EQUAL) | (1L << EQUAL) | (1L << GREATER) | (1L << GREATER_EQUAL) | (1L << DIFFERENT_EQUAL))) != 0)) ) {
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
		enterRule(_localctx, 64, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
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
		enterRule(_localctx, 66, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366);
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
		public TerminalNode VOID_OPERATOR() { return getToken(PARSERParser.VOID_OPERATOR, 0); }
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
		enterRule(_localctx, 68, RULE_varValue);
		try {
			setState(373);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				enterOuterAlt(_localctx, 1);
				{
				setState(368);
				match(T__23);
				}
				break;
			case T__24:
				enterOuterAlt(_localctx, 2);
				{
				setState(369);
				match(T__24);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(370);
				match(STRING);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				enterOuterAlt(_localctx, 4);
				{
				setState(371);
				integer();
				}
				break;
			case VOID_OPERATOR:
				enterOuterAlt(_localctx, 5);
				{
				setState(372);
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
		case 21:
			return exprOr_sempred((ExprOrContext)_localctx, predIndex);
		case 24:
			return expr4_sempred((Expr4Context)_localctx, predIndex);
		case 25:
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
	private boolean exprOr_sempred(ExprOrContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr4_sempred(Expr4Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr5_sempred(Expr5Context _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\66\u017a\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\6\2J\n\2\r\2\16\2K\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3[\n\3\3\4\3\4\3\4\5\4`\n\4\3\4\3\4\3\4"+
		"\3\4\3\4\6\4g\n\4\r\4\16\4h\3\4\3\4\5\4m\n\4\5\4o\n\4\3\4\3\4\3\5\3\5"+
		"\3\5\3\5\5\5w\n\5\3\5\3\5\3\5\7\5|\n\5\f\5\16\5\177\13\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\6\3\6\6\6\u0088\n\6\r\6\16\6\u0089\3\6\3\6\3\6\5\6\u008f\n\6"+
		"\5\6\u0091\n\6\3\6\3\6\5\6\u0095\n\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a5\n\b\5\b\u00a7\n\b\3\b\3\b\3\t\3\t\3\t"+
		"\3\t\6\t\u00af\n\t\r\t\16\t\u00b0\3\t\3\t\5\t\u00b5\n\t\3\n\7\n\u00b8"+
		"\n\n\f\n\16\n\u00bb\13\n\3\n\3\n\3\n\7\n\u00c0\n\n\f\n\16\n\u00c3\13\n"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00ce\n\13\3\13\3\13"+
		"\3\f\3\f\3\f\3\f\3\f\6\f\u00d7\n\f\r\f\16\f\u00d8\3\f\3\f\3\f\5\f\u00de"+
		"\n\f\5\f\u00e0\n\f\3\f\3\f\5\f\u00e4\n\f\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\17\3\17\3\17\3\17\3\17\5\17\u00f1\n\17\3\20\3\20\5\20\u00f5\n\20\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00fc\n\21\3\22\3\22\3\22\5\22\u0101\n\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\5\23\u0109\n\23\3\23\3\23\3\23\5\23\u010e"+
		"\n\23\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\7\26\u011b"+
		"\n\26\f\26\16\26\u011e\13\26\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0126"+
		"\n\27\f\27\16\27\u0129\13\27\3\30\3\30\3\30\5\30\u012e\n\30\3\31\3\31"+
		"\3\31\3\31\3\31\5\31\u0135\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32"+
		"\u013e\n\32\f\32\16\32\u0141\13\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\7\33\u014a\n\33\f\33\16\33\u014d\13\33\3\34\3\34\3\34\3\34\3\34\5\34"+
		"\u0154\n\34\3\35\3\35\3\35\3\35\3\35\5\35\u015b\n\35\3\36\3\36\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\5\36\u0167\n\36\3\37\3\37\3 \3 \3!\3"+
		"!\3\"\3\"\3#\3#\3$\3$\3$\3$\3$\5$\u0178\n$\3$\2\6*,\62\64%\2\4\6\b\n\f"+
		"\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDF\2\7\3\2\37 \3"+
		"\2\35\36\3\2!&\3\2/\61\4\2\26\31\63\63\2\u0193\2I\3\2\2\2\4Z\3\2\2\2\6"+
		"\\\3\2\2\2\br\3\2\2\2\n\u0082\3\2\2\2\f\u009a\3\2\2\2\16\u009e\3\2\2\2"+
		"\20\u00b4\3\2\2\2\22\u00b9\3\2\2\2\24\u00cd\3\2\2\2\26\u00d1\3\2\2\2\30"+
		"\u00e5\3\2\2\2\32\u00e7\3\2\2\2\34\u00eb\3\2\2\2\36\u00f2\3\2\2\2 \u00f6"+
		"\3\2\2\2\"\u00fd\3\2\2\2$\u0102\3\2\2\2&\u010f\3\2\2\2(\u0112\3\2\2\2"+
		"*\u0114\3\2\2\2,\u011f\3\2\2\2.\u012d\3\2\2\2\60\u0134\3\2\2\2\62\u0136"+
		"\3\2\2\2\64\u0142\3\2\2\2\66\u0153\3\2\2\28\u015a\3\2\2\2:\u0166\3\2\2"+
		"\2<\u0168\3\2\2\2>\u016a\3\2\2\2@\u016c\3\2\2\2B\u016e\3\2\2\2D\u0170"+
		"\3\2\2\2F\u0177\3\2\2\2HJ\5\b\5\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2"+
		"\2\2L\3\3\2\2\2M[\5\32\16\2N[\5\36\20\2O[\5\34\17\2P[\5$\23\2Q[\5\20\t"+
		"\2R[\5&\24\2S[\7\62\2\2T[\5F$\2UV\7\3\2\2VW\5\4\3\2WX\7\4\2\2X[\3\2\2"+
		"\2Y[\5(\25\2ZM\3\2\2\2ZN\3\2\2\2ZO\3\2\2\2ZP\3\2\2\2ZQ\3\2\2\2ZR\3\2\2"+
		"\2ZS\3\2\2\2ZT\3\2\2\2ZU\3\2\2\2ZY\3\2\2\2[\5\3\2\2\2\\n\7\5\2\2]`\5\4"+
		"\3\2^`\5\6\4\2_]\3\2\2\2_^\3\2\2\2`o\3\2\2\2ab\5\4\3\2bc\7\6\2\2cg\3\2"+
		"\2\2dg\5\34\17\2eg\5\36\20\2fa\3\2\2\2fd\3\2\2\2fe\3\2\2\2gh\3\2\2\2h"+
		"f\3\2\2\2hi\3\2\2\2il\3\2\2\2jm\5\4\3\2km\5\6\4\2lj\3\2\2\2lk\3\2\2\2"+
		"mo\3\2\2\2n_\3\2\2\2nf\3\2\2\2no\3\2\2\2op\3\2\2\2pq\7\7\2\2q\7\3\2\2"+
		"\2rs\7\b\2\2sv\7\63\2\2tu\7\t\2\2uw\7\63\2\2vt\3\2\2\2vw\3\2\2\2wx\3\2"+
		"\2\2x}\7\5\2\2y|\5\n\6\2z|\5\16\b\2{y\3\2\2\2{z\3\2\2\2|\177\3\2\2\2}"+
		"{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7\7\2\2\u0081"+
		"\t\3\2\2\2\u0082\u0094\7\62\2\2\u0083\u0090\7\3\2\2\u0084\u0085\5\f\7"+
		"\2\u0085\u0086\7\n\2\2\u0086\u0088\3\2\2\2\u0087\u0084\3\2\2\2\u0088\u0089"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u008b\3\2\2\2\u008b"+
		"\u008c\5\f\7\2\u008c\u0091\3\2\2\2\u008d\u008f\5\f\7\2\u008e\u008d\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u0087\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0095\7\4\2\2\u0093\u0095\7+"+
		"\2\2\u0094\u0083\3\2\2\2\u0094\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096"+
		"\u0097\7\13\2\2\u0097\u0098\5D#\2\u0098\u0099\5\6\4\2\u0099\13\3\2\2\2"+
		"\u009a\u009b\7\62\2\2\u009b\u009c\7\13\2\2\u009c\u009d\5D#\2\u009d\r\3"+
		"\2\2\2\u009e\u009f\7\62\2\2\u009f\u00a0\7\13\2\2\u00a0\u00a6\5D#\2\u00a1"+
		"\u00a4\7\f\2\2\u00a2\u00a5\5\4\3\2\u00a3\u00a5\5\6\4\2\u00a4\u00a2\3\2"+
		"\2\2\u00a4\u00a3\3\2\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a6"+
		"\u00a7\3\2\2\2\u00a7\u00a8\3\2\2\2\u00a8\u00a9\7\6\2\2\u00a9\17\3\2\2"+
		"\2\u00aa\u00b5\5\22\n\2\u00ab\u00ac\5\22\n\2\u00ac\u00ad\7\r\2\2\u00ad"+
		"\u00af\3\2\2\2\u00ae\u00ab\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0\u00ae\3\2"+
		"\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\5\22\n\2\u00b3"+
		"\u00b5\3\2\2\2\u00b4\u00aa\3\2\2\2\u00b4\u00ae\3\2\2\2\u00b5\21\3\2\2"+
		"\2\u00b6\u00b8\5\24\13\2\u00b7\u00b6\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2"+
		"\2\2\u00bc\u00c1\5\26\f\2\u00bd\u00be\7\r\2\2\u00be\u00c0\5\26\f\2\u00bf"+
		"\u00bd\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2"+
		"\2\2\u00c2\23\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00ce\7\62\2\2\u00c5\u00c6"+
		"\7\3\2\2\u00c6\u00c7\5&\24\2\u00c7\u00c8\7\4\2\2\u00c8\u00ce\3\2\2\2\u00c9"+
		"\u00ca\7\3\2\2\u00ca\u00cb\5\36\20\2\u00cb\u00cc\7\4\2\2\u00cc\u00ce\3"+
		"\2\2\2\u00cd\u00c4\3\2\2\2\u00cd\u00c5\3\2\2\2\u00cd\u00c9\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d0\7\r\2\2\u00d0\25\3\2\2\2\u00d1\u00e3\7\62\2"+
		"\2\u00d2\u00df\7\3\2\2\u00d3\u00d4\5\30\r\2\u00d4\u00d5\7\n\2\2\u00d5"+
		"\u00d7\3\2\2\2\u00d6\u00d3\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8\u00d6\3\2"+
		"\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00db\5\30\r\2\u00db"+
		"\u00e0\3\2\2\2\u00dc\u00de\5\30\r\2\u00dd\u00dc\3\2\2\2\u00dd\u00de\3"+
		"\2\2\2\u00de\u00e0\3\2\2\2\u00df\u00d6\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e4\7\4\2\2\u00e2\u00e4\7+\2\2\u00e3\u00d2\3\2"+
		"\2\2\u00e3\u00e2\3\2\2\2\u00e4\27\3\2\2\2\u00e5\u00e6\5\4\3\2\u00e6\31"+
		"\3\2\2\2\u00e7\u00e8\7\62\2\2\u00e8\u00e9\7\f\2\2\u00e9\u00ea\5\4\3\2"+
		"\u00ea\33\3\2\2\2\u00eb\u00ec\7\16\2\2\u00ec\u00ed\5\4\3\2\u00ed\u00f0"+
		"\7\17\2\2\u00ee\u00f1\5\4\3\2\u00ef\u00f1\5\6\4\2\u00f0\u00ee\3\2\2\2"+
		"\u00f0\u00ef\3\2\2\2\u00f1\35\3\2\2\2\u00f2\u00f4\5 \21\2\u00f3\u00f5"+
		"\5\"\22\2\u00f4\u00f3\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\37\3\2\2\2\u00f6"+
		"\u00f7\7\20\2\2\u00f7\u00f8\5\4\3\2\u00f8\u00fb\7\21\2\2\u00f9\u00fc\5"+
		"\4\3\2\u00fa\u00fc\5\6\4\2\u00fb\u00f9\3\2\2\2\u00fb\u00fa\3\2\2\2\u00fc"+
		"!\3\2\2\2\u00fd\u0100\7\22\2\2\u00fe\u0101\5\4\3\2\u00ff\u0101\5\6\4\2"+
		"\u0100\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101#\3\2\2\2\u0102\u0103\7"+
		"\23\2\2\u0103\u0104\7\62\2\2\u0104\u0105\7\13\2\2\u0105\u0108\5D#\2\u0106"+
		"\u0107\7\f\2\2\u0107\u0109\5\4\3\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2"+
		"\2\2\u0109\u010a\3\2\2\2\u010a\u010d\7\24\2\2\u010b\u010e\5\4\3\2\u010c"+
		"\u010e\5\6\4\2\u010d\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010e%\3\2\2\2"+
		"\u010f\u0110\7\25\2\2\u0110\u0111\7\63\2\2\u0111\'\3\2\2\2\u0112\u0113"+
		"\5*\26\2\u0113)\3\2\2\2\u0114\u0115\b\26\1\2\u0115\u0116\5,\27\2\u0116"+
		"\u011c\3\2\2\2\u0117\u0118\f\4\2\2\u0118\u0119\7\'\2\2\u0119\u011b\5,"+
		"\27\2\u011a\u0117\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d+\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0120\b\27\1\2"+
		"\u0120\u0121\5.\30\2\u0121\u0127\3\2\2\2\u0122\u0123\f\4\2\2\u0123\u0124"+
		"\7(\2\2\u0124\u0126\5.\30\2\u0125\u0122\3\2\2\2\u0126\u0129\3\2\2\2\u0127"+
		"\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128-\3\2\2\2\u0129\u0127\3\2\2\2"+
		"\u012a\u012b\7)\2\2\u012b\u012e\5.\30\2\u012c\u012e\5\60\31\2\u012d\u012a"+
		"\3\2\2\2\u012d\u012c\3\2\2\2\u012e/\3\2\2\2\u012f\u0130\5\62\32\2\u0130"+
		"\u0131\5@!\2\u0131\u0132\5\62\32\2\u0132\u0135\3\2\2\2\u0133\u0135\5\62"+
		"\32\2\u0134\u012f\3\2\2\2\u0134\u0133\3\2\2\2\u0135\61\3\2\2\2\u0136\u0137"+
		"\b\32\1\2\u0137\u0138\5\64\33\2\u0138\u013f\3\2\2\2\u0139\u013a\f\4\2"+
		"\2\u013a\u013b\5<\37\2\u013b\u013c\5\64\33\2\u013c\u013e\3\2\2\2\u013d"+
		"\u0139\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2"+
		"\2\2\u0140\63\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0143\b\33\1\2\u0143\u0144"+
		"\5\66\34\2\u0144\u014b\3\2\2\2\u0145\u0146\f\4\2\2\u0146\u0147\5> \2\u0147"+
		"\u0148\5\66\34\2\u0148\u014a\3\2\2\2\u0149\u0145\3\2\2\2\u014a\u014d\3"+
		"\2\2\2\u014b\u0149\3\2\2\2\u014b\u014c\3\2\2\2\u014c\65\3\2\2\2\u014d"+
		"\u014b\3\2\2\2\u014e\u014f\7\37\2\2\u014f\u0154\5\66\34\2\u0150\u0151"+
		"\7*\2\2\u0151\u0154\5\66\34\2\u0152\u0154\58\35\2\u0153\u014e\3\2\2\2"+
		"\u0153\u0150\3\2\2\2\u0153\u0152\3\2\2\2\u0154\67\3\2\2\2\u0155\u0156"+
		"\5:\36\2\u0156\u0157\7\34\2\2\u0157\u0158\58\35\2\u0158\u015b\3\2\2\2"+
		"\u0159\u015b\5:\36\2\u015a\u0155\3\2\2\2\u015a\u0159\3\2\2\2\u015b9\3"+
		"\2\2\2\u015c\u015d\7\3\2\2\u015d\u015e\5*\26\2\u015e\u015f\7\4\2\2\u015f"+
		"\u0167\3\2\2\2\u0160\u0167\5F$\2\u0161\u0167\7\62\2\2\u0162\u0167\5\20"+
		"\t\2\u0163\u0167\5&\24\2\u0164\u0167\5\36\20\2\u0165\u0167\5\6\4\2\u0166"+
		"\u015c\3\2\2\2\u0166\u0160\3\2\2\2\u0166\u0161\3\2\2\2\u0166\u0162\3\2"+
		"\2\2\u0166\u0163\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0165\3\2\2\2\u0167"+
		";\3\2\2\2\u0168\u0169\t\2\2\2\u0169=\3\2\2\2\u016a\u016b\t\3\2\2\u016b"+
		"?\3\2\2\2\u016c\u016d\t\4\2\2\u016dA\3\2\2\2\u016e\u016f\t\5\2\2\u016f"+
		"C\3\2\2\2\u0170\u0171\t\6\2\2\u0171E\3\2\2\2\u0172\u0178\7\32\2\2\u0173"+
		"\u0178\7\33\2\2\u0174\u0178\7\64\2\2\u0175\u0178\5B\"\2\u0176\u0178\7"+
		"+\2\2\u0177\u0172\3\2\2\2\u0177\u0173\3\2\2\2\u0177\u0174\3\2\2\2\u0177"+
		"\u0175\3\2\2\2\u0177\u0176\3\2\2\2\u0178G\3\2\2\2+KZ_fhlnv{}\u0089\u008e"+
		"\u0090\u0094\u00a4\u00a6\u00b0\u00b4\u00b9\u00c1\u00cd\u00d8\u00dd\u00df"+
		"\u00e3\u00f0\u00f4\u00fb\u0100\u0108\u010d\u011c\u0127\u012d\u0134\u013f"+
		"\u014b\u0153\u015a\u0166\u0177";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}