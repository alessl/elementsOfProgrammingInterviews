package com.leonenko.epi._10_heap;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._10_heap._106_LargestKElementsOfMaxHeap.getLargestKNodes;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class _106_LargestKElementsOfMaxHeapTest {

    @Test
    void testGetLargestKNodes() {
        var k = 4;
        var maxHeap = List.of(8, 7, 6, 5);

        var largestKNodes = getLargestKNodes(maxHeap, k);

        assertThat(largestKNodes).containsExactly(8);
    }

}