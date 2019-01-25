package com.leonenko.epi._14_bst_TODO;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

public class _144_LcaInBst {

    static SimpleBinaryTreeNode<Integer> findLca(SimpleBinaryTreeNode<Integer> root,
                                                 SimpleBinaryTreeNode<Integer> left,
                                                 SimpleBinaryTreeNode<Integer> right) {
        var node = root;

        while (node.getKey() < left.getKey() || node.getKey() > right.getKey()) {
            while (node.getKey() < left.getKey()) {
                node = node.getRightChild();
            }
            while (node.getKey() > right.getKey()) {
                node = node.getLeftChild();
            }
        }

        return node;
    }
}
