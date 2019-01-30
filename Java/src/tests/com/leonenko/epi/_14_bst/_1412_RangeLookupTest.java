package com.leonenko.epi._14_bst;

import com.leonenko.epi._14_bst._1412_RangeLookup.Interval;
import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._14_bst._1412_RangeLookup.keysOfInterval;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.*;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.node;
import static org.assertj.core.api.Assertions.assertThat;

class _1412_RangeLookupTest {

    private SimpleBinaryTreeNode<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = root(5,
                node(4,
                        node(2,
                                node(1),
                                node(3)),
                        nil()),
                node(10,
                        node(8),
                        node(15,
                                node(12),
                                node(20,
                                        node(17),
                                        node(25)))));
    }

    @Test
    void testKeysOfInterval() {
        assertKeysOfInterval(1, 5, List.of(1, 2, 3, 4, 5));
        assertKeysOfInterval(10, 25, List.of(10, 12, 15, 17, 20, 25));
        assertKeysOfInterval(1, 25, List.of(1, 2, 3, 4, 5, 8, 10, 12, 15, 17, 20, 25));
    }

    private void assertKeysOfInterval(int left, int right, List<Integer> expectedKeys) {
        assertThat(findKeys(left, right)).containsExactlyElementsOf(expectedKeys);
    }

    private List<Integer> findKeys(int left, int right) {
        return keysOfInterval(bst, new Interval(left, right));
    }
}