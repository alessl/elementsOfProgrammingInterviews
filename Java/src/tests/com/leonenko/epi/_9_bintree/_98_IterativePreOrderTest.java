package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._9_bintree._98_IterativePreOrder.getKeysPreOrder;
import static com.leonenko.epi._9_bintree._98_IterativePreOrder.getKeysPreOrderWithNulls;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _98_IterativePreOrderTest {

    private SimpleBinaryTreeNode<Integer> root;

    @BeforeEach
    void setUp() {
        root = root(4,
                node(1,
                        node(0),
                        node(2)),
                node(6,
                        null,
                        node(5,
                                node(7),
                                null)));
    }

    @Test
    void testPreOrder() {
        assertThat(getKeysPreOrder(root)).containsExactly(4, 1, 0, 2, 6, 5, 7);
    }

    @Test
    void testPreOrderWithNulls() {
        assertThat(getKeysPreOrderWithNulls(root)).containsExactly(4, 1, 0, null, null, 2, null,
                null, 6, null, 5, 7, null, null, null);
    }

}