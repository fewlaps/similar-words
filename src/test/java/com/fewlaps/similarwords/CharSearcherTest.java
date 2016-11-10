package com.fewlaps.similarwords;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CharSearcherTest {

  CharSearcher charSearcher;

  @Before
  public void setUp() {
    charSearcher = new CharSearcher();
  }

  @Test
  public void returnPosition1And3_whenAskingForOInROCO() {
    String input = "ROCO";
    String charToFind = "O";

    List<Integer> positions = charSearcher.findCharPositions(input, charToFind);

    assertThat(positions.get(0)).isEqualTo(1);
    assertThat(positions.get(1)).isEqualTo(3);
    assertThat(positions.size()).isEqualTo(2);
  }

  @Test
  public void returnPosition1_whenAskingForOInROC() {
    String input = "ROC";
    String charToFind = "O";

    List<Integer> positions = charSearcher.findCharPositions(input, charToFind);

    assertThat(positions.get(0)).isEqualTo(1);
    assertThat(positions.size()).isEqualTo(1);
  }

  @Test
  public void returnNothing_whenAskingForAInROC() {
    String input = "ROC";
    String charToFind = "A";

    List<Integer> positions = charSearcher.findCharPositions(input, charToFind);

    assertThat(positions.size()).isEqualTo(0);
  }
}