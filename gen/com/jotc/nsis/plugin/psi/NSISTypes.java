// This is a generated file. Not intended for manual editing.
package com.jotc.nsis.plugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.jotc.nsis.plugin.psi.impl.*;

public interface NSISTypes {


  IElementType COMMENT = new NSISTokenType("COMMENT");
  IElementType COMPILE_COMMAND = new NSISTokenType("COMPILE_COMMAND");
  IElementType CRLF = new NSISTokenType("CRLF");
  IElementType WHITE_SPACE = new NSISTokenType("WHITE_SPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
