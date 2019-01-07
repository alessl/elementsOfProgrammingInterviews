package com.leonenko.epi._10_heap;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.leonenko.epi._10_heap._101_MergeSortedLists.mergeSortedLists;
import static org.assertj.core.api.Assertions.assertThat;

class _101_MergeSortedListsTest {

    @Test
    void testMergeSortedLists() {
        var tailList = IntStream.range(10, 16)
                                .boxed()
                                .collect(Collectors.toList());

        var evenList = IntStream.range(0, 11)
                                .filter(i -> i % 2 == 0)
                                .boxed()
                                .collect(Collectors.toList());

        var oddList = IntStream.range(0, 11)
                               .filter(i -> i % 2 != 0)
                               .boxed()
                               .collect(Collectors.toList());

        var negList = IntStream.range(-5, 0)
                               .filter(i -> i % 2 == 0)
                               .boxed()
                               .collect(Collectors.toList());

        var sortedLists = List.of(tailList, evenList, oddList, negList);

        var mergedList = mergeSortedLists(sortedLists);

        var expectedMergedList = sortedLists.stream()
                                            .flatMap(List::stream)
                                            .sorted()
                                            .collect(Collectors.toList());

        assertThat(mergedList).containsExactlyElementsOf(expectedMergedList);
    }
}