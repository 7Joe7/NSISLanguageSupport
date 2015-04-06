package com.jotc.nsis;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.jotc.nsis.psi.NSISTypes;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.Reader;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 * Created by Joe on 05/03/15 at 00:59.
 * <p/>
 * Requirements: ${REQUIREMENTS}
 */
public class NSISSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey COMMENT = createTextAttributesKey("NSIS_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey STRING = createTextAttributesKey("NSIS_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey NUMBER = createTextAttributesKey("NSIS_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey("NSIS_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    public static final TextAttributesKey BLOCK_DECLARATION = createTextAttributesKey("NSIS_BLOCK", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);
    public static final TextAttributesKey COMPILER_COMMAND = createTextAttributesKey("NSIS_COMPILER_COMMAND", DefaultLanguageHighlighterColors.FUNCTION_CALL);
    public static final TextAttributesKey KEYWORD = createTextAttributesKey("NSIS_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey INSTRUCTION = createTextAttributesKey("NSIS_INSTRUCTION", DefaultLanguageHighlighterColors.FUNCTION_CALL);
    public static final TextAttributesKey CONSTANT = createTextAttributesKey("NSIS_CONSTANT", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey SPECIAL_SYMBOL = createTextAttributesKey("NSIS_SPECIAL_SYMBOL", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey BAD_CHARACTER = createTextAttributesKey("NSIS_BAD_CHARACTER", new TextAttributes(Color.RED, null, null, null, Font.BOLD));

    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new NSISLexer((Reader) null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(NSISTypes.STRING)) {
            return pack(STRING);
        } else if (tokenType.equals(NSISTypes.NUMBER)) {
            return pack(NUMBER);
        } else if (tokenType.equals(NSISTypes.IDENTIFIER)) {
            return pack(IDENTIFIER);
        } else if (tokenType.equals(NSISTypes.INSTRUCTION)) {
            return pack(INSTRUCTION);
        } else if (tokenType.equals(NSISTypes.COMPILER_COMMAND)) {
            return pack(COMPILER_COMMAND);
        } else if (tokenType.equals(NSISTypes.BLOCK_DECLARATION)) {
            return pack(BLOCK_DECLARATION);
        } else if (tokenType.equals(NSISTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(NSISTypes.CONSTANT) || tokenType.equals(NSISTypes.VALUE) || tokenType.equals(NSISTypes.VARIABLE)) {
            return pack(CONSTANT);
        } else if (tokenType.equals(NSISTypes.KEYWORD)) {
            return pack(KEYWORD);
        } else if (tokenType.equals(NSISTypes.SPECIAL_SYMBOL)) {
            return pack(SPECIAL_SYMBOL);
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return pack(BAD_CHARACTER);
        } else {
            return EMPTY;
        }
    }
}
