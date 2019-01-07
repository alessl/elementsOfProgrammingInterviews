package com.leonenko.myinterview.google;

import java.util.Arrays;

/**
 * Created by leo on 5/31/2016.
 */
public class IncreasingDecreasingArrayMax {

    public static void main(String[] args) {
        printMax(new int[] {1, 2, 3, 5, 4, 0});
        printMax(new int[] {1, 2, 3, 5});
        printMax(new int[] {5, 4, 3, 2, 1});
        printMax(new int[] {5, 8, 2});
        printMax(new int[] {5, 8});
        printMax(new int[] {5});
    }

    private static void printMax(int[] increasingDecreasing) {
        System.out.println(Arrays.toString(increasingDecreasing)
                + ", max: " + max(increasingDecreasing));
    }

    private static int max(int[] increasingDecreasing) {
        int left = 0;
        int right = increasingDecreasing.length - 1;
        while (right - left >= 2) {
            int mid = left + (right - left) / 2;
            int midValue = increasingDecreasing[mid];
            int beforeMidValue = increasingDecreasing[mid - 1];
            int afterMidValue = increasingDecreasing[mid + 1];
            if (midValue > beforeMidValue && midValue > afterMidValue) {
                return midValue;
            }
            if (midValue > beforeMidValue && midValue < afterMidValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return Math.max(increasingDecreasing[left], increasingDecreasing[right]);
    }
}
