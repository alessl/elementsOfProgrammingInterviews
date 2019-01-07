package com.leonenko.epi._5_array;

import java.util.List;

/**
 * Created by Alex on 5/12/2017.
 */
public class _55_DeleteDuplicatesFromSortedArray {

    static List<Integer> removeDuplicates(List<Integer> a) {
        var writeIdx = 1;

        for (var i = 1; i < a.size(); i++) {
            if (a.get(i) != (int) a.get(i - 1)) {
                a.set(writeIdx++, a.get(i));
            }
        }

        return a.subList(0, writeIdx);
    }
}
