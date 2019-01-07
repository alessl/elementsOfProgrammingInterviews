package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._9_bintree._912_CreateTreeFromTraversal.rebuildTree;
import static com.leonenko.epi._9_bintree._97_IterativeInOrder.getKeysInOrder;
import static com.leonenko.epi._9_bintree._98_IterativePreOrder.getKeysPreOrder;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _912_CreateTreeFromTraversalTest {

    private SimpleBinaryTreeNode<Integer> root;

    @BeforeEach
    void setUp() {
        root = root(2,
                node(3,
                        node(5),
                        node(4)),
                node(1,
                        node(6,
                                node(7),
                                node(8)),
                        node(9)));
    }

    @Test
    void testRebuildTree() {
        var inOrderKeys = getKeysInOrder(root);
        var preOrderKeys = getKeysPreOrder(root);

        var rebuiltRoot = rebuildTree(preOrderKeys, inOrderKeys);

        assertThat(rebuiltRoot).isNotNull();
        assertThat(rebuiltRoot.getKey()).isEqualTo(root.getKey());
        assertThat(getKeysInOrder(rebuiltRoot)).containsExactlyElementsOf(inOrderKeys);
        assertThat(getKeysPreOrder(rebuiltRoot)).containsExactlyElementsOf(preOrderKeys);
    }

}