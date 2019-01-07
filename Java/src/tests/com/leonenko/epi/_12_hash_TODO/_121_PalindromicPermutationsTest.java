package com.leonenko.epi._12_hash_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._12_hash_TODO._121_PalindromicPermutations_TODO.isPalindromePossible;
import static org.assertj.core.api.Assertions.assertThat;

class _121_PalindromicPermutationsTest {
    @Test
    void palindromeIsPossibleWithEvenCharCount() {
        assertThat(isPalindromePossible("aa")).isTrue();
    }

    @Test
    void palindromeIsPossibleWithOddCharCount() {
        assertThat(isPalindromePossible("aac")).isTrue();
    }

    @Test
    void palindromeIsNotPossible() {
        assertThat(isPalindromePossible("abc")).isFalse();
    }
}
