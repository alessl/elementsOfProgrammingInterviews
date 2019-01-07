package com.leonenko.epi._24_honor_TODO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionMatchingTest {

    @Test
    void simpleMatchWholeString() {
        assertTrue(_2426_RegularExpressionMatching_TODO.isMatch("abc", "abc"));
    }

    @Test
    void simpleMatchMiddleString() {
        assertTrue(_2426_RegularExpressionMatching_TODO.isMatch("abc", "aaaabccccc"));
    }

    @Test
    void simpleMatchWithStartEndAnchors() {
        assertTrue(_2426_RegularExpressionMatching_TODO.isMatch("^abc$", "abc"));
    }

    @Test
    void simpleMatchWithStartAnchor() {
        assertTrue(_2426_RegularExpressionMatching_TODO.isMatch("^abc", "abccc"));
    }

    @Test
    void simpleMatchWithEndAnchor() {
        assertTrue(_2426_RegularExpressionMatching_TODO.isMatch("abc$", "aaaabc"));
    }

    @Test
    void mismatchWithAnchors() {
        assertFalse(_2426_RegularExpressionMatching_TODO.isMatch("^abc$", "aaaabc"));
    }
}