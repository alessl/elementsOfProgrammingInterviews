package com.leonenko.epi._7_list_TODO;

public class _74_CheckOverlappingListsNoCycles {

    static boolean isOverlap(
            ListNode<Integer> firstHead,
            ListNode<Integer> secondHead) {

        var firstSize = firstHead.size();
        var secondSize = secondHead.size();

        if (firstSize > secondSize) {
            firstHead = advanceHead(firstHead, firstSize - secondSize);
        } else if (firstSize < secondSize) {
            secondHead = advanceHead(secondHead, secondSize - firstSize);
        }

        while (firstHead != null && secondHead != null) {
            if (firstHead == secondHead) {
                return true;
            }

            firstHead = firstHead.getNext();
            secondHead = secondHead.getNext();
        }

        return false;
    }

    private static ListNode<Integer> advanceHead(
            ListNode<Integer> head,
            int offset) {

        while (offset-- > 0 && head != null) {
            head = head.getNext();
        }

        return head;
    }
}
