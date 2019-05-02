package com.leonenko.epi._7_list_TODO;

/**
 * Created by Alex on 5/12/2017.
 */
public class _71_MergeTwoSortedLists {

    public static <T extends Comparable<T>> ListNode<T> mergeLists(
            ListNode<T> listHead1, ListNode<T> listHead2) {
        var mergedHead = new ListNode<T>(null);
        var iterator = mergedHead;

        while (listHead1 != null && listHead2 != null) {
            if (listHead1.compareTo(listHead2) <= 0) {
                iterator.setNext(listHead1);
                listHead1 = listHead1.getNext();
            } else {
                iterator.setNext(listHead2);
                listHead2 = listHead2.getNext();
            }
            iterator = iterator.getNext();
        }

        if (listHead1 != null) {
            iterator.setNext(listHead1);
        } else if (listHead2 != null) {
            iterator.setNext(listHead2);
        }

        return mergedHead.getNext();
    }
}
