package com.leonenko.epi._24_honor_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._24_honor_TODO._247_LongestContiguousIncreasingSubArray_TODO.getMaxIncSubArray;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class _247_LongestContiguousIncreasingSubArrayTODOTest {

    @Test
    void testGetMaxIncSubArray1() {
        assertMaxIncreasingSubArray(new int[] {1, 2, 3},
                new int[] {1, 2, 3});
    }

    @Test
    void testGetMaxIncSubArray2() {
        assertMaxIncreasingSubArray(new int[] {1, 2, 2, 10, 20, 30},
                new int[] {2, 10, 20, 30});
    }

    @Test
    void testGetMaxIncSubArray3() {
        assertMaxIncreasingSubArray(new int[] {1, 2, 3, 2, 1, 0, 30, 40, 50},
                new int[] {0, 30, 40, 50});
    }

    private void assertMaxIncreasingSubArray(int[] array, int[] expectedMaxIncSubArray) {
        assertThat(getMaxIncSubArray(array)).containsExactly(expectedMaxIncSubArray);
    }
}