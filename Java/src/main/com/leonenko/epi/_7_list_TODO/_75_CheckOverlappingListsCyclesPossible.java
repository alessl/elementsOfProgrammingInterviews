package com.leonenko.epi._7_list_TODO;

import java.util.List;

public class _75_CheckOverlappingListsCyclesPossible {

    static boolean isOverlap(ListNode<Integer> firstHead, ListNode<Integer> secondHead) {

        List<ListNode<Integer>> firstCycle = _73_DetectCycle.getCycle(firstHead);
        List<ListNode<Integer>> secondCycle = _73_DetectCycle.getCycle(secondHead);

        if (firstCycle.isEmpty() && secondCycle.isEmpty()) {
            return _74_CheckOverlappingListsNoCycles.isOverlap(firstHead, secondHead);
        } else if (!firstCycle.isEmpty() && !secondCycle.isEmpty()) {
            var firstCycleStart = firstCycle.get(0);
            var secondCycleStart = secondCycle.get(0);

            if (firstCycleStart == secondCycleStart) {
                return true;
            } else {
                return cyclesIntersect(firstCycleStart, secondCycleStart);
            }
        } else {
            return false;
        }
    }

    private static boolean cyclesIntersect(
            ListNode<Integer> firstStart,
            ListNode<Integer> secondStart) {

        var iter = firstStart;
        while (iter != secondStart && iter.getNext() != firstStart) {
            iter = iter.getNext();
        }

        return iter.getNext() != firstStart;
    }
}
