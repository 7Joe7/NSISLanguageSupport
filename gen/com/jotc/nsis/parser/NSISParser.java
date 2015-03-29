// This is a generated file. Not intended for manual editing.
package com.jotc.nsis.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;

import static com.intellij.lang.parser.GeneratedParserUtilBase.*;

import com.intellij.lang.parser.GeneratedParserUtilBase;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.lang.PsiParser;
import com.jotc.nsis.psi.NSISTypes;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class NSISParser implements PsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b, 0);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return nsisFile(b, l + 1);
  }

  /* ********************************************************** */
  // COMPILE_COMMAND|COMMENT|CRLF|WHITE_SPACE
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = GeneratedParserUtilBase.consumeToken(b, NSISTypes.COMPILE_COMMAND);
    if (!r) r = GeneratedParserUtilBase.consumeToken(b, NSISTypes.COMMENT);
    if (!r) r = GeneratedParserUtilBase.consumeToken(b, NSISTypes.CRLF);
    if (!r) r = GeneratedParserUtilBase.consumeToken(b, NSISTypes.WHITE_SPACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // item_*
  static boolean nsisFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nsisFile")) return false;
    int c = current_position_(b);
    while (true) {
      if (!item_(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "nsisFile", c)) break;
      c = current_position_(b);
    }
    return true;
  }

}