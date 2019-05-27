package com.leonenko.epi._24_honor_TODO;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._24_honor_TODO._2413_BinaryTreePostOrderIter.walkPostOrder;
import static com.leonenko.epi._24_honor_TODO._2413_BinaryTreePostOrderIter.walkPostOrder2;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.*;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static org.assertj.core.api.Assertions.assertThat;

class _2413_BinaryTreePostOrderIterTest {

    private SimpleBinaryTreeNode<Integer> root;

    @BeforeEach
    void setUp() {
        root = root(11,
                node(5,
                        node(3,
                                node(1),
                                node(2)),
                        node(4)),
                node(10,
                        node(9),
                        node(8,
                                node(6),
                                node(7))));
    }

    @Test
    void testWalkPostOrder() {
        assertThat(walkPostOrder(root)).containsExactly(1, 2, 3, 4, 5, 9, 6, 7, 8, 10, 11);
    }

    @Test
    void testWalkPostOrder2() {
        assertThat(walkPostOrder2(root)).containsExactly(1, 2, 3, 4, 5, 9, 6, 7, 8, 10, 11);
    }
}