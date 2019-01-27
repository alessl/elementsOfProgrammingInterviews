package com.leonenko.epi._14_bst_TODO;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

public class _1411_AreThreeBstNodesTotallyOrdered {

    static boolean isOrdered(SimpleBinaryTreeNode<Integer> leftNode,
                             SimpleBinaryTreeNode<Integer> rightNode,
                             SimpleBinaryTreeNode<Integer> middleNode) {
        var leftSearchNode = leftNode;
        var rightSearchNode = rightNode;

        while (leftSearchNode != rightSearchNode
                && leftSearchNode != middleNode
                && rightSearchNode != middleNode
                && (leftSearchNode != null || rightSearchNode != null)) {
            if (leftSearchNode != null) {
                leftSearchNode = leftSearchNode.getKey() > middleNode.getKey()
                        ? leftSearchNode.getLeftChild() : leftSearchNode.getRightChild();
            }

            if (rightSearchNode != null) {
                rightSearchNode = rightSearchNode.getKey() > middleNode.getKey()
                        ? rightSearchNode.getLeftChild() : rightSearchNode.getRightChild();
            }
        }

        if (leftSearchNode != middleNode && rightSearchNode != middleNode) {
            return false;
        }

        return leftSearchNode == middleNode
                ? containsNode(middleNode, rightNode) : containsNode(middleNode, leftNode);
    }

    private static boolean containsNode(SimpleBinaryTreeNode<Integer> currNode,
                                        SimpleBinaryTreeNode<Integer> searchNode) {
        while (currNode != null && currNode != searchNode) {
            currNode = currNode.getKey() > searchNode.getKey() ?
                    currNode.getLeftChild() : currNode.getRightChild();
        }
        return currNode == searchNode;
    }
}
