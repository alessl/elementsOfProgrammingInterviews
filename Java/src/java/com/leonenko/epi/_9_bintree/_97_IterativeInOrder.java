package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _97_IterativeInOrder {

    public static List<Integer> getKeysInOrder(SimpleBinaryTreeNode<Integer> root) {
        var nodeKeysInOrder = new ArrayList<Integer>();

        var nodeStack = new LinkedList<SimpleBinaryTreeNode<Integer>>();
        var currNode = root;

        while (!nodeStack.isEmpty() || currNode != null) {
            if (currNode != null) {
                nodeStack.push(currNode);

                currNode = currNode.getLeftChild();
            } else {
                currNode = nodeStack.pop();
                nodeKeysInOrder.add(currNode.getKey());

                currNode = currNode.getRightChild();
            }
        }

        return nodeKeysInOrder;
    }
}
