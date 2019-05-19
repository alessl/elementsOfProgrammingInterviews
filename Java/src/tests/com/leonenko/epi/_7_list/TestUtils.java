package com.leonenko.epi._7_list;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtils {

    static void assertListContainsKeys(Iterable<Integer> list, List<Integer> keys) {
        assertThat(list).containsExactlyElementsOf(keys);
    }

    static void assertNotNull(Object list) {
        assertThat(list).isNotNull();
    }
}
