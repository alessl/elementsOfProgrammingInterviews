package com.leonenko.epi._7_list_TODO;

/**
 * Created by Alex on 5/12/2017.
 */
public class _72_ReverseSingleSubList_TODO {

    public static void main(String[] args) {
        ListNode head = getSortedList();
        System.out.println(head);
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
