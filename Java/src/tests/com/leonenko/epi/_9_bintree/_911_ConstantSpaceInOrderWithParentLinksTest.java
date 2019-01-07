package com.leonenko.epi._9_bintree;

import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._9_bintree._911_ConstantSpaceInOrderWithParentLinks.getKeysInOrder;
import static com.leonenko.epi.common.binarytree.ParentLinkBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.ParentLinkBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _911_ConstantSpaceInOrderWithParentLinksTest {

    @Test
    void testInOrder() {
        var root = root(4,
                node(1,
                        node(0),
                        node(2)),
                node(6,
                        node(5),
                        node(7)));

        List<Integer> keysInOrder = getKeysInOrder(root);

        assertThat(keysInOrder).containsExactly(0, 1, 2, 4, 5, 6, 7);
    }
}