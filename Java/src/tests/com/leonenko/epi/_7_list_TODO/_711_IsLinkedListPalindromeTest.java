package com.leonenko.epi._7_list_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._7_list_TODO.ListNode.generateList;
import static com.leonenko.epi._7_list_TODO._711_IsLinkedListPalindrome.isPalindrome;
import static com.leonenko.epi._7_list_TODO._711_IsLinkedListPalindrome.isPalindromeDoublyLinked;
import static org.junit.jupiter.api.Assertions.*;

class _711_IsLinkedListPalindromeTest {

    @Test
    void testIsPalindrome() {
        assertTrue(isPalindrome(generateList(List.of(1, 2, 1))));
        assertTrue(isPalindrome(generateList(List.of(1, 1, 1))));
        assertTrue(isPalindrome(generateList(List.of(3, 1, 2, 2, 1, 3))));
        assertTrue(isPalindrome(generateList(List.of(5))));
        assertTrue(isPalindrome(generateList(List.of(5, 5))));
    }

    @Test
    void testIsNotPalindrome() {
        assertFalse(isPalindrome(generateList(List.of(1, 2))));
        assertFalse(isPalindrome(generateList(List.of(2, 2, 1))));
        assertFalse(isPalindrome(generateList(List.of(1, 2, 3, 1))));
    }

    @Test
    void testDoublyLinkedListIsPalindrome() {
        assertTrue(isPalindromeDoublyLinked(doublyLinked(generateList(List.of(2, 1, 2)))));
        assertTrue(isPalindromeDoublyLinked(doublyLinked(generateList(List.of(1, 1)))));
        assertTrue(isPalindromeDoublyLinked(doublyLinked(generateList(List.of(1)))));
        assertTrue(isPalindromeDoublyLinked(doublyLinked(generateList(List.of(1, 1, 1)))));
    }

    @Test
    void testDoublyLinkedListIsNotPalindrome() {
        assertFalse(isPalindromeDoublyLinked(doublyLinked(generateList(List.of(1, 2)))));
        assertFalse(isPalindromeDoublyLinked(doublyLinked(generateList(List.of(2, 1, 1)))));
        assertFalse(isPalindromeDoublyLinked(doublyLinked(generateList(List.of(2, 1, 2, 2)))));
    }

    private ListNode<Integer> doublyLinked(ListNode<Integer> head) {
        ListNode<Integer> prev = null;
        ListNode<Integer> iter = head;

        while (iter != null) {
            iter.setPrev(prev);
            prev = iter;
            iter = iter.getNext();
        }

        return head;
    }

}