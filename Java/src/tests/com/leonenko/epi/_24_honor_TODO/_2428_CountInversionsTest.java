package com.leonenko.epi._24_honor_TODO;

import org.junit.jupiter.api.Test;


import static com.leonenko.epi._24_honor_TODO._2428_CountInversions.getNumInversions;
import static org.assertj.core.api.Assertions.assertThat;

class _2428_CountInversionsTest {

    @Test
    void testGetInversions() {
        assertCountedInversions(new int[] {3, 6, 4}, 1);
        assertCountedInversions(new int[] {3, 6, 4, 2, 5, 1}, 10);
    }

    @Test
    void testNoInversions() {
        assertCountedInversions(new int[] {1, 2, 5}, 0);
    }

    private void assertCountedInversions(int[] array, int expectedNumInversions) {
        var numInversions = getNumInversions(array);

        assertThat(numInversions).isEqualTo(expectedNumInversions);
    }
}