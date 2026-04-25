// Generated from grammar/ControlFlow.g4 by ANTLR 4.13.2

    package parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ControlFlowLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IF=1, ELSE=2, FOR=3, OR=4, AND=5, NOT=6, ADD=7, SUB=8, MUL=9, DIV=10, 
		GT=11, LT=12, GTE=13, LTE=14, EQ=15, NEQ=16, ASSIGN=17, SEMI=18, LPAREN=19, 
		RPAREN=20, LBRACE=21, RBRACE=22, ID=23, INT=24, WS=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"IF", "ELSE", "FOR", "OR", "AND", "NOT", "ADD", "SUB", "MUL", "DIV", 
			"GT", "LT", "GTE", "LTE", "EQ", "NEQ", "ASSIGN", "SEMI", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "ID", "INT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'if'", "'else'", "'for'", "'||'", "'&&'", "'!'", "'+'", "'-'", 
			"'*'", "'/'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'='", "';'", 
			"'('", "')'", "'{'", "'}'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IF", "ELSE", "FOR", "OR", "AND", "NOT", "ADD", "SUB", "MUL", "DIV", 
			"GT", "LT", "GTE", "LTE", "EQ", "NEQ", "ASSIGN", "SEMI", "LPAREN", "RPAREN", 
			"LBRACE", "RBRACE", "ID", "INT", "WS"
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


	public ControlFlowLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ControlFlow.g4"; }

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
		"\u0004\u0000\u0019~\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0007\u0001\u0007\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0005\u0016n\b\u0016\n\u0016\f\u0016q\t\u0016\u0001"+
		"\u0017\u0004\u0017t\b\u0017\u000b\u0017\f\u0017u\u0001\u0018\u0004\u0018"+
		"y\b\u0018\u000b\u0018\f\u0018z\u0001\u0018\u0001\u0018\u0000\u0000\u0019"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017"+
		"/\u00181\u0019\u0001\u0000\u0004\u0003\u0000AZ__az\u0004\u000009AZ__a"+
		"z\u0001\u000009\u0003\u0000\t\n\r\r  \u0080\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000"+
		"\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000"+
		"\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001"+
		"\u0001\u0000\u0000\u0000\u00013\u0001\u0000\u0000\u0000\u00036\u0001\u0000"+
		"\u0000\u0000\u0005;\u0001\u0000\u0000\u0000\u0007?\u0001\u0000\u0000\u0000"+
		"\tB\u0001\u0000\u0000\u0000\u000bE\u0001\u0000\u0000\u0000\rG\u0001\u0000"+
		"\u0000\u0000\u000fI\u0001\u0000\u0000\u0000\u0011K\u0001\u0000\u0000\u0000"+
		"\u0013M\u0001\u0000\u0000\u0000\u0015O\u0001\u0000\u0000\u0000\u0017Q"+
		"\u0001\u0000\u0000\u0000\u0019S\u0001\u0000\u0000\u0000\u001bV\u0001\u0000"+
		"\u0000\u0000\u001dY\u0001\u0000\u0000\u0000\u001f\\\u0001\u0000\u0000"+
		"\u0000!_\u0001\u0000\u0000\u0000#a\u0001\u0000\u0000\u0000%c\u0001\u0000"+
		"\u0000\u0000\'e\u0001\u0000\u0000\u0000)g\u0001\u0000\u0000\u0000+i\u0001"+
		"\u0000\u0000\u0000-k\u0001\u0000\u0000\u0000/s\u0001\u0000\u0000\u0000"+
		"1x\u0001\u0000\u0000\u000034\u0005i\u0000\u000045\u0005f\u0000\u00005"+
		"\u0002\u0001\u0000\u0000\u000067\u0005e\u0000\u000078\u0005l\u0000\u0000"+
		"89\u0005s\u0000\u00009:\u0005e\u0000\u0000:\u0004\u0001\u0000\u0000\u0000"+
		";<\u0005f\u0000\u0000<=\u0005o\u0000\u0000=>\u0005r\u0000\u0000>\u0006"+
		"\u0001\u0000\u0000\u0000?@\u0005|\u0000\u0000@A\u0005|\u0000\u0000A\b"+
		"\u0001\u0000\u0000\u0000BC\u0005&\u0000\u0000CD\u0005&\u0000\u0000D\n"+
		"\u0001\u0000\u0000\u0000EF\u0005!\u0000\u0000F\f\u0001\u0000\u0000\u0000"+
		"GH\u0005+\u0000\u0000H\u000e\u0001\u0000\u0000\u0000IJ\u0005-\u0000\u0000"+
		"J\u0010\u0001\u0000\u0000\u0000KL\u0005*\u0000\u0000L\u0012\u0001\u0000"+
		"\u0000\u0000MN\u0005/\u0000\u0000N\u0014\u0001\u0000\u0000\u0000OP\u0005"+
		">\u0000\u0000P\u0016\u0001\u0000\u0000\u0000QR\u0005<\u0000\u0000R\u0018"+
		"\u0001\u0000\u0000\u0000ST\u0005>\u0000\u0000TU\u0005=\u0000\u0000U\u001a"+
		"\u0001\u0000\u0000\u0000VW\u0005<\u0000\u0000WX\u0005=\u0000\u0000X\u001c"+
		"\u0001\u0000\u0000\u0000YZ\u0005=\u0000\u0000Z[\u0005=\u0000\u0000[\u001e"+
		"\u0001\u0000\u0000\u0000\\]\u0005!\u0000\u0000]^\u0005=\u0000\u0000^ "+
		"\u0001\u0000\u0000\u0000_`\u0005=\u0000\u0000`\"\u0001\u0000\u0000\u0000"+
		"ab\u0005;\u0000\u0000b$\u0001\u0000\u0000\u0000cd\u0005(\u0000\u0000d"+
		"&\u0001\u0000\u0000\u0000ef\u0005)\u0000\u0000f(\u0001\u0000\u0000\u0000"+
		"gh\u0005{\u0000\u0000h*\u0001\u0000\u0000\u0000ij\u0005}\u0000\u0000j"+
		",\u0001\u0000\u0000\u0000ko\u0007\u0000\u0000\u0000ln\u0007\u0001\u0000"+
		"\u0000ml\u0001\u0000\u0000\u0000nq\u0001\u0000\u0000\u0000om\u0001\u0000"+
		"\u0000\u0000op\u0001\u0000\u0000\u0000p.\u0001\u0000\u0000\u0000qo\u0001"+
		"\u0000\u0000\u0000rt\u0007\u0002\u0000\u0000sr\u0001\u0000\u0000\u0000"+
		"tu\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000"+
		"\u0000v0\u0001\u0000\u0000\u0000wy\u0007\u0003\u0000\u0000xw\u0001\u0000"+
		"\u0000\u0000yz\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000z{\u0001"+
		"\u0000\u0000\u0000{|\u0001\u0000\u0000\u0000|}\u0006\u0018\u0000\u0000"+
		"}2\u0001\u0000\u0000\u0000\u0004\u0000ouz\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}