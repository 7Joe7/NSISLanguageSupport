// This is a generated file. Not intended for manual editing.
package com.jotc.nsis.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.jotc.nsis.psi.NSISTypes.*;
import static com.jotc.nsis.parser.NSISParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

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
  // IDENTIFIER|NUMBER|VARIABLE|CONSTANT|SPECIAL_SYMBOL|VALUE|STRING|PLUGIN_CALL|INSTRUCTION|BLOCK_DECLARATION|KEYWORD|COMPILER_COMMAND|COMMENT|CRLF|WHITE_SPACE
  static boolean item_(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "item_")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, VARIABLE);
    if (!r) r = consumeToken(b, CONSTANT);
    if (!r) r = consumeToken(b, SPECIAL_SYMBOL);
    if (!r) r = consumeToken(b, VALUE);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, PLUGIN_CALL);
    if (!r) r = consumeToken(b, INSTRUCTION);
    if (!r) r = consumeToken(b, BLOCK_DECLARATION);
    if (!r) r = consumeToken(b, KEYWORD);
    if (!r) r = consumeToken(b, COMPILER_COMMAND);
    if (!r) r = consumeToken(b, COMMENT);
    if (!r) r = consumeToken(b, CRLF);
    if (!r) r = consumeToken(b, WHITE_SPACE);
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
