// Generated from /Users/lopo/work/bigger/workspace/dsl/src/main/resources/PCScript.g4 by ANTLR 4.12.0
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PCScriptParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, SingleInteger=12, MultipleInteger=13, Float=14, DOT=15, 
		TEXT=16, ID=17, WS=18;
	public static final int
		RULE_root = 0, RULE_operator_token = 1, RULE_nested_express = 2, RULE_simple_express = 3, 
		RULE_param_name = 4, RULE_method = 5, RULE_number = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"root", "operator_token", "nested_express", "simple_express", "param_name", 
			"method", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'>'", "'<'", "'>='", "'<='", "'('", 
			"')'", "','", null, null, null, "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"SingleInteger", "MultipleInteger", "Float", "DOT", "TEXT", "ID", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "PCScript.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PCScriptParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RootContext extends ParserRuleContext {
		public Simple_expressContext simple_express() {
			return getRuleContext(Simple_expressContext.class,0);
		}
		public RootContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_root; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).enterRoot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).exitRoot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCScriptVisitor ) return ((PCScriptVisitor<? extends T>)visitor).visitRoot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RootContext root() throws RecognitionException {
		RootContext _localctx = new RootContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_root);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			simple_express();
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

	@SuppressWarnings("CheckReturnValue")
	public static class Operator_tokenContext extends ParserRuleContext {
		public Operator_tokenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operator_token; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).enterOperator_token(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).exitOperator_token(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCScriptVisitor ) return ((PCScriptVisitor<? extends T>)visitor).visitOperator_token(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Operator_tokenContext operator_token() throws RecognitionException {
		Operator_tokenContext _localctx = new Operator_tokenContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_operator_token);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 510L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class Nested_expressContext extends ParserRuleContext {
		public Simple_expressContext simple_express() {
			return getRuleContext(Simple_expressContext.class,0);
		}
		public Nested_expressContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nested_express; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).enterNested_express(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).exitNested_express(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCScriptVisitor ) return ((PCScriptVisitor<? extends T>)visitor).visitNested_express(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nested_expressContext nested_express() throws RecognitionException {
		Nested_expressContext _localctx = new Nested_expressContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_nested_express);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			match(T__8);
			setState(19);
			simple_express();
			setState(20);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_expressContext extends ParserRuleContext {
		public List<Param_nameContext> param_name() {
			return getRuleContexts(Param_nameContext.class);
		}
		public Param_nameContext param_name(int i) {
			return getRuleContext(Param_nameContext.class,i);
		}
		public List<NumberContext> number() {
			return getRuleContexts(NumberContext.class);
		}
		public NumberContext number(int i) {
			return getRuleContext(NumberContext.class,i);
		}
		public List<MethodContext> method() {
			return getRuleContexts(MethodContext.class);
		}
		public MethodContext method(int i) {
			return getRuleContext(MethodContext.class,i);
		}
		public List<Nested_expressContext> nested_express() {
			return getRuleContexts(Nested_expressContext.class);
		}
		public Nested_expressContext nested_express(int i) {
			return getRuleContext(Nested_expressContext.class,i);
		}
		public List<Operator_tokenContext> operator_token() {
			return getRuleContexts(Operator_tokenContext.class);
		}
		public Operator_tokenContext operator_token(int i) {
			return getRuleContext(Operator_tokenContext.class,i);
		}
		public Simple_expressContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_express; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).enterSimple_express(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).exitSimple_express(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCScriptVisitor ) return ((PCScriptVisitor<? extends T>)visitor).visitSimple_express(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_expressContext simple_express() throws RecognitionException {
		Simple_expressContext _localctx = new Simple_expressContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_simple_express);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(22);
				param_name();
				}
				break;
			case 2:
				{
				setState(23);
				number();
				}
				break;
			case 3:
				{
				setState(24);
				method();
				}
				break;
			case 4:
				{
				setState(25);
				nested_express();
				}
				break;
			}
			setState(37);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 510L) != 0)) {
				{
				{
				setState(28);
				operator_token();
				setState(33);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(29);
					param_name();
					}
					break;
				case 2:
					{
					setState(30);
					number();
					}
					break;
				case 3:
					{
					setState(31);
					method();
					}
					break;
				case 4:
					{
					setState(32);
					nested_express();
					}
					break;
				}
				}
				}
				setState(39);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	@SuppressWarnings("CheckReturnValue")
	public static class Param_nameContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(PCScriptParser.TEXT, 0); }
		public Param_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).enterParam_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).exitParam_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCScriptVisitor ) return ((PCScriptVisitor<? extends T>)visitor).visitParam_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_nameContext param_name() throws RecognitionException {
		Param_nameContext _localctx = new Param_nameContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_param_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(TEXT);
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

	@SuppressWarnings("CheckReturnValue")
	public static class MethodContext extends ParserRuleContext {
		public TerminalNode TEXT() { return getToken(PCScriptParser.TEXT, 0); }
		public List<Simple_expressContext> simple_express() {
			return getRuleContexts(Simple_expressContext.class);
		}
		public Simple_expressContext simple_express(int i) {
			return getRuleContext(Simple_expressContext.class,i);
		}
		public MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).enterMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).exitMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCScriptVisitor ) return ((PCScriptVisitor<? extends T>)visitor).visitMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodContext method() throws RecognitionException {
		MethodContext _localctx = new MethodContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_method);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(TEXT);
			setState(43);
			match(T__8);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 94726L) != 0)) {
				{
				setState(44);
				simple_express();
				}
			}

			setState(51);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__10) {
				{
				{
				setState(47);
				match(T__10);
				setState(48);
				simple_express();
				}
				}
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(54);
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

	@SuppressWarnings("CheckReturnValue")
	public static class NumberContext extends ParserRuleContext {
		public TerminalNode SingleInteger() { return getToken(PCScriptParser.SingleInteger, 0); }
		public TerminalNode MultipleInteger() { return getToken(PCScriptParser.MultipleInteger, 0); }
		public TerminalNode Float() { return getToken(PCScriptParser.Float, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PCScriptListener ) ((PCScriptListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PCScriptVisitor ) return ((PCScriptVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__0 || _la==T__1) {
				{
				setState(56);
				_la = _input.LA(1);
				if ( !(_la==T__0 || _la==T__1) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(59);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 28672L) != 0)) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001\u0012>\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u001b\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\"\b"+
		"\u0003\u0005\u0003$\b\u0003\n\u0003\f\u0003\'\t\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005.\b\u0005\u0001"+
		"\u0005\u0001\u0005\u0005\u00052\b\u0005\n\u0005\f\u00055\t\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0003\u0006:\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0000\u0000\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000"+
		"\u0003\u0001\u0000\u0001\b\u0001\u0000\u0001\u0002\u0001\u0000\f\u000e"+
		"@\u0000\u000e\u0001\u0000\u0000\u0000\u0002\u0010\u0001\u0000\u0000\u0000"+
		"\u0004\u0012\u0001\u0000\u0000\u0000\u0006\u001a\u0001\u0000\u0000\u0000"+
		"\b(\u0001\u0000\u0000\u0000\n*\u0001\u0000\u0000\u0000\f9\u0001\u0000"+
		"\u0000\u0000\u000e\u000f\u0003\u0006\u0003\u0000\u000f\u0001\u0001\u0000"+
		"\u0000\u0000\u0010\u0011\u0007\u0000\u0000\u0000\u0011\u0003\u0001\u0000"+
		"\u0000\u0000\u0012\u0013\u0005\t\u0000\u0000\u0013\u0014\u0003\u0006\u0003"+
		"\u0000\u0014\u0015\u0005\n\u0000\u0000\u0015\u0005\u0001\u0000\u0000\u0000"+
		"\u0016\u001b\u0003\b\u0004\u0000\u0017\u001b\u0003\f\u0006\u0000\u0018"+
		"\u001b\u0003\n\u0005\u0000\u0019\u001b\u0003\u0004\u0002\u0000\u001a\u0016"+
		"\u0001\u0000\u0000\u0000\u001a\u0017\u0001\u0000\u0000\u0000\u001a\u0018"+
		"\u0001\u0000\u0000\u0000\u001a\u0019\u0001\u0000\u0000\u0000\u001b%\u0001"+
		"\u0000\u0000\u0000\u001c!\u0003\u0002\u0001\u0000\u001d\"\u0003\b\u0004"+
		"\u0000\u001e\"\u0003\f\u0006\u0000\u001f\"\u0003\n\u0005\u0000 \"\u0003"+
		"\u0004\u0002\u0000!\u001d\u0001\u0000\u0000\u0000!\u001e\u0001\u0000\u0000"+
		"\u0000!\u001f\u0001\u0000\u0000\u0000! \u0001\u0000\u0000\u0000\"$\u0001"+
		"\u0000\u0000\u0000#\u001c\u0001\u0000\u0000\u0000$\'\u0001\u0000\u0000"+
		"\u0000%#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&\u0007\u0001"+
		"\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000()\u0005\u0010\u0000\u0000"+
		")\t\u0001\u0000\u0000\u0000*+\u0005\u0010\u0000\u0000+-\u0005\t\u0000"+
		"\u0000,.\u0003\u0006\u0003\u0000-,\u0001\u0000\u0000\u0000-.\u0001\u0000"+
		"\u0000\u0000.3\u0001\u0000\u0000\u0000/0\u0005\u000b\u0000\u000002\u0003"+
		"\u0006\u0003\u00001/\u0001\u0000\u0000\u000025\u0001\u0000\u0000\u0000"+
		"31\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000046\u0001\u0000\u0000"+
		"\u000053\u0001\u0000\u0000\u000067\u0005\n\u0000\u00007\u000b\u0001\u0000"+
		"\u0000\u00008:\u0007\u0001\u0000\u000098\u0001\u0000\u0000\u00009:\u0001"+
		"\u0000\u0000\u0000:;\u0001\u0000\u0000\u0000;<\u0007\u0002\u0000\u0000"+
		"<\r\u0001\u0000\u0000\u0000\u0006\u001a!%-39";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}