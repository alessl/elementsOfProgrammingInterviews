package com.leonenko.epi._12_hash_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._12_hash_TODO._122_IsAnonymousLetterPossible.isAnonymousLetterPossible;
import static org.assertj.core.api.Assertions.assertThat;

class _122_IsAnonymousLetterPossibleTest {

    @Test
    void testIsAnonymousLetterPossible() {
        assertThat(isAnonymousLetterPossible("abc", "abc")).isTrue();
        assertThat(isAnonymousLetterPossible("abc", "aaaabbbbc")).isTrue();
        assertThat(isAnonymousLetterPossible("aabbcc", "aabbcc")).isTrue();
        assertThat(isAnonymousLetterPossible("aabbcc", "aaabbbccc")).isTrue();
    }

    @Test
    void testIsNotAnonymousLetterPossible() {
        assertThat(isAnonymousLetterPossible("abc", "ab")).isFalse();
        assertThat(isAnonymousLetterPossible("abc", "ac")).isFalse();
        assertThat(isAnonymousLetterPossible("aabbcc", "aabcc")).isFalse();
        assertThat(isAnonymousLetterPossible("aabbcc", "bbcc")).isFalse();
    }
}