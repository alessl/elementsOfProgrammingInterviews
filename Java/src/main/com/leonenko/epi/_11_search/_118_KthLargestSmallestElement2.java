package com.leonenko.epi._11_search;

import java.util.Comparator;
import java.util.Random;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

/**
 * Created by Alex on 4/27/2017.
 */
public class _118_KthLargestSmallestElement2 {

    private static final Random RANDOM = new Random();

    static int getKLargest(int[] array, int k) {
        return getK(array, k - 1, reverseOrder());
    }

    static int getSmallestK(int[] array, int k) {
        return getK(array, k - 1, naturalOrder());
    }

    private static int getK(int[] array, int k, Comparator<Integer> comparator) {
        var left = 0;
        var right = array.length - 1;

        while (left <= right) {
            var p = partition(array, left, right, comparator);

            if (p == k) {
                return array[p];
            } else if (k < p) {
                right = p - 1;
            } else {
                left = p + 1;
            }
        }

        return -1;
    }

    private static int partition(int[] array,
                                 int from, int to, Comparator<Integer> comparator) {

        swap(array, from, from + RANDOM.nextInt(to - from + 1));

        var pivotValue = array[from];
        var left = from + 1;
        var right = to;

        while (true) {
            while (left < to && comparator.compare(array[left], pivotValue) < 0) {
                left++;
            }

            while (comparator.compare(array[right], pivotValue) > 0) {
                right--;
            }

            if (left < right) {
                swap(array, left, right);

                left++;
                right--;
            } else {
                swap(array, from, right);

                return right;
            }
        }
    }

    private static void swap(int[] array, int i, int j) {
        var tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
