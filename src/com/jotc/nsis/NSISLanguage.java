package com.jotc.nsis;

import com.intellij.lang.Language;

/**
 * Created by Joe on 03/03/15 at 21:51.
 * <p/>
 * Requirements: ${REQUIREMENTS}
 */
public class NSISLanguage extends Language {
    public static final NSISLanguage INSTANCE = new NSISLanguage();

    private NSISLanguage() {
        super("NSIS");
    }
}
