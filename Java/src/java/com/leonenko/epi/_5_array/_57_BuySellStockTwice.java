package com.leonenko.epi._5_array;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Alex on 5/8/2017.
 */
public class _57_BuySellStockTwice {

    static BuyAndSellDays findBestBuySellDays(List<Integer> prices) {
        var buySellDays = new BuyAndSellDays();

        var profit = Stream.generate(() -> 0)
                           .limit(prices.size())
                           .collect(Collectors.toList());

        findFirstPairOfDays(prices, profit, buySellDays);
        findSecondPairOfDays(prices, profit, buySellDays);

        return buySellDays;
    }

    private static void findFirstPairOfDays(List<Integer> prices,
                                            List<Integer> profit,
                                            BuyAndSellDays buySellDays) {
        var firstBuyDay = -1;
        var firstSellDay = -1;
        var minPriceDay = -1;
        var minPrice = Integer.MAX_VALUE;
        var maxProfit = Integer.MIN_VALUE;

        for (var i = 0; i < prices.size(); i++) {
            if (minPrice > prices.get(i)) {
                minPrice = prices.get(i);
                minPriceDay = i;
            }

            if (maxProfit < prices.get(i) - minPrice) {
                maxProfit = prices.get(i) - minPrice;
                firstBuyDay = minPriceDay;
                firstSellDay = i;
            }

            profit.set(i, maxProfit);
        }

        buySellDays.firstBuyDay = firstBuyDay;
        buySellDays.firstSellDay = firstSellDay;
    }

    private static void findSecondPairOfDays(List<Integer> prices,
                                             List<Integer> profit,
                                             BuyAndSellDays buySellDays) {
        var maxProfit = prices.get(buySellDays.firstSellDay) - prices.get(buySellDays.firstBuyDay);
        var secondBuyDay = -1;
        var secondSellDay = -1;
        var maxPriceDay = -1;
        var maxPrice = Integer.MIN_VALUE;

        for (var i = prices.size() - 1; i > 0; i--) {
            if (maxPrice < prices.get(i)) {
                maxPrice = prices.get(i);
                maxPriceDay = i;
            }

            var newProfit = maxPrice - prices.get(i) + profit.get(i - 1);

            if (maxProfit < newProfit) {
                maxProfit = newProfit;
                secondBuyDay = i;
                secondSellDay = maxPriceDay;
            }
        }

        buySellDays.secondBuyDay = secondBuyDay;
        buySellDays.secondSellDay = secondSellDay;
    }

    static int getMaxProfit(List<Integer> prices) {
        var maxProfit = 0;
        var firstBuySellProfits = new ArrayList<Integer>();
        var minPrice = Integer.MAX_VALUE;

        for (var price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
            firstBuySellProfits.add(maxProfit);
        }

        var maxPrice = Integer.MIN_VALUE;

        for (int i = prices.size() - 1; i > 0; i--) {
            maxPrice = Math.max(maxPrice, prices.get(i));
            maxProfit = Math.max(maxProfit,
                    maxPrice - prices.get(i) + firstBuySellProfits.get(i - 1));
        }

        return maxProfit;
    }

    @Data
    static final class BuyAndSellDays {
        private int firstBuyDay;
        private int firstSellDay;
        private int secondBuyDay;
        private int secondSellDay;

        private BuyAndSellDays() { }
    }
 }
