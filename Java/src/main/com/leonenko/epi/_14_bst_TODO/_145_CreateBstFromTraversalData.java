package com.leonenko.epi._14_bst_TODO;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.SimpleBinaryTreeNodeBuilder;
import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;

public class _145_CreateBstFromTraversalData {

    static SimpleBinaryTreeNode<Integer> rebuild(List<Integer> preOrderKeys) {
        return root(doRebuild(preOrderKeys, 0, preOrderKeys.size()));
    }

    private static SimpleBinaryTreeNodeBuilder<Integer> doRebuild(
            List<Integer> preOrderKeys, int start, int end) {

        if (start >= end) {
            return null;
        }

        int transitionPoint = start + 1;

        while (transitionPoint < end
                && preOrderKeys.get(transitionPoint) < preOrderKeys.get(start)) {
            transitionPoint++;
        }

        return node(preOrderKeys.get(start),
                doRebuild(preOrderKeys, start + 1, transitionPoint),
                doRebuild(preOrderKeys, transitionPoint, end));
    }

    static SimpleBinaryTreeNode<Integer> rebuild2(List<Integer> preOrderKeys) {
        return root(doRebuild2(preOrderKeys,
                Integer.MIN_VALUE, Integer.MAX_VALUE, new AtomicInteger()));
    }

    private static SimpleBinaryTreeNodeBuilder<Integer> doRebuild2(List<Integer> preOrderKeys,
                                                           int minValue,
                                                           int maxValue,
                                                           AtomicInteger rootIndex) {
        if (rootIndex.get() == preOrderKeys.size()) {
            return null;
        }

        var rootKey = preOrderKeys.get(rootIndex.get());

        if (rootKey < minValue || rootKey > maxValue) {
            return null;
        }

        rootIndex.incrementAndGet();

        return node(rootKey,
                doRebuild2(preOrderKeys, minValue, rootKey, rootIndex),
                doRebuild2(preOrderKeys, rootKey, maxValue, rootIndex));
    }
}
