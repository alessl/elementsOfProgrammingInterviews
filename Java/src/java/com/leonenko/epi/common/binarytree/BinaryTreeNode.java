package com.leonenko.epi.common.binarytree;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString(exclude = "parent", includeFieldNames = false)
class BinaryTreeNode<T extends Comparable<T>> implements ParentLinkBinaryTreeNode<T> {

    private final T key;

    private BinaryTreeNode<T> parent;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;
}
