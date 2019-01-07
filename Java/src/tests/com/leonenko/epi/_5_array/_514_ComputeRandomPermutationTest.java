package com.leonenko.epi._5_array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static com.leonenko.epi._5_array._514_ComputeRandomPermutation.getRandomPermutation;
import static org.assertj.core.api.Assertions.assertThat;

class _514_ComputeRandomPermutationTest {

    @Test
    void testGetRandomPermutation() {
        int[] randomPermutation = getRandomPermutation(10);

        System.out.println(Arrays.toString(randomPermutation));

        assertThat(randomPermutation).hasSize(10);
    }
}