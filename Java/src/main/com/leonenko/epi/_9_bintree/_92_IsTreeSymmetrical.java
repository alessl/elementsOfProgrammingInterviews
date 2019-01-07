package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

public class _92_IsTreeSymmetrical {

    static boolean isSymmetrical(SimpleBinaryTreeNode<Integer> root) {
        return root == null || isSymmetrical(root.getLeftChild(), root.getRightChild());
    }

    private static boolean isSymmetrical(SimpleBinaryTreeNode<Integer> leftNode,
                                         SimpleBinaryTreeNode<Integer> rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }

        if (leftNode != null && rightNode != null) {
            var areKeysEqual = leftNode.getKey().equals(rightNode.getKey());

            var isLeftSymmetric = isSymmetrical(leftNode.getLeftChild(),
                    leftNode.getRightChild());

            var isRightSymmetric = isSymmetrical(rightNode.getLeftChild(),
                    rightNode.getRightChild());

            return areKeysEqual && isLeftSymmetric && isRightSymmetric;
        }

        return false;
    }
}
