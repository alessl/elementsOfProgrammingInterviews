package com.leonenko.epi._7_list;

/**
 * Created by Alex on 5/12/2017.
 */
public class _71_MergeTwoSortedLists {

    public static <T extends Comparable<T>> ListNode<T> mergeLists(
            ListNode<T> firstHead, ListNode<T> secondHead) {

        var mergedHead = new ListNode<T>(null);
        var iterator = mergedHead;

        while (firstHead != null && secondHead != null) {
            if (firstHead.compareTo(secondHead) <= 0) {
                iterator.setNext(firstHead);
                firstHead = firstHead.getNext();
            } else {
                iterator.setNext(secondHead);
                secondHead = secondHead.getNext();
            }
            iterator = iterator.getNext();
        }

        if (firstHead != null) {
            iterator.setNext(firstHead);
        } else if (secondHead != null) {
            iterator.setNext(secondHead);
        }

        return mergedHead.getNext();
    }
}
