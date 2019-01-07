package com.leonenko.epi._8_stackqueue;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._8_stackqueue._83_IsStringWellFormed.isValid;
import static org.assertj.core.api.Assertions.assertThat;

// https://en.wikipedia.org/wiki/Bracket
class _83_IsStringWellFormed_Test {

    @Test
    void testEmptyStrIsValid() {
        assertThat(isValid("")).isTrue();
    }

//    round brackets = parentheses
    @Test
    void testParenStrIsValid() {
        assertThat(isValid("((()))")).isTrue();
        assertThat(isValid("()()()")).isTrue();
        assertThat(isValid("()()(())")).isTrue();
    }

//    curly brackets = braces
    @Test
    void testBracesStrIsValid() {
        assertThat(isValid("{{{}}}")).isTrue();
        assertThat(isValid("{}{}{}")).isTrue();
        assertThat(isValid("{}{}{{}}")).isTrue();
    }

//    square brackets == brackets
    @Test
    void testBracketsStrIsValid() {
        assertThat(isValid("[[[]]]")).isTrue();
        assertThat(isValid("[][][]")).isTrue();
        assertThat(isValid("[][][[]]")).isTrue();
    }

    @Test
    void testBalanceAllTypesOfBracketsStrIsValid() {
        assertThat(isValid("[]{}(){[()]}([[]])")).isTrue();
    }

    @Test
    void testParenStrIsInvalid() {
        assertThat(isValid("(}")).isFalse();
        assertThat(isValid("(]")).isFalse();
        assertThat(isValid("(")).isFalse();
        assertThat(isValid(")")).isFalse();
        assertThat(isValid("((")).isFalse();
        assertThat(isValid("))")).isFalse();
    }

    @Test
    void testBracesStrIsInvalid() {
        assertThat(isValid("{]")).isFalse();
        assertThat(isValid("{)")).isFalse();
        assertThat(isValid("{")).isFalse();
        assertThat(isValid("{(")).isFalse();
        assertThat(isValid(")")).isFalse();
        assertThat(isValid("))")).isFalse();
    }

    @Test
    void testBracketsStrIsInvalid() {
        assertThat(isValid("[)")).isFalse();
        assertThat(isValid("[}")).isFalse();
        assertThat(isValid("[[")).isFalse();
        assertThat(isValid("[")).isFalse();
        assertThat(isValid("]")).isFalse();
    }
}