package com.fewlaps.similarwords;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RealResponsesTest {

  SimilarWordsWorker library;

  @Before
  public void init() {
    library = new SimilarWordsWorker();
  }

  @Test
  public void shouldReturnEmpty_whenInputDoesntHaveSimilarWords() {
    String input = "Roc";
    Result result = library.getSimilarWords(input);

    assertThat(result.getSimilarWords().size()).isEqualTo(0);
  }

  @Test
  public void shouldReturnR0C_whenInputIsROC() {
    String input = "ROC";
    Result result = library.getSimilarWords(input);

    assertThat(result.getSimilarWords().get(0)).isEqualTo("R0C");
    assertThat(result.getSimilarWords().size()).isEqualTo(1);
  }
}
