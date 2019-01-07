package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.ParentLinkBinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class _911_ConstantSpaceInOrderWithParentLinks {

    public static List<Integer> getKeysInOrder(ParentLinkBinaryTreeNode<Integer> root) {
        ParentLinkBinaryTreeNode<Integer> prevNode = null;
        ParentLinkBinaryTreeNode<Integer> currNode = root;

        List<Integer> keysInOrder = new ArrayList<>();

        while (currNode != null) {
            ParentLinkBinaryTreeNode<Integer> nextNode;

            if (currNode.getParent() == prevNode) {
                if (currNode.getLeftChild() != null) {
                    nextNode = currNode.getLeftChild();
                } else {
                    keysInOrder.add(currNode.getKey());

                    nextNode = currNode.getRightChild() != null
                            ? currNode.getRightChild() : currNode.getParent();
                }
            } else if (currNode.getLeftChild() == prevNode) {
                keysInOrder.add(currNode.getKey());

                nextNode = currNode.getRightChild() != null
                        ? currNode.getRightChild() : currNode.getParent();
            } else {
                nextNode = currNode.getParent();
            }

            prevNode = currNode;
            currNode = nextNode;
        }

        return keysInOrder;
    }
}
