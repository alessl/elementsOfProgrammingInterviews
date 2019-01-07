package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.OptionalInt;

public class _99_KthNodeInOrder {

    static List<Integer> getTopKNodes(SimpleBinaryTreeNode<Integer> root, int topSize) {
        var top = new LinkedList<Integer>();

        getTopKNodes(root, top, topSize);

        return top;
    }

    private static void getTopKNodes(SimpleBinaryTreeNode<Integer> node, List<Integer> top, int k) {
        if (node == null || top.size() == k) {
            return;
        }
        if (node.getRightChild() != null) {
            getTopKNodes(node.getRightChild(), top, k);
        }
        if (top.size() < k) {
            top.add(node.getKey());
        }
        if (node.getLeftChild() != null) {
            getTopKNodes(node.getLeftChild(), top, k);
        }
    }

    public static OptionalInt getKthNode(SimpleBinaryTreeNode<Integer> root, int k) {
        var currNode = root;

        while (currNode != null) {
            var leftSize = currNode.getLeftChild() != null ? currNode.getLeftChild().size() : 0;

            if (leftSize + 1 < k) {
                k -= leftSize + 1;

                currNode = currNode.getRightChild();
            } else if (leftSize == k - 1) {
                return OptionalInt.of(currNode.getKey());
            } else {
                currNode = currNode.getLeftChild();
            }
        }

        return OptionalInt.empty();
    }
}
