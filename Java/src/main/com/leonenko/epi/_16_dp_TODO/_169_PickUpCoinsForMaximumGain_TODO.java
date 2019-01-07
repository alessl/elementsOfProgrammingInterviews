package com.leonenko.epi._16_dp_TODO;

/**
 * Created by Alex on 5/7/2017.
 */
public class _169_PickUpCoinsForMaximumGain_TODO {

    static int getMaxValue(int[] coins, int start, int end, int[][] cache) {
        if (start > end) {
            return 0;
        }

        if (cache[start][end] == 0) {
            var valueWithStartCoin =
                    coins[start] + Math.min(getMaxValue(coins, start + 2, end, cache),
                            getMaxValue(coins, start + 1, end - 1, cache));

            var valueWithEndCoin =
                    coins[end] + Math.min(getMaxValue(coins, start + 1, end - 1, cache),
                            getMaxValue(coins, start, end - 2, cache));

            cache[start][end] = Math.max(valueWithStartCoin, valueWithEndCoin);
        }

        return cache[start][end];
    }
}
