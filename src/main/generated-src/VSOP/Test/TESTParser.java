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
		T__0=1, T__1=2, T__2=3, T__3=4, POW=5, MULTI=6, DIV=7, MINUS=8, PLUS=9, 
		LOWER_EQUAL=10, EQUAL=11, LOWER=12, AND=13, NOT=14, ISNULL=15, DOT=16, 
		ASSIGN=17, INTEGER_BIN=18, INTEGER_HEX=19, INTEGER_DEC=20, STRING=21, 
		WS=22;
	public static final int
		RULE_expression = 0, RULE_expr1 = 1, RULE_expr2 = 2, RULE_expr3 = 3, RULE_expr4 = 4, 
		RULE_expr5 = 5, RULE_expr6 = 6, RULE_expr7 = 7, RULE_expr8 = 8, RULE_termOperator = 9, 
		RULE_factorOperator = 10, RULE_comparatorOperator = 11, RULE_varValue = 12, 
		RULE_integer = 13;
	public static final String[] ruleNames = {
		"expression", "expr1", "expr2", "expr3", "expr4", "expr5", "expr6", "expr7", 
		"expr8", "termOperator", "factorOperator", "comparatorOperator", "varValue", 
		"integer"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "'true'", "'false'", "'^'", "'*'", "'/'", "'-'", "'+'", 
		"'<='", "'='", "'<'", "'and'", "'not'", "'isnull'", "'.'", "'<-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, "POW", "MULTI", "DIV", "MINUS", "PLUS", 
		"LOWER_EQUAL", "EQUAL", "LOWER", "AND", "NOT", "ISNULL", "DOT", "ASSIGN", 
		"INTEGER_BIN", "INTEGER_HEX", "INTEGER_DEC", "STRING", "WS"
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
	public static class ExpressionContext extends ParserRuleContext {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
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
		public TerminalNode AND() { return getToken(TESTParser.AND, 0); }
		public Expr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterExpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitExpr1(this);
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
		int _startState = 2;
		enterRecursionRule(_localctx, 2, RULE_expr1, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(31);
			expr2();
			}
			_ctx.stop = _input.LT(-1);
			setState(38);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr1Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr1);
					setState(33);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(34);
					match(AND);
					setState(35);
					expr2();
					}
					} 
				}
				setState(40);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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
		public TerminalNode NOT() { return getToken(TESTParser.NOT, 0); }
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
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterExpr2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitExpr2(this);
		}
	}

	public final Expr2Context expr2() throws RecognitionException {
		Expr2Context _localctx = new Expr2Context(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr2);
		try {
			setState(44);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(41);
				match(NOT);
				setState(42);
				expr2();
				}
				break;
			case T__0:
			case T__2:
			case T__3:
			case MINUS:
			case ISNULL:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
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
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterExpr3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitExpr3(this);
		}
	}

	public final Expr3Context expr3() throws RecognitionException {
		Expr3Context _localctx = new Expr3Context(_ctx, getState());
		enterRule(_localctx, 6, RULE_expr3);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(46);
				expr4(0);
				setState(47);
				comparatorOperator();
				setState(48);
				expr4(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50);
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
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterExpr4(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitExpr4(this);
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
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expr4, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(54);
			expr5(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(62);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr4Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr4);
					setState(56);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(57);
					termOperator();
					setState(58);
					expr5(0);
					}
					} 
				}
				setState(64);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
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
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterExpr5(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitExpr5(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr5, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(66);
			expr6();
			}
			_ctx.stop = _input.LT(-1);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr5Context(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expr5);
					setState(68);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(69);
					factorOperator();
					setState(70);
					expr6();
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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
		public TerminalNode MINUS() { return getToken(TESTParser.MINUS, 0); }
		public Expr6Context expr6() {
			return getRuleContext(Expr6Context.class,0);
		}
		public TerminalNode ISNULL() { return getToken(TESTParser.ISNULL, 0); }
		public Expr7Context expr7() {
			return getRuleContext(Expr7Context.class,0);
		}
		public Expr6Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr6; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterExpr6(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitExpr6(this);
		}
	}

	public final Expr6Context expr6() throws RecognitionException {
		Expr6Context _localctx = new Expr6Context(_ctx, getState());
		enterRule(_localctx, 12, RULE_expr6);
		try {
			setState(82);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				match(MINUS);
				setState(78);
				expr6();
				}
				break;
			case ISNULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(79);
				match(ISNULL);
				setState(80);
				expr6();
				}
				break;
			case T__0:
			case T__2:
			case T__3:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(81);
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
		public TerminalNode POW() { return getToken(TESTParser.POW, 0); }
		public Expr7Context expr7() {
			return getRuleContext(Expr7Context.class,0);
		}
		public Expr7Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr7; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterExpr7(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitExpr7(this);
		}
	}

	public final Expr7Context expr7() throws RecognitionException {
		Expr7Context _localctx = new Expr7Context(_ctx, getState());
		enterRule(_localctx, 14, RULE_expr7);
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(84);
				expr8();
				setState(85);
				match(POW);
				setState(86);
				expr7();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88);
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public Expr8Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr8; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterExpr8(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitExpr8(this);
		}
	}

	public final Expr8Context expr8() throws RecognitionException {
		Expr8Context _localctx = new Expr8Context(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr8);
		try {
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(T__0);
				setState(92);
				expression();
				setState(93);
				match(T__1);
				}
				break;
			case T__2:
			case T__3:
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
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

	public static class TermOperatorContext extends ParserRuleContext {
		public TerminalNode MINUS() { return getToken(TESTParser.MINUS, 0); }
		public TerminalNode PLUS() { return getToken(TESTParser.PLUS, 0); }
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
			setState(98);
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
		public TerminalNode MULTI() { return getToken(TESTParser.MULTI, 0); }
		public TerminalNode DIV() { return getToken(TESTParser.DIV, 0); }
		public FactorOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factorOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterFactorOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitFactorOperator(this);
		}
	}

	public final FactorOperatorContext factorOperator() throws RecognitionException {
		FactorOperatorContext _localctx = new FactorOperatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_factorOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
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
		public TerminalNode LOWER() { return getToken(TESTParser.LOWER, 0); }
		public TerminalNode LOWER_EQUAL() { return getToken(TESTParser.LOWER_EQUAL, 0); }
		public TerminalNode EQUAL() { return getToken(TESTParser.EQUAL, 0); }
		public ComparatorOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparatorOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).enterComparatorOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TESTListener ) ((TESTListener)listener).exitComparatorOperator(this);
		}
	}

	public final ComparatorOperatorContext comparatorOperator() throws RecognitionException {
		ComparatorOperatorContext _localctx = new ComparatorOperatorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_comparatorOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
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
		enterRule(_localctx, 24, RULE_varValue);
		try {
			setState(108);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				match(T__3);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				match(STRING);
				}
				break;
			case INTEGER_BIN:
			case INTEGER_HEX:
			case INTEGER_DEC:
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
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
		enterRule(_localctx, 26, RULE_integer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1:
			return expr1_sempred((Expr1Context)_localctx, predIndex);
		case 4:
			return expr4_sempred((Expr4Context)_localctx, predIndex);
		case 5:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30s\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\7\3"+
		"\'\n\3\f\3\16\3*\13\3\3\4\3\4\3\4\5\4/\n\4\3\5\3\5\3\5\3\5\3\5\5\5\66"+
		"\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\7\6?\n\6\f\6\16\6B\13\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\7\7K\n\7\f\7\16\7N\13\7\3\b\3\b\3\b\3\b\3\b\5\bU\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\\\n\t\3\n\3\n\3\n\3\n\3\n\5\nc\n\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\5\16o\n\16\3\17\3\17\3\17\2\5\4\n\f"+
		"\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\6\3\2\n\13\3\2\b\t\3\2\f\16"+
		"\3\2\24\26\2p\2\36\3\2\2\2\4 \3\2\2\2\6.\3\2\2\2\b\65\3\2\2\2\n\67\3\2"+
		"\2\2\fC\3\2\2\2\16T\3\2\2\2\20[\3\2\2\2\22b\3\2\2\2\24d\3\2\2\2\26f\3"+
		"\2\2\2\30h\3\2\2\2\32n\3\2\2\2\34p\3\2\2\2\36\37\5\4\3\2\37\3\3\2\2\2"+
		" !\b\3\1\2!\"\5\6\4\2\"(\3\2\2\2#$\f\4\2\2$%\7\17\2\2%\'\5\6\4\2&#\3\2"+
		"\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\5\3\2\2\2*(\3\2\2\2+,\7\20\2\2,/"+
		"\5\6\4\2-/\5\b\5\2.+\3\2\2\2.-\3\2\2\2/\7\3\2\2\2\60\61\5\n\6\2\61\62"+
		"\5\30\r\2\62\63\5\n\6\2\63\66\3\2\2\2\64\66\5\n\6\2\65\60\3\2\2\2\65\64"+
		"\3\2\2\2\66\t\3\2\2\2\678\b\6\1\289\5\f\7\29@\3\2\2\2:;\f\4\2\2;<\5\24"+
		"\13\2<=\5\f\7\2=?\3\2\2\2>:\3\2\2\2?B\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\13"+
		"\3\2\2\2B@\3\2\2\2CD\b\7\1\2DE\5\16\b\2EL\3\2\2\2FG\f\4\2\2GH\5\26\f\2"+
		"HI\5\16\b\2IK\3\2\2\2JF\3\2\2\2KN\3\2\2\2LJ\3\2\2\2LM\3\2\2\2M\r\3\2\2"+
		"\2NL\3\2\2\2OP\7\n\2\2PU\5\16\b\2QR\7\21\2\2RU\5\16\b\2SU\5\20\t\2TO\3"+
		"\2\2\2TQ\3\2\2\2TS\3\2\2\2U\17\3\2\2\2VW\5\22\n\2WX\7\7\2\2XY\5\20\t\2"+
		"Y\\\3\2\2\2Z\\\5\22\n\2[V\3\2\2\2[Z\3\2\2\2\\\21\3\2\2\2]^\7\3\2\2^_\5"+
		"\2\2\2_`\7\4\2\2`c\3\2\2\2ac\5\32\16\2b]\3\2\2\2ba\3\2\2\2c\23\3\2\2\2"+
		"de\t\2\2\2e\25\3\2\2\2fg\t\3\2\2g\27\3\2\2\2hi\t\4\2\2i\31\3\2\2\2jo\7"+
		"\5\2\2ko\7\6\2\2lo\7\27\2\2mo\5\34\17\2nj\3\2\2\2nk\3\2\2\2nl\3\2\2\2"+
		"nm\3\2\2\2o\33\3\2\2\2pq\t\5\2\2q\35\3\2\2\2\13(.\65@LT[bn";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}