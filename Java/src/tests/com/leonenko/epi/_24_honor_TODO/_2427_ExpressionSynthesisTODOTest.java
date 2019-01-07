package com.leonenko.epi._24_honor_TODO;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._24_honor_TODO._2427_ExpressionSynthesis_TODO.synthesizeExpression;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class _2427_ExpressionSynthesisTODOTest {

    @Test
    void testSynthesizeExpression1() {
        assertThat(synthesizeExpression("571", 571)).hasValue("571");
    }

    @Test
    void testSynthesizeExpression2() {
        assertThat(synthesizeExpression("5", 5)).hasValue("5");
    }

    @Test
    void testSynthesizeExpression3() {
        assertThat(synthesizeExpression("521", 7)).hasValue("5+2*1");
    }

    @Test
    void testSynthesizeExpression4() {
        assertThat(synthesizeExpression("521", 8)).hasValue("5+2+1");
    }

    @Test
    void testSynthesizeExpression5() {
        assertThat(synthesizeExpression("5321", 18)).hasValue("5*3+2+1");
    }

    @Test
    void testSynthesizeExpression6() {
        assertThat(synthesizeExpression("5321", 161)).hasValue("5*32+1");
    }
}