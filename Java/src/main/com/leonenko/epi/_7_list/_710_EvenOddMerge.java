package com.leonenko.epi._7_list;

import java.util.*;

public class _710_EvenOddMerge {

    public static ListNode<Integer> merge(ListNode<Integer> head) {
        var evenHead = ListNode.<Integer>singleton(null);
        var oddHead = ListNode.<Integer>singleton(null);

        var evenOddTails = doMerge(head, evenHead, oddHead);

        evenOddTails.get(0).setNext(oddHead.getNext());

        return evenHead.getNext();
    }

    private static List<ListNode<Integer>> doMerge(
            ListNode<Integer> head,
            ListNode<Integer> evenHead,
            ListNode<Integer> oddHead) {

        var evenOddTails = Arrays.asList(evenHead, oddHead);
        var turn = 0;
        var iter = head;

        while (iter != null) {
            evenOddTails.get(turn).setNext(iter);
            evenOddTails.set(turn, iter);
            iter = iter.getNext();
            turn ^= 1;
        }

        evenOddTails.get(1).setNext(null);

        return evenOddTails;
    }

}
