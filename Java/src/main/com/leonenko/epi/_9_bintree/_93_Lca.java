package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.concurrent.atomic.AtomicReference;

public class _93_Lca {

    static SimpleBinaryTreeNode<Integer> lca(SimpleBinaryTreeNode<Integer> root,
                                             SimpleBinaryTreeNode<Integer> firstNode,
                                             SimpleBinaryTreeNode<Integer> secondNode) {
        var lca = new AtomicReference<SimpleBinaryTreeNode<Integer>>();

        findLcaInternal(root, firstNode, secondNode, lca);

        return lca.get();
    }

    private static int findLcaInternal(SimpleBinaryTreeNode<Integer> currRoot,
                                       SimpleBinaryTreeNode<Integer> firstNode,
                                       SimpleBinaryTreeNode<Integer> secondNode,
                                       AtomicReference<SimpleBinaryTreeNode<Integer>> lcaRef) {
        if (currRoot == null) {
            return 0;
        }

        var numFoundOnLeft = findLcaInternal(currRoot.getLeftChild(),
                firstNode, secondNode, lcaRef);

        if (numFoundOnLeft == 2) {
            return 2;
        }

        var numFoundOnRight = findLcaInternal(currRoot.getRightChild(),
                firstNode, secondNode, lcaRef);

        if (numFoundOnRight == 2) {
            return 2;
        }

        var numFoundHere = numFoundOnLeft + numFoundOnRight
                + (currRoot == firstNode || currRoot == secondNode ? 1 : 0);

        if (numFoundHere == 2) {
            lcaRef.set(currRoot);
        }

        return numFoundHere;
    }
}
