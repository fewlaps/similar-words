package com.fewlaps.similarwords;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class EmptyInputTest {

  SimilarWordsWorker library;

  @Before
  public void init() {
    library = new SimilarWordsWorker();
  }

  @Test
  public void shouldReturnEmptyList_ifInputIsNull() {
    String input = null;
    Result result = library.getSimilarWords(input);
    assertTrue(result.getSimilarWords().isEmpty());
  }

  @Test
  public void shouldReturnEmptyList_ifInputIsEmpty() {
    String input = "";
    Result result = library.getSimilarWords(input);
    assertTrue(result.getSimilarWords().isEmpty());
  }

  @Test
  public void shouldReturnEmptyList_ifInputIsASpace() {
    String input = " ";
    Result result = library.getSimilarWords(input);
    assertTrue(result.getSimilarWords().isEmpty());
  }

  @Test
  public void shouldReturnEmptyList_ifInputAreTwoSpaces() {
    String input = "  ";
    Result result = library.getSimilarWords(input);
    assertTrue(result.getSimilarWords().isEmpty());
  }
}
