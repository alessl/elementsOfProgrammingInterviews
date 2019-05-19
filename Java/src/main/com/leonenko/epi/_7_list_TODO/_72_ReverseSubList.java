package com.leonenko.epi._7_list_TODO;


/**
 * Created by Alex on 5/12/2017.
 */
public class _72_ReverseSubList {

    public static <T extends Comparable<T>> ListNode<T> reverseSubList(
            ListNode<T> listHead,
            int from,
            int to) {

        var newListHead = new ListNode<T>(null, listHead, null);

        var subListHead = newListHead;
        for (int i = 0; i < from; i++) {
            subListHead = subListHead.getNext();
        }

        var iterator = subListHead.getNext();

        for (int i = from; i < to; i++) {
            var temp = iterator.getNext();
            iterator.setNext(temp.getNext());
            temp.setNext(subListHead.getNext());
            subListHead.setNext(temp);
        }

        return newListHead.getNext();
    }

    public static <T extends Comparable<T>> ListNode<T> reverseDoublyLinkedSubList(
            ListNode<T> listHead, int from, int to) {
        return null;
    }

}
