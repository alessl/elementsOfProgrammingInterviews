package com.leonenko.epi._15_rec_TODO;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static com.leonenko.epi._15_rec_TODO._158_GenerateAllBinaryTrees.generateTrees;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class _158_GenerateAllBinaryTreesTest {

    @Test
    void testCreateTrees() {
        var trees = generateTrees(3);

        System.out.println("Generated trees:");
        trees.forEach(System.out::println);

        assertThat(trees).hasSize(5);

        assertAll(
                assertion(trees.get(0),
                        "BinaryTreeNode(0, null, "
                                + "BinaryTreeNode(1, null, "
                                + "BinaryTreeNode(2, null, null)))"),
                assertion(trees.get(1),
                        "BinaryTreeNode(0, null, "
                                + "BinaryTreeNode(2, "
                                + "BinaryTreeNode(1, null, null), null))"),
                assertion(trees.get(2),
                        "BinaryTreeNode(1, "
                                + "BinaryTreeNode(0, null, null), "
                                + "BinaryTreeNode(2, null, null))"),
                assertion(trees.get(3),
                        "BinaryTreeNode(2, " +
                                "BinaryTreeNode(0, null, " +
                                "BinaryTreeNode(1, null, null)), null)"),
                assertion(trees.get(4),
                        "BinaryTreeNode(2, "
                                + "BinaryTreeNode(1, "
                                + "BinaryTreeNode(0, null, null), null), null)"));
    }

    private Executable assertion(SimpleBinaryTreeNode root, String treeAsString) {
        return () -> assertThat(root).hasToString(treeAsString);
    }
}