// Generated from D:\netbeans_projects\MumpsAnalyzer\src\main\java\grammar\M.g4 by ANTLR 4.0

  package grammar;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, COMMENT=2, CHAR=3, INTEGER=4, PERCENT=5, PAREN=6, PERIOD=7, COLON=8, 
		DOLLAR=9, COMMA=10, NEWLINE=11, OPERATOR=12, SEMICOLON=13, SPACE=14, STRING_LITERAL=15, 
		DO=16, ELSE=17, FOR=18, GOTO=19, IF=20, KILL=21, NEW=22, QUIT=23, READ=24, 
		SET=25, USE=26, WRITE=27, XECUTE=28, ID=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'\"'", "COMMENT", "CHAR", "INTEGER", "'%'", "PAREN", "'.'", "':'", "'$'", 
		"','", "NEWLINE", "OPERATOR", "';'", "SPACE", "STRING_LITERAL", "DO", 
		"ELSE", "FOR", "GOTO", "IF", "KILL", "NEW", "QUIT", "READ", "SET", "USE", 
		"WRITE", "XECUTE", "ID"
	};
	public static final String[] ruleNames = {
		"T__0", "COMMENT", "CHAR", "INTEGER", "PERCENT", "PAREN", "PERIOD", "COLON", 
		"DOLLAR", "COMMA", "NEWLINE", "OPERATOR", "SEMICOLON", "SPACE", "ESCAPE_SEQUENCE", 
		"STRING_LITERAL", "DO", "ELSE", "FOR", "GOTO", "IF", "KILL", "NEW", "QUIT", 
		"READ", "SET", "USE", "WRITE", "XECUTE", "ID", "LETTER"
	};


	public MLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "M.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\2\4\37\u00e1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \3\2\3\2\3\3\3\3\7\3F\n\3\f\3\16\3I\13\3\3\4\3\4"+
		"\3\5\3\5\3\5\7\5P\n\5\f\5\16\5S\13\5\5\5U\n\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\5\ff\n\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\ru\n\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\20\3\21\3\21\3\21\7\21\u0081\n\21\f\21\16\21\u0084\13\21\3\21\3\21"+
		"\3\22\3\22\5\22\u008a\n\22\3\23\3\23\3\23\3\23\5\23\u0090\n\23\3\24\3"+
		"\24\3\24\5\24\u0095\n\24\3\25\3\25\3\25\3\25\5\25\u009b\n\25\3\26\3\26"+
		"\5\26\u009f\n\26\3\27\3\27\3\27\3\27\5\27\u00a5\n\27\3\30\3\30\3\30\5"+
		"\30\u00aa\n\30\3\31\3\31\3\31\3\31\5\31\u00b0\n\31\3\32\3\32\3\32\3\32"+
		"\5\32\u00b6\n\32\3\33\3\33\3\33\5\33\u00bb\n\33\3\34\3\34\3\34\5\34\u00c0"+
		"\n\34\3\35\3\35\3\35\3\35\3\35\5\35\u00c7\n\35\3\36\3\36\3\36\3\36\3\36"+
		"\3\36\5\36\u00cf\n\36\3\37\3\37\3\37\5\37\u00d4\n\37\3\37\3\37\3\37\3"+
		"\37\3\37\7\37\u00db\n\37\f\37\16\37\u00de\13\37\3 \3 \2!\3\3\1\5\4\1\7"+
		"\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33"+
		"\17\1\35\20\1\37\2\1!\21\1#\22\1%\23\1\'\24\1)\25\1+\26\1-\27\1/\30\1"+
		"\61\31\1\63\32\1\65\33\1\67\34\19\35\1;\36\1=\37\1?\2\1\3\2:\4\f\f\17"+
		"\17\t%%,,\61\61^^``bb}\u0080\4\f\f\17\17\6--//AA]]\6##()??__\4BBaa\4\13"+
		"\13\"\"\5\f\f\17\17$$\4FFff\4QQqq\4GGgg\4NNnn\4UUuu\4GGgg\4HHhh\4QQqq"+
		"\4TTtt\4IIii\4QQqq\4VVvv\4QQqq\4KKkk\4HHhh\4MMmm\4KKkk\4NNnn\4NNnn\4P"+
		"Ppp\4GGgg\4YYyy\4SSss\4WWww\4KKkk\4VVvv\4TTtt\4GGgg\4CCcc\4FFff\4UUuu"+
		"\4GGgg\4VVvv\4WWww\4UUuu\4GGgg\4YYyy\4TTtt\4KKkk\4VVvv\4GGgg\4ZZzz\4G"+
		"Ggg\4EEee\4WWww\4VVvv\4GGgg\4C\\c|\u0100\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3"+
		"\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2"+
		"\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35"+
		"\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3"+
		"\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2"+
		"\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\3A\3\2\2\2\5C\3\2\2\2\7J"+
		"\3\2\2\2\tT\3\2\2\2\13V\3\2\2\2\rX\3\2\2\2\17Z\3\2\2\2\21\\\3\2\2\2\23"+
		"^\3\2\2\2\25`\3\2\2\2\27e\3\2\2\2\31t\3\2\2\2\33v\3\2\2\2\35x\3\2\2\2"+
		"\37z\3\2\2\2!}\3\2\2\2#\u0087\3\2\2\2%\u008b\3\2\2\2\'\u0091\3\2\2\2)"+
		"\u0096\3\2\2\2+\u009c\3\2\2\2-\u00a0\3\2\2\2/\u00a6\3\2\2\2\61\u00ab\3"+
		"\2\2\2\63\u00b1\3\2\2\2\65\u00b7\3\2\2\2\67\u00bc\3\2\2\29\u00c1\3\2\2"+
		"\2;\u00c8\3\2\2\2=\u00d3\3\2\2\2?\u00df\3\2\2\2AB\7$\2\2B\4\3\2\2\2CG"+
		"\5\33\16\2DF\n\2\2\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2H\6\3\2\2"+
		"\2IG\3\2\2\2JK\t\3\2\2K\b\3\2\2\2LU\7\62\2\2MQ\4\63;\2NP\4\62;\2ON\3\2"+
		"\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2RU\3\2\2\2SQ\3\2\2\2TL\3\2\2\2TM\3\2"+
		"\2\2U\n\3\2\2\2VW\7\'\2\2W\f\3\2\2\2XY\4*+\2Y\16\3\2\2\2Z[\7\60\2\2[\20"+
		"\3\2\2\2\\]\7<\2\2]\22\3\2\2\2^_\7&\2\2_\24\3\2\2\2`a\7.\2\2a\26\3\2\2"+
		"\2bf\t\4\2\2cd\7\17\2\2df\7\f\2\2eb\3\2\2\2ec\3\2\2\2f\30\3\2\2\2gu\t"+
		"\5\2\2hi\7)\2\2iu\7]\2\2ju\t\6\2\2kl\7)\2\2lu\7?\2\2mu\7@\2\2no\7)\2\2"+
		"ou\7@\2\2pu\7>\2\2qr\7)\2\2ru\7>\2\2su\t\7\2\2tg\3\2\2\2th\3\2\2\2tj\3"+
		"\2\2\2tk\3\2\2\2tm\3\2\2\2tn\3\2\2\2tp\3\2\2\2tq\3\2\2\2ts\3\2\2\2u\32"+
		"\3\2\2\2vw\7=\2\2w\34\3\2\2\2xy\t\b\2\2y\36\3\2\2\2z{\7$\2\2{|\7$\2\2"+
		"| \3\2\2\2}\u0082\7$\2\2~\u0081\5\37\20\2\177\u0081\n\t\2\2\u0080~\3\2"+
		"\2\2\u0080\177\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\7$\2\2\u0086"+
		"\"\3\2\2\2\u0087\u0089\t\n\2\2\u0088\u008a\t\13\2\2\u0089\u0088\3\2\2"+
		"\2\u0089\u008a\3\2\2\2\u008a$\3\2\2\2\u008b\u008f\t\f\2\2\u008c\u008d"+
		"\t\r\2\2\u008d\u008e\t\16\2\2\u008e\u0090\t\17\2\2\u008f\u008c\3\2\2\2"+
		"\u008f\u0090\3\2\2\2\u0090&\3\2\2\2\u0091\u0094\t\20\2\2\u0092\u0093\t"+
		"\21\2\2\u0093\u0095\t\22\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"(\3\2\2\2\u0096\u009a\t\23\2\2\u0097\u0098\t\24\2\2\u0098\u0099\t\25\2"+
		"\2\u0099\u009b\t\26\2\2\u009a\u0097\3\2\2\2\u009a\u009b\3\2\2\2\u009b"+
		"*\3\2\2\2\u009c\u009e\t\27\2\2\u009d\u009f\t\30\2\2\u009e\u009d\3\2\2"+
		"\2\u009e\u009f\3\2\2\2\u009f,\3\2\2\2\u00a0\u00a4\t\31\2\2\u00a1\u00a2"+
		"\t\32\2\2\u00a2\u00a3\t\33\2\2\u00a3\u00a5\t\34\2\2\u00a4\u00a1\3\2\2"+
		"\2\u00a4\u00a5\3\2\2\2\u00a5.\3\2\2\2\u00a6\u00a9\t\35\2\2\u00a7\u00a8"+
		"\t\36\2\2\u00a8\u00aa\t\37\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2"+
		"\u00aa\60\3\2\2\2\u00ab\u00af\t \2\2\u00ac\u00ad\t!\2\2\u00ad\u00ae\t"+
		"\"\2\2\u00ae\u00b0\t#\2\2\u00af\u00ac\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"\62\3\2\2\2\u00b1\u00b5\t$\2\2\u00b2\u00b3\t%\2\2\u00b3\u00b4\t&\2\2\u00b4"+
		"\u00b6\t\'\2\2\u00b5\u00b2\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6\64\3\2\2"+
		"\2\u00b7\u00ba\t(\2\2\u00b8\u00b9\t)\2\2\u00b9\u00bb\t*\2\2\u00ba\u00b8"+
		"\3\2\2\2\u00ba\u00bb\3\2\2\2\u00bb\66\3\2\2\2\u00bc\u00bf\t+\2\2\u00bd"+
		"\u00be\t,\2\2\u00be\u00c0\t-\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2"+
		"\2\u00c08\3\2\2\2\u00c1\u00c6\t.\2\2\u00c2\u00c3\t/\2\2\u00c3\u00c4\t"+
		"\60\2\2\u00c4\u00c5\t\61\2\2\u00c5\u00c7\t\62\2\2\u00c6\u00c2\3\2\2\2"+
		"\u00c6\u00c7\3\2\2\2\u00c7:\3\2\2\2\u00c8\u00ce\t\63\2\2\u00c9\u00ca\t"+
		"\64\2\2\u00ca\u00cb\t\65\2\2\u00cb\u00cc\t\66\2\2\u00cc\u00cd\t\67\2\2"+
		"\u00cd\u00cf\t8\2\2\u00ce\u00c9\3\2\2\2\u00ce\u00cf\3\2\2\2\u00cf<\3\2"+
		"\2\2\u00d0\u00d4\5\13\6\2\u00d1\u00d4\5? \2\u00d2\u00d4\5\t\5\2\u00d3"+
		"\u00d0\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4\u00dc\3\2"+
		"\2\2\u00d5\u00db\5? \2\u00d6\u00db\5\t\5\2\u00d7\u00db\5\25\13\2\u00d8"+
		"\u00db\5\r\7\2\u00d9\u00db\5\13\6\2\u00da\u00d5\3\2\2\2\u00da\u00d6\3"+
		"\2\2\2\u00da\u00d7\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00d9\3\2\2\2\u00db"+
		"\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd>\3\2\2\2"+
		"\u00de\u00dc\3\2\2\2\u00df\u00e0\t9\2\2\u00e0@\3\2\2\2\32\2GQTet\u0080"+
		"\u0082\u0089\u008f\u0094\u009a\u009e\u00a4\u00a9\u00af\u00b5\u00ba\u00bf"+
		"\u00c6\u00ce\u00d3\u00da\u00dc";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}