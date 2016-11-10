package com.fewlaps.similarwords;

import java.util.ArrayList;
import java.util.List;

public class SimilarCharsGroup {

  private final List<String> similarChars;

  public SimilarCharsGroup(String... input) {
    similarChars = new ArrayList();

    for (String i : input) {
      similarChars.add(i);
    }
  }

  public List<String> getSimilarChars() {
    return similarChars;
  }
}
