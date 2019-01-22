package com.leonenko.epi._14_bst_TODO;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import lombok.Value;

import java.util.LinkedList;
import java.util.Queue;

public class _141_IsTreeBst {

    static boolean isBst(SimpleBinaryTreeNode<Integer> root) {
        return isKeyInRange(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isKeyInRange(SimpleBinaryTreeNode<Integer> root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }

        if (root.getKey() < minValue || root.getKey() > maxValue) {
            return false;
        }

        return isKeyInRange(root.getLeftChild(), minValue, root.getKey())
                && isKeyInRange(root.getRightChild(), root.getKey(), maxValue);
    }

    static boolean isBst2(SimpleBinaryTreeNode<Integer> root) {
        Queue<QueueEntry> queue = new LinkedList<>();

        queue.add(new QueueEntry(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

        while (!queue.isEmpty()) {
            var entry = queue.poll();
            var node = entry.getNode();
            var minValue = entry.getMinValue();
            var maxValue = entry.getMaxValue();

            if (node.getKey() < minValue || node.getKey() > maxValue) {
                return false;
            }
            if (node.getLeftChild() != null) {
                queue.add(new QueueEntry(node.getLeftChild(), minValue, node.getKey()));
            }
            if (node.getRightChild() != null) {
                queue.add(new QueueEntry(node.getRightChild(), node.getKey(), maxValue));
            }
        }

        return true;
    }

    @Value
    private static class QueueEntry {
        private SimpleBinaryTreeNode<Integer> node;
        private int minValue;
        private int maxValue;
    }
}
