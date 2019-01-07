package com.leonenko.epi.common.binarytree;


import lombok.RequiredArgsConstructor;
import lombok.Setter;

public class ParentLinkBinaryTreeBuilders {

    public static <T extends Comparable<T>> ParentLinkBinaryTreeNode<T> root(T key) {
        return nodeBuilder(key).build();
    }

    public static <T extends Comparable<T>> ParentLinkBinaryTreeNode<T> root(
            T key, ParentLinkBinaryTreeNodeBuilder<T> leftChild,
            ParentLinkBinaryTreeNodeBuilder<T> rightChild) {

        return node(key, leftChild, rightChild).build();
    }

    public static <T extends Comparable<T>> ParentLinkBinaryTreeNodeBuilder<T> node(T key) {
        return nodeBuilder(key);
    }

    public static <T extends Comparable<T>> ParentLinkBinaryTreeNodeBuilder<T> node(
            T key, ParentLinkBinaryTreeNodeBuilder<T> leftChild,
            ParentLinkBinaryTreeNodeBuilder<T> rightChild) {

        var node = nodeBuilder(key);

        node.setLeftChild(leftChild);
        node.setRightChild(rightChild);

        return node;
    }

    private static <T extends Comparable<T>> ParentLinkBinaryTreeNodeBuilder<T> nodeBuilder(T key) {
        return new ParentLinkBinaryTreeNodeBuilder<>(BinaryTreeNode.<T>builder().key(key));
    }

    @RequiredArgsConstructor
    public static class ParentLinkBinaryTreeNodeBuilder<T extends Comparable<T>> {

        private final BinaryTreeNode.BinaryTreeNodeBuilder<T> nodeBuilder;

        @Setter
        private ParentLinkBinaryTreeNodeBuilder<T> rightChild;
        @Setter
        private ParentLinkBinaryTreeNodeBuilder<T> leftChild;

        BinaryTreeNode<T> build() {
            return build(null);
        }

        BinaryTreeNode<T> build(BinaryTreeNode<T> parent) {
            var node = nodeBuilder.build();

            if (parent != null) {
                node.setParent(parent);
            }

            if (leftChild != null) {
                node.setLeftChild(leftChild.build(node));
            }

            if (rightChild != null) {
                node.setRightChild(rightChild.build(node));
            }

            return node;
        }
    }
}
