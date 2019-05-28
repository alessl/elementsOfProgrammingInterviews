package com.leonenko.epi._24_honor_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._24_honor_TODO._2411_LongestSubStrWithMatchingParens.getLongestValidSubStr;
import static org.assertj.core.api.Assertions.assertThat;

class _2411_LongestSubStrWithMatchingParensTest {

    @Test
    void testGetLongestValidSubStr() {
        assertLongestValidSubStr("(()((())((())()", "(())()");
        assertLongestValidSubStr("(())()", "(())()");
        assertLongestValidSubStr("(()))()", "(())");
    }

    private static void assertLongestValidSubStr(String str, String expectedSubStr) {
        var subStr = getLongestValidSubStr(str);

        assertThat(subStr).isEqualTo(expectedSubStr);
    }
}