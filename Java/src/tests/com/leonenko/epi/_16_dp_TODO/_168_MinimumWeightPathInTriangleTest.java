package com.leonenko.epi._16_dp_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._16_dp_TODO._168_MinimumWeightPathInTriangle.getMinPathSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class _168_MinimumWeightPathInTriangleTest {

    @Test
    void testGetMinPathSum() {
        var triangle = List.of(
                List.of(2),
                List.of(4, 4),
                List.of(8, 5, 6),
                List.of(4, 2, 6, 2),
                List.of(1, 5, 2, 3, 4));
        assertThat(getMinPathSum(triangle)).isEqualTo(15);
    }
}