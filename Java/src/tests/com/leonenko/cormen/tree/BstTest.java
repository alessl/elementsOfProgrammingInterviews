package com.leonenko.cormen.tree;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class BstTest {


    private Bst<Integer> bst = new Bst<>();

    @BeforeEach
    void setUp() {
        bst = new Bst<>();
    }

    @Test
    void emptyBst() {
        assertThat(bst).hasToString("Bst is empty");
    }

    @Test
    void contains() {
        int key = 10;

        assertThat(bst.contains(key)).isFalse();
        bst.insert(key);
        assertThat(bst.contains(key)).isTrue();

        assertThat(bst).hasToString(String.format("(_ %s _)", key));
    }

    @Test
    void insertionOfMax() {
        bst.insert(10);
        assertThat(bst.contains(10)).isTrue();

        bst.insert(20);
        assertThat(bst.contains(20)).isTrue();

        assertThat(bst).hasToString("(_ 10 20)");
    }

    @Test
    void insertionOfNewMax() {
        bst.insert(10);
        bst.insert(20);

        bst.insert(30);
        assertThat(bst.contains(30)).isTrue();

        assertThat(bst).hasToString("(_ 10 (_ 20 30))");
    }

    @Test
    void insertionOfMin() {
        bst.insert(10);
        bst.insert(5);

        assertThat(bst.contains(10)).isTrue();
        assertThat(bst.contains(5)).isTrue();
        assertThat(bst).hasToString("(5 10 _)");
    }

    @Test
    void insertionOfNewMin() {
        bst.insert(10);
        bst.insert(5);

        bst.insert(3);
        assertThat(bst.contains(3)).isTrue();
        assertThat(bst).hasToString("((3 5 _) 10 _)");
    }

    @Test
    void insertionOfInternalKey() {
        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        bst.insert(5);
        bst.insert(3);
        bst.insert(4);
        bst.insert(14);

        assertThat(bst.contains(4)).isTrue();
        assertThat(bst.contains(14)).isTrue();
        assertThat(bst).hasToString("((3 5 4) 10 (14 20 30))");
    }

    @Test
    void deletion() {
        int key1 = 10;
        bst.insert(key1);
        assertThat(bst.contains(key1)).isTrue();
        bst.delete(key1);
        assertThat(bst.contains(key1)).isFalse();

        int key2 = 20;
        bst.insert(key2);
        assertThat(bst.contains(key2)).isTrue();
        bst.delete(key2);
        assertThat(bst.contains(key2)).isFalse();

        bst.delete(key2);

        assertThat(bst).hasToString("(((_ 1 _) 5 _) 10 (((_ 14 _) 15 (_ 20 _)) 30 (_ 40 _)))");

        bst.delete(15);
        assertThat(bst).hasToString("(((_ 1 _) 5 _) 10 (((_ 14 _) 20 _) 30 (_ 40 _)))");

        bst.delete(40);
        assertThat(bst).hasToString("(((_ 1 _) 5 _) 10 (((_ 14 _) 20 _) 30 _))");
    }

    @Test
    void deletionFromEmptyBst() {
        assertThat(bst.contains(20)).isFalse();
        assertThat(bst).hasToString("Bst is empty");

        bst.delete(20);

        assertThat(bst.contains(20)).isFalse();
        assertThat(bst).hasToString("Bst is empty");
    }

    @Test
    void deletionOfMin() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(5);

        assertThat(bst.contains(5)).isTrue();
        assertThat(bst).hasToString("(((_ 5 _) 10 _) 20 (_ 30 _))");

        bst.delete(5);
        assertThat(bst.contains(5)).isFalse();
        assertThat(bst).hasToString("((_ 10 _) 20 (_ 30 _))");

        bst.delete(10);
        assertThat(bst.contains(10)).isFalse();
        assertThat(bst).hasToString("(_ 20 (_ 30 _))");
    }

    @Test
    void deletionOfMax() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(40);

        assertThat(bst.contains(40)).isTrue();
        assertThat(bst).hasToString("((_ 10 _) 20 (_ 30 (_ 40 _)))");

        bst.delete(40);
        assertThat(bst.contains(40)).isFalse();
        assertThat(bst).hasToString("((_ 10 _) 20 (_ 30 _))");

        bst.delete(30);
        assertThat(bst.contains(30)).isFalse();
        assertThat(bst).hasToString("((_ 10 _) 20 _)");
    }

    @Test
    void deletionOfRoot() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);

        assertThat(bst.contains(20)).isTrue();
        assertThat(bst).hasToString("((_ 10 _) 20 (_ 30 _))");

        bst.delete(20);

        assertThat(bst.contains(20)).isFalse();
        assertThat(bst).hasToString("((_ 10 _) 30 _)");
    }

    @Test
    void deletionOfRootInTreeWithOnlyOneNode() {
        bst.insert(20);

        assertThat(bst.contains(20)).isTrue();
        assertThat(bst).hasToString("(_ 20 _)");

        bst.delete(20);

        assertThat(bst.contains(20)).isFalse();
        assertThat(bst).hasToString("Bst is empty");
    }

    @Test
    void deletionOfInternalNodeWithOnlyLeftChild() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(5);

        assertThat(bst.contains(10)).isTrue();
        assertThat(bst).hasToString("(((_ 5 _) 10 _) 20 (_ 30 _))");

        bst.delete(10);

        assertThat(bst.contains(10)).isFalse();
        assertThat(bst).hasToString("((_ 5 _) 20 (_ 30 _))");
    }

    @Test
    void deletionOfInternalNodeWithOnlyRightChild() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(15);

        assertThat(bst.contains(10)).isTrue();
        assertThat(bst).hasToString("((_ 10 (_ 15 _)) 20 (_ 30 _))");

        bst.delete(10);

        assertThat(bst.contains(10)).isFalse();
        assertThat(bst).hasToString("((_ 15 _) 20 (_ 30 _))");
    }

    @Test
    void deletionOfInternalNodeWithTwoChildren() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(15);
        bst.insert(5);

        assertThat(bst.contains(10)).isTrue();
        assertThat(bst).hasToString("(((_ 5 _) 10 (_ 15 _)) 20 (_ 30 _))");

        bst.delete(10);

        assertThat(bst.contains(10)).isFalse();
        assertThat(bst).hasToString("(((_ 5 _) 15 _) 20 (_ 30 _))");
    }

    @Test
    void deletionOfInternalNodeWithTwoChildrenAndSuccessorWithRightChild() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(25);
        bst.insert(27);
        bst.insert(35);

        assertThat(bst.contains(20)).isTrue();
        assertThat(bst).hasToString("((_ 10 _) 20 ((_ 25 (_ 27 _)) 30 (_ 35 _)))");

        bst.delete(20);

        assertThat(bst.contains(20)).isFalse();
        assertThat(bst).hasToString("((_ 10 _) 25 ((_ 27 _) 30 (_ 35 _)))");
    }

    @Test
    void deletionOfInternalNodeWithTwoChildrenAndSuccessorWithRightChild2() {
        bst.insert(20);
        bst.insert(10);
        bst.insert(30);
        bst.insert(25);
        bst.insert(27);
        bst.insert(35);

        assertThat(bst.contains(20)).isTrue();
        assertThat(bst).hasToString("((_ 10 _) 20 ((_ 25 (_ 27 _)) 30 (_ 35 _)))");

        bst.delete2(20);

        assertThat(bst.contains(20)).isFalse();
        assertThat(bst).hasToString("(_ 10 ((_ 25 (_ 27 _)) 30 (_ 35 _)))");
    }

    @Test
    void rotateLeft() {
        var root = bstNode(10);
        root.leftChildNode(bstNode(5));
        root.rightChildNode(bstNode(20));

        root.rightChildNode().leftChildNode(bstNode(14));
        root.rightChildNode().rightChildNode(bstNode(25));

        root.rightChildNode().rightChildNode().leftChildNode(bstNode(21));
        root.rightChildNode().rightChildNode().rightChildNode(bstNode(29));

        assertThat(root).hasToString("((_ 5 _) 10 ((_ 14 _) 20 ((_ 21 _) 25 (_ 29 _))))");

        bst.rotateLeft(root.rightChildNode());

        assertThat(root).hasToString("((_ 5 _) 10 (((_ 14 _) 20 (_ 21 _)) 25 (_ 29 _)))");
    }

    @Test
    void rotateRight() {
        var root = bstNode(10);

        root.leftChildNode(bstNode(5));
        root.rightChildNode(bstNode(20));

        root.leftChildNode().leftChildNode(bstNode(1));
        root.leftChildNode().rightChildNode(bstNode(6));

        root.leftChildNode().leftChildNode().leftChildNode(bstNode(0));
        root.leftChildNode().leftChildNode().rightChildNode(bstNode(3));

        assertThat(root).hasToString("((((_ 0 _) 1 (_ 3 _)) 5 (_ 6 _)) 10 (_ 20 _))");

        bst.rotateRight(root.leftChildNode());

        assertThat(root).hasToString("(((_ 0 _) 1 ((_ 3 _) 5 (_ 6 _))) 10 (_ 20 _))");
    }

    private Bst<Integer>.BstNode bstNode(int i) {
        return new Bst<Integer>().new BstNode(i);
    }

    @Test
    void insertionBalancedBst() {
        var bst = new Bst<Integer>(true);

        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        assertThat(bst).hasToString("((_ 10 _) 20 (_ 30 _))");

        bst.insert(40);
        bst.insert(50);
        assertThat(bst).hasToString("((_ 10 _) 20 ((_ 30 _) 40 (_ 50 _)))");

        bst.insert(5);
        bst.insert(4);
        assertThat(bst).hasToString("((_ 10 _) 20 ((_ 30 _) 40 (_ 50 _)))");

        bst.insert(3);
        bst.insert(2);

        assertThat(bst).hasToString("((((_ 2 _) 3 (_ 4 _)) 5 (_ 10 _)) 20 ((_ 30 _) 40 (_ 50 _)))");
    }

    @Test
    void deletionBalancedBst() {
        var bst = new Bst<Integer>(true);

        bst.insert(10);
        bst.insert(20);
        bst.insert(30);
        assertThat(bst).hasToString("((_ 10R _) 20B (_ 30R _))");

        bst.delete(20);
        assertThat(bst).hasToString("((_ 10R _) 30B _)");

        bst.insert(20);
        bst.insert(40);
        bst.insert(50);
        assertThat(bst).hasToString("(((_ 10B _) 20B _) 30B (_ 40B (_ 50R _)))");

        bst.delete(50);
        assertThat(bst).hasToString("(((_ 10B _) 20B _) 30B (_ 40B _))");

        bst.delete(20);
    }

    @Test
    void name() {
        var bst = new Bst<Integer>(true);

        bst.insert(10);
        bst.insert(20);
        bst.insert(5);
        bst.insert(8);
        bst.insert(1);
        bst.insert(11);
        bst.insert(24);
        bst.insert(25);
//        bst.insert(26);

        assertThat(bst).hasToString("(((_ 1R _) 5B (_ 8R _)) 10B ((_ 11R _) 20B (_ 24R _)))");
    }


    @Test
    void toString1() {
        var bst = new Bst<Integer>(true);

        bst.insert(10);
        bst.insert(20);
        bst.insert(5);
        bst.insert(2);
        bst.insert(8);

        System.out.println(bst.toString());
    }
}