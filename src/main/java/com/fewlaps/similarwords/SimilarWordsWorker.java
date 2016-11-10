package com.fewlaps.similarwords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimilarWordsWorker {

  static List<SimilarCharsGroup> similarCharsGroupGroups = new ArrayList<SimilarCharsGroup>();

  static {
    similarCharsGroupGroups.add(new SimilarCharsGroup("O", "0"));
  }

  CharSearcher charSearcher = new CharSearcher();
  StringCharReplacer charReplacer = new StringCharReplacer();

  public Result getSimilarWords(String input) {
    if (input == null || input.trim().isEmpty()) {
      return new Result(input);
    }

    List<String> similarWords = new ArrayList();
    List<String> wordsToScan = Collections.singletonList(input);
    int newSuggestions = -1;
    while (newSuggestions == -1 || newSuggestions > 0) {
      List<String> newSuggestedWords = new ArrayList<String>();
      for (String wordToScan : wordsToScan) {
        List<String> suggestedWords = findSimilarWords(wordToScan);
        newSuggestedWords = getNewSuggestions(suggestedWords, similarWords, input);
        similarWords.addAll(newSuggestedWords);
        newSuggestions = newSuggestedWords.size();
      }
      wordsToScan = newSuggestedWords;
    }

    return new Result(input, similarWords);
  }

  private List<String> findSimilarWords(String input) {
    List<String> similarWords = new ArrayList();
    for (SimilarCharsGroup group : similarCharsGroupGroups) {
      for (String originalChar : group.getSimilarChars()) {
        for (String translationChar : group.getSimilarChars()) {
          for (Integer position : charSearcher.findCharPositions(input, originalChar)) {
            String similarWord = charReplacer.replaceChar(input, translationChar, position);
            if (!similarWord.equals(input) && !similarWords.contains(similarWord)) {
              similarWords.add(similarWord);
            }
          }
        }
      }
    }
    return similarWords;
  }

  private List<String> getNewSuggestions(List<String> newSuggestions, List<String> oldSuggestions, String originalWord) {
    List<String> result = new ArrayList();
    for (String newSuggestion : newSuggestions) {
      if (!oldSuggestions.contains(newSuggestion) && !newSuggestion.equals(originalWord)) {
        result.add(newSuggestion);
      }
    }
    return result;
  }
}
