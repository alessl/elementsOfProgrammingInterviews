package com.leonenko.epi._24_honor_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._24_honor_TODO._247_IdentifyPositionsAttackedByRooks.markAttackedPositions;
import static org.assertj.core.api.Assertions.assertThat;

class _247_IdentifyPositionsAttackedByRooksTest {

    @Test
    void test() {
        var board = new int[][] {
                {1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
        };

        markAttackedPositions(board);

        assertThat(board).containsExactlyElementsOf(List.of(
                new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                new int[] {0, 0, 1, 0, 1, 0, 1, 1},
                new int[] {0, 0, 1, 0, 1, 0, 1, 1},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                new int[] {0, 0, 1, 0, 1, 0, 1, 1},
                new int[] {0, 0, 0, 0, 0, 0, 0, 0},
                new int[] {0, 0, 1, 0, 1, 0, 1, 1}
        ));
    }
}