package com.leonenko.epi._15_rec;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._15_rec._156_GenerateStringsOfMatchedParens.enumerateBalancedParentheses;
import static org.assertj.core.api.Assertions.assertThat;

class _156_GenerateStringsOfMatchedParensTest {

    @Test
    void testEnumerateBalancedParenthesesCombinations() {
        assertThat(enumerateBalancedParentheses(3))
                .containsExactly("((()))", "(()())", "(())()", "()(())", "()()()");

        assertThat(enumerateBalancedParentheses(1)).containsExactly("()");

        assertThat(enumerateBalancedParentheses(0)).isEmpty();
    }

}