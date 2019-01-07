package com.leonenko.epi._5_array;

import java.util.Collections;
import java.util.List;

/**
 * Created by Alex on 5/12/2017.
 */
public class _58_ComputeAlternation {

    static void alternateArray(int[] array) {
        for (var idx = 1; idx < array.length; idx++) {
            var isCurrLessThanPrevAndEvenIdx = idx % 2 == 0 && array[idx] < array[idx - 1];
            var isCurrGreaterThanPrevAndOddIdx = idx % 2 != 0 && array[idx] > array[idx - 1];

            if (isCurrLessThanPrevAndEvenIdx || isCurrGreaterThanPrevAndOddIdx) {
                var temp = array[idx];
                array[idx] = array[idx - 1];
                array[idx -1] = temp;
            }
        }
    }

    static void alternateList(List<Integer> list) {
        for (var idx = 1; idx < list.size(); idx++) {
            var isCurrLessThanPrevAndIdxIsEven = idx % 2 == 0 && list.get(idx) < list.get(idx - 1);
            var isCurrGreaterThanPrevAndIdxIsEven = idx % 2 != 0 && list.get(idx) > list.get(idx - 1);

            if (isCurrLessThanPrevAndIdxIsEven || isCurrGreaterThanPrevAndIdxIsEven) {
                Collections.swap(list, idx, idx - 1);
            }
        }
    }
}
