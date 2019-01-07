package com.leonenko.epi._15_rec_TODO;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._15_rec_TODO._157_GeneratePalindromicDecompositions.enumeratePalindromicDecompositions;
import static com.leonenko.epi._15_rec_TODO._157_GeneratePalindromicDecompositions.enumeratePalindromicSubStringsOfSameSize;
import static org.assertj.core.api.Assertions.assertThat;

class _157_GeneratePalindromicDecompositions_Test {

    @Test
    void testEnumeratePalindromicDecompositions1() {
        assertThat(enumeratePalindromicDecompositions("abbaca"))
                .containsExactly(List.of("a", "c", "a", "b", "b", "a"),
                        List.of("aca", "b", "b", "a"),
                        List.of("a", "c", "a", "bb", "a"),
                        List.of("aca", "bb", "a"),
                        List.of("a", "c", "abba"));
    }

    @Test
    void testEnumeratePalindromicDecompositions2() {
        assertThat(enumeratePalindromicDecompositions("abc"))
                .containsExactly(List.of("c", "b", "a"));
    }

    @Test
    void testEnumeratePalindromicSubStringsOfSameSize() {
        assertThat(enumeratePalindromicSubStringsOfSameSize("ccaabbaacc"))
                .containsExactly(List.of("c", "c", "a", "a", "b", "b", "a", "a", "c", "c"),
                        List.of("cc", "aa", "bb", "aa", "cc"),
                        List.of("ccaabbaacc"));
    }
}