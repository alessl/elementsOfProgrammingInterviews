package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

public class _916_RightSiblingTree_TODO {

    public static void createRightSiblingTree(SimpleBinaryTreeNode<Integer> rootNode) {
        SimpleBinaryTreeNode<Integer> leftStartNode = rootNode;

        while (leftStartNode != null && leftStartNode.getLeftChild() != null) {
            populateLowerNextField(leftStartNode);
            leftStartNode = leftStartNode.getLeftChild();
        }
    }

    private static void populateLowerNextField(SimpleBinaryTreeNode<Integer> startNode) {
        SimpleBinaryTreeNode<Integer> iter = startNode;

        while (iter != null) {
        }
    }

}
