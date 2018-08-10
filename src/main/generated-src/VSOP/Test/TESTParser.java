// Generated from Test\TEST.g4 by ANTLR 4.7.1
package VSOP.Test;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TESTParser extends Parser {
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
	public static final int
		RULE_program = 0, RULE_binaryOperation = 1, RULE_condition = 2, RULE_term = 3, 
		RULE_factor = 4, RULE_value = 5, RULE_unOperation = 6, RULE_newObj = 7, 
		RULE_unOperator = 8, RULE_termOperator = 9, RULE_comparaiser = 10, RULE_integer = 11, 
		RULE_varType = 12, RULE_varValue = 13;
	public static final String[] ruleNames = {
		"program", "binaryOperation", "condition", "term", "factor", "value", 
		"unOperation", "newObj", "unOperator", "termOperator", "comparaiser", 
		"integer", "varType", "varValue"
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

	@Override
	public String getGrammarFileName() { return "TEST.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TESTParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<BinaryOperationContext> binaryOperation() {
			return getRuleContexts(BinaryOperationContext.class);
		}
		public BinaryOperationContext binaryOperation(int i) {
			return getRuleContext(BinaryOperationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(28);
				binaryOperation();
				}
				}
				setState(31); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__7) | (1L << T__8) | (1L << UN_OPERATOR) | (1L << NEGATIVE_OPERATOR) | (1L << VOID_OPERATOR) | (1L << INTEGER_BIN) | (1L << INTEGER_HEX) | (1L << INTEGER_DEC) | (1L << OBJECT_IDENTIFIER) | (1L << STRING))) != 0) );
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
		public List<TerminalNode> AND_OPERATOR() { return getTokens(TESTParser.AND_OPERATOR); }
		public TerminalNode AND_OPERATOR(int i) {
			return getToken(TESTParser.AND_OPERATOR, i);
		}
		public BinaryOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterBinaryOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitBinaryOperation(this);
		}
	}

	public final BinaryOperationContext binaryOperation() throws RecognitionException {
		BinaryOperationContext _localctx = new BinaryOperationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_binaryOperation);
		int _la;
		try {
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				condition();
				setState(38);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND_OPERATOR) {
					{
					{
					setState(34);
					match(AND_OPERATOR);
					setState(35);
					condition();
					}
					}
					setState(40);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(41);
				match(T__0);
				setState(42);
				condition();
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AND_OPERATOR) {
					{
					{
					setState(43);
					match(AND_OPERATOR);
					setState(44);
					condition();
					}
					}
					setState(49);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(50);
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
		public List<TerminalNode> CONDITIONAL_OPERATOR() { return getTokens(TESTParser.CONDITIONAL_OPERATOR); }
		public TerminalNode CONDITIONAL_OPERATOR(int i) {
			return getToken(TESTParser.CONDITIONAL_OPERATOR, i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_condition);
		int _la;
		try {
			int _alt;
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(54);
				term();
				setState(59);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(55);
						match(CONDITIONAL_OPERATOR);
						setState(56);
						term();
						}
						} 
					}
					setState(61);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(62);
				match(T__0);
				setState(63);
				term();
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CONDITIONAL_OPERATOR) {
					{
					{
					setState(64);
					match(CONDITIONAL_OPERATOR);
					setState(65);
					term();
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(71);
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
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_term);
		int _la;
		try {
			int _alt;
			setState(96);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75);
				factor();
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(76);
						termOperator();
						setState(77);
						factor();
						}
						} 
					}
					setState(83);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(84);
				match(T__0);
				setState(85);
				factor();
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==TERM_OPERATOR || _la==NEGATIVE_OPERATOR) {
					{
					{
					setState(86);
					termOperator();
					setState(87);
					factor();
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(94);
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
		public List<TerminalNode> FACTOR_OPERATOR() { return getTokens(TESTParser.FACTOR_OPERATOR); }
		public TerminalNode FACTOR_OPERATOR(int i) {
			return getToken(TESTParser.FACTOR_OPERATOR, i);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_factor);
		int _la;
		try {
			int _alt;
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__8:
			case UN_OPERATOR:
			case NEGATIVE_OPERATOR:
			case VOID_OPERATOR:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case OBJECT_IDENTIFIER:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(98);
				value();
				setState(103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(99);
						match(FACTOR_OPERATOR);
						setState(100);
						value();
						}
						} 
					}
					setState(105);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				}
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(106);
				match(T__0);
				setState(107);
				value();
				setState(112);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==FACTOR_OPERATOR) {
					{
					{
					setState(108);
					match(FACTOR_OPERATOR);
					setState(109);
					value();
					}
					}
					setState(114);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(115);
				match(T__1);
				}
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

	public static class ValueContext extends ParserRuleContext {
		public UnOperationContext unOperation() {
			return getRuleContext(UnOperationContext.class,0);
		}
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(TESTParser.OBJECT_IDENTIFIER, 0); }
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public TerminalNode VOID_OPERATOR() { return getToken(TESTParser.VOID_OPERATOR, 0); }
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitValue(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_value);
		try {
			setState(123);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case UN_OPERATOR:
			case NEGATIVE_OPERATOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				unOperation();
				}
				break;
			case OBJECT_IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case T__7:
			case T__8:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
				varValue();
				}
				break;
			case VOID_OPERATOR:
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
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

	public static class UnOperationContext extends ParserRuleContext {
		public UnOperatorContext unOperator() {
			return getRuleContext(UnOperatorContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public UnOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterUnOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitUnOperation(this);
		}
	}

	public final UnOperationContext unOperation() throws RecognitionException {
		UnOperationContext _localctx = new UnOperationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_unOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			unOperator();
			{
			setState(126);
			condition();
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
		public TerminalNode TYPE_IDENTIFIER() { return getToken(TESTParser.TYPE_IDENTIFIER, 0); }
		public NewObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newObj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterNewObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitNewObj(this);
		}
	}

	public final NewObjContext newObj() throws RecognitionException {
		NewObjContext _localctx = new NewObjContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_newObj);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(T__2);
			setState(129);
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
		public TerminalNode UN_OPERATOR() { return getToken(TESTParser.UN_OPERATOR, 0); }
		public TerminalNode NEGATIVE_OPERATOR() { return getToken(TESTParser.NEGATIVE_OPERATOR, 0); }
		public UnOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterUnOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitUnOperator(this);
		}
	}

	public final UnOperatorContext unOperator() throws RecognitionException {
		UnOperatorContext _localctx = new UnOperatorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
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
		public TerminalNode TERM_OPERATOR() { return getToken(TESTParser.TERM_OPERATOR, 0); }
		public TerminalNode NEGATIVE_OPERATOR() { return getToken(TESTParser.NEGATIVE_OPERATOR, 0); }
		public TermOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterTermOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitTermOperator(this);
		}
	}

	public final TermOperatorContext termOperator() throws RecognitionException {
		TermOperatorContext _localctx = new TermOperatorContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_termOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
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
		public TerminalNode OBJECT_IDENTIFIER() { return getToken(TESTParser.OBJECT_IDENTIFIER, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode STRING() { return getToken(TESTParser.STRING, 0); }
		public ComparaiserContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparaiser; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterComparaiser(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitComparaiser(this);
		}
	}

	public final ComparaiserContext comparaiser() throws RecognitionException {
		ComparaiserContext _localctx = new ComparaiserContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_comparaiser);
		try {
			setState(138);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OBJECT_IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(135);
				match(OBJECT_IDENTIFIER);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				enterOuterAlt(_localctx, 2);
				{
				setState(136);
				integer();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
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
		public TerminalNode INTEGER_HEX() { return getToken(TESTParser.INTEGER_HEX, 0); }
		public TerminalNode INTEGER_DEC() { return getToken(TESTParser.INTEGER_DEC, 0); }
		public TerminalNode INTEGER_BIN() { return getToken(TESTParser.INTEGER_BIN, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitInteger(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
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
		public TerminalNode TYPE_IDENTIFIER() { return getToken(TESTParser.TYPE_IDENTIFIER, 0); }
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterVarType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitVarType(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_varType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__6) | (1L << TYPE_IDENTIFIER))) != 0)) ) {
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
		public TerminalNode STRING() { return getToken(TESTParser.STRING, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public VarValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterVarValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitVarValue(this);
		}
	}

	public final VarValueContext varValue() throws RecognitionException {
		VarValueContext _localctx = new VarValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varValue);
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(T__7);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				match(T__8);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(146);
				match(STRING);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				enterOuterAlt(_localctx, 4);
				{
				setState(147);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\35\u0099\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\6\2 \n\2\r\2\16\2!\3\3\3"+
		"\3\3\3\7\3\'\n\3\f\3\16\3*\13\3\3\3\3\3\3\3\3\3\7\3\60\n\3\f\3\16\3\63"+
		"\13\3\3\3\3\3\5\3\67\n\3\3\4\3\4\3\4\7\4<\n\4\f\4\16\4?\13\4\3\4\3\4\3"+
		"\4\3\4\7\4E\n\4\f\4\16\4H\13\4\3\4\3\4\5\4L\n\4\3\5\3\5\3\5\3\5\7\5R\n"+
		"\5\f\5\16\5U\13\5\3\5\3\5\3\5\3\5\3\5\7\5\\\n\5\f\5\16\5_\13\5\3\5\3\5"+
		"\5\5c\n\5\3\6\3\6\3\6\7\6h\n\6\f\6\16\6k\13\6\3\6\3\6\3\6\3\6\7\6q\n\6"+
		"\f\6\16\6t\13\6\3\6\3\6\5\6x\n\6\3\7\3\7\3\7\3\7\5\7~\n\7\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\5\f\u008d\n\f\3\r\3\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\5\17\u0097\n\17\3\17\2\2\20\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\2\6\4\2\f\f\21\21\4\2\16\16\21\21\3\2\26\30\4\2\6\t"+
		"\32\32\2\u009f\2\37\3\2\2\2\4\66\3\2\2\2\6K\3\2\2\2\bb\3\2\2\2\nw\3\2"+
		"\2\2\f}\3\2\2\2\16\177\3\2\2\2\20\u0082\3\2\2\2\22\u0085\3\2\2\2\24\u0087"+
		"\3\2\2\2\26\u008c\3\2\2\2\30\u008e\3\2\2\2\32\u0090\3\2\2\2\34\u0096\3"+
		"\2\2\2\36 \5\4\3\2\37\36\3\2\2\2 !\3\2\2\2!\37\3\2\2\2!\"\3\2\2\2\"\3"+
		"\3\2\2\2#(\5\6\4\2$%\7\17\2\2%\'\5\6\4\2&$\3\2\2\2\'*\3\2\2\2(&\3\2\2"+
		"\2()\3\2\2\2)\67\3\2\2\2*(\3\2\2\2+,\7\3\2\2,\61\5\6\4\2-.\7\17\2\2.\60"+
		"\5\6\4\2/-\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\64\3\2\2"+
		"\2\63\61\3\2\2\2\64\65\7\4\2\2\65\67\3\2\2\2\66#\3\2\2\2\66+\3\2\2\2\67"+
		"\5\3\2\2\28=\5\b\5\29:\7\20\2\2:<\5\b\5\2;9\3\2\2\2<?\3\2\2\2=;\3\2\2"+
		"\2=>\3\2\2\2>L\3\2\2\2?=\3\2\2\2@A\7\3\2\2AF\5\b\5\2BC\7\20\2\2CE\5\b"+
		"\5\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\7\4"+
		"\2\2JL\3\2\2\2K8\3\2\2\2K@\3\2\2\2L\7\3\2\2\2MS\5\n\6\2NO\5\24\13\2OP"+
		"\5\n\6\2PR\3\2\2\2QN\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2Tc\3\2\2\2U"+
		"S\3\2\2\2VW\7\3\2\2W]\5\n\6\2XY\5\24\13\2YZ\5\n\6\2Z\\\3\2\2\2[X\3\2\2"+
		"\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^`\3\2\2\2_]\3\2\2\2`a\7\4\2\2ac\3\2"+
		"\2\2bM\3\2\2\2bV\3\2\2\2c\t\3\2\2\2di\5\f\7\2ef\7\r\2\2fh\5\f\7\2ge\3"+
		"\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2jx\3\2\2\2ki\3\2\2\2lm\7\3\2\2mr\5"+
		"\f\7\2no\7\r\2\2oq\5\f\7\2pn\3\2\2\2qt\3\2\2\2rp\3\2\2\2rs\3\2\2\2su\3"+
		"\2\2\2tr\3\2\2\2uv\7\4\2\2vx\3\2\2\2wd\3\2\2\2wl\3\2\2\2x\13\3\2\2\2y"+
		"~\5\16\b\2z~\7\31\2\2{~\5\34\17\2|~\7\22\2\2}y\3\2\2\2}z\3\2\2\2}{\3\2"+
		"\2\2}|\3\2\2\2~\r\3\2\2\2\177\u0080\5\22\n\2\u0080\u0081\5\6\4\2\u0081"+
		"\17\3\2\2\2\u0082\u0083\7\5\2\2\u0083\u0084\7\32\2\2\u0084\21\3\2\2\2"+
		"\u0085\u0086\t\2\2\2\u0086\23\3\2\2\2\u0087\u0088\t\3\2\2\u0088\25\3\2"+
		"\2\2\u0089\u008d\7\31\2\2\u008a\u008d\5\30\r\2\u008b\u008d\7\33\2\2\u008c"+
		"\u0089\3\2\2\2\u008c\u008a\3\2\2\2\u008c\u008b\3\2\2\2\u008d\27\3\2\2"+
		"\2\u008e\u008f\t\4\2\2\u008f\31\3\2\2\2\u0090\u0091\t\5\2\2\u0091\33\3"+
		"\2\2\2\u0092\u0097\7\n\2\2\u0093\u0097\7\13\2\2\u0094\u0097\7\33\2\2\u0095"+
		"\u0097\5\30\r\2\u0096\u0092\3\2\2\2\u0096\u0093\3\2\2\2\u0096\u0094\3"+
		"\2\2\2\u0096\u0095\3\2\2\2\u0097\35\3\2\2\2\22!(\61\66=FKS]birw}\u008c"+
		"\u0096";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}