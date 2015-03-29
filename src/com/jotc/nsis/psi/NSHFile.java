package com.jotc.nsis.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.jotc.nsis.NSHFileType;
import com.jotc.nsis.NSISLanguage;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by Joe on 05/03/15 at 00:43.
 * <p/>
 * Requirements: ${REQUIREMENTS}
 */
public class NSHFile extends PsiFileBase {

    public NSHFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, NSISLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return NSHFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "NSH File";
    }

    @Override
    public Icon getIcon(int flags) {
        return super.getIcon(flags);
    }
}