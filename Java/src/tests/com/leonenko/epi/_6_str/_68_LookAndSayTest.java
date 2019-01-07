package com.leonenko.epi._6_str;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._6_str._68_LookAndSay.lookAndSay;
import static org.assertj.core.api.Assertions.assertThat;

class _68_LookAndSayTest {

    @Test
    void testLookAndSay1() {
        var lookAndSayStr = lookAndSay(10);

        assertThat(lookAndSayStr).isEqualTo("13211311123113112211");
    }

    @Test
    void testLookAndSay2() {
        var lookAndSayStr = lookAndSay(5);

        assertThat(lookAndSayStr).isEqualTo("111221");
    }
}