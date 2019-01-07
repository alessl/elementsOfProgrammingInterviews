package com.leonenko.epi._11_search;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Alex on 5/3/2017.
 */
public class _111_FindFirstLastOccurrenceInSortedArray_2 {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        int[] numbers = getNumbers();
        System.out.println(Arrays.toString(numbers));

        int searchNum = numbers[RANDOM.nextInt(numbers.length)];

        int firstIndex = firstIndexOf(numbers, searchNum);
        System.out.printf(
                "First occurrence of %s is %s, actual %s%n",
                searchNum, firstIndex, numbers[firstIndex]);

        int lastIndex = lastIndexOf(numbers, searchNum);
        System.out.printf(
                "Last occurrence of %s is %s, actual %s%n",
                searchNum, lastIndex, numbers[lastIndex]);
    }

    private static int firstIndexOf(int[] numbers, int searchNum) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] >= searchNum) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int lastIndexOf(int[] numbers, int searchNum) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] <= searchNum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    private static int[] getNumbers() {
        int[] numbers = new int[10 + RANDOM.nextInt(20)];
        for (int i = 0; i < numbers.length;) {
            int n = RANDOM.nextInt(100 + 1);
            int repeatLimit = RANDOM.nextInt(5);
            for (int j = 0; j < repeatLimit && i < numbers.length; j++) {
                numbers[i++] = n;
            }
        }
        Arrays.sort(numbers);
        return numbers;
    }
}
