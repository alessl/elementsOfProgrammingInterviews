package com.leonenko.epi._6_str;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class _66_ReverseAllWordsInSentenceTest {

    @Test
    void testReverseWords() {
        char[] sentence = "The pizza with extra cheese and meatballs is the best".toCharArray();

        _66_ReverseAllWordsInSentence.reverseWords(sentence);

        assertThat(String.copyValueOf(sentence))
                .isEqualTo("best the is meatballs and cheese extra with pizza The");
    }
}