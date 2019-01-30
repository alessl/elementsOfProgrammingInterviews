package com.leonenko.epi._14_bst;

import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.leonenko.epi._14_bst._145_CreateBstFromTraversalData.rebuild;
import static com.leonenko.epi._14_bst._145_CreateBstFromTraversalData.rebuild2;
import static com.leonenko.epi._9_bintree._97_IterativeInOrder.getKeysInOrder;
import static com.leonenko.epi._9_bintree._98_IterativePreOrder.getKeysPreOrder;
import static com.leonenko.epi.common.binarytree.SimpleBinaryTreeBuilders.*;
import static org.assertj.core.api.Assertions.assertThat;

class _145_CreateBstFromTraversalDataTest {

    private SimpleBinaryTreeNode<Integer> expectedBst;
    private List<Integer> expectedKeysPreOrder;
    private List<Integer> expectedKeysInOrder;

    @BeforeEach
    void setUp() {
        expectedBst = root(5,
                node(2,
                        node(1,
                                node(0),
                                node(2)),
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
        System.out.println("Expected Bst:\n" + expectedBst);

        expectedKeysPreOrder = getKeysPreOrder(expectedBst);
        System.out.println("Expected Pre-order:\n" + expectedKeysPreOrder);

        expectedKeysInOrder = getKeysInOrder(expectedBst);
        System.out.println("Expected In-order:\n" + expectedKeysInOrder);
    }

    @Test
    void testRebuild() {
        assertRebuiltBst(rebuild(expectedKeysPreOrder));
    }

    @Test
    void testRebuild2() {
        assertRebuiltBst(rebuild2(expectedKeysPreOrder));
    }

    private void assertRebuiltBst(SimpleBinaryTreeNode<Integer> bst) {
        List<Integer> keysPreOrder = getKeysPreOrder(bst);
        System.out.println("Rebuilt Pre-order:\n" + keysPreOrder);
        assertThat(keysPreOrder).containsExactlyElementsOf(keysPreOrder);

        List<Integer> keysInOrder = getKeysInOrder(bst);
        System.out.println("Rebuilt In-order:\n" + keysInOrder);
        assertThat(keysInOrder).containsExactlyElementsOf(expectedKeysInOrder);
    }
}