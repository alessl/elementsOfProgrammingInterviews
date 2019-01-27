package com.leonenko.epi._14_bst_TODO;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.SimpleBinaryTreeNodeBuilder;
import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.List;

import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;

public class _149_BuildMinimumHeightBstFromSortedArray {

    static SimpleBinaryTreeNode<Integer> buildMinHeightBst(List<Integer> sortedList) {
        return root(doBuildMinHeightBst(sortedList, 0, sortedList.size() - 1));
    }

    private static SimpleBinaryTreeNodeBuilder<Integer> doBuildMinHeightBst(
            List<Integer> sortedList,
            int start,
            int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;

        return node(sortedList.get(mid),
                doBuildMinHeightBst(sortedList, start, mid - 1),
                doBuildMinHeightBst(sortedList, mid + 1, end));
    }
}
