package com.leonenko.epi.common.binarytree;

public interface ParentLinkBinaryTreeNode<T extends Comparable<T>> extends SimpleBinaryTreeNode<T> {

    @Override
    ParentLinkBinaryTreeNode<T> getLeftChild();

    @Override
    ParentLinkBinaryTreeNode<T> getRightChild();

    ParentLinkBinaryTreeNode<T> getParent();

    default ParentLinkBinaryTreeNode<T> findNode(T key) {
        return SimpleBinaryTreeNode.findNode(this, key);
    }
}
