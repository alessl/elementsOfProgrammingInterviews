package com.leonenko.epi._8_stackqueue;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._8_stackqueue._87_ComputeBinaryTreeNodesInOrderOfIncDepth.getKeysByLevels;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _87_ComputeBinaryTreeNodesInOrderOfIncDepth_Test {

    @Test
    void testGetKeysByLevels() {
        SimpleBinaryTreeNode<Integer> root =
                root(1,
                        node(2,
                                node(3,
                                        node(4),
                                        null),
                                node(3)),
                        node(2,
                                node(3,
                                        null,
                                        node(4)),
                                null));

        List<List<Integer>> keysByLevels = getKeysByLevels(root);

        assertThat(keysByLevels).containsExactly(List.of(1),
                List.of(2, 2), List.of(3, 3, 3), List.of(4, 4));
    }

}