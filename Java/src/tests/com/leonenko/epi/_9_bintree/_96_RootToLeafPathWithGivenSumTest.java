package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._9_bintree._96_RootToLeafPathWithGivenSum.getRootToLeafPath;
import static com.leonenko.epi._9_bintree._96_RootToLeafPathWithGivenSum.pathExists;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _96_RootToLeafPathWithGivenSumTest {

    private static final int TARGET_SUM_IN_RIGHT_SUBTREE = 10;
    private static final int TARGET_SUM_IN_LEFT_SUBTREE = 17;
    private static final int TARGET_SUM_NOT_IN_TREE = 20;

    private SimpleBinaryTreeNode<Integer> root;

    @BeforeEach
    void setUp() {
        root = root(2,
                node(3,
                        node(5),
                        node(4)),
                node(5,
                        node(5,
                                node(5),
                                node(4)),
                        node(4)));
    }

    @Test
    void testPathExistsInRightSubTree() {
        assertThat(pathExists(root, TARGET_SUM_IN_RIGHT_SUBTREE)).isTrue();
    }

    @Test
    void testPathExistsInLeftSubTree() {
        assertThat(pathExists(root, TARGET_SUM_IN_LEFT_SUBTREE)).isTrue();
    }

    @Test
    void testPathDoesNotExist() {
        assertThat(pathExists(root, TARGET_SUM_NOT_IN_TREE)).isFalse();
    }

    @Test
    void testFindPathInRightSubTree() {
        assertThat(getRootToLeafPath(root, TARGET_SUM_IN_RIGHT_SUBTREE)).containsExactly(2, 3, 5);
    }

    @Test
    void testFindPathInLeftSubTree() {
        assertThat(getRootToLeafPath(root, TARGET_SUM_IN_LEFT_SUBTREE)).containsExactly(2, 5, 5, 5);
    }

    @Test
    void testFindPathDoesNotExist() {
        assertThat(getRootToLeafPath(root, TARGET_SUM_NOT_IN_TREE)).isEmpty();
    }
}