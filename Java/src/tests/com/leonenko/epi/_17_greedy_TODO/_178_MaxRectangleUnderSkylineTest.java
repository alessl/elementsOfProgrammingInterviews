package com.leonenko.epi._17_greedy_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._17_greedy_TODO._178_MaxRectangleUnderSkyline.getMaxRectangle;
import static org.assertj.core.api.Assertions.assertThat;

class _178_MaxRectangleUnderSkylineTest {

    @Test
    void testGetMaxRectangle() {
        var maxRectangle1 = getMaxRectangle(new int[] {1, 4, 2, 5, 6, 3, 2, 6, 5, 5, 2, 1, 3});
        assertThat(maxRectangle1.getArea()).isEqualTo(18);

        var maxRectangle2 = getMaxRectangle(new int[] {
                1, 4, 2, 5, 6, 3, 2, 6, 5, 5, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
        assertThat(maxRectangle2.getArea()).isEqualTo(19);
    }
}