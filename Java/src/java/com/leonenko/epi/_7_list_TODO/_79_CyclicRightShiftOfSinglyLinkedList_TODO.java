package com.leonenko.epi._7_list_TODO;

import java.util.Random;

/**
 * Created by Alex on 5/11/2017.
 */
public class _79_CyclicRightShiftOfSinglyLinkedList_TODO {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        ListNode head = getSortedList();
        System.out.println(head);

        head = rotate(head, 2);
        System.out.println(head);

        head = rotate(head, 4);
        System.out.println(head);
    }

    private static ListNode rotate(ListNode head, int distance) {
        if (head == null) {
            return null;
        }
        int len = 0;
        ListNode tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
            len++;
        }
        if (distance % len == 0) {
            return head;
        }
        tail.setNext(head);
        ListNode newTail = tail.getNext();
        for (int i = 0; i < len - distance; i++) {
            newTail = newTail.getNext();
        }
        ListNode newHead = newTail.getNext();
        newTail.setNext(null);
        return newHead;
    }

    private static ListNode getSortedList() {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int key = 1; key <= 10; key++) {
            current = current.setNext(key);
        }
        return head;
    }

}
