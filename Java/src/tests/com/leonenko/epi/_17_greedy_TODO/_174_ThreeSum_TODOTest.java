package com.leonenko.epi._17_greedy_TODO;

import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._17_greedy_TODO._174_ThreeSum_TODO.*;
import static org.assertj.core.api.Assertions.assertThat;

class _174_ThreeSum_TODOTest {

    private MutableList<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = Lists.mutable.of(11, 2, 5, 7, 3, 11, 10, 14, 0);
    }

    @Test
    void testFindTriplesBinarySearch() {
        var triples = findTripletsBinarySearch(numbers, 21);

        assertThat(triples).containsExactly(
                List.of(0, 7, 14), List.of(0, 10, 11), List.of(2, 5, 14), List.of(3, 7, 11));
    }

    @Test
    void testFindTripletsTwoIterators() {
        var triples = findTripletsTwoIterators(numbers, 21);

        assertThat(triples).containsExactly(
                List.of(7, 14, 0), List.of(10, 11, 0), List.of(5, 14, 2), List.of(7, 11, 3));
    }

    @Test
    void testFind3TuplesTwoIterators() {
        var triples = findKTuplesTwoIterators(numbers, 21, 3);

        assertThat(triples).containsExactly(
                List.of(7, 14, 0), List.of(10, 11, 0), List.of(5, 14, 2), List.of(7, 11, 3));
    }

}