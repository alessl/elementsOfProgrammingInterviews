package com.leonenko.epi._5_array;

import lombok.Data;

import java.util.List;

/**
 * Created by Alex on 5/8/2017.
 */
public class _56_BuySellStockOnce {

    static int getMaxProfit(List<Integer> prices) {
        var minPrice = prices.get(0);
        var maxProfit = 0;

        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }

    static BuySellDays findBestBuySellDays(List<Integer> prices) {
        var buyDay = 0;
        var sellDay = 0;
        var minPriceDay = 0;

        for (var day = 1; day < prices.size(); day++) {
            if (prices.get(minPriceDay) > prices.get(day)) {
                minPriceDay = day;
            } else {
                var maxProfit = prices.get(sellDay) - prices.get(buyDay);
                var currProfit = prices.get(day) - prices.get(minPriceDay);

                if (maxProfit < currProfit) {
                    buyDay = minPriceDay;
                    sellDay = day;
                }
            }
        }

        return new BuySellDays(buyDay, sellDay);
    }

    @Data
    static final class BuySellDays {
        private final int buyDay;
        private final int sellDay;
    }
}
