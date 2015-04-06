// This is a generated file. Not intended for manual editing.
package com.jotc.nsis.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;

public interface NSISTypes {


  IElementType BLOCK_DECLARATION = new NSISTokenType("BLOCK_DECLARATION");
  IElementType COMMENT = new NSISTokenType("COMMENT");
  IElementType COMPILER_COMMAND = new NSISTokenType("COMPILER_COMMAND");
  IElementType CONSTANT = new NSISTokenType("CONSTANT");
  IElementType CRLF = new NSISTokenType("CRLF");
  IElementType IDENTIFIER = new NSISTokenType("IDENTIFIER");
  IElementType INSTRUCTION = new NSISTokenType("INSTRUCTION");
  IElementType KEYWORD = new NSISTokenType("KEYWORD");
  IElementType NUMBER = new NSISTokenType("NUMBER");
  IElementType PLUGIN_CALL = new NSISTokenType("PLUGIN_CALL");
  IElementType SPECIAL_SYMBOL = new NSISTokenType("SPECIAL_SYMBOL");
  IElementType STRING = new NSISTokenType("STRING");
  IElementType VALUE = new NSISTokenType("VALUE");
  IElementType VARIABLE = new NSISTokenType("VARIABLE");
  IElementType WHITE_SPACE = new NSISTokenType("WHITE_SPACE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
