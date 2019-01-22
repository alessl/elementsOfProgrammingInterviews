package com.leonenko.epi._14_bst_TODO;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._14_bst_TODO._143_KLargestElementsInBst.getKLargestKeys;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.*;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static org.assertj.core.api.Assertions.assertThat;

class _143_KLargestElementsInBstTest {

    private SimpleBinaryTreeNode<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = root(5,
                node(2,
                        node(2,
                                node(1),
                                node(3)),
                        node(3)),
                node(10,
                        node(7),
                        node(15,
                                node(12),
                                node(20,
                                        node(20,
                                                node(20),
                                                nil()),
                                        node(25)))));
    }

    @Test
    void testGetKLargestKeys() {
       assertThat(getKLargestKeys(bst, 3))
               .containsExactly(25, 20, 20);
       assertThat(getKLargestKeys(bst, 8))
               .containsExactly(25, 20, 20, 20, 15, 12, 10, 7);
    }
}