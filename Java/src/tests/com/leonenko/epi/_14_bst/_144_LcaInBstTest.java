package com.leonenko.epi._14_bst;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._14_bst._144_LcaInBst.findLca;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.*;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static org.assertj.core.api.Assertions.assertThat;

class _144_LcaInBstTest {

    private SimpleBinaryTreeNode<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = root(5,
                node(2,
                        node(2,
                                node(1),
                                node(3)),
                        node(3)),
                node(10,
                        node(7),
                        node(15,
                                node(12),
                                node(20,
                                        node(20,
                                                node(20),
                                                nil()),
                                        node(25)))));
    }

    @Test
    void testLindLca() {
        var lca = findLca(bst, bst.findNode(7), bst.findNode(12));

        assertThat(lca)
                .extracting(SimpleBinaryTreeNode::getKey)
                .isEqualTo(10);
    }
}