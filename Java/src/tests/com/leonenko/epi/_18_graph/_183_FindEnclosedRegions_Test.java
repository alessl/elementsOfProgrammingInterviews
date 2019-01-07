package com.leonenko.epi._18_graph;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._18_graph._183_FindEnclosedRegions.*;
import static org.assertj.core.api.Assertions.assertThat;

class _183_FindEnclosedRegions_Test {

    @Test
    void testFillEnclosedRegions() {
        int[][] matrix = {
                {X, X, X, X, X, X, X},
                {X, O, O, X, O, O, X},
                {X, O, X, X, O, O, X},
                {X, X, X, X, X, X, O, O},
                {O, O, X, O, X, O, X},
                {X, O, X, O, X, O, O, X, X},
                {X, X, X, O, X, X, X},
        };

        fillEnclosedRegions(matrix);

        assertThat(matrix).containsExactly(
                new int[] {X, X, X, X, X, X, X},
                new int[] {X, X, X, X, X, X, X},
                new int[] {X, X, X, X, X, X, X},
                new int[] {X, X, X, X, X, X, O, O},
                new int[] {O, O, X, O, X, X, X},
                new int[] {X, O, X, O, X, X, X, X, X},
                new int[] {X, X, X, O, X, X, X}
        );
    }
}