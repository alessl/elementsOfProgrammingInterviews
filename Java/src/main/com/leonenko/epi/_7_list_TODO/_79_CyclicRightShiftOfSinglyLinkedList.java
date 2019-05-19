package com.leonenko.epi._7_list_TODO;

/**
 * Created by Alex on 5/11/2017.
 */
public class _79_CyclicRightShiftOfSinglyLinkedList {

    static <T extends Comparable<T>> ListNode<T> rotate(
            ListNode<T> head,
            int rotateDistance) {

        if (head == null || rotateDistance == 0) {
            return head;
        }

        var size = head.size();

        rotateDistance %= size;

        if (rotateDistance == 0) {
            return head;
        }

        var tail = head.getTail();

        tail.setNext(head);

        var newTail = tail;
        for (int i = 0; i < size - rotateDistance; i++) {
            newTail = newTail.getNext();
        }

        var newHead = newTail.getNext();
        newTail.setNext(null);

        return newHead;
    }
}
