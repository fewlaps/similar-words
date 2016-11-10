package com.fewlaps.similarwords;

import org.junit.Before;
import org.junit.Test;

public class PerformanceTest {

  SimilarWordsWorker library;

  @Before
  public void init() {
    library = new SimilarWordsWorker();
  }

  @Test
  public void performanceTest() {
    String input = "IIIIIIIIIIOIOIOIOIOIOIOIOIOIOIOIOIOIOIOIIIIIIIIIIIIIIIIIIIIOOOOOOOO";
    Result result = library.getSimilarWords(input);
    System.out.print("Similar words: " + result.getSimilarWords().size());
  }
}
