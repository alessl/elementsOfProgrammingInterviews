package com.leonenko.epi._7_list_TODO;

public class _712_ListPivoting {

    public static ListNode<Integer> pivot(ListNode<Integer> head, int pivotKey) {
        var lessHead = new ListNode<>(-1);
        var equalHead = new ListNode<>(-1);
        var greaterHead = new ListNode<>(-1);
        var lessIter = lessHead;
        var equalIter = equalHead;
        var greaterIter = greaterHead;

        var iter = head;
        while (iter != null) {
            var cmp = iter.getKey().compareTo(pivotKey);

            if (cmp < 0) {
                lessIter.setNext(iter);
                lessIter = lessIter.getNext();
            } else if (cmp > 0) {
                greaterIter.setNext(iter);
                greaterIter = greaterIter.getNext();
            } else {
                equalIter.setNext(iter);
                equalIter = equalIter.getNext();
            }

            iter = iter.getNext();
        }

        lessIter.setNext(equalHead.getNext());
        equalIter.setNext(greaterHead.getNext());
        greaterIter.setNext(null);

        return lessHead.getNext();
    }
}
