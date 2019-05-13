package com.leonenko.epi._7_list_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._7_list_TODO.TestUtils.assertListContainsKeys;

class _713_AddListIntegersTest {

    @Test
    void sumReversed_NoCarry() {
        var firstNum = ListNode.generateList(List.of(3, 2, 1));
        var secondNum = ListNode.generateList(List.of(3, 2, 1));

        var sum = _713_AddListIntegers.sumReversed(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(6, 4, 2));
    }

    @Test
    void sumReversed_WithCarry() {
        var firstNum = ListNode.generateList(List.of(9, 2, 1));
        var secondNum = ListNode.generateList(List.of(3, 7, 1));

        var sum = _713_AddListIntegers.sumReversed(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(2, 0, 3));
    }

    @Test
    void sumReversed_WithCarryToNewPlace() {
        var firstNum = ListNode.generateList(List.of(1, 0, 1));
        var secondNum = ListNode.generateList(List.of(9, 9, 8));

        var sum = _713_AddListIntegers.sumReversed(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(0, 0, 0, 1));
    }

    @Test
    void sumReversed_DifferentLengthNumbers() {
        var firstNum = ListNode.generateList(List.of(1, 1));
        var secondNum = ListNode.generateList(List.of(2, 2, 3));

        var sum = _713_AddListIntegers.sumReversed(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(3, 3, 3));
    }

    @Test
    void sum_NoCarry() {
        var firstNum = ListNode.generateList(List.of(1, 2, 3));
        var secondNum = ListNode.generateList(List.of(1, 2, 3));

        var sum = _713_AddListIntegers.sum(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(2, 4, 6));
    }

    @Test
    void sum_WithCarry() {
        var firstNum = ListNode.generateList(List.of(1, 2, 9));
        var secondNum = ListNode.generateList(List.of(1, 7, 3));

        var sum = _713_AddListIntegers.sum(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(3, 0, 2));
    }

    @Test
    void sum_WithCarryToNewPlace() {
        var firstNum = ListNode.generateList(List.of(1, 0, 1));
        var secondNum = ListNode.generateList(List.of(8, 9, 9));

        var sum = _713_AddListIntegers.sum(firstNum, secondNum);

        assertListContainsKeys(sum, List.of(1, 0, 0, 0));
    }
}