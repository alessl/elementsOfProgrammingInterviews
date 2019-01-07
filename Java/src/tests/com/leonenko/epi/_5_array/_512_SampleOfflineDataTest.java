package com.leonenko.epi._5_array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static com.leonenko.epi._5_array._512_SampleOfflineData.sample;

class _512_SampleOfflineDataTest {

    @Test
    void testSample() {
    }

    public static void main(String[] args) {
        int[] array = IntStream.range(0, 11).toArray();
        System.out.println("Input: " + Arrays.toString(array));
        System.out.println("Sample5: " + Arrays.toString(sample(array, 5)));
        System.out.println("Sample7: " + Arrays.toString(sample(array, 7)));
        System.out.println("Sample3: " + Arrays.toString(sample(array, 3)));
    }
}