package com.leonenko.epi._16_dp_TODO;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.fill;

/**
 * Created by Alex on 5/7/2017.
 */
public class _166_Knapsack {

    static int getMaxKnapsackValue(List<KnapsackItem> items, int maxCapacity) {
        var cache = new int[items.size()][maxCapacity + 1];

        Arrays.stream(cache).forEach(a -> fill(a, -1));

        return getMaxKnapsackValue(items, items.size() - 1, maxCapacity, cache);
    }

    private static int getMaxKnapsackValue(List<KnapsackItem> items,
                                           int currItem,
                                           int availableCapacity,
                                           int[][] cache) {
        if (currItem < 0) {
            return 0;
        }

        if (cache[currItem][availableCapacity] == -1) {
            var noCurrItem = getMaxKnapsackValue(items, currItem - 1, availableCapacity, cache);
            var withCurrItem = noCurrItem;

            if (availableCapacity >= items.get(currItem).weight) {
                withCurrItem = items.get(currItem).value + getMaxKnapsackValue(
                        items,
                        currItem - 1,
                        availableCapacity - items.get(currItem).weight,
                        cache);
            }

            cache[currItem][availableCapacity] = Math.max(noCurrItem, withCurrItem);
        } else {
            System.out.println(String.format("Found in cache item=%s cap=%s", currItem, availableCapacity));
        }

        return cache[currItem][availableCapacity];
    }

    @Data
    static final class KnapsackItem {
        private final int value;
        private final int weight;
    }
}
