package com.leonenko.epi._5_array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class _510_PermuteArrayTest {

    @Test
    void testApplyPermutation() {
        assertPermute(List.of(3, 0, 1, 4, 2), List.of(0, 10, 20, 30, 40),
                _510_PermuteArray::permute);
    }

    @Test
    void testApplyPermutation2() {
        assertPermute(List.of(3, 0, 1, 4, 2), List.of(0, 10, 20, 30, 40),
                _510_PermuteArray::permute2);
    }

    private void assertPermute(List<Integer> permutation,
                               List<Integer> listToPermute,
                               BiConsumer<List<Integer>, List<Integer>> permuter) {
        permutation = new ArrayList<>(permutation);
        listToPermute = new ArrayList<>(listToPermute);

        var expectedList = permutation.stream()
                                      .map(listToPermute::get)
                                      .collect(toList());

        permuter.accept(permutation, listToPermute);

        assertThat(listToPermute).containsExactlyElementsOf(expectedList);
    }
}