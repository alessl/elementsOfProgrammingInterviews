package com.leonenko.epi._10_heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.leonenko.epi._10_heap._101_MergeSortedLists.mergeSortedLists;

public class _102_SortIncrDecrList_1 {

    public static List<Integer> sortListWithIncrDecrSubList(List<Integer> list) {
        var sortedLists = new ArrayList<List<Integer>>();
        var isIncreaing = list.get(0) < list.get(1);
        var startIdx = 0;

        for (int endIdx = 1; endIdx <= list.size(); endIdx++) {
            var isSubListEnd = endIdx == list.size()
                    || isIncreaing && list.get(endIdx - 1) > list.get(endIdx)
                    || !isIncreaing && list.get(endIdx - 1) < list.get(endIdx);

            if (isSubListEnd) {
                var sortedList = new ArrayList<>(list.subList(startIdx, endIdx));

                if (!isIncreaing) {
                    Collections.reverse(sortedList);
                }

                sortedLists.add(sortedList);

                startIdx = endIdx;
                isIncreaing = !isIncreaing;
            }
        }

        return mergeSortedLists(sortedLists);
    }

}
