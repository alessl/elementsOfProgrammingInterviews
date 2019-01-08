package com.leonenko.epi._17_greedy;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._17_greedy._176_GasUp.findStartCity1;
import static com.leonenko.epi._17_greedy._176_GasUp.findStartCity2;
import static org.assertj.core.api.Assertions.assertThat;

class _176_GasUpTest {

    private static final int[] milesToNext = new int[]{900, 600, 200, 400, 600, 200, 100};
    private static final int[] gasVol = new int[]{50, 20, 5, 30, 25, 10, 10};
    private static final char[] cities = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};

    @Test
    void testFindStartCity1() {
        assertThat(findStartCity1(milesToNext, gasVol, cities)).isEqualTo('D');
    }

    @Test
    void testFindStartCity2() {
        assertThat(findStartCity2(milesToNext, gasVol, cities)).isEqualTo('D');
    }
}