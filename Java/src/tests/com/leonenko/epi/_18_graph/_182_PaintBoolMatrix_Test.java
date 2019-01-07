package com.leonenko.epi._18_graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._18_graph._182_PaintBoolMatrix.flipRegionBfs;
import static com.leonenko.epi._18_graph._182_PaintBoolMatrix.flipRegionDfs;
import static org.assertj.core.api.Assertions.assertThat;

class _182_PaintBoolMatrix_Test {

    private static final boolean X = false;
    private static final boolean O = true;

    private static final boolean[][] MATRIX= {
            {X, X, O, O},
            {O, O, X, O},
            {O, X, X, X},
            {O, X, O, O},
            {X, X, O, O}};

    @BeforeEach
    void setUp() {

    }

    @Test
    void testFlipRegionDfs() {
        flipRegionDfs(MATRIX, 0, 2);

        assertThat(MATRIX).containsExactly(
                new boolean[] {X, X, X, X},
                new boolean[] {O, O, X, X},
                new boolean[] {O, X, X, X},
                new boolean[] {O, X, O, O},
                new boolean[] {X, X, O, O});

        flipRegionDfs(MATRIX, 2, 0);

        assertThat(MATRIX).containsExactly(
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, O, O},
                new boolean[] {X, X, O, O});

        flipRegionDfs(MATRIX, 4, 3);

        assertThat(MATRIX).containsExactly(
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, X, X});
    }

    @Test
    void testFlipRegionBfs() {
        flipRegionBfs(MATRIX, 0, 2);

        assertThat(MATRIX).containsExactly(
                new boolean[] {X, X, X, X},
                new boolean[] {O, O, X, X},
                new boolean[] {O, X, X, X},
                new boolean[] {O, X, O, O},
                new boolean[] {X, X, O, O});

        flipRegionBfs(MATRIX, 2, 0);

        assertThat(MATRIX).containsExactly(
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, O, O},
                new boolean[] {X, X, O, O});

        flipRegionBfs(MATRIX, 4, 3);

        assertThat(MATRIX).containsExactly(
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, X, X},
                new boolean[] {X, X, X, X});
    }

}