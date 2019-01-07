package com.leonenko.epi._8_stackqueue;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _87_ComputeBinaryTreeNodesInOrderOfIncDepth {

    static List<List<Integer>> getKeysByLevels(SimpleBinaryTreeNode<Integer> root) {
        var keysByLevels = new ArrayList<List<Integer>>();
        var currLevelNodes = List.of(root);

        while (!currLevelNodes.isEmpty()) {
            var currLevelKeys = currLevelNodes.stream()
                    .map(SimpleBinaryTreeNode::getKey)
                    .collect(Collectors.toList());
            keysByLevels.add(currLevelKeys);

            currLevelNodes = currLevelNodes.stream()
                    .flatMap(n -> Stream.of(n.getLeftChild(), n.getRightChild()))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toCollection(LinkedList::new));
        }

        return keysByLevels;
    }
}
