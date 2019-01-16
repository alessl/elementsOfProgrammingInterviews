package com.leonenko.epi._16_dp_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._16_dp_TODO._161_NumberOfScoreCombinations.*;
import static org.assertj.core.api.Assertions.assertThat;

class _161_NumberOfScoreCombinationsTest {

    private static final int TOTAL_SCORE = 12;
    private static final int[] POINTS = {2, 3, 7};

    @Test
    void testListCombinations() {
        assertThat(listUniqueScoreCombinations(TOTAL_SCORE, POINTS)).contains(
                List.of(2, 3, 7), List.of(2, 2, 2, 3, 3), List.of(2, 2, 2, 2, 2, 2), List.of(3, 3, 3, 3));
    }

    @Test
    void testCountCombinations() {
        assertThat(countUniqueScoreCombinations(TOTAL_SCORE, POINTS)).isEqualTo(4);
    }

    @Test
    void testCuntCombinationsDP() {
        assertThat(countCombinationsDP(TOTAL_SCORE, POINTS)).isEqualTo(4);
    }
}