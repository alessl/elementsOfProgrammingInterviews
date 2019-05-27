package com.leonenko.epi._7_list;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUtils {

    public static void assertListContainsKeys(Iterable<Integer> list,
            List<Integer> keys) {
        assertThat(list).containsExactlyElementsOf(keys);
    }

    public static void assertNotNull(Object list) {
        assertThat(list).isNotNull();
    }
}
