package com.leonenko.epi._6_str;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._6_str._65_TestPalindromicity.isPalindrome;
import static org.assertj.core.api.Assertions.assertThat;

class _65_TestPalindromicityTest {

    @Test
    void testIsPalindromeEven() {
        assertThat(isPalindrome("aa")).isTrue();
    }

    @Test
    void testIsPalindromeOdd() {
        assertThat(isPalindrome("aba")).isTrue();
    }

    @Test
    void testIsPalindromeComplex() {
        assertThat(isPalindrome("cababac")).isTrue();
    }

    @Test
    void testIsNotPalindrome() {
        assertThat(isPalindrome("ab")).isFalse();
    }
}