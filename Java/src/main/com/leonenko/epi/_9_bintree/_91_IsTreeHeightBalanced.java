package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

public class _91_IsTreeHeightBalanced {

    public static boolean isBalanced(SimpleBinaryTreeNode<Integer> root) {
        return isBalanced2(root);
    }

    public static boolean isBalanced2(SimpleBinaryTreeNode<Integer> root) {
        return Math.abs(getHeight(root.getLeftChild()) - getHeight(root.getRightChild())) <= 1;
    }

    private static int getBalancedHeight(SimpleBinaryTreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        var leftHeight = getBalancedHeight(node.getLeftChild());

        if (leftHeight < 0) {
            return -1;
        }

        var rightHeight = getBalancedHeight(node.getRightChild());

        if (rightHeight < 0) {
            return -1;
        }

        return Math.abs(leftHeight - rightHeight) <= 1 ? Math.max(leftHeight, rightHeight) + 1 : -1;
    }

    private static int getHeight(SimpleBinaryTreeNode<Integer> node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild())) + 1;
    }
}
