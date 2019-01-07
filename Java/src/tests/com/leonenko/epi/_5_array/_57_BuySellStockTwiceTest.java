package com.leonenko.epi._5_array;

import com.leonenko.epi._5_array._57_BuySellStockTwice.BuyAndSellDays;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._5_array._57_BuySellStockTwice.findBestBuySellDays;
import static com.leonenko.epi._5_array._57_BuySellStockTwice.getMaxProfit;

class _57_BuySellStockTwiceTest {

    @Test
    void testGetBuyAndSellDays() {
        var prices = List.of(1, 100, 2, 104, 0, 500, 5);

        BuyAndSellDays buyAndSellDays = findBestBuySellDays(prices);

        int maxProfit = getMaxProfit(prices);

        System.out.println();
    }

    /*public static void main(String[] args) {


        var profit = Stream.generate(() -> 0)
                           .limit(stock.size())
                           .collect(Collectors.toList());

        var firstBuyDay = -1;
        var firstSellDay = -1;
        var minPriceDay = -1;
        var minPrice = Integer.MAX_VALUE;
        var maxProfit = Integer.MIN_VALUE;

        for (int i = 0; i < stock.size(); i++) {
            if (minPrice > stock.get(i)) {
                minPrice = stock.get(i);
                minPriceDay = i;
            }

            if (maxProfit < stock.get(i) - minPrice) {
                maxProfit = stock.get(i) - minPrice;
                firstBuyDay = minPriceDay;
                firstSellDay = i;
            }

            profit.set(i, maxProfit);
        }

        var secondBuyDay = -1;
        var secondSellDay = -1;
        var maxPriceDay = -1;
        var maxPrice = Integer.MIN_VALUE;

        for (var i = stock.size() - 1; i > 0; i--) {
            if (maxPrice < stock.get(i)) {
                maxPrice = stock.get(i);
                maxPriceDay = i;
            }

            var newProfit = maxPrice - stock.get(i) + profit.get(i - 1);

            if (maxProfit < newProfit) {
                maxProfit = newProfit;
                secondBuyDay = i;
                secondSellDay = maxPriceDay;
            }
        }

        System.out.printf(
                "buy on %s [%s], sell on %s [%s], profit %s%n",
                firstBuyDay, stock.get(firstBuyDay), firstSellDay, stock.get(firstSellDay), maxProfit);
        System.out.printf(
                "buy on %s [%s], sell on %s [%s], profit %s%n",
                secondBuyDay, stock.get(secondBuyDay), secondSellDay, stock.get(secondSellDay), maxProfit);

        System.out.println("Max profit: " + getMaxProfit(stock));
    }*/
}