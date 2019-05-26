package com.leonenko.epi._24_honor_TODO;

import com.leonenko.epi._7_list.ListNode;
import com.leonenko.epi._7_list.TestUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._24_honor_TODO._249_ListZipping.zip;


class _249_ListZippingTest {

    @Test
    void testZip() {
        assertZipped(
                ListNode.singlyLinkedListOf(List.of(1, 3, 5, 7, 6, 4, 2)),
                List.of(1, 2, 3, 4, 5, 6, 7));
        assertZipped(
                ListNode.singlyLinkedListOf(List.of(1, 3, 5, 7, 8, 6, 4, 2)),
                List.of(1, 2, 3, 4, 5, 6, 7, 8));
    }

    private void assertZipped(ListNode<Integer> unzipped, List<Integer> expectedZippedKeys) {
        TestUtils.assertListContainsKeys(zip(unzipped), expectedZippedKeys);
    }
}