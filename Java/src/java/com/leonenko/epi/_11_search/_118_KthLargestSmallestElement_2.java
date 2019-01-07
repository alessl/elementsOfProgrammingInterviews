package com.leonenko.epi._11_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

/**
 * Created by Alex on 4/27/2017.
 */
public class _118_KthLargestSmallestElement_2 {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] array = RANDOM.ints(20, 0, 100 + 1).toArray();
        printK(array, 2);
        printK(array, 5);
        printK(array, 10);
    }

    private static void printK(int[] array, int k) {
        int[] sortedArray = Arrays.stream(array).sorted().toArray();
        int largestK = getLargestK(array, k);
        int smallestK = getSmallestK(array, k);
        int actualLargestK = sortedArray[sortedArray.length - k];
        int actualSmallestK = sortedArray[k - 1];
        System.out.printf("Sorted Array: %s%n", Arrays.toString(sortedArray));
        System.out.printf("Smallest(%s): %s=%s%n", k, actualSmallestK, smallestK);
        System.out.printf("Largest(%s): %s=%s%n", k, actualLargestK, largestK);
    }

    private static int getLargestK(int[] array, int k) {
        return getK(array, k - 1, reverseOrder());
    }

    private static int getSmallestK(int[] array, int k) {
        return getK(array, k - 1, naturalOrder());
    }

    private static int getK(int[] array, int k, Comparator<Integer> comparator) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int p = partition(array, left, right, comparator);
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

    private static int partition(
            int[] array, int from, int to, Comparator<Integer> comparator) {
        swap(array, from, from + RANDOM.nextInt(to - from + 1));
        int pivotValue = array[from];
        int left = from + 1;
        int right = to;
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
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
