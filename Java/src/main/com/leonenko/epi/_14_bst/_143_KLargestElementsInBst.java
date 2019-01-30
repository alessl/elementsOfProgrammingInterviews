package com.leonenko.epi._14_bst;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class _143_KLargestElementsInBst {

    static List<Integer> getKLargestKeys(SimpleBinaryTreeNode<Integer> root,
                                         int numLargestKeys) {
        return doFindKLargestKeys(root, numLargestKeys, new ArrayList<>());
    }

    private static List<Integer> doFindKLargestKeys(SimpleBinaryTreeNode<Integer> root,
                                                    int numLargestKeys,
                                                    List<Integer> largestKeys) {
        if (root == null || largestKeys.size() >= numLargestKeys) {
            return largestKeys;
        }

        doFindKLargestKeys(root.getRightChild(), numLargestKeys, largestKeys);

        if (largestKeys.size() < numLargestKeys) {
            largestKeys.add(root.getKey());

            doFindKLargestKeys(root.getLeftChild(), numLargestKeys, largestKeys);
        }

        return largestKeys;
    }
}
