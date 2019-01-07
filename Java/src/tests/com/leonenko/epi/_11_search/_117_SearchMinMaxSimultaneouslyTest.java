package com.leonenko.epi._11_search;

import com.leonenko.epi._11_search._117_SearchMinMaxSimultaneously.MinMax;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._11_search._117_SearchMinMaxSimultaneously.findMinMax;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class _117_SearchMinMaxSimultaneouslyTest {

    @Test
    void testFindMinMaxSimple1() {
        MinMax minMax = findMinMax(List.of(10, 1));

        assertThat(minMax.getMin()).isEqualTo(1);
        assertThat(minMax.getMax()).isEqualTo(10);
    }

    @Test
    void testFindMinMaxSimple2() {
        MinMax minMax = findMinMax(List.of(1, 10));

        assertThat(minMax.getMin()).isEqualTo(1);
        assertThat(minMax.getMax()).isEqualTo(10);
    }

    @Test
    void testFindMinMax() {
        MinMax minMax = findMinMax(List.of(10, 5, 15, 6, 7, 2, 1, 20));

        assertThat(minMax.getMin()).isEqualTo(1);
        assertThat(minMax.getMax()).isEqualTo(20);
    }

}