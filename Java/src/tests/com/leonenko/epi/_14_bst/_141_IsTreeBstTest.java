package com.leonenko.epi._14_bst;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._14_bst._141_IsTreeBst.isBst;
import static com.leonenko.epi._14_bst._141_IsTreeBst.isBst2;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _141_IsTreeBstTest {

    private SimpleBinaryTreeNode<Integer> bst;
    private SimpleBinaryTreeNode<Integer> notBst;

    @BeforeEach
    void setUp() {
        bst = root(5,
                node(2,
                        node(1),
                        node(3)),
                node(10,
                        node(7),
                        node(15,
                                node(12),
                                node(20))));
        notBst = root(5,
                node(2,
                        node(1),
                        node(11)),
                node(10,
                        node(7),
                        node(15,
                                node(12),
                                node(20))));
    }

    @Test
    void testIsBst() {
        assertThat(isBst(bst)).isTrue();
    }

    @Test
    void testIsNotBst() {
        assertThat(isBst(notBst)).isFalse();
    }

    @Test
    void testIsBst2() {
        assertThat(isBst2(bst)).isTrue();
    }

    @Test
    void testIsNotBst2() {
        assertThat(isBst2(notBst)).isFalse();
    }
}