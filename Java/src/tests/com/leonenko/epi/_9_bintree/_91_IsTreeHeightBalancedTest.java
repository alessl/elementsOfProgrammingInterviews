package com.leonenko.epi._9_bintree;

import org.junit.jupiter.api.Test;

import static com.leonenko.epi._9_bintree._91_IsTreeHeightBalanced.isBalanced;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _91_IsTreeHeightBalancedTest {

    @Test
    void testIsBalancedZeroHeightDiff() {
        var root = root(5,
                node(10,
                        node(20),
                        node(8)),
                node(100,
                        node(50),
                        node(200)));
        var isBalanced = isBalanced(root);

        assertThat(isBalanced).isTrue();
    }

    @Test
    void testIsBalancedHeightDiffEqualToOne() {
        var root = root(5,
                node(10,
                        node(20),
                        node(8,
                                node(1),
                                node(7))),
                node(100,
                        node(50),
                        node(200)));
        var isBalanced = isBalanced(root);

        assertThat(isBalanced).isTrue();
    }

    @Test
    void testIsBalancedOnlyOneNodeTree() {
        var root = root(0, null, null);
        var isBalanced = isBalanced(root);

        assertThat(isBalanced).isTrue();
    }

    @Test
    void testIsUnbalancedHeightDiffGreaterThanOne() {
        var root = root(5,
                node(10,
                        node(20,
                                node(15),
                                node(30,
                                        node(40),
                                        node(2))),
                        node(8)),
                node(100,
                        node(50),
                        node(200)));
        var isBalanced = isBalanced(root);

        assertThat(isBalanced).isFalse();
    }
}