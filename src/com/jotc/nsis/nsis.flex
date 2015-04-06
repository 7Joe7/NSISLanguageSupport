package com.jotc.nsis;

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

//CRLF= \n|\r|\r\n
//WHITE_SPACE=[\ \t\f]
//FIRST_VALUE_CHARACTER=[^ \n\r\f\\] | "\\"{CRLF} | "\\".
//VALUE_CHARACTER=[^\n\r\f\\] | "\\"{CRLF} | "\\".
//END_OF_LINE_COMMENT=("#"|";")[^\r\n]*
//FIRST_COMPILE_COMMAND_CHARACTER="!"
//COMPILE_COMMAND_CHARACTER=[:letter:]
//STRING_LITERAL_QUOTATION_MARKS=\" [:jletterdigit:]* ~\"
//STRING_LITERAL_QUOTE_MARKS=\' [:jletterdigit:]* ~\'
//STRING_LITERAL_APOSTROPHE=\` [:jletterdigit:]* ~\`
//VARIABLE_SIGN="$"
//VARIABLE_CHARACTER=[:jletterdigit:]
//VARIABLE_USAGE={VARIABLE_SIGN}{VARIABLE_CHARACTER}+
//CONSTANT_NAME=[_[:jletterdigit:]]
//CONSTANT_VALUE= {VARIABLE_USAGE} | [:digit:]+ // yet there may be a string
//VARIABLE_DECLARATION_KEYWORD="Var"
//CONSTANT_DEFINITION_KEYWORD="define"

