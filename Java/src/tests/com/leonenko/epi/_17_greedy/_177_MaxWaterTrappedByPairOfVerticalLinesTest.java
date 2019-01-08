package com.leonenko.epi._17_greedy;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._17_greedy._177_MaxWaterTrappedByPairOfVerticalLines.getMaxTrappedWater;
import static org.assertj.core.api.Assertions.assertThat;

class _177_MaxWaterTrappedByPairOfVerticalLinesTest {

    @Test
    void testMaxWaterTrappedByPairOfLines() {
        var lineHeights = List.of(1, 2, 1, 3, 4, 5, 6, 7, 2, 1, 3, 1, 3, 2, 1, 2, 4, 1);

        var maxWater = getMaxTrappedWater(lineHeights);

        assertThat(maxWater).isEqualTo(48);
    }

}