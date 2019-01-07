package com.leonenko.epi._10_heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class _103_SortKSortedList {

    public static List<Integer> sortKSortedList(List<Integer> list, int k) {
        var sortedList = new ArrayList<Integer>();

        var minHeap = list.stream()
                          .limit(k)
                          .collect(Collectors.toCollection(PriorityQueue::new));

        for (var curr : list.subList(k, list.size())) {
            minHeap.add(curr);

            sortedList.add(minHeap.remove());
        }

        while (!minHeap.isEmpty()) {
            sortedList.add(minHeap.remove());
        }

        return sortedList;
    }

}
