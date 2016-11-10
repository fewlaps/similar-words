package com.fewlaps.similarwords;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCharReplacerShould {

  StringCharReplacer replacer;

  @Before
  public void setUp() {
    replacer = new StringCharReplacer();
  }

  @Test
  public void replaceLastCharacter() throws Exception {
    String word = "Roc";
    String replacement = "C";
    int position = 2;

    String result = replacer.replaceChar(word, replacement, position);

    assertThat(result).isEqualTo("RoC");
  }

  @Test
  public void replaceFirstCharacter() throws Exception {
    String word = "Roc";
    String replacement = "M";
    int position = 0;

    String result = replacer.replaceChar(word, replacement, position);

    assertThat(result).isEqualTo("Moc");
  }

  @Test(expected = StringIndexOutOfBoundsException.class)
  public void launchAnExceptionIfPositionIsOutOfBounds() throws Exception {
    String word = "Roc";
    String replacement = "M";
    int position = 3;

    String result = replacer.replaceChar(word, replacement, position);
  }
}