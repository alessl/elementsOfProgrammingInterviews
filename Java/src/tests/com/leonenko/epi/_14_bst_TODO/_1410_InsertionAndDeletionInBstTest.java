package com.leonenko.epi._14_bst_TODO;

import com.leonenko.epi._14_bst_TODO._1410_InsertionAndDeletionInBst.BinaryTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._14_bst_TODO._1410_InsertionAndDeletionInBst.createBst;
import static org.assertj.core.api.Assertions.assertThat;

class _1410_InsertionAndDeletionInBstTest {

    private BinaryTree tree;

    @BeforeEach
    void setUp() {
        tree = createBst();

        assertInsert(tree, 10);
        assertInsert(tree, 20);
        assertInsert(tree, 30);
        assertInsert(tree, 40);
        assertInsert(tree, 15);
        assertInsert(tree, 17);
        assertInsert(tree, 12);
        assertInsert(tree, 5);
        assertInsert(tree, 2);
        assertInsert(tree, 8);
        assertInsert(tree, 9);

        System.out.println("Tree: " + tree);
    }

    @Test
    void testDelete1() {
        assertDelete1(tree, 8);

        System.out.println("Deleted 8: " + tree);

        assertDelete1(tree, 30);

        System.out.println("Deleted 30: " + tree);

        assertDelete1(tree, 9);

        System.out.println("Deleted 9: " + tree);

        assertDelete1(tree, 10);

        System.out.println("Deleted 10: " + tree);

        assertThat(tree.delete1(100)).isFalse();

        System.out.println("Did not delete 100: " + tree);
    }

    @Test
    void testDelete2() {
        assertDelete2(tree, 8);

        System.out.println("Deleted 8: " + tree);

        assertDelete2(tree, 30);

        System.out.println("Deleted 30: " + tree);

        assertDelete2(tree, 9);

        System.out.println("Deleted 9: " + tree);

        assertDelete2(tree, 10);

        System.out.println("Deleted 10: " + tree);

        assertThat(tree.delete2(100)).isFalse();

        System.out.println("Did not delete 100: " + tree);
    }

    private void assertInsert(BinaryTree tree, int key) {
        assertThat(tree.insert(key)).isTrue();
    }

    private void assertDelete1(BinaryTree tree, int key) {
        assertThat(tree.delete1(key)).isTrue();
    }

    private void assertDelete2(BinaryTree tree, int key) {
        assertThat(tree.delete2(key)).isTrue();
    }
}