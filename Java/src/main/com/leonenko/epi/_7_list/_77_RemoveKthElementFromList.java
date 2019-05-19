package com.leonenko.epi._7_list;

import java.util.Objects;

public class _77_RemoveKthElementFromList {

    static ListNode<Integer> removeKthNodeFromEnd(ListNode<Integer> head, int k) {
        Objects.requireNonNull(head);

        head = new ListNode<>(null, head, null);

        var aheadIter = head;
        while (k-- > 0) {
            aheadIter = aheadIter.getNext();
        }

        var behindIter = head;
        while (aheadIter != null) {
            behindIter = behindIter.getNext();
            aheadIter = aheadIter.getNext();
        }

        behindIter.setNext(behindIter.getNext().getNext());

        return head;
    }
}
