package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.SimpleBinaryTreeNodeBuilder;
import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;

public class _912_CreateTreeFromTraversal {

    public static SimpleBinaryTreeNode<Integer> rebuildTree(
            List<Integer> preOrderKeys, List<Integer> inOrderKeys) {

        var inOrderIdxMap = IntStream.range(0, inOrderKeys.size())
                                           .boxed()
                                           .collect(Collectors.toMap(inOrderKeys::get, i -> i));

        var rootKey = preOrderKeys.get(0);
        var rootInOrderIdx = inOrderIdxMap.get(rootKey);

        var leftSubtree = rebuildTree(preOrderKeys, 1,
                1 + rootInOrderIdx, 0, rootInOrderIdx,
                inOrderIdxMap);

        var rightSubtree = rebuildTree(
                preOrderKeys, 1 + rootInOrderIdx, preOrderKeys.size(),
                rootInOrderIdx + 1, inOrderKeys.size(), inOrderIdxMap);

        return root(rootKey, leftSubtree, rightSubtree);
    }

    private static SimpleBinaryTreeNodeBuilder<Integer> rebuildTree(List<Integer> preOrderKeys,
            int preOrderStart, int preOrderEnd, int inOrderStart, int inOrderEnd,
            Map<Integer, Integer> inOrderIdxMap) {

        if (preOrderStart >= preOrderEnd || inOrderStart >= inOrderEnd) {
            return null;
        }

        var rootKey = preOrderKeys.get(preOrderStart);
        var rootInOrderIdx = inOrderIdxMap.get(rootKey);
        var leftSubtreeSize = rootInOrderIdx - inOrderStart;

        var leftSubtree = rebuildTree(preOrderKeys, preOrderStart + 1,
                preOrderStart + 1 + leftSubtreeSize, inOrderStart, rootInOrderIdx,
                inOrderIdxMap);

        var rightSubtree = rebuildTree(
                preOrderKeys, preOrderStart + 1 + leftSubtreeSize, preOrderEnd,
                rootInOrderIdx + 1, inOrderEnd, inOrderIdxMap);

        return node(rootKey, leftSubtree, rightSubtree);
    }

}
