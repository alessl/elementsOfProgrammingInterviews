package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._9_bintree._95_SumOfRootToLeafPaths.getRootToLeafPathsAsNumbers;
import static com.leonenko.epi._9_bintree._95_SumOfRootToLeafPaths.getSumOfPaths;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _95_SumOfRootToLeafPathsTest {

    private SimpleBinaryTreeNode<Integer> root;

    @BeforeEach
    void setUp() {
        root = root(1,
                node(2,
                        node(3,
                                node(4),
                                node(5)),
                        node(7)),
                node(12));
    }

    @Test
    void testGetSumOfPathsAsNumbers() {
        assertThat(getSumOfPaths(root)).isEqualTo(2618);
    }

    @Test
    void testGetRootToLeafPathsAsNumbers() {
        assertThat(getRootToLeafPathsAsNumbers(root)).containsExactly(1234, 1235, 127, 22);
    }
}