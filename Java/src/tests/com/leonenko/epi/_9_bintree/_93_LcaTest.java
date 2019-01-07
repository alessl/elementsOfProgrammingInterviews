package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._9_bintree._93_Lca.lca;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _93_LcaTest {

    private SimpleBinaryTreeNode<Integer> root;

    @BeforeEach
    void setUp() {
        root = root(5,
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
    }

    @Test
    void testFindLcaNodesInDifferentSubtrees() {
        var expectedLca = root.findNode(20);
        var firstNode = expectedLca.findNode(15);
        var secondNode = expectedLca.findNode(2);

        var foundLca = lca(root, firstNode, secondNode);

        assertThat(foundLca).isNotNull();
        assertThat(foundLca).isSameAs(expectedLca);
    }

    @Test
    void testFindLcaNodesInSameSubtree() {
        var expectedLca = root.findNode(20);
        var firstNode = expectedLca.findNode(15);
        var secondNode = expectedLca;

        var foundLca = lca(root, firstNode, secondNode);

        assertThat(foundLca).isNotNull();
        assertThat(foundLca).isSameAs(expectedLca);
    }

    @Test
    void testFindLcaRoot() {
        var expectedLca = root.findNode(5);
        var firstNode = expectedLca.findNode(50);
        var secondNode = expectedLca.findNode(2);

        var foundLca = lca(root, firstNode, secondNode);

        assertThat(foundLca).isNotNull();
        assertThat(foundLca).isSameAs(expectedLca);
    }

    @Test
    void testFindLcaNotFound() {
        var foundLca = lca(root, root.findNode(50), root(10000));

        assertThat(foundLca).isNull();
    }
}