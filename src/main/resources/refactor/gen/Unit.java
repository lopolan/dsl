// Generated from /Users/lopo/bigger/workspace/dsl/src/main/resources/refactor/Unit.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class Unit extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Unit=1, UnitSymbol=2, SimpleUnit=3, ComplexUnit=4, OtherUnit=5, LengthUnit=6, 
		AreaUnit=7, VolumesUnit=8, SizeUnit=9, WeightUnit=10, PowerUnit=11, TimeUnit=12;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Unit", "UnitSymbol", "SimpleUnit", "ComplexUnit", "OtherUnit", "LengthUnit", 
			"AreaUnit", "VolumesUnit", "SizeUnit", "WeightUnit", "PowerUnit", "TimeUnit"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Unit", "UnitSymbol", "SimpleUnit", "ComplexUnit", "OtherUnit", 
			"LengthUnit", "AreaUnit", "VolumesUnit", "SizeUnit", "WeightUnit", "PowerUnit", 
			"TimeUnit"
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


	public Unit(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Unit.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\16\u0162\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\5\2\36\n\2\3\3\3\3\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\5\4*\n\4\3\5\3\5\3\5\3\5\7\5\60\n\5\f\5\16\5\63\13\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\5\6I\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7r\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00db\n\b\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0122\n\t\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\5\n\u013b\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u0148\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\5\f\u0155\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0161\n\r\2"+
		"\2\16\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\3\2\r\5"+
		"\2,,\61\61^^\4\2\u53f2\u53f2\u5ea9\u5ea9\30\2\u4e1d\u4e1d\u4e2c\u4e2c"+
		"\u4eda\u4eda\u4ef8\u4ef8\u4eff\u4eff\u5271\u5271\u533b\u533b\u53ec\u53ec"+
		"\u5759\u5759\u5959\u5959\u5bfb\u5bfb\u628c\u628c\u6514\u6514\u6531\u6531"+
		"\u682c\u682c\u683b\u683b\u6982\u6982\u6a1a\u6a1a\u76c8\u76c8\u7ec6\u7ec6"+
		"\u8284\u8284\u90ea\u90ea\7\2\u5145\u5145\u5906\u5906\u5b99\u5b99\u7f3a"+
		"\u7f3a\u8f88\u8f88\5\2OOoo\u7c75\u7c75\4\2\u4eab\u4eab\u9879\u9879\5\2"+
		"NNnn\u5349\u5349\5\2VVvv\u542a\u542a\5\2YYyy\u74e8\u74e8\b\2\u5208\u5208"+
		"\u5e76\u5e76\u65e7\u65e7\u65f8\u65f8\u670a\u670a\u79d4\u79d4\4\2\u546a"+
		"\u546a\u592b\u592b\2\u01dd\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\35\3\2\2\2\5\37\3\2\2\2\7)\3\2"+
		"\2\2\t+\3\2\2\2\13H\3\2\2\2\rq\3\2\2\2\17\u00da\3\2\2\2\21\u0121\3\2\2"+
		"\2\23\u013a\3\2\2\2\25\u0147\3\2\2\2\27\u0154\3\2\2\2\31\u0160\3\2\2\2"+
		"\33\36\5\7\4\2\34\36\5\t\5\2\35\33\3\2\2\2\35\34\3\2\2\2\36\4\3\2\2\2"+
		"\37 \t\2\2\2 \6\3\2\2\2!*\5\13\6\2\"*\5\r\7\2#*\5\17\b\2$*\5\21\t\2%*"+
		"\5\23\n\2&*\5\25\13\2\'*\5\27\f\2(*\5\31\r\2)!\3\2\2\2)\"\3\2\2\2)#\3"+
		"\2\2\2)$\3\2\2\2)%\3\2\2\2)&\3\2\2\2)\'\3\2\2\2)(\3\2\2\2*\b\3\2\2\2+"+
		"\61\5\7\4\2,-\5\5\3\2-.\5\7\4\2.\60\3\2\2\2/,\3\2\2\2\60\63\3\2\2\2\61"+
		"/\3\2\2\2\61\62\3\2\2\2\62\n\3\2\2\2\63\61\3\2\2\2\64I\t\3\2\2\65\66\7"+
		"\u6bd1\2\2\66I\7\u5ea9\2\2\67I\t\4\2\289\7\u7cfd\2\29I\7\u7ee1\2\2:I\t"+
		"\5\2\2;<\7\u5345\2\2<I\7\u4e2c\2\2=>\7\u7680\2\2>I\7\u4e2c\2\2?@\7\u5de7"+
		"\2\2@I\7\u65e7\2\2AB\7\u53f2\2\2BI\7\u73ef\2\2CD\7\u5345\2\2DI\7\u5363"+
		"\2\2EI\7\u5363\2\2FG\7\u5345\2\2GI\7\u533b\2\2H\64\3\2\2\2H\65\3\2\2\2"+
		"H\67\3\2\2\2H8\3\2\2\2H:\3\2\2\2H;\3\2\2\2H=\3\2\2\2H?\3\2\2\2HA\3\2\2"+
		"\2HC\3\2\2\2HE\3\2\2\2HF\3\2\2\2I\f\3\2\2\2JK\7o\2\2Kr\7o\2\2LM\7O\2\2"+
		"Mr\7O\2\2NO\7O\2\2Or\7o\2\2PQ\7\u6bed\2\2Qr\7\u7c75\2\2RS\7e\2\2Sr\7o"+
		"\2\2TU\7E\2\2Ur\7o\2\2VW\7e\2\2Wr\7O\2\2XY\7E\2\2Yr\7O\2\2Z[\7\u539a\2"+
		"\2[r\7\u7c75\2\2\\]\7f\2\2]r\7o\2\2^_\7F\2\2_r\7o\2\2`a\7f\2\2ar\7O\2"+
		"\2bc\7F\2\2cr\7O\2\2de\7\u5208\2\2er\7\u7c75\2\2fr\t\6\2\2gh\7m\2\2hr"+
		"\7o\2\2ij\7M\2\2jr\7o\2\2kl\7m\2\2lr\7O\2\2mn\7M\2\2nr\7O\2\2op\7\u5345"+
		"\2\2pr\7\u7c75\2\2qJ\3\2\2\2qL\3\2\2\2qN\3\2\2\2qP\3\2\2\2qR\3\2\2\2q"+
		"T\3\2\2\2qV\3\2\2\2qX\3\2\2\2qZ\3\2\2\2q\\\3\2\2\2q^\3\2\2\2q`\3\2\2\2"+
		"qb\3\2\2\2qd\3\2\2\2qf\3\2\2\2qg\3\2\2\2qi\3\2\2\2qk\3\2\2\2qm\3\2\2\2"+
		"qo\3\2\2\2r\16\3\2\2\2st\7o\2\2t\u00db\7\64\2\2uv\7O\2\2v\u00db\7\64\2"+
		"\2wx\7o\2\2x\u00db\7\u00b4\2\2yz\7O\2\2z\u00db\7\u00b4\2\2{|\7\u5e75\2"+
		"\2|}\7\u65bb\2\2}\u00db\7\u7c75\2\2~\177\7\u5e75\2\2\177\u00db\7\u7c75"+
		"\2\2\u0080\u0081\7\u5e75\2\2\u0081\u00db\7\u65bb\2\2\u0082\u00db\7\u65bb"+
		"\2\2\u0083\u0084\7f\2\2\u0084\u0085\7o\2\2\u0085\u00db\7\64\2\2\u0086"+
		"\u0087\7F\2\2\u0087\u0088\7o\2\2\u0088\u00db\7\64\2\2\u0089\u008a\7f\2"+
		"\2\u008a\u008b\7o\2\2\u008b\u00db\7\u00b4\2\2\u008c\u008d\7F\2\2\u008d"+
		"\u008e\7o\2\2\u008e\u00db\7\u00b4\2\2\u008f\u0090\7f\2\2\u0090\u0091\7"+
		"O\2\2\u0091\u00db\7\64\2\2\u0092\u0093\7F\2\2\u0093\u0094\7O\2\2\u0094"+
		"\u00db\7\64\2\2\u0095\u0096\7f\2\2\u0096\u0097\7O\2\2\u0097\u00db\7\u00b4"+
		"\2\2\u0098\u0099\7F\2\2\u0099\u009a\7O\2\2\u009a\u00db\7\u00b4\2\2\u009b"+
		"\u009c\7\u5e75\2\2\u009c\u009d\7\u65bb\2\2\u009d\u009e\7\u5208\2\2\u009e"+
		"\u00db\7\u7c75\2\2\u009f\u00a0\7e\2\2\u00a0\u00a1\7o\2\2\u00a1\u00db\7"+
		"\64\2\2\u00a2\u00a3\7E\2\2\u00a3\u00a4\7o\2\2\u00a4\u00db\7\64\2\2\u00a5"+
		"\u00a6\7e\2\2\u00a6\u00a7\7o\2\2\u00a7\u00db\7\u00b4\2\2\u00a8\u00a9\7"+
		"E\2\2\u00a9\u00aa\7o\2\2\u00aa\u00db\7\u00b4\2\2\u00ab\u00ac\7e\2\2\u00ac"+
		"\u00ad\7O\2\2\u00ad\u00db\7\64\2\2\u00ae\u00af\7E\2\2\u00af\u00b0\7O\2"+
		"\2\u00b0\u00db\7\64\2\2\u00b1\u00b2\7e\2\2\u00b2\u00b3\7O\2\2\u00b3\u00db"+
		"\7\u00b4\2\2\u00b4\u00b5\7E\2\2\u00b5\u00b6\7O\2\2\u00b6\u00db\7\u00b4"+
		"\2\2\u00b7\u00b8\7\u5e75\2\2\u00b8\u00b9\7\u65bb\2\2\u00b9\u00ba\7\u539a"+
		"\2\2\u00ba\u00db\7\u7c75\2\2\u00bb\u00bc\7o\2\2\u00bc\u00bd\7o\2\2\u00bd"+
		"\u00db\7\64\2\2\u00be\u00bf\7O\2\2\u00bf\u00c0\7o\2\2\u00c0\u00db\7\64"+
		"\2\2\u00c1\u00c2\7o\2\2\u00c2\u00c3\7o\2\2\u00c3\u00db\7\u00b4\2\2\u00c4"+
		"\u00c5\7O\2\2\u00c5\u00c6\7o\2\2\u00c6\u00db\7\u00b4\2\2\u00c7\u00c8\7"+
		"o\2\2\u00c8\u00c9\7O\2\2\u00c9\u00db\7\64\2\2\u00ca\u00cb\7O\2\2\u00cb"+
		"\u00cc\7O\2\2\u00cc\u00db\7\64\2\2\u00cd\u00ce\7o\2\2\u00ce\u00cf\7O\2"+
		"\2\u00cf\u00db\7\u00b4\2\2\u00d0\u00d1\7O\2\2\u00d1\u00d2\7O\2\2\u00d2"+
		"\u00db\7\u00b4\2\2\u00d3\u00d4\7\u5e75\2\2\u00d4\u00d5\7\u65bb\2\2\u00d5"+
		"\u00d6\7\u6bed\2\2\u00d6\u00db\7\u7c75\2\2\u00d7\u00d8\7\u516e\2\2\u00d8"+
		"\u00db\7\u9879\2\2\u00d9\u00db\t\7\2\2\u00das\3\2\2\2\u00dau\3\2\2\2\u00da"+
		"w\3\2\2\2\u00day\3\2\2\2\u00da{\3\2\2\2\u00da~\3\2\2\2\u00da\u0080\3\2"+
		"\2\2\u00da\u0082\3\2\2\2\u00da\u0083\3\2\2\2\u00da\u0086\3\2\2\2\u00da"+
		"\u0089\3\2\2\2\u00da\u008c\3\2\2\2\u00da\u008f\3\2\2\2\u00da\u0092\3\2"+
		"\2\2\u00da\u0095\3\2\2\2\u00da\u0098\3\2\2\2\u00da\u009b\3\2\2\2\u00da"+
		"\u009f\3\2\2\2\u00da\u00a2\3\2\2\2\u00da\u00a5\3\2\2\2\u00da\u00a8\3\2"+
		"\2\2\u00da\u00ab\3\2\2\2\u00da\u00ae\3\2\2\2\u00da\u00b1\3\2\2\2\u00da"+
		"\u00b4\3\2\2\2\u00da\u00b7\3\2\2\2\u00da\u00bb\3\2\2\2\u00da\u00be\3\2"+
		"\2\2\u00da\u00c1\3\2\2\2\u00da\u00c4\3\2\2\2\u00da\u00c7\3\2\2\2\u00da"+
		"\u00ca\3\2\2\2\u00da\u00cd\3\2\2\2\u00da\u00d0\3\2\2\2\u00da\u00d3\3\2"+
		"\2\2\u00da\u00d7\3\2\2\2\u00da\u00d9\3\2\2\2\u00db\20\3\2\2\2\u00dc\u00dd"+
		"\7e\2\2\u00dd\u00de\7o\2\2\u00de\u0122\7\65\2\2\u00df\u00e0\7E\2\2\u00e0"+
		"\u00e1\7o\2\2\u00e1\u0122\7\65\2\2\u00e2\u00e3\7e\2\2\u00e3\u00e4\7o\2"+
		"\2\u00e4\u0122\7\u00b5\2\2\u00e5\u00e6\7E\2\2\u00e6\u00e7\7o\2\2\u00e7"+
		"\u0122\7\u00b5\2\2\u00e8\u00e9\7e\2\2\u00e9\u00ea\7O\2\2\u00ea\u0122\7"+
		"\65\2\2\u00eb\u00ec\7E\2\2\u00ec\u00ed\7O\2\2\u00ed\u0122\7\65\2\2\u00ee"+
		"\u00ef\7e\2\2\u00ef\u00f0\7O\2\2\u00f0\u0122\7\u00b5\2\2\u00f1\u00f2\7"+
		"E\2\2\u00f2\u00f3\7O\2\2\u00f3\u0122\7\u00b5\2\2\u00f4\u00f5\7\u7acd\2"+
		"\2\u00f5\u00f6\7\u65bb\2\2\u00f6\u00f7\7\u539a\2\2\u00f7\u0122\7\u7c75"+
		"\2\2\u00f8\u00f9\7f\2\2\u00f9\u00fa\7o\2\2\u00fa\u0122\7\65\2\2\u00fb"+
		"\u00fc\7F\2\2\u00fc\u00fd\7o\2\2\u00fd\u0122\7\65\2\2\u00fe\u00ff\7f\2"+
		"\2\u00ff\u0100\7o\2\2\u0100\u0122\7\u00b5\2\2\u0101\u0102\7F\2\2\u0102"+
		"\u0103\7o\2\2\u0103\u0122\7\u00b5\2\2\u0104\u0105\7f\2\2\u0105\u0106\7"+
		"O\2\2\u0106\u0122\7\65\2\2\u0107\u0108\7F\2\2\u0108\u0109\7O\2\2\u0109"+
		"\u0122\7\65\2\2\u010a\u010b\7f\2\2\u010b\u010c\7O\2\2\u010c\u0122\7\u00b5"+
		"\2\2\u010d\u010e\7F\2\2\u010e\u010f\7O\2\2\u010f\u0122\7\u00b5\2\2\u0110"+
		"\u0111\7\u7acd\2\2\u0111\u0112\7\u65bb\2\2\u0112\u0113\7\u5208\2\2\u0113"+
		"\u0122\7\u7c75\2\2\u0114\u0115\7o\2\2\u0115\u0122\7\65\2\2\u0116\u0117"+
		"\7O\2\2\u0117\u0122\7\65\2\2\u0118\u0119\7o\2\2\u0119\u0122\7\u00b5\2"+
		"\2\u011a\u011b\7O\2\2\u011b\u0122\7\u00b5\2\2\u011c\u011d\7\u7acd\2\2"+
		"\u011d\u011e\7\u65bb\2\2\u011e\u0122\7\u7c75\2\2\u011f\u0120\7\u7acd\2"+
		"\2\u0120\u0122\7\u65bb\2\2\u0121\u00dc\3\2\2\2\u0121\u00df\3\2\2\2\u0121"+
		"\u00e2\3\2\2\2\u0121\u00e5\3\2\2\2\u0121\u00e8\3\2\2\2\u0121\u00eb\3\2"+
		"\2\2\u0121\u00ee\3\2\2\2\u0121\u00f1\3\2\2\2\u0121\u00f4\3\2\2\2\u0121"+
		"\u00f8\3\2\2\2\u0121\u00fb\3\2\2\2\u0121\u00fe\3\2\2\2\u0121\u0101\3\2"+
		"\2\2\u0121\u0104\3\2\2\2\u0121\u0107\3\2\2\2\u0121\u010a\3\2\2\2\u0121"+
		"\u010d\3\2\2\2\u0121\u0110\3\2\2\2\u0121\u0114\3\2\2\2\u0121\u0116\3\2"+
		"\2\2\u0121\u0118\3\2\2\2\u0121\u011a\3\2\2\2\u0121\u011c\3\2\2\2\u0121"+
		"\u011f\3\2\2\2\u0122\22\3\2\2\2\u0123\u013b\t\b\2\2\u0124\u0125\7\u5208"+
		"\2\2\u0125\u013b\7\u5349\2\2\u0126\u0127\7O\2\2\u0127\u013b\7N\2\2\u0128"+
		"\u0129\7o\2\2\u0129\u013b\7N\2\2\u012a\u012b\7O\2\2\u012b\u013b\7n\2\2"+
		"\u012c\u012d\7o\2\2\u012d\u013b\7n\2\2\u012e\u012f\7\u539a\2\2\u012f\u013b"+
		"\7\u5349\2\2\u0130\u0131\7E\2\2\u0131\u013b\7N\2\2\u0132\u0133\7e\2\2"+
		"\u0133\u013b\7N\2\2\u0134\u0135\7E\2\2\u0135\u013b\7n\2\2\u0136\u0137"+
		"\7e\2\2\u0137\u013b\7n\2\2\u0138\u0139\7\u6bed\2\2\u0139\u013b\7\u5349"+
		"\2\2\u013a\u0123\3\2\2\2\u013a\u0124\3\2\2\2\u013a\u0126\3\2\2\2\u013a"+
		"\u0128\3\2\2\2\u013a\u012a\3\2\2\2\u013a\u012c\3\2\2\2\u013a\u012e\3\2"+
		"\2\2\u013a\u0130\3\2\2\2\u013a\u0132\3\2\2\2\u013a\u0134\3\2\2\2\u013a"+
		"\u0136\3\2\2\2\u013a\u0138\3\2\2\2\u013b\24\3\2\2\2\u013c\u013d\7M\2\2"+
		"\u013d\u0148\7I\2\2\u013e\u013f\7m\2\2\u013f\u0148\7i\2\2\u0140\u0141"+
		"\7M\2\2\u0141\u0148\7i\2\2\u0142\u0143\7m\2\2\u0143\u0148\7I\2\2\u0144"+
		"\u0145\7\u5345\2\2\u0145\u0148\7\u514d\2\2\u0146\u0148\t\t\2\2\u0147\u013c"+
		"\3\2\2\2\u0147\u013e\3\2\2\2\u0147\u0140\3\2\2\2\u0147\u0142\3\2\2\2\u0147"+
		"\u0144\3\2\2\2\u0147\u0146\3\2\2\2\u0148\26\3\2\2\2\u0149\u014a\7\u5345"+
		"\2\2\u014a\u0155\7\u74e8\2\2\u014b\u014c\7M\2\2\u014c\u0155\7Y\2\2\u014d"+
		"\u014e\7m\2\2\u014e\u0155\7y\2\2\u014f\u0150\7m\2\2\u0150\u0155\7Y\2\2"+
		"\u0151\u0152\7M\2\2\u0152\u0155\7y\2\2\u0153\u0155\t\n\2\2\u0154\u0149"+
		"\3\2\2\2\u0154\u014b\3\2\2\2\u0154\u014d\3\2\2\2\u0154\u014f\3\2\2\2\u0154"+
		"\u0151\3\2\2\2\u0154\u0153\3\2\2\2\u0155\30\3\2\2\2\u0156\u0161\t\13\2"+
		"\2\u0157\u0158\7\u5c11\2\2\u0158\u0161\7\u65f8\2\2\u0159\u015a\7\u5208"+
		"\2\2\u015a\u0161\7\u94a1\2\2\u015b\u015c\7\u6bed\2\2\u015c\u0161\7\u79d4"+
		"\2\2\u015d\u015e\7\u5fb0\2\2\u015e\u0161\7\u79d4\2\2\u015f\u0161\t\f\2"+
		"\2\u0160\u0156\3\2\2\2\u0160\u0157\3\2\2\2\u0160\u0159\3\2\2\2\u0160\u015b"+
		"\3\2\2\2\u0160\u015d\3\2\2\2\u0160\u015f\3\2\2\2\u0161\32\3\2\2\2\16\2"+
		"\35)\61Hq\u00da\u0121\u013a\u0147\u0154\u0160\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}