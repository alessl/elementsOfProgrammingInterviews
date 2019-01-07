package com.leonenko.epi._11_search;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._11_search._115_RealSquareRoot.squareRoot;
import static org.assertj.core.api.Assertions.assertThat;

class _115_RealSquareRoot_Test {

    @Test
    void testSquareRoot() {
        assertThat(squareRoot(9.0)).isEqualTo(3.0);
        assertThat(squareRoot(25.0)).isBetween(4.99998, 5.0);
        assertThat(squareRoot(117.0)).isBetween(10.81, 10.817);
        assertThat(squareRoot(144.0)).isBetween(12.0, 12.0001);
    }

}