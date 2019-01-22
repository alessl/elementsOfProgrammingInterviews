package com.leonenko.epi._14_bst_TODO;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders;
import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._14_bst_TODO._142_FirstKeyGreaterThanGivenValueInBst.*;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.*;
import static org.assertj.core.api.Assertions.assertThat;

class _142_FirstKeyGreaterThanGivenValueInBstTest {

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
    void testCeilingKey() {
        assertThat(ceilingKey(bst, 0)).hasValue(1);
        assertThat(ceilingKey(bst, 12)).hasValue(15);
    }

    @Test
    void testFloorKey() {
        assertThat(floorKey(bst, 2)).hasValue(1);
        assertThat(floorKey(bst, 15)).hasValue(12);
    }

    @Test
    void testFirstEqualInOrder() {
        var node1 = firstEqualInOrder(bst, 2);
        assertThat(node1.getKey()).isEqualTo(2);
        assertThat(node1.getLeftChild().getKey()).isEqualTo(1);
        assertThat(node1.getRightChild().getKey()).isEqualTo(3);

        var node3 = firstEqualInOrder(bst, 20);
        assertThat(node3.getKey()).isEqualTo(20);
        assertThat(node3.getLeftChild()).isNull();
        assertThat(node3.getRightChild()).isNull();

        assertThat(firstEqualInOrder(bst, 14)).isNull();
    }
}