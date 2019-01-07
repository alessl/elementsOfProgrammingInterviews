package com.leonenko.epi._24_honor_TODO;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by Alex on 5/5/2017.
 */
public class _2436_SearchPairSumInAbsSortedArray_TODO {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] array = getArray();
        System.out.println(Arrays.toString(array));

        int n1 = array[RANDOM.nextInt(array.length)];
        int n2 = array[RANDOM.nextInt(array.length)];
        System.out.printf("%d + %d = %d", n1, n2, n1 + n2);

        int[] pair = getPairWithSum(array, n1 + n2);
        if (pair == null) {
            System.out.printf("Not found pair with sum %d", n1 + n2);
        } else {
            System.out.printf(
                    "Found pair %d + %d = %d",
                    array[pair[0]], array[pair[1]], array[pair[0]] + array[pair[1]]);
        }
    }

    private static int[] getPairWithSum(int[] array, int sum) {
        return null;
    }

    private static int[] getPair(int[] array, int sum, Comparator<Integer> comparator) {

        return null;
    }

    private static int[] getArray() {
        int size = 20;
        int origin = -100;
        int bound = 101;
        return RANDOM.ints(size, origin, bound)
                .boxed()
                .sorted(Comparator.comparingInt(Math::abs))
                .mapToInt(i -> i)
                .toArray();
    }
}
