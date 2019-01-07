package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.ParentLinkBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._9_bintree._94_LcaWithParentLinks.lca;
import static com.leonenko.epi.common.binarytree.ParentLinkBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.ParentLinkBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _94_LcaWithParentLinksTest {

    private ParentLinkBinaryTreeNode<Integer> root;

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
    void testSameDepthAndDifferentSubtrees() {
        assertFoundLca(root.findNode(15), root.findNode(8), root.findNode(10));
    }

    @Test
    void testDifferentDepthsAndDifferentSubtrees() {
        assertFoundLca(root.findNode(20), root.findNode(50), root.findNode(5));
    }

    @Test
    void testDifferentDepthsAndSameSubtrees() {
        assertFoundLca(root.findNode(20), root.findNode(40), root.findNode(20));
    }

    private void assertFoundLca(ParentLinkBinaryTreeNode<Integer> firstNode,
                                ParentLinkBinaryTreeNode<Integer> secondNode,
                                ParentLinkBinaryTreeNode<Integer> expectedLca) {
        var lca = lca(firstNode, secondNode);

        assertThat(lca).isNotNull();
        assertThat(lca).isSameAs(expectedLca);
    }
}