package com.leonenko.epi._24_honor_TODO;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class _2426_RegularExpressionMatchingTest {

    @Test
    void testIsMatch() {
        assertMatch("a", "a");
        assertMatch("abc", "abc");
        assertMatch("ab.", "abb");
        assertMatch("ab.c", "abbc");
        assertMatch("abc*", "abccc");
        assertMatch("abc*.", "abccc");
        assertMatch("abc*.", "abcccd");
        assertMatch(".*.*c", "aaaac");
        assertMatch(".*.*c", "aabc");
        assertMatch(".*", "aaaaaa");

        assertMatch("aa$", "aa");
        assertMatch("^aab", "aab");
        assertMatch("^aab$", "aab");

        assertMatch("^aa", "aacc");
        assertMatch("aab$", "ccaab");
    }

    @Test
    void testIsNotMatch() {
        assertMismatch("a", "b");
        assertMismatch("abc", "ab");
        assertMismatch("^aab$", "aabc");
        assertMismatch("aab$", "aabc");
        assertMismatch("aab$a", "aaba");
    }

    private static void assertMatch(String regex, String str) {
        assertThat(_2426_RegularExpressionMatching.isMatch(regex, str)).isTrue();
        assertThat(_2426_RegularExpressionMatching.isMatchDP(regex, str)).isTrue();
    }

    private static void assertMismatch(String regex, String str) {
        assertThat(_2426_RegularExpressionMatching.isMatch(regex, str)).isFalse();
        assertThat(_2426_RegularExpressionMatching.isMatchDP(regex, str)).isFalse();
    }
}