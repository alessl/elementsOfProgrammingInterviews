package com.leonenko.epi._16_dp;

import com.leonenko.epi._16_dp._166_Knapsack.KnapsackItem;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._16_dp._166_Knapsack.getMaxKnapsackValue;
import static org.assertj.core.api.Assertions.assertThat;

class _166_KnapsackTest {

    @Test
    void testGetMaxKnapsackValue() {
        var items = List.of(new KnapsackItem(60, 5),
                new KnapsackItem(50, 3),
                new KnapsackItem(40, 1),
                new KnapsackItem(70, 4),
                new KnapsackItem(30, 2),
                new KnapsackItem(20, 1));
        var maxCapacity = 5;

        int maxKnapsackValue = getMaxKnapsackValue(items, maxCapacity);

        assertThat(maxKnapsackValue).isEqualTo(110);
    }
}