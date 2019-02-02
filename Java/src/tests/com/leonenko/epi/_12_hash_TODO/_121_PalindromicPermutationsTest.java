package com.leonenko.epi._12_hash_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._12_hash_TODO._121_PalindromicPermutations.isPalindromePossible;
import static org.assertj.core.api.Assertions.assertThat;

class _121_PalindromicPermutationsTest {

    @Test
    void testIsPalindromePossible() {
        assertThat(isPalindromePossible("a")).isTrue();
        assertThat(isPalindromePossible("aa")).isTrue();
        assertThat(isPalindromePossible("aaa")).isTrue();
        assertThat(isPalindromePossible("abab")).isTrue();
        assertThat(isPalindromePossible("abcba")).isTrue();
    }

    @Test
    void testIsNotPalindromePossible() {
        assertThat(isPalindromePossible("ab")).isFalse();
        assertThat(isPalindromePossible("aaab")).isFalse();
        assertThat(isPalindromePossible("ababbc")).isFalse();
    }
}