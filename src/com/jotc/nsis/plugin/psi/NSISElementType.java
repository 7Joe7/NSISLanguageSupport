package com.jotc.nsis.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.jotc.nsis.plugin.NSISLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Joe on 05/03/15 at 00:27.
 * <p/>
 * Requirements: ${REQUIREMENTS}
 */
public class NSISElementType extends IElementType {
    public NSISElementType(@NotNull @NonNls String debugName) {
        super(debugName, NSISLanguage.INSTANCE);
    }
}
