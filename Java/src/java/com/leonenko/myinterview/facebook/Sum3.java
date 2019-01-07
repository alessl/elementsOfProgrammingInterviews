package com.leonenko.myinterview.facebook;

import com.leonenko.gfg.arr.Shuffle;

import java.util.*;

/**
 * Created by Alex on 5/26/2017.
 *
 * http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 */
public class Sum3 {

    public static void main(String[] args) {
        int sum = 12;
        int[] a = {0, 1, 1, 1, 2, 2, 3, 4, 4, 5, 5, 7, 8, 8, 8, 8, 8, 9};

        Shuffle.shuffle(a);
        print3SumSort(a, sum);

        Shuffle.shuffle(a);
        print3SumBS(a, sum);

        Shuffle.shuffle(a);
        print3SumHash(a, sum);
    }

    private static void print3SumBS(int[] a, int threeSum) {
        Arrays.sort(a);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int index1 = 0; index1 < a.length - 2; index1 = increment(a, index1)) {
            for (int index2 = index1 + 1; index2 < a.length - 1; index2 = increment(a, index2)) {
                int index3 = Arrays.binarySearch(
                        a, index2 + 1, a.length, threeSum - (a[index1] + a[index2]));
                if (index3 > 0) {
                    triplets.add(Arrays.asList(a[index1], a[index2], a[index3]));
                }
            }
        }
        System.out.println(triplets);
    }

    private static void print3SumSort(int[] a, int threeSum) {
        Arrays.sort(a);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < a.length;) {
            int lt = i + 1;
            int rt = a.length - 1;
            int twoSum = threeSum - a[i];
            while (lt < rt) {
                int currSum = a[lt] + a[rt];
                if (twoSum == currSum) {
                    triplets.add(Arrays.asList(a[i], a[lt], a[rt]));
                    lt = increment(a, lt);
                    rt = decrement(a, rt);
                } else if (twoSum > currSum) {
                    lt = increment(a, lt);
                } else {
                    rt = decrement(a, rt);
                }
            }
            i = increment(a, i);
        }
        System.out.println(triplets);
    }

    private static int decrement(int[] a, int i) {
        while (i > 0 && a[i] == a[i - 1])
            i--;
        return i - 1;
    }

    private static int increment(int[] a, int i) {
        while (i < a.length - 1 && a[i] == a[i + 1])
            i++;
        return i + 1;
    }

    private static void print3SumHash(int[] a, int threeSum) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            m.put(a[i], i);
        }
        Set<List<Integer>> triplets = new HashSet<>();
        for (int index1 = 0; index1 < a.length - 2; index1++) {
            int twoSum = threeSum - a[index1];
            for (int index2 = index1 + 1; index2 < a.length - 1; index2++) {
                int difference = twoSum - a[index2];
                if (m.containsKey(difference)
                        && m.get(difference) > index2) {
                    List<Integer> triplet = Arrays.asList(a[index1], a[index2], difference);
                    Collections.sort(triplet);
                    triplets.add(triplet);
                }
            }
        }
        System.out.println(triplets);
    }
}
