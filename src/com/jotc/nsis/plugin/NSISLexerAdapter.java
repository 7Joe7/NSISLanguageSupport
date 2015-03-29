package com.jotc.nsis.plugin;

import com.intellij.lexer.FlexAdapter;

import java.io.Reader;

/**
 * Created by Joe on 05/03/15 at 00:41.
 * <p/>
 * Requirements: ${REQUIREMENTS}
 */
public class NSISLexerAdapter extends FlexAdapter {
    public NSISLexerAdapter() {
        super(new NSISLexer((Reader) null));
    }
}