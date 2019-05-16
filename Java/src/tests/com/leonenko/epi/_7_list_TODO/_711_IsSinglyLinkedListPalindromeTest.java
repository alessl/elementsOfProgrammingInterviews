package com.leonenko.epi._7_list_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._7_list_TODO.ListNode.generateList;
import static org.junit.jupiter.api.Assertions.*;

class _711_IsSinglyLinkedListPalindromeTest {

    @Test
    void isPalindrome() {
        assertTrue(_711_IsSinglyLinkedListPalindrome.isPalindrome(
                generateList(List.of(1, 2, 1))));

        assertTrue(_711_IsSinglyLinkedListPalindrome.isPalindrome(
                generateList(List.of(1, 1, 1))));

        assertTrue(_711_IsSinglyLinkedListPalindrome.isPalindrome(
                generateList(List.of(3, 1, 2, 2, 1, 3))));

        assertTrue(_711_IsSinglyLinkedListPalindrome.isPalindrome(
                generateList(List.of(5))));

        assertTrue(_711_IsSinglyLinkedListPalindrome.isPalindrome(
                generateList(List.of(5, 5))));
    }

    @Test
    void isNotPalindrome() {
        assertFalse(_711_IsSinglyLinkedListPalindrome.isPalindrome(
                generateList(List.of(1, 2))));

        assertFalse(_711_IsSinglyLinkedListPalindrome.isPalindrome(
                generateList(List.of(2, 2, 1))));

        assertFalse(_711_IsSinglyLinkedListPalindrome.isPalindrome(
                generateList(List.of(1, 2, 3, 1))));
    }
}