CRLF                    = \n|\r|\r\n
InputCharacter          = [^\r\n]
WhiteSpace              = [ \t]
END_OF_LINE_COMMENT     = ("#"|";")[^\r\n]*
CompilerCommand         = (\!include|\!addincludedir|\!addplugindir|\!appendfile|\!cd|\!delfile|\!echo|\!error|\!execute|\!packhdr|\!finalize|\!getdllversion|\!system|\!tempfile|\!warning|\!verbose|\!define|\!undef|\!insertmacro|\!makensis|\!searchparse|\!searchreplace)
Instruction = (Abort|AddBrandingImage|AddSize|AllowRootDirInstall|AllowSkipFiles|AutoCloseWindow|BGFont|BGGradient|BrandingText|BringToFront|Call|CallInstDLL|Caption|ChangeUI|CheckBitmap|ClearErrors|CompletedText|ComponentText|CopyFiles|CRCCheck|CreateDirectory|CreateFont|CreateShortCut|Delete|DeleteINISec|DeleteINIStr|DeleteRegKey|DeleteRegValue|DetailPrint|DetailsButtonText|DirText|DirVar|DirVerify|EnableWindow|EnumRegKey|EnumRegValue|Exch|Exec|ExecShell|ExecWait|ExpandEnvStrings|File|FileBufSize|FileClose|FileErrorText|FileOpen|FileRead|FileReadByte|FileReadUTF16LE|FileReadWord|FileWriteUTF16LE|FileSeek|FileWrite|FileWriteByte|FileWriteWord|FindClose|FindFirst|FindNext|FindWindow|FlushINI|GetCurInstType|GetCurrentAddress|GetDlgItem|GetDLLVersion|GetDLLVersionLocal|GetErrorLevel|GetFileTime|GetFileTimeLocal|GetFullPathName|GetFunctionAddress|GetInstDirError|GetLabelAddress|GetTempFileName|Goto|HideWindow|Icon|IfAbort|IfErrors|IfFileExists|IfRebootFlag|IfSilent|InitPluginsDir|InstallButtonText|InstallColors|InstallDir|InstallDirRegKey|InstProgressFlags|InstType|InstTypeGetText|InstTypeSetText|IntCmp|IntCmpU|IntFmt|IntOp|IsWindow|LangString|LicenseBkColor|LicenseData|LicenseForceSelection|LicenseLangString|LicenseText|LoadLanguageFile|LockWindow|LogSet|LogText|ManifestDPIAware|ManifestSupportedOS|MessageBox|MiscButtonText|Name|Nop|OutFile|Page|PageCallbacks|Pop|Push|Quit|ReadEnvStr|ReadINIStr|ReadRegDWORD|ReadRegStr|Reboot|RegDLL|Rename|RequestExecutionLevel|ReserveFile|Return|RMDir|SearchPath|SectionGetFlags|SectionGetInstTypes|SectionGetSize|SectionGetText|SectionIn|SectionSetFlags|SectionSetInstTypes|SectionSetSize|SectionSetText|SendMessage|SetAutoClose|SetBrandingImage|SetCompress|SetCompressor|SetCompressorDictSize|SetCtlColors|SetCurInstType|SetDatablockOptimize|SetDateSave|SetDetailsPrint|SetDetailsView|SetErrorLevel|SetErrors|SetFileAttributes|SetFont|SetOutPath|SetOverwrite|SetPluginUnload|SetRebootFlag|SetRegView|SetShellVarContext|SetSilent|ShowInstDetails|ShowUninstDetails|ShowWindow|SilentInstall|SilentUnInstall|Sleep|SpaceTexts|StrCmp|StrCmpS|StrCpy|StrLen|SubCaption|Unicode|UninstallButtonText|UninstallCaption|UninstallIcon|UninstallSubCaption|UninstallText|UninstPage|UnRegDLL|Var|VIAddVersionKey|VIFileVersion|VIProductVersion|WindowIcon|WriteINIStr|WriteRegBin|WriteRegDWORD|WriteRegExpandStr|WriteRegStr|WriteUninstaller|XPStyle)
BlockDeclaration = (Function|FunctionEnd|Section|SectionEnd|SectionGroup|SectionGroupEnd|SubSection|SubSectionEnd|PageEx|PageExEnd|\!macro|\!macroend)
ControlCommand = (\!ifdef|\!ifndef|\!if|\!ifmacrodef|\!ifmacrondef|\!else|\!endif)
Constant = (HKCC|HKCR|HKCU|HKDD|HKLM|HKPD|HKU|MB_ABORTRETRYIGNORE|MB_DEFBUTTON1|MB_DEFBUTTON2|MB_DEFBUTTON3|MB_DEFBUTTON4|MB_ICONEXCLAMATION|MB_ICONINFORMATION|MB_ICONQUESTION|MB_ICONSTOP|MB_OK|MB_OKCANCEL|MB_RETRYCANCEL|MB_RIGHT|MB_RTLREADING|MB_SETFOREGROUND|MB_TOPMOST|MB_USERICON|MB_YESNO|MB_YESNOCANCEL|IDABORT|IDCANCEL|IDIGNORE|IDNO|IDOK|IDRETRY|IDYES|SHCTX)
PluginCall              = {Identifier} "::" {Identifier}
Label                   = {Identifier} ":"
Number                  = [:jletterdigit:]+
SpecialSymbol           = "*"|"-"|"+"|"!="|"<>"|"=="|"<="|">="|"<"|">"|"/"|"="|"("|")"|"&"|","
StringSq                = \'([^\\\'\r\n]|\\[^\r\n])*(\')
StringDq                = \"([^\\\"\r\n]|\\[^\r\n])*(\")
StringBq                = \`([^\\\`\r\n]|\\[^\r\n])*(\`)
String                  = {StringSq}|{StringDq}|{StringBq}
Identifier              = [:jletter:][:jletterdigit:]*
UninstallerIdentifier   = [i:un\.] {Identifier}
Value                   = "${" ({Identifier}|{PluginCall}) "}"
Variable                = "$" ({Identifier}|{PluginCall}|{Number})

%state WAITING_VALUE

%%

<WAITING_VALUE> {CRLF} { yybegin(YYINITIAL); return NSISTypes.CRLF; }
{CRLF} { yybegin(YYINITIAL); return NSISTypes.CRLF; }
{WhiteSpace}+           { return TokenType.WHITE_SPACE; }
<YYINITIAL> {END_OF_LINE_COMMENT} { yybegin(YYINITIAL); return NSISTypes.COMMENT; }
{CompilerCommand}       { return NSISTypes.COMPILER_COMMAND; }
{ControlCommand}        { return NSISTypes.KEYWORD; }
{BlockDeclaration}      { return NSISTypes.BLOCK_DECLARATION; }
{Instruction}           { return NSISTypes.INSTRUCTION; }
{PluginCall}            { return NSISTypes.PLUGIN_CALL; }
{String}                { return NSISTypes.STRING; }
{Value}                 { return NSISTypes.VALUE; }
{SpecialSymbol}         { return NSISTypes.SPECIAL_SYMBOL; }
{Constant}              { return NSISTypes.CONSTANT; }
{Variable}              { return NSISTypes.VARIABLE; }
{Identifier}|{UninstallerIdentifier}|{Label}     { return NSISTypes.IDENTIFIER; }
{Number}                { return NSISTypes.NUMBER; }
.                       { return NSISTypes.IDENTIFIER; }

//<YYINITIAL> {VARIABLE_DECLARATION_KEYWORD} { yybegin(YYINITIAL); return NSISTypes.VARIABLE_DECLARATION_KEYWORD;}
//<YYINITIAL> {VARIABLE_CHARACTER}+ {yybegin(YYINITIAL); return NSISTypes.VARIABLE_NAME; }
//
//<YYINITIAL> ^{FIRST_COMPILE_COMMAND_CHARACTER}{CONSTANT_DEFINITION_KEYWORD} { yybegin(YYINITIAL); return NSISTypes.COMPILE_CONSTANT_DEFINITION;}
//<YYINITIAL> {CONSTANT_NAME}+ { yybegin(YYINITIAL); return NSISTypes.CONSTANT_NAME; }
//<YYINITIAL> {CONSTANT_VALUE} {yybegin(YYINITIAL); return NSISTypes.CONSTANT_VALUE; }
//
//// <YYINITIAL> {STRING_LITERAL_APOSTROPHE} { yybegin(YYINITIAL); return NSISTypes.STRING_LITERAL; }
//// <YYINITIAL> {STRING_LITERAL_QUOTATION_MARKS} { yybegin(YYINITIAL); return NSISTypes.STRING_LITERAL; }
//// <YYINITIAL> {STRING_LITERAL_QUOTE_MARKS} { yybegin(YYINITIAL); return NSISTypes.STRING_LITERAL; }
//
//<YYINITIAL> {END_OF_LINE_COMMENT} { yybegin(YYINITIAL); return NSISTypes.COMMENT; }
//
//<YYINITIAL> {VARIABLE_USAGE} { yybegin(YYINITIAL); return NSISTypes.VARIABLE_USAGE; }
//
//<YYINITIAL> ^{FIRST_COMPILE_COMMAND_CHARACTER}{COMPILE_COMMAND_CHARACTER}+ { yybegin(YYINITIAL); return NSISTypes.COMPILE_COMMAND;}
//
//<WAITING_VALUE> {CRLF} { yybegin(YYINITIAL); return NSISTypes.CRLF; }
//
//<WAITING_VALUE> {WHITE_SPACE}+ { yybegin(WAITING_VALUE); return TokenType.WHITE_SPACE; }
//
//{CRLF} { yybegin(YYINITIAL); return NSISTypes.CRLF; }
//
//{WHITE_SPACE}+ { yybegin(YYINITIAL); return TokenType.WHITE_SPACE; }
//
//. { return TokenType.BAD_CHARACTER; }