package com.fewlaps.similarwords;

import java.util.ArrayList;
import java.util.List;

public class CharSearcher {

  public static final int DOESNT_EXISTS = -1;

  List<Integer> findCharPositions(String word, String charToFind) {
    List<Integer> positions = new ArrayList();
    if (positions.isEmpty()) {
      int firstPosition = word.indexOf(charToFind);
      if (firstPosition >= 0) {
        positions.add(firstPosition);
      }
    }
    if (!positions.isEmpty()) {
      Integer newPosition = null;
      while (newPosition == null || newPosition != DOESNT_EXISTS) {
        newPosition = word.indexOf(charToFind, positions.get(positions.size() - 1) + 1);
        if (newPosition != DOESNT_EXISTS) {
          positions.add(newPosition);
        }
      }
    }
    return positions;
  }
}
