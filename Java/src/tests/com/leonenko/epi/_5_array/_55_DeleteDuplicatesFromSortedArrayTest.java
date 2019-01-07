package com.leonenko.epi._5_array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.leonenko.epi._5_array._55_DeleteDuplicatesFromSortedArray.removeDuplicates;
import static org.assertj.core.api.Assertions.assertThat;

class _55_DeleteDuplicatesFromSortedArrayTest {

    @Test
    void testRemoveDuplicates() {
        List<Integer> freeOfDuplicates = removeDuplicates(
                new ArrayList<>(List.of(1, 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 7)));

        assertThat(freeOfDuplicates).containsExactly(1, 2, 3, 4, 5, 6, 7);
    }
}