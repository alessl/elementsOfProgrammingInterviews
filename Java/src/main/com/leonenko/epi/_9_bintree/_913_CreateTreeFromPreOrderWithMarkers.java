package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.SimpleBinaryTreeNodeBuilder;
import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;

public class _913_CreateTreeFromPreOrderWithMarkers {

    public static SimpleBinaryTreeNode<Integer> rebuildTreeFromPreOrderWithNulls(
            List<Integer> preOrderKeysWithNulls) {

        return root(rebuildTreeFromPreOrderWithNulls(preOrderKeysWithNulls,
                new AtomicInteger(0)));
    }

    private static SimpleBinaryTreeNodeBuilder<Integer> rebuildTreeFromPreOrderWithNulls(
            List<Integer> preOrderKeysWithNulls, AtomicInteger idx) {

        var key = preOrderKeysWithNulls.get(idx.get());

        idx.incrementAndGet();

        if (key == null) {
            return null;
        }

        return node(key, rebuildTreeFromPreOrderWithNulls(preOrderKeysWithNulls, idx),
                rebuildTreeFromPreOrderWithNulls(preOrderKeysWithNulls, idx));
    }

}
