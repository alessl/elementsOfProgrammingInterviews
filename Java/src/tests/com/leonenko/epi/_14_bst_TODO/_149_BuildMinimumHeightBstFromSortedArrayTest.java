package com.leonenko.epi._14_bst_TODO;

import com.leonenko.epi._9_bintree._97_IterativeInOrder;
import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._14_bst_TODO._149_BuildMinimumHeightBstFromSortedArray.*;
import static org.assertj.core.api.Assertions.assertThat;

class _149_BuildMinimumHeightBstFromSortedArrayTest {

    @Test
    void testBuildMinHeightBst() {
        List<Integer> sortedList = List.of(1, 2, 3, 4, 5, 6, 7, 8);

        SimpleBinaryTreeNode<Integer> bst = buildMinHeightBst(sortedList);
        System.out.println(bst);

        List<Integer> keysInOrder = _97_IterativeInOrder.getKeysInOrder(bst);

        assertThat(keysInOrder).containsExactlyElementsOf(sortedList);
    }
}