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
  public void shouldReturnEmpty_whenInputIsRoc() {
    String input = "Roc";
    Result result = library.getSimilarWords(input);

    assertThat(result.getSimilarWords().size()).isEqualTo(0);
  }

}
