package com.leonenko.epi._11_search;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._11_search._114_IntSquareRoot.squareRootOf;
import static org.assertj.core.api.Assertions.assertThat;

class _114_IntSquareRootTest {

    @Test
    void testSquareRootOf() {
        assertThat(squareRootOf(9)).isEqualTo(3);
        assertThat(squareRootOf(25)).isEqualTo(5);
        assertThat(squareRootOf(0)).isEqualTo(0);
    }

}