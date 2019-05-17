package com.leonenko.epi._7_list_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._7_list_TODO.ListNode.doublyLinkedListOf;
import static com.leonenko.epi._7_list_TODO.ListNode.singlyLinkedListOf;
import static com.leonenko.epi._7_list_TODO._711_IsLinkedListPalindrome.isPalindrome;
import static com.leonenko.epi._7_list_TODO._711_IsLinkedListPalindrome.isPalindromeDoublyLinked;
import static org.junit.jupiter.api.Assertions.*;

class _711_IsLinkedListPalindromeTest {

    @Test
    void testIsPalindrome() {
        assertTrue(isPalindrome(singlyLinkedListOf(List.of(1, 2, 1))));
        assertTrue(isPalindrome(singlyLinkedListOf(List.of(1, 1, 1))));
        assertTrue(isPalindrome(singlyLinkedListOf(List.of(3, 1, 2, 2, 1, 3))));
        assertTrue(isPalindrome(singlyLinkedListOf(List.of(5))));
        assertTrue(isPalindrome(singlyLinkedListOf(List.of(5, 5))));
    }

    @Test
    void testIsNotPalindrome() {
        assertFalse(isPalindrome(singlyLinkedListOf(List.of(1, 2))));
        assertFalse(isPalindrome(singlyLinkedListOf(List.of(2, 2, 1))));
        assertFalse(isPalindrome(singlyLinkedListOf(List.of(1, 2, 3, 1))));
    }

    @Test
    void testDoublyLinkedListIsPalindrome() {
        assertTrue(isPalindromeDoublyLinked(doublyLinkedListOf(List.of(2, 1, 2))));
        assertTrue(isPalindromeDoublyLinked(doublyLinkedListOf(List.of(1, 1))));
        assertTrue(isPalindromeDoublyLinked(doublyLinkedListOf(List.of(1))));
        assertTrue(isPalindromeDoublyLinked(doublyLinkedListOf(List.of(1, 1, 1))));
    }

    @Test
    void testDoublyLinkedListIsNotPalindrome() {
        assertFalse(isPalindromeDoublyLinked(doublyLinkedListOf(List.of(1, 2))));
        assertFalse(isPalindromeDoublyLinked(doublyLinkedListOf(List.of(2, 1, 1))));
        assertFalse(isPalindromeDoublyLinked(doublyLinkedListOf(List.of(2, 1, 2, 2))));
    }
}