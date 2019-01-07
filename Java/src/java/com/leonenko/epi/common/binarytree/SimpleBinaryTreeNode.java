package com.leonenko.epi.common.binarytree;

public interface SimpleBinaryTreeNode<T extends Comparable<T>> {
    T getKey();

    SimpleBinaryTreeNode<T> getLeftChild();

    SimpleBinaryTreeNode<T> getRightChild();

    default boolean isLeaf() {
        return getLeftChild() == null && getRightChild() == null;
    }

    default int size() {
        return size(getLeftChild()) + size(getRightChild()) + 1;
    }

    private static <T extends Comparable<T>, N extends SimpleBinaryTreeNode<T>> int size(N root) {
        if (root == null) {
            return 0;
        }

        return size(root.getLeftChild()) + size(root.getRightChild()) + 1;
    }

    default SimpleBinaryTreeNode<T> findNode(T key) {
        return findNode(this, key);
    }

    static <T extends Comparable<T>, N extends SimpleBinaryTreeNode<T>> N findNode(N root, T key) {
        if (root == null || root.getKey().compareTo(key) == 0) {
            return root;
        }

        var foundNode = findNode(root.getLeftChild(), key);

        if (foundNode != null) {
            return (N) foundNode;
        }

        return (N) findNode(root.getRightChild(), key);
    }
}
