package com.leonenko.epi._5_array;

import java.util.Collections;
import java.util.List;

public class _510_PermuteArray {

    static void permute(List<Integer> permutation, List<Integer> listToPermute) {
        for (int i = 0; i < listToPermute.size(); i++) {
            var next = i;

            while (permutation.get(next) >= 0) {
                var temp = permutation.get(next);

                Collections.swap(listToPermute, i, temp);

                permutation.set(next, temp - permutation.size());

                next = temp;
            }
        }

        for (int i = 0; i < permutation.size(); i++) {
            permutation.set(i, permutation.get(i) + permutation.size());
        }
    }

    static void permute2(List<Integer> permutation, List<Integer> listToPermute) {
        for (int i = 0; i < listToPermute.size(); i++) {
            var isMin = true;
            var j = permutation.get(i);

            while (j != i) {
                if (j < i) {
                    isMin = false;
                    break;
                }

                j = permutation.get(j);
            }

            if (isMin) {
                cyclicPermutation(i, permutation, listToPermute);
            }
        }
    }

    private static void cyclicPermutation(int start,
                                          List<Integer> permutation,
                                          List<Integer> listToPermute) {
        var temp = listToPermute.get(start);
        var idx = start;

        do {
            var nextIdx = permutation.get(idx);
            var nextTemp = permutation.get(nextIdx);

            listToPermute.set(nextIdx, temp);

            idx = nextIdx;
            temp = nextTemp;
        } while (idx != start);
    }
}
