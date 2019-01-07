package com.leonenko.epi._15_rec_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._15_rec_TODO._156_GenerateStringsOfMatchedParens.enumerateBalancedParentheses;
import static org.assertj.core.api.Assertions.assertThat;

class _156_GenerateStringsOfMatchedParens_Test {

    @Test
    void testEnumerateBalancedParenthesesCombinations() {
        assertThat(enumerateBalancedParentheses(3))
                .containsExactly("((()))", "(()())", "(())()", "()(())", "()()()");

        assertThat(enumerateBalancedParentheses(1)).containsExactly("()");

        assertThat(enumerateBalancedParentheses(0)).isEmpty();
    }

}