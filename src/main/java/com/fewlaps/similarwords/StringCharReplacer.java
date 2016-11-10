package com.fewlaps.similarwords;

public class StringCharReplacer {
  public String replaceChar(String word, String replacement, int index) {
    return word.substring(0, index) + replacement + word.substring(index + 1, word.length());
  }
}
