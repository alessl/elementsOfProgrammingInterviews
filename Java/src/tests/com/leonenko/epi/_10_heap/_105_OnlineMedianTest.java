package com.leonenko.epi._10_heap;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class _105_OnlineMedianTest {

    @Test
    void test() {
        var iterator = List.of(1, 0, 3, 5, 2, 0, 1).iterator();

        var onlineMedian = new _105_OnlineMedian(iterator);

        assertThat(onlineMedian.next()).hasValue(1);
        assertThat(onlineMedian.median()).hasValue(1);

        assertThat(onlineMedian.next()).hasValue(0);
        assertThat(onlineMedian.median()).hasValue(1);

        assertThat(onlineMedian.next()).hasValue(3);
        assertThat(onlineMedian.median()).hasValue(2);

        assertThat(onlineMedian.next()).hasValue(5);
        assertThat(onlineMedian.median()).hasValue(1);

        assertThat(onlineMedian.next()).hasValue(2);
        assertThat(onlineMedian.median()).hasValue(2);

        assertThat(onlineMedian.next()).hasValue(0);
        assertThat(onlineMedian.median()).hasValue(2);

        assertThat(onlineMedian.next()).hasValue(1);
        assertThat(onlineMedian.median()).hasValue(1);

        assertThat(onlineMedian.next()).isEmpty();
    }

}