package com.leonenko.epi._5_array;

/**
 * Created by Alex on 4/28/2017.
 */
public class _511_NextAndPrevPermutation {

    static int[] getPrevPerm(int[] perm) {
        var pivot = perm.length - 2;

        while (pivot > 0 && perm[pivot] < perm[pivot + 1]) {
            pivot--;
        }

        if (pivot == 0) {
            return perm;
        }

        var newPivot = perm.length - 1;

        while (perm[pivot] < perm[newPivot]) {
            newPivot--;
        }

        swap(perm, pivot, newPivot);
        reverse(perm, pivot + 1, perm.length - 1);

        return perm;
    }

    static int[] getNextPerm(int[] perm) {
        var pivot = perm.length - 2;

        while (pivot > 0 && perm[pivot] > perm[pivot + 1]) {
            pivot--;
        }

        if (pivot == 0) {
            return perm;
        }

        var newPivot = perm.length - 1;

        while (perm[pivot] > perm[newPivot]) {
            newPivot--;
        }

        swap(perm, pivot, newPivot);
        reverse(perm, pivot + 1, perm.length - 1);

        return perm;
    }

    private static void reverse(int[] array, int left, int right) {
        while (left < right) {
            swap(array, left++, right--);
        }
    }

    private static void swap(int[] array, int i, int j) {
        var tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
