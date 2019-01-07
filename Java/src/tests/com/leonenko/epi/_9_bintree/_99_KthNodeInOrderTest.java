package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._9_bintree._99_KthNodeInOrder.getKthNode;
import static com.leonenko.epi._9_bintree._99_KthNodeInOrder.getTopKNodes;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _99_KthNodeInOrderTest {

    private SimpleBinaryTreeNode<Integer> root;

    @BeforeEach
    void setUp() {
        root = root(4,
                        node(1,
                             node(0),
                             node(2)),
                        node(6,
                             node(5),
                             node(7)));
    }

    @Test
    void testGetFirstLargest() {
        assertKthLargestNode(1, 0);
    }

    @Test
    void testGetKLastLargest() {
        assertKthLargestNode(7, 7);
    }

    @Test
    void testGetKMiddleLargest() {
        assertKthLargestNode(4, 4);
    }

    @Test
    void testGetKLargestIndexOutOfRange() {
        assertThat(getKthNode(root, 20)).isEmpty();
    }

    private void assertKthLargestNode(int k, int expectedKey) {
        assertThat(getKthNode(root, k)).hasValue(expectedKey);
    }

    @Test
    void testGetKLargestNodes() {
        assertThat(getTopKNodes(root, 3)).containsExactly(7, 6, 5);
    }

}