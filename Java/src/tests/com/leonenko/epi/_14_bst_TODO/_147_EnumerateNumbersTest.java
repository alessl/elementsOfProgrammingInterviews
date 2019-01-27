package com.leonenko.epi._14_bst_TODO;

import com.leonenko.epi._14_bst_TODO._147_EnumerateNumbers.ABSqrt2Number;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static com.leonenko.epi._14_bst_TODO._147_EnumerateNumbers.enumerateNumbersAdd;
import static com.leonenko.epi._14_bst_TODO._147_EnumerateNumbers.enumerateNumbersBst;
import static org.assertj.core.api.Assertions.assertThat;

class _147_EnumerateNumbersTest {

    @Test
    void testEnumerateNumbersBst() {
        List<String> numbers =
                enumerateNumbersBst(5).stream()
                                      .map(ABSqrt2Number::toString)
                                      .collect(Collectors.toList());
        assertThat(numbers).containsExactly(
                "0 + 0 * √2 = 0.00",
                "1 + 0 * √2 = 1.00",
                "0 + 1 * √2 = 1.41",
                "2 + 0 * √2 = 2.00",
                "1 + 1 * √2 = 2.41");
    }

    @Test
    void testEnumerateNumbersAdd() {
        List<String> numbers =
                enumerateNumbersAdd(5).stream()
                                      .map(ABSqrt2Number::toString)
                                      .collect(Collectors.toList());
        assertThat(numbers).containsExactly(
                "0 + 0 * √2 = 0.00",
                "1 + 0 * √2 = 1.00",
                "0 + 1 * √2 = 1.41",
                "2 + 0 * √2 = 2.00",
                "1 + 1 * √2 = 2.41");
    }
}