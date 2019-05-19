package com.leonenko.epi._7_list_TODO;

import java.util.List;

/**
 * Created by Alex on 5/12/2017.
 *
 * https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
 */
public class _73_DetectCycle {

    public static List<ListNode<Integer>> getCycle(ListNode<Integer> head) {

        if (head == null || head.getNext() == null) {
            return List.of();
        }

        var slowIter = head;
        var fastIter = head;

        while (fastIter != null && fastIter.getNext() != null) {
            slowIter = slowIter.getNext();
            fastIter = fastIter.getNext().getNext();

            if (fastIter == slowIter) {
                slowIter = head;

                while (slowIter.getNext() != fastIter.getNext()) {
                    slowIter = slowIter.getNext();
                    fastIter = fastIter.getNext();
                }

                return List.of(slowIter.getNext(), fastIter);
            }
        }

        return List.of();
    }

}
