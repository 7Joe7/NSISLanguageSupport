package com.jotc.nsis.psi;

import com.intellij.psi.tree.IElementType;
import com.jotc.nsis.NSISLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * Created by Joe on 05/03/15 at 00:26.
 * <p/>
 * Requirements: ${REQUIREMENTS}
 */
public class NSISTokenType extends IElementType {

    public NSISTokenType(@NotNull @NonNls String debugName) {
        super(debugName, NSISLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "NSISTokenType." + super.toString();
    }
}