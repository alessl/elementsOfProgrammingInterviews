package com.leonenko.epi._16_dp;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._16_dp._169_PickUpCoinsForMaximumGain.getMaxValue;
import static org.assertj.core.api.Assertions.assertThat;

class _169_PickUpCoinsForMaximumGainTest {

    @Test
    void testGetMaxValue() {
        var coins = new int[] {5, 25, 10, 1};

        var maxRevenue = getMaxValue(coins,
                0, coins.length - 1, new int[coins.length][coins.length]);

        assertThat(maxRevenue).isEqualTo(26);
    }
}