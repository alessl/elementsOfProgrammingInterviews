package com.leonenko.epi._5_array;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Alex on 4/28/2017.
 */
public class _512_SampleOfflineData {

    static int[] sample(int[] array, int sampleSize) {
        Random random = new Random();
        for (int i = 0; i < sampleSize; i++) {
            swap(array, i, i + random.nextInt(array.length - i));
        }
        return Arrays.copyOfRange(array, 0, sampleSize);
    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
