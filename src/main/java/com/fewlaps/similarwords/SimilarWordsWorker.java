package com.fewlaps.similarwords;

import java.util.ArrayList;
import java.util.List;

public class SimilarWordsWorker {

  static List<SimilarCharsGroup> similarCharsGroupGroups = new ArrayList<SimilarCharsGroup>();

  static {
    similarCharsGroupGroups.add(new SimilarCharsGroup("O", "0"));
  }


  public Result getSimilarWords(String input) {
    if (input == null || input.trim().isEmpty()) {
      return new Result(input);
    }

    List<String> similarWords = new ArrayList();
    for (SimilarCharsGroup group : similarCharsGroupGroups) {
      for (String originalChar : group.getSimilarChars()) {
        for (String translationChar : group.getSimilarChars()) {
          String similarWord = input.replaceAll(originalChar, translationChar);
          if (!similarWord.equals(input) && !similarWords.contains(similarWord)) {
            similarWords.add(similarWord);
          }
        }
      }
    }

    return new Result(input, similarWords);
  }
}
