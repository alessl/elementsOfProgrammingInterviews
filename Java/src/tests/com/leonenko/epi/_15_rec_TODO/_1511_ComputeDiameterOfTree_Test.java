package com.leonenko.epi._15_rec_TODO;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._15_rec_TODO._1511_ComputeDiameterOfTree.diameter;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _1511_ComputeDiameterOfTree_Test {

    private SimpleBinaryTreeBuilders.SimpleBinaryTreeNodeBuilder<Integer> longSubTree;
    private SimpleBinaryTreeBuilders.SimpleBinaryTreeNodeBuilder<Integer> shortSubTree;

    @BeforeEach
    public void setUp() {
        longSubTree = node(10,
                node(8,
                        node(5,
                                node(6,
                                        null,
                                        node(7)),
                                null),
                        node(9)),
                node(20,
                        node(15),
                        node(25,
                                node(22),
                                null)));
        shortSubTree = node(2);
    }

    @Test
    void testDiameterViaRoot() {
        var root = root(4, longSubTree, longSubTree);

        assertThat(diameter(root)).isEqualTo(11);
    }

    @Test
    void testDiameterInRightSubTree() {
        var root = root(4, shortSubTree, longSubTree);

        assertThat(diameter(root)).isEqualTo(8);
    }

    @Test
    void testDiameterInLeftSubTree() {
        var root = root(4, longSubTree, shortSubTree);

        assertThat(diameter(root)).isEqualTo(8);
    }

}