/**
 * Copyright (C) 2013 Chris Barthauer <mumpsanalyzer@gmail.com>
 *
 * This file is part of MumpsAnalyzer.
 *
 * MumpsAnalyzer is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MumpsAnalyzer is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MumpsAnalyzer.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors:
 *     Chris Barthauer - Initial API and implementation.
 */
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
		T__0=1, CHAR=2, INTEGER=3, PERCENT=4, PAREN=5, PERIOD=6, COLON=7, DOLLAR=8, 
		COMMA=9, NEWLINE=10, OPERATOR=11, SEMICOLON=12, SPACE=13, STRING_LITERAL=14, 
		DO=15, ELSE=16, FOR=17, GOTO=18, IF=19, KILL=20, NEW=21, QUIT=22, READ=23, 
		SET=24, USE=25, WRITE=26, XECUTE=27, ID=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'\"'", "CHAR", "INTEGER", "'%'", "PAREN", "'.'", "':'", "'$'", "','", 
		"NEWLINE", "OPERATOR", "';'", "' '", "STRING_LITERAL", "DO", "ELSE", "FOR", 
		"GOTO", "IF", "KILL", "NEW", "QUIT", "READ", "SET", "USE", "WRITE", "XECUTE", 
		"ID"
	};
	public static final String[] ruleNames = {
		"T__0", "CHAR", "INTEGER", "PERCENT", "PAREN", "PERIOD", "COLON", "DOLLAR", 
		"COMMA", "NEWLINE", "OPERATOR", "SEMICOLON", "SPACE", "ESCAPE_SEQUENCE", 
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
		"\2\4\36\u00d8\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\3\2\3\2\3\3\3\3\3\4\3\4\3\4\7\4G\n\4\f\4\16\4J\13\4\5"+
		"\4L\n\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\5\13]\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\fl\n"+
		"\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\7\20x\n\20\f\20\16"+
		"\20{\13\20\3\20\3\20\3\21\3\21\5\21\u0081\n\21\3\22\3\22\3\22\3\22\5\22"+
		"\u0087\n\22\3\23\3\23\3\23\5\23\u008c\n\23\3\24\3\24\3\24\3\24\5\24\u0092"+
		"\n\24\3\25\3\25\5\25\u0096\n\25\3\26\3\26\3\26\3\26\5\26\u009c\n\26\3"+
		"\27\3\27\3\27\5\27\u00a1\n\27\3\30\3\30\3\30\3\30\5\30\u00a7\n\30\3\31"+
		"\3\31\3\31\3\31\5\31\u00ad\n\31\3\32\3\32\3\32\5\32\u00b2\n\32\3\33\3"+
		"\33\3\33\5\33\u00b7\n\33\3\34\3\34\3\34\3\34\3\34\5\34\u00be\n\34\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\5\35\u00c6\n\35\3\36\3\36\3\36\5\36\u00cb\n"+
		"\36\3\36\3\36\3\36\3\36\3\36\7\36\u00d2\n\36\f\36\16\36\u00d5\13\36\3"+
		"\37\3\37\2 \3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1"+
		"\25\f\1\27\r\1\31\16\1\33\17\1\35\2\1\37\20\1!\21\1#\22\1%\23\1\'\24\1"+
		")\25\1+\26\1-\27\1/\30\1\61\31\1\63\32\1\65\33\1\67\34\19\35\1;\36\1="+
		"\2\1\3\28\t%%,,\61\61^^``bb}\u0080\4\f\f\17\17\6--//AA]]\6##()??__\4B"+
		"Baa\5\f\f\17\17$$\4FFff\4QQqq\4GGgg\4NNnn\4UUuu\4GGgg\4HHhh\4QQqq\4TT"+
		"tt\4IIii\4QQqq\4VVvv\4QQqq\4KKkk\4HHhh\4MMmm\4KKkk\4NNnn\4NNnn\4PPpp\4"+
		"GGgg\4YYyy\4SSss\4WWww\4KKkk\4VVvv\4TTtt\4GGgg\4CCcc\4FFff\4UUuu\4GGg"+
		"g\4VVvv\4WWww\4UUuu\4GGgg\4YYyy\4TTtt\4KKkk\4VVvv\4GGgg\4ZZzz\4GGgg\4"+
		"EEee\4WWww\4VVvv\4GGgg\4C\\c|\u00f6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\3?\3\2\2\2\5A\3\2\2\2\7K\3\2\2\2\tM\3\2\2"+
		"\2\13O\3\2\2\2\rQ\3\2\2\2\17S\3\2\2\2\21U\3\2\2\2\23W\3\2\2\2\25\\\3\2"+
		"\2\2\27k\3\2\2\2\31m\3\2\2\2\33o\3\2\2\2\35q\3\2\2\2\37t\3\2\2\2!~\3\2"+
		"\2\2#\u0082\3\2\2\2%\u0088\3\2\2\2\'\u008d\3\2\2\2)\u0093\3\2\2\2+\u0097"+
		"\3\2\2\2-\u009d\3\2\2\2/\u00a2\3\2\2\2\61\u00a8\3\2\2\2\63\u00ae\3\2\2"+
		"\2\65\u00b3\3\2\2\2\67\u00b8\3\2\2\29\u00bf\3\2\2\2;\u00ca\3\2\2\2=\u00d6"+
		"\3\2\2\2?@\7$\2\2@\4\3\2\2\2AB\t\2\2\2B\6\3\2\2\2CL\7\62\2\2DH\4\63;\2"+
		"EG\4\62;\2FE\3\2\2\2GJ\3\2\2\2HF\3\2\2\2HI\3\2\2\2IL\3\2\2\2JH\3\2\2\2"+
		"KC\3\2\2\2KD\3\2\2\2L\b\3\2\2\2MN\7\'\2\2N\n\3\2\2\2OP\4*+\2P\f\3\2\2"+
		"\2QR\7\60\2\2R\16\3\2\2\2ST\7<\2\2T\20\3\2\2\2UV\7&\2\2V\22\3\2\2\2WX"+
		"\7.\2\2X\24\3\2\2\2Y]\t\3\2\2Z[\7\17\2\2[]\7\f\2\2\\Y\3\2\2\2\\Z\3\2\2"+
		"\2]\26\3\2\2\2^l\t\4\2\2_`\7)\2\2`l\7]\2\2al\t\5\2\2bc\7)\2\2cl\7?\2\2"+
		"dl\7@\2\2ef\7)\2\2fl\7@\2\2gl\7>\2\2hi\7)\2\2il\7>\2\2jl\t\6\2\2k^\3\2"+
		"\2\2k_\3\2\2\2ka\3\2\2\2kb\3\2\2\2kd\3\2\2\2ke\3\2\2\2kg\3\2\2\2kh\3\2"+
		"\2\2kj\3\2\2\2l\30\3\2\2\2mn\7=\2\2n\32\3\2\2\2op\7\"\2\2p\34\3\2\2\2"+
		"qr\7$\2\2rs\7$\2\2s\36\3\2\2\2ty\7$\2\2ux\5\35\17\2vx\n\7\2\2wu\3\2\2"+
		"\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3\2\2\2|}\7$\2"+
		"\2} \3\2\2\2~\u0080\t\b\2\2\177\u0081\t\t\2\2\u0080\177\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\"\3\2\2\2\u0082\u0086\t\n\2\2\u0083\u0084\t\13\2"+
		"\2\u0084\u0085\t\f\2\2\u0085\u0087\t\r\2\2\u0086\u0083\3\2\2\2\u0086\u0087"+
		"\3\2\2\2\u0087$\3\2\2\2\u0088\u008b\t\16\2\2\u0089\u008a\t\17\2\2\u008a"+
		"\u008c\t\20\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c&\3\2\2\2"+
		"\u008d\u0091\t\21\2\2\u008e\u008f\t\22\2\2\u008f\u0090\t\23\2\2\u0090"+
		"\u0092\t\24\2\2\u0091\u008e\3\2\2\2\u0091\u0092\3\2\2\2\u0092(\3\2\2\2"+
		"\u0093\u0095\t\25\2\2\u0094\u0096\t\26\2\2\u0095\u0094\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096*\3\2\2\2\u0097\u009b\t\27\2\2\u0098\u0099\t\30\2\2\u0099"+
		"\u009a\t\31\2\2\u009a\u009c\t\32\2\2\u009b\u0098\3\2\2\2\u009b\u009c\3"+
		"\2\2\2\u009c,\3\2\2\2\u009d\u00a0\t\33\2\2\u009e\u009f\t\34\2\2\u009f"+
		"\u00a1\t\35\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1.\3\2\2\2"+
		"\u00a2\u00a6\t\36\2\2\u00a3\u00a4\t\37\2\2\u00a4\u00a5\t \2\2\u00a5\u00a7"+
		"\t!\2\2\u00a6\u00a3\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7\60\3\2\2\2\u00a8"+
		"\u00ac\t\"\2\2\u00a9\u00aa\t#\2\2\u00aa\u00ab\t$\2\2\u00ab\u00ad\t%\2"+
		"\2\u00ac\u00a9\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\62\3\2\2\2\u00ae\u00b1"+
		"\t&\2\2\u00af\u00b0\t\'\2\2\u00b0\u00b2\t(\2\2\u00b1\u00af\3\2\2\2\u00b1"+
		"\u00b2\3\2\2\2\u00b2\64\3\2\2\2\u00b3\u00b6\t)\2\2\u00b4\u00b5\t*\2\2"+
		"\u00b5\u00b7\t+\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\66\3"+
		"\2\2\2\u00b8\u00bd\t,\2\2\u00b9\u00ba\t-\2\2\u00ba\u00bb\t.\2\2\u00bb"+
		"\u00bc\t/\2\2\u00bc\u00be\t\60\2\2\u00bd\u00b9\3\2\2\2\u00bd\u00be\3\2"+
		"\2\2\u00be8\3\2\2\2\u00bf\u00c5\t\61\2\2\u00c0\u00c1\t\62\2\2\u00c1\u00c2"+
		"\t\63\2\2\u00c2\u00c3\t\64\2\2\u00c3\u00c4\t\65\2\2\u00c4\u00c6\t\66\2"+
		"\2\u00c5\u00c0\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6:\3\2\2\2\u00c7\u00cb"+
		"\5\t\5\2\u00c8\u00cb\5=\37\2\u00c9\u00cb\5\7\4\2\u00ca\u00c7\3\2\2\2\u00ca"+
		"\u00c8\3\2\2\2\u00ca\u00c9\3\2\2\2\u00cb\u00d3\3\2\2\2\u00cc\u00d2\5="+
		"\37\2\u00cd\u00d2\5\7\4\2\u00ce\u00d2\5\23\n\2\u00cf\u00d2\5\13\6\2\u00d0"+
		"\u00d2\5\t\5\2\u00d1\u00cc\3\2\2\2\u00d1\u00cd\3\2\2\2\u00d1\u00ce\3\2"+
		"\2\2\u00d1\u00cf\3\2\2\2\u00d1\u00d0\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3"+
		"\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4<\3\2\2\2\u00d5\u00d3\3\2\2\2"+
		"\u00d6\u00d7\t\67\2\2\u00d7>\3\2\2\2\31\2HK\\kwy\u0080\u0086\u008b\u0091"+
		"\u0095\u009b\u00a0\u00a6\u00ac\u00b1\u00b6\u00bd\u00c5\u00ca\u00d1\u00d3";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}