package com.leonenko.epi._5_array;

import java.util.Arrays;
import java.util.PrimitiveIterator;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by Alex on 4/28/2017.
 */
public class _513_SampleOnlineData {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        System.out.println("Sample3: " + Arrays.toString(sample(getIterator(), 3)));
        System.out.println("Sample5: " + Arrays.toString(sample(getIterator(), 5)));
        System.out.println("Sample7: " + Arrays.toString(sample(getIterator(), 7)));
    }

    static int[] sample(PrimitiveIterator.OfInt iterator, int sampleSize) {
        int num = 0;
        int[] sample = new int[sampleSize];
        while (iterator.hasNext()) {
            int nextNum = iterator.nextInt();
            if (num < sampleSize) {
                sample[num] = nextNum;
            } else {
                int swapIndex = RANDOM.nextInt(num + 1);
                if (swapIndex < sampleSize) {
                    sample[swapIndex] = nextNum;
                }
            }
            num++;
        }
        return sample;
    }

    private static PrimitiveIterator.OfInt getIterator() {
        return IntStream.range(0, 11).iterator();
    }
}
