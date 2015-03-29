package com.jotc.nsis.plugin.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.jotc.nsis.plugin.NSIFileType;
import com.jotc.nsis.plugin.NSISLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by Joe on 05/03/15 at 00:43.
 * <p/>
 * Requirements: ${REQUIREMENTS}
 */
public class NSIFile extends PsiFileBase {

    public NSIFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, NSISLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return NSIFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "NSI File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}