package com.leonenko.epi._14_bst_TODO;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

public class _1412_RangeLookup {

    static List<Integer> keysOfInterval(SimpleBinaryTreeNode<Integer> root, Interval interval) {
        return findKeysOfInterval(root, interval, new ArrayList<>());
    }

    private static List<Integer> findKeysOfInterval(SimpleBinaryTreeNode<Integer> root,
                                                    Interval interval,
                                                    ArrayList<Integer> keys) {
        if (root == null) {
            return keys;
        }

        if (interval.left <= root.getKey() && root.getKey() <= interval.right) {
            findKeysOfInterval(root.getLeftChild(), interval, keys);
            keys.add(root.getKey());
            findKeysOfInterval(root.getRightChild(), interval, keys);
        } else if (interval.left> root.getKey()) {
            findKeysOfInterval(root.getRightChild(), interval, keys);
        } else { // interval.right >= root.getKey()
            findKeysOfInterval(root.getLeftChild(), interval, keys);
        }

        return keys;
    }

    @Value
    static class Interval {
        private int left;
        private int right;
    }
}
