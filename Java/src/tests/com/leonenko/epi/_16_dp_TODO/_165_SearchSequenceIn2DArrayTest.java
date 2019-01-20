package com.leonenko.epi._16_dp_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._16_dp_TODO._165_SearchSequenceIn2DArray.searchPattern;
import static org.assertj.core.api.Assertions.assertThat;

class _165_SearchSequenceIn2DArrayTest {

    private final int[][] grid = {
            {1, 2, 3},
            {3, 4, 5},
            {5, 6, 7}
    };

    @Test
    void testSuccessfulSearchPatternStartsAtTopLeft() {
        assertThat(searchPattern(grid, new int[] {1, 2, 4, 6, 5})).isTrue();
    }

    @Test
    void testUnSuccessfulSearchPatternStartsAtTopLeft() {
        assertThat(searchPattern(grid, new int[] {1, 2, 3, 4})).isFalse();
    }

    @Test
    void testSuccessfulSearchPatternStartsInsideGrid() {
        assertThat(searchPattern(grid, new int[] {3, 4, 6, 7})).isTrue();
    }

    @Test
    void testUnSuccessfulSearchPatternStartsInsideGrid() {
        assertThat(searchPattern(grid, new int[] {2, 3, 5, 6})).isFalse();
    }

    // pat = 1, 2, 1, 3
    private final int[][] grid1 = {
            {1, 2, 1},
            {3, 4, 2},
            {5, 3, 1}
    };

    @Test
    void testSuccessfulSearchPatternStartsAtTopLeft1() {
        assertThat(searchPattern(grid1, new int[] {4, 2, 1, 2})).isTrue();
    }
}