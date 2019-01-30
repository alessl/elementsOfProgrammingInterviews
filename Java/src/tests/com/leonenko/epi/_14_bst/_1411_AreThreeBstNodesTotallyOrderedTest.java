package com.leonenko.epi._14_bst;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.*;
import static org.assertj.core.api.Assertions.assertThat;

class _1411_AreThreeBstNodesTotallyOrderedTest {

    private SimpleBinaryTreeNode<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = root(5,
                node(4,
                        node(2,
                                node(1),
                                node(3)),
                        nil()),
                node(10,
                        node(8),
                        node(15,
                                node(12),
                                node(20,
                                        node(17),
                                        node(25)))));
    }

    @Test
    void testIsOrdered() {
        assertIsOrdered(5, 4, 2);
        assertIsOrdered(5, 2, 3);
        assertIsOrdered(5, 20, 17);
        assertIsOrdered(5, 20, 25);
        assertIsOrdered(10, 15, 17);
    }

    @Test
    void testIsNotOrdered() {
        assertIsNotOrdered(5, 1, 4);
        assertIsNotOrdered(4, 2, 10);
        assertIsNotOrdered(10, 17, 25);
    }

    private void assertIsOrdered(int leftKey, int middleKey, int rightKey) {
        assertThat(isOrdered(leftKey, middleKey, rightKey)).isTrue();
    }

    private void assertIsNotOrdered(int leftKey, int middleKey, int rightKey) {
        assertThat(isOrdered(leftKey, middleKey, rightKey)).isFalse();
    }

    private boolean isOrdered(int leftKey, int middleKey, int rightKey) {
        var leftNode = bst.findNode(leftKey);
        var rightNode = bst.findNode(rightKey);
        var middleNode = bst.findNode(middleKey);
        return _1411_AreThreeBstNodesTotallyOrdered.isOrdered(leftNode, rightNode, middleNode);
    }
}