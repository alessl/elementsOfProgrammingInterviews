package com.leonenko.epi._5_array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._5_array._54_AdvancingThroughArray.isEndReachable;
import static org.assertj.core.api.Assertions.assertThat;

class _54_AdvancingThroughArrayTest {

    @Test
    void testEndIsReachable() {
        assertThat(isEndReachable(List.of(3, 3, 1, 0, 2, 0, 1))).isTrue();
    }

    @Test
    void testEndIsNotReachable() {
        assertThat(isEndReachable(List.of(2, 0, 1, 0, 2, 0, 1))).isFalse();
    }
}