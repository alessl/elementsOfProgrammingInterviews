package com.leonenko.epi._14_bst_TODO;

import com.leonenko.epi._14_bst_TODO._1410_InsertionAndDeletionInBst_TODO.BinaryTree;
import org.junit.jupiter.api.Test;

import static com.leonenko.epi._14_bst_TODO._1410_InsertionAndDeletionInBst_TODO.createBst;
import static org.assertj.core.api.Assertions.assertThat;

class _1410_InsertionAndDeletionInBst_TODOTest {

    @Test
    void testCreateBinaryTree() {
        BinaryTree tree = createBst();

        assertInsert(tree, 10);
        assertInsert(tree, 20);
        assertInsert(tree, 30);
        assertInsert(tree, 40);
        assertInsert(tree, 5);
        assertInsert(tree, 2);
        assertInsert(tree, 8);
        assertInsert(tree, 9);

        System.out.println(tree);

        assertDelete(tree, 2);
        assertDelete(tree, 40);
        assertDelete(tree, 5);

        assertThat(tree.delete1(100)).isFalse();

        System.out.println(tree);
    }

    private void assertInsert(BinaryTree tree, int key) {
        assertThat(tree.insert(key)).isTrue();
    }

    private void assertDelete(BinaryTree tree, int key) {
        assertThat(tree.delete1(key)).isTrue();
    }
}