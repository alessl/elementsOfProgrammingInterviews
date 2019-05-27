package com.leonenko.epi._24_honor_TODO;


import com.leonenko.epi.common.binarytree.SimpleBinaryTreeNode;

import java.util.*;

/**
 * Created by Alex on 5/4/2017.
 */
public class _2413_BinaryTreePostOrderIter {

    public static List<Integer> walkPostOrder(SimpleBinaryTreeNode<Integer> findNode) {
        var postOrder = new ArrayList<Integer>();
        var stack = new LinkedList<>(Collections.singleton(findNode));
        var prev = (SimpleBinaryTreeNode<Integer>) null;

        while (!stack.isEmpty()) {
            var curr = stack.peek();

            if (prev == null || prev.getLeftChild() == curr || prev.getRightChild() == curr) {
                if (curr.getLeftChild() != null) {
                    stack.push(curr.getLeftChild());
                } else if (curr.getRightChild() != null) {
                    stack.push(curr.getRightChild());
                } else {
                    postOrder.add(curr.getKey());

                    stack.pop();
                }
            } else if (curr.getLeftChild() == prev && curr.getRightChild() != null) {
                stack.push(curr.getRightChild());
            } else {
                postOrder.add(curr.getKey());
                stack.pop();
            }

            prev = curr;
        }
        return postOrder;
    }

    public static List<Integer> walkPostOrder2(SimpleBinaryTreeNode<Integer> findNode) {
        var postOrder = new ArrayList<Integer>();
        var stack = new LinkedList<SimpleBinaryTreeNode<Integer>>();
        var prev = (SimpleBinaryTreeNode<Integer>) null;
        var curr = findNode;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);

                curr = curr.getLeftChild();
            } else {
                var top = stack.peek();

                if (top.getRightChild() != null && top.getRightChild() != prev) {
                    curr = top.getRightChild();
                } else {
                    stack.pop();
                    prev = top;
                    postOrder.add(top.getKey());
                }
            }
        }
        return postOrder;
    }
}
