package com.leonenko.epi.common.binarytree;


import lombok.RequiredArgsConstructor;

public class SimpleBinaryTreeBuilders {

    public static <T extends Comparable<T>> SimpleBinaryTreeNode<T> root(T key) {
        return node(key).build();
    }

    public static <T extends Comparable<T>> SimpleBinaryTreeNode<T> root(
            SimpleBinaryTreeNodeBuilder<T> root) {
        return root != null ? root.build() : null;
    }

    public static <T extends Comparable<T>> SimpleBinaryTreeNode<T> root(
            T key,
            SimpleBinaryTreeNodeBuilder<T> leftChild,
            SimpleBinaryTreeNodeBuilder<T> rightChild) {
        return node(key, leftChild, rightChild)
                .build();
    }

    public static <T extends Comparable<T>> SimpleBinaryTreeNodeBuilder<T> node(
            T key,
            SimpleBinaryTreeNodeBuilder<T> leftChild,
            SimpleBinaryTreeNodeBuilder<T> rightChild) {
        return node(key)
                .leftChild(leftChild)
                .rightChild(rightChild);
    }

    public static <T extends Comparable<T>> SimpleBinaryTreeNodeBuilder<T> node(T key) {
        return new SimpleBinaryTreeNodeBuilder<>(BinaryTreeNode.<T>builder().key(key));
    }

    @RequiredArgsConstructor
    public static class SimpleBinaryTreeNodeBuilder<T extends Comparable<T>> {
        private final BinaryTreeNode.BinaryTreeNodeBuilder<T> nodeBuilder;

        BinaryTreeNode<T> build() {
            return nodeBuilder.build();
        }

        SimpleBinaryTreeNodeBuilder<T> leftChild(SimpleBinaryTreeNodeBuilder<T> leftChild) {
            if (leftChild != null) {
                nodeBuilder.leftChild(leftChild.build());
            }
            return this;
        }

        SimpleBinaryTreeNodeBuilder<T> rightChild(SimpleBinaryTreeNodeBuilder<T> rightChild) {
            if (rightChild != null) {
                nodeBuilder.rightChild(rightChild.build());
            }
            return this;
        }
    }
}
