package com.leonenko.epi._24_honor_TODO;

import com.leonenko.epi._7_list.ListNode;


/**
 * Created by Alex on 5/12/2017.
 */
public class _249_ListZipping {

    static ListNode<Integer> zip(ListNode<Integer> head) {
        var first = head;
        var second = getSecond(head);

        while (second != null) {
            // store second.next
            var tmp = second.getNext();
            // set second.next = first.next
            second.setNext(first.getNext());
            // set first.next = second
            first.setNext(second);
            // move forward first
            first = first.getNext().getNext();
            // move forward second
            second = tmp;
        }

        return head;
    }

    private static ListNode<Integer> getSecond(ListNode<Integer> head) {
        var fastIter = head;
        var slowIter = head;

        while (fastIter.getNext() != null) {
            fastIter = fastIter.getNext().getNext();
            slowIter = slowIter.getNext();
        }

        var mid = slowIter.getNext();
        slowIter.setNext(null);

        return reverse(mid);
    }

    private static ListNode reverse(ListNode<Integer> start) {
        var tempHead = new ListNode<Integer>(null, start, null);
        var iter = start;

        while (iter.getNext() != null) {
            var temp = iter.getNext();
            iter.setNext(temp.getNext());
            temp.setNext(tempHead.getNext());
            tempHead.setNext(temp);
        }

        return tempHead.getNext();
    }
}
