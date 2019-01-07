package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 5/8/2017.
 */
public class _95_SumOfRootToLeafPaths {

    static int getSumOfPaths(SimpleBinaryTreeNode<Integer> root) {
        return getSumOfPaths(root, 0);
    }

    private static int getSumOfPaths(SimpleBinaryTreeNode<Integer> node, int runningSum) {
        if (node == null) {
            return 0;
        }

        runningSum = runningSum * 10 + node.getKey();

        if (node.isLeaf()) {
            return runningSum;
        } else {
            return getSumOfPaths(node.getLeftChild(), runningSum)
                    + getSumOfPaths(node.getRightChild(), runningSum);
        }
    }

    static List<Integer> getRootToLeafPathsAsNumbers(SimpleBinaryTreeNode<Integer> root) {
        var paths = new ArrayList<Integer>();

        getRootToLeafPathsAsNumbers(root, 0, paths);

        return paths;
    }

    private static void getRootToLeafPathsAsNumbers(SimpleBinaryTreeNode<Integer> node,
            int runningSum, List<Integer> paths) {

        if (node == null) {
            return;
        }

        runningSum = runningSum * 10 + node.getKey();

        if (node.isLeaf()) {
            paths.add(runningSum);
        } else {
            getRootToLeafPathsAsNumbers(node.getLeftChild(), runningSum, paths);
            getRootToLeafPathsAsNumbers(node.getRightChild(), runningSum, paths);
        }
    }
}
