package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._9_bintree._913_CreateTreeFromPreOrderWithMarkers.rebuildTreeFromPreOrderWithNulls;
import static com.leonenko.epi._9_bintree._97_IterativeInOrder.getKeysInOrder;
import static com.leonenko.epi._9_bintree._98_IterativePreOrder.getKeysPreOrder;
import static com.leonenko.epi._9_bintree._98_IterativePreOrder.getKeysPreOrderWithNulls;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _913_CreateTreeFromPreOrderWithMarkersTest {

    private SimpleBinaryTreeNode<Integer> root;
    private List<Integer> preOrderKeys;
    private List<Integer> inOrderKeys;

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

        preOrderKeys = getKeysPreOrder(root);
        inOrderKeys = getKeysInOrder(root);
    }

    @Test
    void testRebuildTreeFromPreOrder() {
        var preOrderKeysWithNulls = getKeysPreOrderWithNulls(root);

        var rebuiltRoot = rebuildTreeFromPreOrderWithNulls(preOrderKeysWithNulls);

        assertThat(rebuiltRoot).isNotNull();

        assertThat(getKeysPreOrder(rebuiltRoot)).containsExactlyElementsOf(preOrderKeys);
        assertThat(getKeysInOrder(rebuiltRoot)).containsExactlyElementsOf(inOrderKeys);
    }
}