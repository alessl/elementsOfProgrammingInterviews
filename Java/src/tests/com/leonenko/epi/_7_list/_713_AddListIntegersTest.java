package com.leonenko.epi._7_list;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._7_list.TestUtils.assertListContainsKeys;
import static com.leonenko.epi._7_list._713_AddListIntegers.sum;
import static com.leonenko.epi._7_list._713_AddListIntegers.sumReversed;

class _713_AddListIntegersTest {

    @Test
    void sumReversed_NoCarry() {
        var firstNum = ListNode.singlyLinkedListOf(List.of(3, 2, 1));
        var secondNum = ListNode.singlyLinkedListOf(List.of(3, 2, 1));

        var sum = sumReversed(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(6, 4, 2));
    }

    @Test
    void sumReversed_WithCarry() {
        var firstNum = ListNode.singlyLinkedListOf(List.of(9, 2, 1));
        var secondNum = ListNode.singlyLinkedListOf(List.of(3, 7, 1));

        var sum = sumReversed(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(2, 0, 3));
    }

    @Test
    void sumReversed_WithCarryToNewPlace() {
        var firstNum = ListNode.singlyLinkedListOf(List.of(1, 0, 1));
        var secondNum = ListNode.singlyLinkedListOf(List.of(9, 9, 8));

        var sum = sumReversed(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(0, 0, 0, 1));
    }

    @Test
    void sumReversed_DifferentLengthNumbers() {
        var firstNum = ListNode.singlyLinkedListOf(List.of(1, 1));
        var secondNum = ListNode.singlyLinkedListOf(List.of(2, 2, 3));

        var sum = sumReversed(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(3, 3, 3));
    }

    @Test
    void sum_NoCarry() {
        var firstNum = ListNode.singlyLinkedListOf(List.of(1, 2, 3));
        var secondNum = ListNode.singlyLinkedListOf(List.of(1, 2, 3));

        var sum = sum(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(2, 4, 6));
    }

    @Test
    void sum_WithCarry() {
        var firstNum = ListNode.singlyLinkedListOf(List.of(1, 2, 9));
        var secondNum = ListNode.singlyLinkedListOf(List.of(1, 7, 3));

        var sum = sum(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(3, 0, 2));
    }

    @Test
    void sum_WithCarryToNewPlace() {
        var firstNum = ListNode.singlyLinkedListOf(List.of(1, 0, 1));
        var secondNum = ListNode.singlyLinkedListOf(List.of(8, 9, 9));

        var sum = sum(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(1, 0, 0, 0));
    }
}