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
		T__24=25, UN_OPERATOR=26, ARITHMETIC_OPERATOR=27, CONDITIONAL_OPERATOR=28, 
		MULTILINE_OPEN_COMMENT=29, MULTILINE_CLOSE_COMMENT=30, MULTILINE_COMMENT=31, 
		INTEGER_BIN=32, INTEGER_HEX=33, INTEGER_DEC=34, OBJECT_IDENTIFIER=35, 
		TYPE_IDENTIFIER=36, STRING=37, SINGLE_LINE_COMMENT=38, WS=39;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_block = 2, RULE_classDefinition = 3, 
		RULE_methodDefinition = 4, RULE_formal = 5, RULE_field = 6, RULE_callMethod = 7, 
		RULE_argument = 8, RULE_assign = 9, RULE_whileStatement = 10, RULE_ifStatement = 11, 
		RULE_ifStat = 12, RULE_elseStat = 13, RULE_let = 14, RULE_binaryOperation = 15, 
		RULE_unOperation = 16, RULE_newObj = 17, RULE_condition = 18, RULE_comparaiser = 19, 
		RULE_integer = 20, RULE_varType = 21, RULE_varValue = 22;
	public static final String[] ruleNames = {
		"program", "statement", "block", "classDefinition", "methodDefinition", 
		"formal", "field", "callMethod", "argument", "assign", "whileStatement", 
		"ifStatement", "ifStat", "elseStat", "let", "binaryOperation", "unOperation", 
		"newObj", "condition", "comparaiser", "integer", "varType", "varValue"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "';'", "'}'", "'class'", "'extends'", "'('", "','", "')'", 
		"':'", "'<-'", "'.'", "'while'", "'do'", "'if'", "'then'", "'else'", "'let'", 
		"'in'", "'new'", "'bool'", "'int32'", "'string'", "'unit'", "'true'", 
		"'false'", null, null, null, "'(*'", "'*)'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "UN_OPERATOR", "ARITHMETIC_OPERATOR", "CONDITIONAL_OPERATOR", 
		"MULTILINE_OPEN_COMMENT", "MULTILINE_CLOSE_COMMENT", "MULTILINE_COMMENT", 
		"INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "OBJECT_IDENTIFIER", "TYPE_IDENTIFIER", 
		"STRING", "SINGLE_LINE_COMMENT", "WS"
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
			setState(49); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(49);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(46);
					classDefinition();
					}
					break;
				case 2:
					{
					setState(47);
					methodDefinition();
					}
					break;
				case 3:
					{
					setState(48);
					statement();
					}
					break;
				}
				}
				setState(51); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__11) | (1L << T__13) | (1L << T__16) | (1L << T__18) | (1L << T__23) | (1L << T__24) | (1L << UN_OPERATOR) | (1L << INTEGER_BIN) | (1L << INTEGER_HEX) | (1L << INTEGER_DEC) | (1L << OBJECT_IDENTIFIER) | (1L << STRING))) != 0) );
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
		public UnOperationContext unOperation() {
			return getRuleContext(UnOperationContext.class,0);
		}
		public BinaryOperationContext binaryOperation() {
			return getRuleContext(BinaryOperationContext.class,0);
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
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(53);
				assign();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				ifStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(55);
				whileStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(56);
				let();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(57);
				unOperation();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(58);
				binaryOperation();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(59);
				callMethod();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(60);
				newObj();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(61);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(62);
				varValue();
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
			setState(65);
			match(T__0);
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(66);
				statement();
				}
				break;
			case 2:
				{
				{
				setState(72); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(72);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
						case 1:
							{
							{
							setState(67);
							statement();
							setState(68);
							match(T__1);
							}
							}
							break;
						case 2:
							{
							setState(70);
							whileStatement();
							}
							break;
						case 3:
							{
							setState(71);
							ifStatement();
							}
							break;
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(74); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(76);
				statement();
				}
				}
				break;
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
			setState(82);
			match(T__3);
			setState(83);
			match(TYPE_IDENTIFIER);
			setState(86);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__4) {
				{
				setState(84);
				match(T__4);
				setState(85);
				match(TYPE_IDENTIFIER);
				}
			}

			setState(88);
			match(T__0);
			setState(93);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OBJECT_IDENTIFIER) {
				{
				setState(91);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
				case 1:
					{
					setState(89);
					methodDefinition();
					}
					break;
				case 2:
					{
					setState(90);
					field();
					}
					break;
				}
				}
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(96);
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
			setState(98);
			match(OBJECT_IDENTIFIER);
			setState(99);
			match(T__5);
			setState(112);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				{
				setState(103); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(100);
						formal();
						setState(101);
						match(T__6);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(105); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				{
				setState(107);
				formal();
				}
				}
				}
				break;
			case 2:
				{
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OBJECT_IDENTIFIER) {
					{
					setState(109);
					formal();
					}
				}

				}
				break;
			}
			setState(114);
			match(T__7);
			setState(115);
			match(T__8);
			setState(116);
			varType();
			setState(117);
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
			setState(119);
			match(OBJECT_IDENTIFIER);
			setState(120);
			match(T__8);
			setState(121);
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
			setState(123);
			match(OBJECT_IDENTIFIER);
			setState(124);
			match(T__8);
			setState(125);
			varType();
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(126);
				match(T__9);
				setState(127);
				statement();
				}
			}

			setState(130);
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

	public static class CallMethodContext extends ParserRuleContext {
		public List<TerminalNode> OBJECT_IDENTIFIER() { return getTokens(PARSERParser.OBJECT_IDENTIFIER); }
		public TerminalNode OBJECT_IDENTIFIER(int i) {
			return getToken(PARSERParser.OBJECT_IDENTIFIER, i);
		}
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(132);
					match(OBJECT_IDENTIFIER);
					setState(133);
					match(T__10);
					}
					} 
				}
				setState(138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(139);
			match(OBJECT_IDENTIFIER);
			setState(140);
			match(T__5);
			setState(146);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(141);
					argument();
					setState(142);
					match(T__6);
					}
					} 
				}
				setState(148);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(149);
			argument();
			setState(150);
			match(T__7);
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
		enterRule(_localctx, 16, RULE_argument);
		try {
			setState(154);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(152);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case T__23:
			case T__24:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(153);
				varValue();
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
		enterRule(_localctx, 18, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(OBJECT_IDENTIFIER);
			setState(157);
			match(T__9);
			setState(158);
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
		enterRule(_localctx, 20, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__11);
			setState(161);
			condition();
			setState(162);
			match(T__12);
			setState(165);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__13:
			case T__16:
			case T__18:
			case T__23:
			case T__24:
			case UN_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(163);
				statement();
				}
				break;
			case T__0:
				{
				setState(164);
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
		enterRule(_localctx, 22, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			ifStat();
			setState(169);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(168);
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
		enterRule(_localctx, 24, RULE_ifStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__13);
			setState(172);
			condition();
			setState(173);
			match(T__14);
			setState(176);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__13:
			case T__16:
			case T__18:
			case T__23:
			case T__24:
			case UN_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(174);
				statement();
				}
				break;
			case T__0:
				{
				setState(175);
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
		enterRule(_localctx, 26, RULE_elseStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(T__15);
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__11:
			case T__13:
			case T__16:
			case T__18:
			case T__23:
			case T__24:
			case UN_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				{
				setState(179);
				statement();
				}
				break;
			case T__0:
				{
				setState(180);
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
		enterRule(_localctx, 28, RULE_let);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(T__16);
			setState(184);
			match(OBJECT_IDENTIFIER);
			setState(185);
			match(T__8);
			setState(186);
			varType();
			setState(189);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(187);
				match(T__9);
				setState(188);
				statement();
				}
			}

			setState(191);
			match(T__17);
			setState(192);
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

	public static class BinaryOperationContext extends ParserRuleContext {
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(PARSERParser.OBJECT_IDENTIFIER, 0); }
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public List<TerminalNode> ARITHMETIC_OPERATOR() { return getTokens(PARSERParser.ARITHMETIC_OPERATOR); }
		public TerminalNode ARITHMETIC_OPERATOR(int i) {
			return getToken(PARSERParser.ARITHMETIC_OPERATOR, i);
		}
		public List<TerminalNode> CONDITIONAL_OPERATOR() { return getTokens(PARSERParser.CONDITIONAL_OPERATOR); }
		public TerminalNode CONDITIONAL_OPERATOR(int i) {
			return getToken(PARSERParser.CONDITIONAL_OPERATOR, i);
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
		enterRule(_localctx, 30, RULE_binaryOperation);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT_IDENTIFIER:
				{
				setState(194);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case T__23:
			case T__24:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case STRING:
				{
				setState(195);
				varValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(200); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(198);
					_la = _input.LA(1);
					if ( !(_la==ARITHMETIC_OPERATOR || _la==CONDITIONAL_OPERATOR) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(199);
					statement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(202); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
		public TerminalNode UN_OPERATOR() { return getToken(PARSERParser.UN_OPERATOR, 0); }
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
		enterRule(_localctx, 32, RULE_unOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			match(UN_OPERATOR);
			setState(205);
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
		enterRule(_localctx, 34, RULE_newObj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
			match(T__18);
			setState(208);
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
		enterRule(_localctx, 36, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			comparaiser();
			setState(211);
			match(CONDITIONAL_OPERATOR);
			setState(212);
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
		enterRule(_localctx, 38, RULE_comparaiser);
		try {
			setState(217);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(214);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(215);
				integer();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(216);
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
		enterRule(_localctx, 40, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
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
		enterRule(_localctx, 42, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
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
		enterRule(_localctx, 44, RULE_varValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__23:
				{
				setState(223);
				match(T__23);
				}
				break;
			case T__24:
				{
				setState(224);
				match(T__24);
				}
				break;
			case STRING:
				{
				setState(225);
				match(STRING);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				{
				setState(226);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u00e8\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\3\2\3"+
		"\2\6\2\64\n\2\r\2\16\2\65\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3"+
		"B\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\6\4K\n\4\r\4\16\4L\3\4\3\4\5\4Q\n\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\5\5Y\n\5\3\5\3\5\3\5\7\5^\n\5\f\5\16\5a\13\5"+
		"\3\5\3\5\3\6\3\6\3\6\3\6\3\6\6\6j\n\6\r\6\16\6k\3\6\3\6\3\6\5\6q\n\6\5"+
		"\6s\n\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\5\b\u0083"+
		"\n\b\3\b\3\b\3\t\3\t\7\t\u0089\n\t\f\t\16\t\u008c\13\t\3\t\3\t\3\t\3\t"+
		"\3\t\7\t\u0093\n\t\f\t\16\t\u0096\13\t\3\t\3\t\3\t\3\n\3\n\5\n\u009d\n"+
		"\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\5\f\u00a8\n\f\3\r\3\r\5\r\u00ac"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\5\16\u00b3\n\16\3\17\3\17\3\17\5\17\u00b8"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c0\n\20\3\20\3\20\3\20\3\21"+
		"\3\21\5\21\u00c7\n\21\3\21\3\21\6\21\u00cb\n\21\r\21\16\21\u00cc\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\5\25\u00dc"+
		"\n\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u00e6\n\30\3\30\2\2"+
		"\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\5\3\2\35\36\3\2"+
		"\"$\4\2\26\31&&\2\u00f7\2\63\3\2\2\2\4A\3\2\2\2\6C\3\2\2\2\bT\3\2\2\2"+
		"\nd\3\2\2\2\fy\3\2\2\2\16}\3\2\2\2\20\u008a\3\2\2\2\22\u009c\3\2\2\2\24"+
		"\u009e\3\2\2\2\26\u00a2\3\2\2\2\30\u00a9\3\2\2\2\32\u00ad\3\2\2\2\34\u00b4"+
		"\3\2\2\2\36\u00b9\3\2\2\2 \u00c6\3\2\2\2\"\u00ce\3\2\2\2$\u00d1\3\2\2"+
		"\2&\u00d4\3\2\2\2(\u00db\3\2\2\2*\u00dd\3\2\2\2,\u00df\3\2\2\2.\u00e5"+
		"\3\2\2\2\60\64\5\b\5\2\61\64\5\n\6\2\62\64\5\4\3\2\63\60\3\2\2\2\63\61"+
		"\3\2\2\2\63\62\3\2\2\2\64\65\3\2\2\2\65\63\3\2\2\2\65\66\3\2\2\2\66\3"+
		"\3\2\2\2\67B\5\24\13\28B\5\30\r\29B\5\26\f\2:B\5\36\20\2;B\5\"\22\2<B"+
		"\5 \21\2=B\5\20\t\2>B\5$\23\2?B\7%\2\2@B\5.\30\2A\67\3\2\2\2A8\3\2\2\2"+
		"A9\3\2\2\2A:\3\2\2\2A;\3\2\2\2A<\3\2\2\2A=\3\2\2\2A>\3\2\2\2A?\3\2\2\2"+
		"A@\3\2\2\2B\5\3\2\2\2CP\7\3\2\2DQ\5\4\3\2EF\5\4\3\2FG\7\4\2\2GK\3\2\2"+
		"\2HK\5\26\f\2IK\5\30\r\2JE\3\2\2\2JH\3\2\2\2JI\3\2\2\2KL\3\2\2\2LJ\3\2"+
		"\2\2LM\3\2\2\2MN\3\2\2\2NO\5\4\3\2OQ\3\2\2\2PD\3\2\2\2PJ\3\2\2\2PQ\3\2"+
		"\2\2QR\3\2\2\2RS\7\5\2\2S\7\3\2\2\2TU\7\6\2\2UX\7&\2\2VW\7\7\2\2WY\7&"+
		"\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z_\7\3\2\2[^\5\n\6\2\\^\5\16\b\2][\3"+
		"\2\2\2]\\\3\2\2\2^a\3\2\2\2_]\3\2\2\2_`\3\2\2\2`b\3\2\2\2a_\3\2\2\2bc"+
		"\7\5\2\2c\t\3\2\2\2de\7%\2\2er\7\b\2\2fg\5\f\7\2gh\7\t\2\2hj\3\2\2\2i"+
		"f\3\2\2\2jk\3\2\2\2ki\3\2\2\2kl\3\2\2\2lm\3\2\2\2mn\5\f\7\2ns\3\2\2\2"+
		"oq\5\f\7\2po\3\2\2\2pq\3\2\2\2qs\3\2\2\2ri\3\2\2\2rp\3\2\2\2st\3\2\2\2"+
		"tu\7\n\2\2uv\7\13\2\2vw\5,\27\2wx\5\6\4\2x\13\3\2\2\2yz\7%\2\2z{\7\13"+
		"\2\2{|\5,\27\2|\r\3\2\2\2}~\7%\2\2~\177\7\13\2\2\177\u0082\5,\27\2\u0080"+
		"\u0081\7\f\2\2\u0081\u0083\5\4\3\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2"+
		"\2\2\u0083\u0084\3\2\2\2\u0084\u0085\7\4\2\2\u0085\17\3\2\2\2\u0086\u0087"+
		"\7%\2\2\u0087\u0089\7\r\2\2\u0088\u0086\3\2\2\2\u0089\u008c\3\2\2\2\u008a"+
		"\u0088\3\2\2\2\u008a\u008b\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008d\u008e\7%\2\2\u008e\u0094\7\b\2\2\u008f\u0090\5\22\n\2\u0090"+
		"\u0091\7\t\2\2\u0091\u0093\3\2\2\2\u0092\u008f\3\2\2\2\u0093\u0096\3\2"+
		"\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096"+
		"\u0094\3\2\2\2\u0097\u0098\5\22\n\2\u0098\u0099\7\n\2\2\u0099\21\3\2\2"+
		"\2\u009a\u009d\7%\2\2\u009b\u009d\5.\30\2\u009c\u009a\3\2\2\2\u009c\u009b"+
		"\3\2\2\2\u009d\23\3\2\2\2\u009e\u009f\7%\2\2\u009f\u00a0\7\f\2\2\u00a0"+
		"\u00a1\5\4\3\2\u00a1\25\3\2\2\2\u00a2\u00a3\7\16\2\2\u00a3\u00a4\5&\24"+
		"\2\u00a4\u00a7\7\17\2\2\u00a5\u00a8\5\4\3\2\u00a6\u00a8\5\6\4\2\u00a7"+
		"\u00a5\3\2\2\2\u00a7\u00a6\3\2\2\2\u00a8\27\3\2\2\2\u00a9\u00ab\5\32\16"+
		"\2\u00aa\u00ac\5\34\17\2\u00ab\u00aa\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac"+
		"\31\3\2\2\2\u00ad\u00ae\7\20\2\2\u00ae\u00af\5&\24\2\u00af\u00b2\7\21"+
		"\2\2\u00b0\u00b3\5\4\3\2\u00b1\u00b3\5\6\4\2\u00b2\u00b0\3\2\2\2\u00b2"+
		"\u00b1\3\2\2\2\u00b3\33\3\2\2\2\u00b4\u00b7\7\22\2\2\u00b5\u00b8\5\4\3"+
		"\2\u00b6\u00b8\5\6\4\2\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8\35"+
		"\3\2\2\2\u00b9\u00ba\7\23\2\2\u00ba\u00bb\7%\2\2\u00bb\u00bc\7\13\2\2"+
		"\u00bc\u00bf\5,\27\2\u00bd\u00be\7\f\2\2\u00be\u00c0\5\4\3\2\u00bf\u00bd"+
		"\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c2\7\24\2\2"+
		"\u00c2\u00c3\5\4\3\2\u00c3\37\3\2\2\2\u00c4\u00c7\7%\2\2\u00c5\u00c7\5"+
		".\30\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8"+
		"\u00c9\t\2\2\2\u00c9\u00cb\5\4\3\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc\3\2"+
		"\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd!\3\2\2\2\u00ce\u00cf"+
		"\7\34\2\2\u00cf\u00d0\5\4\3\2\u00d0#\3\2\2\2\u00d1\u00d2\7\25\2\2\u00d2"+
		"\u00d3\7&\2\2\u00d3%\3\2\2\2\u00d4\u00d5\5(\25\2\u00d5\u00d6\7\36\2\2"+
		"\u00d6\u00d7\5(\25\2\u00d7\'\3\2\2\2\u00d8\u00dc\7%\2\2\u00d9\u00dc\5"+
		"*\26\2\u00da\u00dc\7\'\2\2\u00db\u00d8\3\2\2\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00da\3\2\2\2\u00dc)\3\2\2\2\u00dd\u00de\t\3\2\2\u00de+\3\2\2\2\u00df"+
		"\u00e0\t\4\2\2\u00e0-\3\2\2\2\u00e1\u00e6\7\32\2\2\u00e2\u00e6\7\33\2"+
		"\2\u00e3\u00e6\7\'\2\2\u00e4\u00e6\5*\26\2\u00e5\u00e1\3\2\2\2\u00e5\u00e2"+
		"\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6/\3\2\2\2\33\63"+
		"\65AJLPX]_kpr\u0082\u008a\u0094\u009c\u00a7\u00ab\u00b2\u00b7\u00bf\u00c6"+
		"\u00cc\u00db\u00e5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}