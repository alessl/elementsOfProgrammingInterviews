package com.leonenko.epi._11_search;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._11_search._111_FindFirstLastOccurrenceInSortedArray.*;
import static org.assertj.core.api.Assertions.assertThat;

class _111_FindFirstLastOccurrenceInSortedArrayTest {

    @Test
    void testOnlyOneElement() {
        assertFirstLastIndex(List.of(1), 1, 0, 0);
    }

    @Test
    void testOneElementOccurringMultipleTimes() {
        assertFirstLastIndex(List.of(1, 1, 1, 1, 1), 1, 0, 4);
    }

    @Test
    void testDifferentElementsResultIsInFirstHalf() {
        assertFirstLastIndex(List.of(1, 2, 2, 2, 3), 2, 1, 3);
    }

    @Test
    void testDifferentElementsResultIsInSecondHalf() {
        assertFirstLastIndex(List.of(1, 2, 2, 2, 3, 3, 3, 4), 3, 4, 6);
    }

    @Test
    void testOddLengthResultIsLastElement() {
        assertFirstLastIndex(List.of(1, 2, 2, 2, 3, 4, 4), 4, 5, 6);
    }

    @Test
    void testEvenLengthResultIsLastElement() {
        assertFirstLastIndex(List.of(1, 2, 2, 2, 3, 4, 4, 4), 4, 5, 7);
    }

    @Test
    void testResultIsLastElementOnlyOneOccurrence() {
        assertFirstLastIndex(List.of(1, 2, 2, 2, 3, 4), 4, 5, 5);
    }

    private void assertFirstLastIndex(List<Integer> list,
            int key, int expectedFirstIndex, int expectedLastIndex) {

        assertThat(findFirstIndex(list, key)).isEqualTo(expectedFirstIndex);
        assertThat(findLastIndex(list, key)).isEqualTo(expectedLastIndex);
    }

    @Test
    void testFirstLessThanKey() {
        var numbers = List.of(1, 5, 5, 7, 8, 8, 9);

        assertThat(findFirstIndexSmallerThan(numbers, 5)).isEqualTo(0);

        assertThat(findFirstIndexSmallerThan(numbers, 8)).isEqualTo(3);
    }

    @Test
    void testFirstGreaterThan() {
        var numbers = List.of(1, 5, 5, 7, 8, 8, 9);

        assertThat(findFirstIndexGreterThan(numbers, 5)).isEqualTo(3);

        assertThat(findFirstIndexGreterThan(numbers, 8)).isEqualTo(6);
    }

}