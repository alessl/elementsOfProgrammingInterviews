package com.leonenko.epi._14_bst_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._14_bst_TODO._146_FindClosestEntriesInThreeSortedArrays.findMinDistanceBetweenEntries;
import static org.assertj.core.api.Assertions.assertThat;

class _146_FindClosestEntriesInThreeSortedArraysTest {

    @Test
    void testFindMinDistanceBetweenEntries() {
        int minDistanceBetweenEntries = findMinDistanceBetweenEntries(List.of(
                List.of(5, 10, 15),
                List.of(3, 6, 9, 12, 15),
                List.of(8, 16, 24)));
        assertThat(minDistanceBetweenEntries).isEqualTo(1);
    }
}