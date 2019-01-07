package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.LinkedList;
import java.util.List;

public class _96_RootToLeafPathWithGivenSum {

    public static boolean pathExists(SimpleBinaryTreeNode<Integer> root, int targetSum) {
        return pathExistsInternal(root, targetSum, 0);
    }

    private static boolean pathExistsInternal(SimpleBinaryTreeNode<Integer> node, int targetSum,
            int partialSum) {

        if (node == null) {
            return false;
        }

        partialSum += node.getKey();

        if (node.isLeaf()) {
            return partialSum == targetSum;
        }

        return pathExistsInternal(node.getLeftChild(), targetSum, partialSum)
                || pathExistsInternal(node.getRightChild(), targetSum, partialSum);
    }

    public static List<Integer> getRootToLeafPath(SimpleBinaryTreeNode<Integer> root,
            int targetSum) {

        var path = new LinkedList<Integer>();

        getRootToLeafPath(root, targetSum, 0, path);

        return path;
    }

    private static boolean getRootToLeafPath(SimpleBinaryTreeNode<Integer> node, int targetSum,
            int partialSum, LinkedList<Integer> path) {

        if (node == null) {
            return false;
        }

        partialSum += node.getKey();

        var pathEndsHere = node.isLeaf() && partialSum == targetSum;
        var pathExists = pathEndsHere || pathExistsInSubtree(node, targetSum, partialSum, path);

        if (pathExists) {
            path.addFirst(node.getKey());
        }

        return pathExists;
    }

    private static boolean pathExistsInSubtree(SimpleBinaryTreeNode<Integer> node, int targetSum,
            int partialSum, LinkedList<Integer> path) {

        return getRootToLeafPath(node.getLeftChild(), targetSum, partialSum, path)
                || getRootToLeafPath(node.getRightChild(), targetSum, partialSum, path);
    }
}
