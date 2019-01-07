package com.leonenko.epi._16_dp_TODO;

import com.leonenko.epi._16_dp_TODO._166_Knapsack_TODO.KnapsackItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._16_dp_TODO._166_Knapsack_TODO.getMaxKnapsackValue;
import static org.assertj.core.api.Assertions.assertThat;

class _166_KnapsackTest {

    @Test
    void testGetMaxKnapsackValue() {
        var items = List.of(new KnapsackItem(60, 5),
                new KnapsackItem(50, 3),
                new KnapsackItem(70, 4),
                new KnapsackItem(30, 2));
        var maxCapacity = 5;

        int maxKnapsackValue = getMaxKnapsackValue(items, maxCapacity);

        assertThat(maxKnapsackValue).isEqualTo(80);
    }
}