package com.fewlaps.similarwords;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Result {
  private final String originalWord;
  private final List<String> similarWords;

  public Result(String originalWord) {
    this.originalWord = originalWord;
    this.similarWords = Collections.emptyList();
  }

  public Result(String originalWord, List<String> similarWords) {
    this.originalWord = originalWord;
    this.similarWords = similarWords;
  }

  /**
   * @return the input the user asked for similar words
   **/
  public String getOriginalWord() {
    return originalWord;
  }

  /**
   * @return the list of similar words, excluding the original word
   **/
  public List<String> getSimilarWords() {
    return similarWords;
  }

  /**
   * @return the list of similar words, including the original word
   **/
  public List<String> getAll() {
    List<String> all = new ArrayList<String>();
    all.add(originalWord);
    all.addAll(similarWords);
    return all;
  }
}
