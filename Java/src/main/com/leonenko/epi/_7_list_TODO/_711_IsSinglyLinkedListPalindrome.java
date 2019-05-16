package com.leonenko.epi._7_list_TODO;

public class _711_IsSinglyLinkedListPalindrome {

    public static boolean isPalindrome(ListNode<Integer> head) {
        var mid = findMiddle(head);

        var firstHalf = head;
        var secondHalf = reverse(mid);

        while (firstHalf != mid && secondHalf != null) {
            if (firstHalf.getKey().compareTo(secondHalf.getKey()) != 0) {
                return false;
            } else {
                firstHalf = firstHalf.getNext();
                secondHalf = secondHalf.getNext();
            }
        }

        return true;
    }

    private static ListNode<Integer> reverse(ListNode<Integer> iter) {
        var reversedHead = new ListNode<Integer>(null, iter, null);

        while (iter.getNext() != null) {
            var temp = iter.getNext();
            iter.setNext(temp.getNext());
            temp.setNext(reversedHead.getNext());
            reversedHead.setNext(temp);
        }

        return reversedHead.getNext();
    }

    private static ListNode<Integer> findMiddle(ListNode<Integer> head) {
        var slowIter = head;
        var fastIter = head;

        while (fastIter != null && fastIter.getNext() != null) {
            slowIter = slowIter.getNext();
            fastIter = fastIter.getNext().getNext();
        }

        return slowIter;
    }

    public static boolean isPalindromeDoubleLinked(ListNode<Integer> head) {
        return false;
    }

}
