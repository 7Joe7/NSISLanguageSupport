package com.jotc.nsis.plugin;

import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import com.jotc.nsis.plugin.psi.NSIFile;

/**
 * Created by Joe on 05/03/15 at 01:32.
 * <p/>
 * Requirements: ${REQUIREMENTS}
 */
public class NSIParserDefinition extends NSISParserDefinition {
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new NSIFile(viewProvider);
    }
}
