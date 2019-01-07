package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _98_IterativePreOrder {

    public static List<Integer> getKeysPreOrder(SimpleBinaryTreeNode<Integer> root) {
        var keysPreOrder = new ArrayList<Integer>();

        var nodeStack = new LinkedList<SimpleBinaryTreeNode<Integer>>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty() ) {
            var currNode = nodeStack.pop();

            keysPreOrder.add(currNode.getKey());

            if (currNode.getRightChild() != null) {
                nodeStack.push(currNode.getRightChild());
            }
            if (currNode.getLeftChild() != null) {
                nodeStack.push(currNode.getLeftChild());
            }
        }

        return keysPreOrder;
    }

    public static List<Integer> getKeysPreOrderWithNulls(SimpleBinaryTreeNode<Integer> root) {
        var keysPreOrder = new ArrayList<Integer>();

        var nodeStack = new LinkedList<SimpleBinaryTreeNode<Integer>>();
        nodeStack.push(root);

        while (!nodeStack.isEmpty() ) {
            var currNode = nodeStack.pop();

            if (currNode != null) {
                keysPreOrder.add(currNode.getKey());
                nodeStack.push(currNode.getRightChild());
                nodeStack.push(currNode.getLeftChild());
            } else {
                keysPreOrder.add(null);
            }

        }

        return keysPreOrder;
    }

}
