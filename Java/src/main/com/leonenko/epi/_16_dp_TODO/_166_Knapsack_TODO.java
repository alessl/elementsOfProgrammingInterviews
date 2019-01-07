package com.leonenko.epi._16_dp_TODO;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.fill;

/**
 * Created by Alex on 5/7/2017.
 */
public class _166_Knapsack_TODO {

    static int getMaxKnapsackValue(List<KnapsackItem> items, int maxCapacity) {
        var cache = new int[items.size()][maxCapacity + 1];

        Arrays.stream(cache).forEach(a -> fill(a, -1));

        return getMaxKnapsackValue(items, items.size() - 1, maxCapacity, cache);
    }

    private static int getMaxKnapsackValue(List<KnapsackItem> items,
                                           int currItem,
                                           int maxCapacity,
                                           int[][] cache) {
        if (currItem < 0) {
            return 0;
        }

        if (cache[currItem][maxCapacity] == -1) {
            var noCurrItem = getMaxKnapsackValue(items, currItem - 1, maxCapacity, cache);
            var withCurrItem = noCurrItem;

            if (maxCapacity >= items.get(currItem).weight) {
                withCurrItem = items.get(currItem).value + getMaxKnapsackValue(
                        items,
                        currItem - 1,
                        maxCapacity - items.get(currItem).weight,
                        cache);
            }

            cache[currItem][maxCapacity] = Math.max(noCurrItem, withCurrItem);
        }

        return cache[currItem][maxCapacity];
    }

    @Data
    static final class KnapsackItem {
        private final int value;
        private final int weight;
    }
}
