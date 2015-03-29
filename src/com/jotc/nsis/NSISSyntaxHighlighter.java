package com.jotc.nsis;

import com.intellij.lexer.FlexAdapter;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.SyntaxHighlighterColors;
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
    public static final TextAttributesKey COMPILE_COMMAND = createTextAttributesKey("NSIS_COMPILE_COMMAND", SyntaxHighlighterColors.KEYWORD);
    public static final TextAttributesKey COMMENT = createTextAttributesKey("NSIS_COMMENT", SyntaxHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey CONSTANT = createTextAttributesKey("NSIS_CONSTANT", SyntaxHighlighterColors.PARENTHS);
    public static final TextAttributesKey VARIABLE = createTextAttributesKey("NSIS_VARIABLE", SyntaxHighlighterColors.COMMA);
    public static final TextAttributesKey MACRO = createTextAttributesKey("NSIS_MACRO", SyntaxHighlighterColors.DOC_COMMENT_TAG);
    public static final TextAttributesKey FUNCTION = createTextAttributesKey("NSIS_FUNCTION", SyntaxHighlighterColors.DOC_COMMENT_MARKUP);
    public static final TextAttributesKey STRING_LITERAL = createTextAttributesKey("NSIS_STRING_LITERAL", SyntaxHighlighterColors.STRING);
    static final TextAttributesKey BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("NSIS_BAD_CHARACTER",
            new TextAttributes(Color.RED, null, null, null, Font.BOLD));

    private static final TextAttributesKey[] COMPILE_COMMAND_KEYS = new TextAttributesKey[]{COMPILE_COMMAND};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new FlexAdapter(new NSISLexer((Reader) null));
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(NSISTypes.COMMENT)) {
            return COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else if (tokenType.equals(NSISTypes.COMPILE_COMMAND)) {
            return COMPILE_COMMAND_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }
}
