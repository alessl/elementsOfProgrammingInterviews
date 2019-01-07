package com.leonenko.epi._11_search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.leonenko.epi._11_search._113_FindMinInSortedArrayThatWasRotated.getMinIndex;
import static org.assertj.core.api.Assertions.assertThat;

class _113_FindMinInSortedArray_ThatWasRotated_Test {

    @Test
    void testFindMin() {
        var minIndex = getMinIndex(List.of(1));
        assertThat(minIndex).isEqualTo(0);
    }

    @Test
    void testFindMin2() {
        var sortedNumbers = new ArrayList<>(List.of(1, 2, 3));

        Collections.rotate(sortedNumbers, 2);

        assertThat(sortedNumbers).containsExactly(2, 3, 1);

        assertThat(getMinIndex(sortedNumbers)).isEqualTo(2);
    }

    @Test
    void testFindMin3() {
        var sortedNumbers = new ArrayList<>(List.of(5, 6, 7, 7, 10, 10, 10, 11));

        Collections.rotate(sortedNumbers, 5);

        assertThat(sortedNumbers).containsExactly(7, 10, 10, 10, 11, 5, 6, 7);

        assertThat(getMinIndex(sortedNumbers)).isEqualTo(5);
    }

}