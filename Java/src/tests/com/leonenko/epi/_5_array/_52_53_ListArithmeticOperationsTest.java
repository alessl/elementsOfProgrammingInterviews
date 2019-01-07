package com.leonenko.epi._5_array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._5_array._52_53_ListArithmeticOperations.increment;
import static com.leonenko.epi._5_array._52_53_ListArithmeticOperations.multiply;
import static org.assertj.core.api.Assertions.assertThat;

class _52_53_ListArithmeticOperationsTest {

    @Test
    void testIncrementSimple() {
        var incrementedNumber = increment(List.of(1, 2, 2));

        assertThat(incrementedNumber).containsExactly(1, 2, 3);
    }

    @Test
    void testIncrementWithCarry() {
        List<Integer> number = List.of(1, 2, 9);

        assertThat(increment(number)).containsExactly(1, 3, 0);
    }

    @Test
    void testIncrementWithCarryToBeginning() {
        var incrementedNumber = increment(List.of(9, 9, 9, 9, 9));

        assertThat(incrementedNumber).containsExactly(1, 0, 0, 0, 0, 0);
    }

    @Test
    void testMultiplyOneDigitNumbers() {
        var product = multiply(List.of(2), List.of(5));

        assertThat(product).containsExactly(10);
    }

    @Test
    void testMultiplyMultiDigitNumbers() {
        var product = multiply(List.of(2, 2, 5), List.of(4, 9, 5));

        assertThat(product).containsExactly(1, 1, 1, 3, 7, 5);
    }

    @Test
    void testMultiplyMultiDigitNumbersWithEmptyFrontDigits() {
        var product = multiply(List.of(2, 0, 0), List.of(4, 0, 0));

        assertThat(product).containsExactly(8, 0, 0, 0, 0);
    }

    @Test
    void testMultiplyDifferentLengthMultiDigitNumbers() {
        var product = multiply(List.of(2, 1), List.of(4, 9, 5, 2));

        assertThat(product).containsExactly(1, 0, 3, 9, 9, 2);
    }

    @Test
    void testMultiplyNonZeroByZero() {
        var product = multiply(List.of(0), List.of(1, 2, 3));

        assertThat(product).containsExactly(0);
    }
}