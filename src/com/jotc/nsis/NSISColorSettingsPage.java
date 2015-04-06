package com.jotc.nsis;

import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighter;
import com.intellij.openapi.options.colors.AttributesDescriptor;
import com.intellij.openapi.options.colors.ColorDescriptor;
import com.intellij.openapi.options.colors.ColorSettingsPage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Map;

/**
 * Created by Joe on 05/03/15 at 01:13.
 * <p/>
 * Requirements: ${REQUIREMENTS}
 */
public class NSISColorSettingsPage implements ColorSettingsPage {
    private static final AttributesDescriptor[] DESCRIPTORS = new AttributesDescriptor[]{
            new AttributesDescriptor("Compiler command", NSISSyntaxHighlighter.COMPILER_COMMAND),
            new AttributesDescriptor("Instruction", NSISSyntaxHighlighter.INSTRUCTION),
            new AttributesDescriptor("String", NSISSyntaxHighlighter.STRING),
            new AttributesDescriptor("Number", NSISSyntaxHighlighter.NUMBER),
    };

    @Nullable
    @Override
    public Icon getIcon() {
        return NSISIcons.NSI_FILE;
    }

    @NotNull
    @Override
    public SyntaxHighlighter getHighlighter() {
        return new NSISSyntaxHighlighter();
    }

    @NotNull
    @Override
    public String getDemoText() {
        return "!include 1 '2' \"3\" CONST ${test} `123` _ABC\n" +
                "; comment\n" +
                "CRCCheck On\n" +
                "nsProcess::_FindProcess /NOUNLOAD\n" +
                "File /r mpg\n";
    }

    @Nullable
    @Override
    public Map<String, TextAttributesKey> getAdditionalHighlightingTagToDescriptorMap() {
        return null;
    }

    @NotNull
    @Override
    public AttributesDescriptor[] getAttributeDescriptors() {
        return DESCRIPTORS;
    }

    @NotNull
    @Override
    public ColorDescriptor[] getColorDescriptors() {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    @NotNull
    @Override
    public String getDisplayName() {
        return "NSIS";
    }
}