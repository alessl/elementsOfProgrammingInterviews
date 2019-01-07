package com.leonenko.epi._24_honor_TODO;

import com.leonenko.epi._7_list_TODO.ListNode;

/**
 * Created by Alex on 5/12/2017.
 */
public class _249_ListZipping_TODO {

    public static void main(String[] args) {
        ListNode head = getSortedList();
        System.out.println(head);

        head = zip(head);
        System.out.println(head);
    }

    private static ListNode zip(ListNode head) {
        ListNode first = head;
        ListNode second = getSecond(head);
        while (second != null) {
            // store second.next
            ListNode tmp = second.getNext();
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

    private static ListNode getSecond(ListNode head) {
        ListNode fast = head;
        ListNode mid = head;
        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            mid = mid.getNext();
        }

        ListNode second = mid.getNext();
        mid.setNext(null);
        return reverse(second);
    }

    private static ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;
        while (curr != null) {
            ListNode next = node.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode getSortedList() {
        ListNode head = new ListNode(0);
        ListNode current = head;
        for (int key = 1; key <= 4; key++) {
            current = current.setNext(key);
        }
        return head;
    }
}
