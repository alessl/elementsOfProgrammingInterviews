package com.leonenko.epi._7_list_TODO;

public class _78_RemoveDuplicatesFromSortedList {

    public static ListNode<Integer> removeDuplicates(ListNode<Integer> head) {

        var iter = head;
        while (iter != null) {
            var next = iter.getNext();
            while (next != null && next.compareTo(iter) == 0) {
                next = next.getNext();
            }
            iter.setNext(next);
            iter = next;
        }

        return head;
    }
}
