package com.leonenko.epi._9_bintree;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.root;
import static org.assertj.core.api.Assertions.assertThat;

class _915_TreeExteriorTest {

    @Test
    void testGetExterior() {
        SimpleBinaryTreeNode<Integer> root = root(4,
                                                  node(1,
                                                       node(0,
                                                            node(10),
                                                            node(20)),
                                                       node(2)),
                                                  node(6,
                                                       node(5),
                                                       node(7)));

        List<Integer> exterior = _915_TreeExterior.getExterior(root);

        assertThat(exterior).containsExactly(4, 1, 0, 10, 20, 2, 5, 7, 6);
    }

}