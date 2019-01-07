package com.leonenko.epi._9_bintree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._9_bintree._97_IterativeInOrder.getKeysInOrder;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _97_IterativeInOrderTest {

    @Test
    void testInOrder() {
        var root = root(4,
                node(1,
                        node(0),
                        node(2)),
                node(6,
                        node(5),
                        node(7)));

        List<Integer> keysInOrder = getKeysInOrder(root);

        assertThat(keysInOrder).containsExactly(0, 1, 2, 4, 5, 6, 7);
    }
}