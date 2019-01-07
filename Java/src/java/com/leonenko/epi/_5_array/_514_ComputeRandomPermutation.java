package com.leonenko.epi._5_array;

import java.util.stream.IntStream;

import static com.leonenko.epi._5_array._512_SampleOfflineData.sample;

public class _514_ComputeRandomPermutation {

    static int[] getRandomPermutation(int uppedBound) {
        var permutation = IntStream.range(1, uppedBound + 1)
                                   .toArray();
        return sample(permutation, permutation.length);
    }
}
