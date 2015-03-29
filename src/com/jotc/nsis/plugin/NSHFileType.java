package com.jotc.nsis.plugin;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by Joe on 03/03/15 at 22:45.
 * <p/>
 * Requirements: ${REQUIREMENTS}
 */
public class NSHFileType extends LanguageFileType {

    public static final NSHFileType INSTANCE = new NSHFileType();

    private NSHFileType() {
        super(NSISLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "NSH file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "NSIS language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "nsh";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return NSISIcons.NSH_FILE;
    }
}
