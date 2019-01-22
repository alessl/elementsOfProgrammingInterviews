package com.leonenko.epi._14_bst_TODO;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.OptionalInt;

public class _142_FirstKeyGreaterThanGivenValueInBst {

    static OptionalInt ceilingKey(SimpleBinaryTreeNode<Integer> root, int searchKey) {
        var node = root;
        var ceilingNode = (SimpleBinaryTreeNode<Integer>) null;

        while (node != null) {
            if (node.getKey() > searchKey) {
                ceilingNode = node;
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }

        return ceilingNode != null ? OptionalInt.of(ceilingNode.getKey()): OptionalInt.empty();
    }

    static OptionalInt floorKey(SimpleBinaryTreeNode<Integer> root, int searchKey) {
        var node = root;
        var floorNode = (SimpleBinaryTreeNode<Integer>) null;

        while (node != null) {
            if (node.getKey() < searchKey) {
                floorNode = node;
                node = node.getRightChild();
            } else {
                node = node.getLeftChild();
            }
        }

        return floorNode != null ? OptionalInt.of(floorNode.getKey()): OptionalInt.empty();
    }

    static SimpleBinaryTreeNode<Integer> firstEqualInOrder(SimpleBinaryTreeNode<Integer> root, int searchKey) {
        var node = root;
        var equalNode = (SimpleBinaryTreeNode<Integer>) null;

        while (node != null) {
            if (node.getKey() == searchKey) {
                equalNode = node;
                node = node.getLeftChild();
            } else if (node.getKey() > searchKey) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }

        return equalNode;
    }
}
