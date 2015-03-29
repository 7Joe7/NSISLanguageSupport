package com.jotc.nsis;

import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiFile;
import com.jotc.nsis.psi.NSHFile;

/**
 * Created by Joe on 05/03/15 at 01:32.
 * <p/>
 * Requirements: ${REQUIREMENTS}
 */
public class NSHParserDefinition extends NSISParserDefinition {
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new NSHFile(viewProvider);
    }
}
