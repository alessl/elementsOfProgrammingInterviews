package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.ParentLinkBinaryTreeNode;

public class _94_LcaWithParentLinks {

    public static ParentLinkBinaryTreeNode<Integer> lca(ParentLinkBinaryTreeNode<Integer> firstNode,
            ParentLinkBinaryTreeNode<Integer> secondNode) {

        var firstDepth = getDepth(firstNode);
        var secondDepth = getDepth(secondNode);

        if (firstDepth < secondDepth) {
            var temp = firstNode;

            firstNode = secondNode;
            secondNode = temp;
        }

        var depthDiff = Math.abs(firstDepth - secondDepth);

        while (depthDiff > 0) {
            firstNode = firstNode.getParent();
            depthDiff--;
        }

        while (firstNode != secondNode) {
            firstNode = firstNode.getParent();
            secondNode = secondNode.getParent();
        }

        return firstNode;
    }

    private static int getDepth(ParentLinkBinaryTreeNode<Integer> node) {
        var depth = 0;

        while (node.getParent() != null) {
            node = node.getParent();
            depth++;
        }

        return depth;
    }
}
