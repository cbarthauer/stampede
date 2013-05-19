//
// Copyright (C) 2013 Chris Barthauer <mumpsstampede@gmail.com>
//
// This file is part of STAMPEDE.
//
// STAMPEDE is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// STAMPEDE is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with STAMPEDE.  If not, see <http://www.gnu.org/licenses/>.
//
// Contributors:
//     Chris Barthauer - Initial API and implementation.
//

grammar M;

options {
  language = Java;
}

@header {
  package grammar;
}

COMMENT
//  : SEMICOLON ~[\r\n]* '\r'? '\n'
  : SEMICOLON ~[\r\n]*
  ;

//Characters which are part of the character set 
//but are not specified elsewhere in the grammar.
CHAR
  : '/' | '*' | '^' | '|' | '~' | '#' | '\\' | '`' | '{' | '}'
  ;
  
INTEGER
  : '0'
  | '1'..'9' ('0'..'9')*
  ;

PERCENT
  : '%'
  ;

PAREN
  : '('
  | ')'
  ;

PERIOD
  : '.'
  ;

COLON
  : ':'
  ;

DOLLAR
  : '$'
  ;

COMMA
  : ','
  ;

NEWLINE
  : '\n'
  | '\r'
  | '\r\n'
  ;
    
OPERATOR
  : '?'  | '+' | '-'   | '['  | '\'[' |
    ']'   | '&' | '!'   | '\'' | '='   |
    '\'=' | '>' | '\'>' | '<'  | '\'<' |
    '_'   | '@'
  ;

SEMICOLON
  : ';'
  ;
  
SPACE
  : ' '
  | '\t' //Tab included as whitespace because ZZRCSUM.m (Uncategorized) 
         //contains tabs.
  ;

fragment
ESCAPE_SEQUENCE
  : '\"\"'
  ;
     
STRING_LITERAL
  : '\"'
    (ESCAPE_SEQUENCE | ~('\"' | '\r' | '\n'))*
    '\"'
  ;

//Command name tokens.
DO : [Dd] [Oo]? ;
ELSE : [Ee] ([Ll] [Ss] [Ee])? ;
FOR : [Ff] ([Oo] [Rr])? ;
GOTO : [Gg] ([Oo] [Tt] [Oo])? ;
IF : [Ii] ([Ff])? ;
KILL : [Kk] ([Ii] [Ll] [Ll])? ;
NEW : [Nn] ([Ee] [Ww])? ;
QUIT : [Qq] ([Uu] [Ii] [Tt])? ;
READ : [Rr] ([Ee] [Aa] [Dd])? ;
SET : [Ss] ([Ee] [Tt])? ;
USE : [Uu] ([Ss] [Ee])? ;
WRITE : [Ww] ([Rr] [Ii] [Tt] [Ee])? ;
XECUTE : [Xx] ([Ee] [Cc] [Uu] [Tt] [Ee])? ;

ID
  : (PERCENT | LETTER | INTEGER) (LETTER | INTEGER | COMMA | PAREN | PERCENT)*
  ;

fragment
LETTER : [a-zA-Z] ;

argument
  : ~(SPACE | NEWLINE | '\"')+
  ;

blockLevel
  : PERIOD (SPACE* PERIOD)*
  ;

cmdDo
  : DO postCondition? (SPACE argument)?
  ;

cmdElse
  : ELSE postCondition? (SPACE argument)?
  ;

cmdFor
  : FOR postCondition? (SPACE argument)?
  ;

cmdGoto
  : GOTO postCondition? (SPACE argument)?
  ;

cmdIf
  : IF postCondition? (SPACE argument)?
  ;

cmdKill
  : KILL postCondition? (SPACE argument)?
  ;

cmdNew
  : NEW postCondition? (SPACE argument)?
  ;

cmdQuit
  : QUIT postCondition? (SPACE argument)?
  ;

cmdRead
  : READ postCondition? (SPACE argument)?
  ;

cmdSet
  : SET postCondition? (SPACE argument)?
  ;

cmdUse
  : USE postCondition? (SPACE argument)?
  ;

cmdWrite
  : WRITE postCondition? (SPACE argument)?
  ;

cmdXecute
  : XECUTE postCondition? (SPACE argument)?
  ;

cmdUnknown
  : ID postCondition? (SPACE argument)?
  ;

command
  : cmdDo 
  | cmdElse 
  | cmdFor
  | cmdGoto
  | cmdIf
  | cmdKill
  | cmdNew
  | cmdQuit
  | cmdRead
  | cmdSet
  | cmdUse
  | cmdWrite
  | cmdXecute
  | cmdUnknown
  ; 

comment
  : COMMENT
  ;

entryLabel
  : identifier
  ;

identifier
  : DO 
  | ELSE 
  | FOR
  | GOTO
  | IF
  | KILL
  | NEW
  | QUIT
  | READ
  | SET
  | USE
  | WRITE
  | XECUTE
  | ID
  | INTEGER //Lexer matches INTEGER tokens before ID tokens, 
            //so this alternative matches numeric identifiers.
  | PERCENT //Lexer matches PERCENT tokens before ID tokens, 
            //so this alternative matches PERCENT used as an identifier.
  ;
    
levelLine
  : entryLabel (SPACE+ blockLevel)? (SPACE* command)* (SPACE* comment)? SPACE* NEWLINE
  | (SPACE+ command)* (SPACE+ comment)? SPACE* NEWLINE
  | SPACE+ blockLevel (SPACE* command)* (SPACE* comment)? SPACE* NEWLINE
  ;
  
postCondition
  : COLON ~(SPACE | NEWLINE | '\"')+
  ;
  
routine
  : levelLine+ EOF
  ;
