package com.jotc.nsis;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Created by Joe on 03/03/15 at 21:58.
 * <p/>
 * Requirements: ${REQUIREMENTS}
 */
public class NSIFileType extends LanguageFileType {

    public static final NSIFileType INSTANCE = new NSIFileType();

    private NSIFileType() {
        super(NSISLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "NSI file";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "NSIS language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "nsi";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return NSISIcons.NSI_FILE;
    }
}