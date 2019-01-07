package com.leonenko.epi._15_rec_TODO;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.SimpleBinaryTreeNodeBuilder;
import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import lombok.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;


/**
 * Created by Alex on 5/4/2017.
 */
public class _158_GenerateAllBinaryTrees {

    static List<SimpleBinaryTreeNode> generateTrees(int numNodes) {
        var roots = new ArrayList<SimpleBinaryTreeNode>();

        for (var root : generateTrees(0, numNodes - 1)) {
            roots.add(root(toSimpleBinaryTreeNode(root)));
        }

        return roots;
    }

    private static SimpleBinaryTreeNodeBuilder<Integer> toSimpleBinaryTreeNode(
            BinaryTreeNode node) {

        if (node.left == null && node.right == null) {
            return node(node.key);
        }

        return node(node.key,
                node.left != null ? toSimpleBinaryTreeNode(node.left) : null,
                node.right != null ? toSimpleBinaryTreeNode(node.right) : null);
    }

    private static List<BinaryTreeNode> generateTrees(int min, int max) {
        if (max < min) {
            return Collections.singletonList(null);
        }

        var trees = new ArrayList<BinaryTreeNode>();

        for (var root = min; root <= max; root++) {
            var leftTrees = generateTrees(min, root - 1);
            var rightTrees = generateTrees(root + 1, max);

            for (var leftTree : leftTrees) {
                for (var rightTree : rightTrees) {
                    trees.add(BinaryTreeNode.of(root, leftTree, rightTree));
                }
            }
        }
        return trees;
    }

    @Value(staticConstructor = "of")
    private static final class BinaryTreeNode {
        private int key;
        private BinaryTreeNode left;
        private BinaryTreeNode right;
    }
}
