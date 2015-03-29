package com.jotc.nsis.plugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.jotc.nsis.psi.NSISTypes;
import com.intellij.psi.TokenType;

%%

%class NSISLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

CRLF= \n|\r|\r\n
WHITE_SPACE=[\ \t\f]
FIRST_VALUE_CHARACTER=[^ \n\r\f\\] | "\\"{CRLF} | "\\".
VALUE_CHARACTER=[^\n\r\f\\] | "\\"{CRLF} | "\\".
END_OF_LINE_COMMENT=("#"|";")[^\r\n]*
FIRST_COMPILE_COMMAND_CHARACTER="^!"
COMPILE_COMMAND=[:letter:]+
STRING_LITERAL_QUOTATION_MARKS=\" [:jletterdigit:]* ~\"
STRING_LITERAL_QUOTE_MARKS=\' [:jletterdigit:]* ~\'
STRING_LITERAL_APOSTROPHE=\` [:jletterdigit:]* ~\`
VARIABLE="$"[:jletterdigit:]+
CONSTANT=[:uppercase:]+

%state WAITING_VALUE

%%

// <YYINITIAL> {VARIABLE} { yybegin(YYINITIAL); return NSISTypes.VARIABLE; }

// <YYINITIAL> {CONSTANT} { yybegin(YYINITIAL); return NSISTypes.CONSTANT; }

// <YYINITIAL> {STRING_LITERAL_APOSTROPHE} { yybegin(YYINITIAL); return NSISTypes.STRING_LITERAL; }
// <YYINITIAL> {STRING_LITERAL_QUOTATION_MARKS} { yybegin(YYINITIAL); return NSISTypes.STRING_LITERAL; }
// <YYINITIAL> {STRING_LITERAL_QUOTE_MARKS} { yybegin(YYINITIAL); return NSISTypes.STRING_LITERAL; }

<YYINITIAL> {END_OF_LINE_COMMENT}                           { yybegin(YYINITIAL); return NSISTypes.COMMENT; }

<YYINITIAL> {FIRST_COMPILE_COMMAND_CHARACTER}{COMPILE_COMMAND}+    { yybegin(YYINITIAL); return NSISTypes.COMPILE_COMMAND;}

<WAITING_VALUE> {CRLF}                                     { yybegin(YYINITIAL); return NSISTypes.CRLF; }

<WAITING_VALUE> {WHITE_SPACE}+                              { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }

{CRLF}                                                     { yybegin(YYINITIAL); return NSISTypes.CRLF; }

{WHITE_SPACE}+                                              { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }

.                                                           { return TokenType.BAD_CHARACTER; }