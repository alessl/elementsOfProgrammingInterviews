package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _915_TreeExterior {

    static List<Integer> getExterior(SimpleBinaryTreeNode<Integer> root) {
        var exterior = new ArrayList<>(Collections.singleton(root.getKey()));

        getLeftSide(root.getLeftChild(), exterior, true);
        getRightSide(root.getRightChild(), exterior, true);

        return exterior;
    }

    private static void getLeftSide(SimpleBinaryTreeNode<Integer> node,
                                    List<Integer> exterior,
                                    boolean isExterior) {
        if (node == null) {
            return;
        }

        if (isExterior || node.isLeaf()) {
            exterior.add(node.getKey());
        }

        if (node.getLeftChild() != null) {
            getLeftSide(node.getLeftChild(), exterior, isExterior);
        }

        if (node.getRightChild() != null) {
            getLeftSide(node.getRightChild(),
                        exterior,
                        isExterior && node.getLeftChild() == null);
        }
    }

    private static void getRightSide(SimpleBinaryTreeNode<Integer> node,
                                     List<Integer> exterior,
                                     boolean isExterior) {
        if (node == null) {
            return;
        }

        if (node.getLeftChild() != null) {
            getRightSide(node.getLeftChild(),
                         exterior,
                         isExterior && node.getRightChild() == null);
        }

        if (node.getRightChild() != null) {
            getRightSide(node.getRightChild(), exterior, isExterior);
        }

        if (node.isLeaf() || isExterior) {
            exterior.add(node.getKey());
        }
    }
}
