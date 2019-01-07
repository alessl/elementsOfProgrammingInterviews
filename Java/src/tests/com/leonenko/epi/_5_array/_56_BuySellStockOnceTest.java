package com.leonenko.epi._5_array;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._5_array._56_BuySellStockOnce.findBestBuySellDays;
import static com.leonenko.epi._5_array._56_BuySellStockOnce.getMaxProfit;
import static org.assertj.core.api.Assertions.assertThat;

class _56_BuySellStockOnceTest {

    @Test
    void testBuyFirstSellMiddle() {
        assertMaxProfitDays(List.of(5, 100, 105, 102), 0, 2);
    }

    @Test
    void testFindBuyFirstSellLast() {
        assertMaxProfitDays(List.of(5, 100, 105, 110), 0, 3);
    }

    @Test
    void testFindBuySecondSellLast() {
        assertMaxProfitDays(List.of(5, 1, 105, 110), 1, 3);
    }

    @Test
    void testFindBuyMiddleSellMiddle() {
        assertMaxProfitDays(List.of(5, 1, 120, 110), 1, 2);
    }

    @Test
    void testFindBuySecondToLastSellLast() {
        assertMaxProfitDays(List.of(1, 2, 0, 10), 2, 3);
    }

    @Test
    void testFindNoGoodBuySell() {
        assertMaxProfitDays(List.of(10, 7, 5, 1), 0, 0);
    }

    private void assertMaxProfitDays(List<Integer> prices,
                                     int expectedBuyDay,
                                     int expectedSellDay) {
        var actualBuySellDays = findBestBuySellDays(prices);
        var actualBuyDay = actualBuySellDays.getBuyDay();
        var actualSellDay = actualBuySellDays.getSellDay();

        assertThat(actualBuyDay).isEqualTo(expectedBuyDay);
        assertThat(actualSellDay).isEqualTo(expectedSellDay);

        var maxProfit = getMaxProfit(prices);

        assertThat(maxProfit).isEqualTo(prices.get(expectedSellDay) - prices.get(expectedBuyDay));
    }
}