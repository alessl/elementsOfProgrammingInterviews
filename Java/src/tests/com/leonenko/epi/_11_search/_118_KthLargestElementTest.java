package com.leonenko.epi._11_search;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.leonenko.epi._11_search._118_KthLargestElement.findKLargestElement;
import static com.leonenko.epi._11_search._118_KthLargestElement.findKLargestElementWithDuplicates;
import static org.assertj.core.api.Assertions.assertThat;

class _118_KthLargestElementTest {

    private List<String> list;

    @Test
    void testFindKLargestElement() {
        list = new ArrayList<>(List.of("1", "2", "3", "4", "5", "6", "7"));

        assertThat(doFindKLargestElement(3)).isEqualTo("5");
        assertThat(doFindKLargestElement(5)).isEqualTo("3");
        assertThat(doFindKLargestElement(7)).isEqualTo("1");
        assertThat(doFindKLargestElement(1)).isEqualTo("7");
        assertThat(doFindKLargestElement(8)).isNull();
    }

    private String doFindKLargestElement(int k) {
        Collections.shuffle(list);

        return findKLargestElement(list, k);
    }

    @Test
    void testFindKLargestElementWithDuplicates() {
        list = new ArrayList<>(List.of("1", "2", "3", "3", "4", "5", "5", "5", "5", "6", "7", "7"));

//        assertThat(doFindKLargestElementWithDuplicates(3)).isEqualTo("3");

        assertThat(doFindKLargestElementWithDuplicates(4)).isEqualTo("3");
    }

    private String doFindKLargestElementWithDuplicates(int k) {
        Collections.shuffle(list);

        return findKLargestElementWithDuplicates(list, k);
    }
}