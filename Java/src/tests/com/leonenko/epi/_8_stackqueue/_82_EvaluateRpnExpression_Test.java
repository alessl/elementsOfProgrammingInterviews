package com.leonenko.epi._8_stackqueue;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._8_stackqueue._82_EvaluateRpnExpression.evaluateExpression;
import static org.assertj.core.api.Assertions.assertThat;

class _82_EvaluateRpnExpression_Test {

    @Test
    void testEvaluateExpression() {
        assertThat(evaluateExpression("3 4 + 2 * 2 +")).isEqualTo(16);
    }
}