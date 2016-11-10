package com.fewlaps.similarwords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimilarWordsWorker {

  private static final int FIRST_ITERATION = -1;
  private static List<SimilarCharsGroup> similarCharsGroupGroups = new ArrayList<SimilarCharsGroup>();

  static {
    similarCharsGroupGroups.add(new SimilarCharsGroup("O", "0"));
  }

  private final CharSearcher charSearcher = new CharSearcher();
  private final StringCharReplacer charReplacer = new StringCharReplacer();

  public Result getSimilarWords(String input) {
    if (isEmpty(input)) {
      return new Result(input);
    }

    List<String> result = new ArrayList<String>();
    List<String> wordsToScan = Collections.singletonList(input);
    int suggestionsCount = FIRST_ITERATION;
    while (suggestionsCount == FIRST_ITERATION || suggestionsCount > 0) {
      List<String> suggestions = new ArrayList<String>();
      for (String wordToScan : wordsToScan) {
        List<String> suggestedWords = suggestSimilarWords(wordToScan);
        suggestions = filterNewSuggestions(suggestedWords, result, input);
        suggestionsCount = suggestions.size();
        result.addAll(suggestions);
      }
      wordsToScan = suggestions;
    }

    return new Result(input, result);
  }

  private List<String> suggestSimilarWords(String input) {
    List<String> similarWords = new ArrayList<String>();
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

  private List<String> filterNewSuggestions(List<String> newSuggestions, List<String> oldSuggestions, String originalWord) {
    List<String> result = new ArrayList<String>();
    for (String newSuggestion : newSuggestions) {
      if (!oldSuggestions.contains(newSuggestion) && !newSuggestion.equals(originalWord)) {
        result.add(newSuggestion);
      }
    }
    return result;
  }

  private boolean isEmpty(String input) {
    return input == null || input.trim().isEmpty();
  }
}
