package com.leonenko.epi._24_honor_TODO;

import com.leonenko.tree.Bst;

import java.util.*;

/**
 * Created by Alex on 5/4/2017.
 */
public class _2413_BinaryTreePostOrderIter_TODO {

    public static void main(String[] args) {
        Bst tree = getTree();
        System.out.println(tree);
        printPostOrder(tree);
    }

    private static void printPostOrder(Bst tree) {
        System.out.println(walkPostOrder(tree.getRoot()));
        System.out.println(walkPostOrder2(tree.getRoot()));
    }

    private static List<Integer> walkPostOrder(Bst.UnmodifiableNode node) {
        var postOrder = new ArrayList<Integer>();
        var stack = new LinkedList<>(Collections.singleton(node));
        var prev = (Bst.UnmodifiableNode) null;

        while (!stack.isEmpty()) {
            var curr = stack.peek();

            if (prev == null || prev.getLeft() == curr || prev.getRight() == curr) {
                if (curr.getLeft() != null) {
                    stack.push(curr.getLeft());
                } else if (curr.getRight() != null) {
                    stack.push(curr.getRight());
                } else {
                    postOrder.add(curr.getKey());

                    stack.pop();
                }
            } else if (curr.getLeft() == prev && curr.getRight() != null) {
                stack.push(curr.getRight());
            } else {
                postOrder.add(curr.getKey());
                stack.pop();
            }

            prev = curr;
        }
        return postOrder;
    }

    private static List<Integer> walkPostOrder2(Bst.UnmodifiableNode node) {
        var postOrder = new ArrayList<Integer>();
        var stack = new LinkedList<Bst.UnmodifiableNode>();
        var prev = (Bst.UnmodifiableNode) null;
        var curr = node;

        while (!stack.isEmpty() || curr != null) {
            if (curr != null) {
                stack.push(curr);

                curr = curr.getLeft();
            } else {
                var top = stack.peek();

                if (top.getRight() != null && top.getRight() != prev) {
                    curr = top.getRight();
                } else {
                    stack.pop();
                    prev = top;
                    postOrder.add(top.getKey());
                }
            }
        }
        return postOrder;
    }

    private static Bst getTree() {
        Bst tree = new Bst(true);
        new Random().ints(10, 0, 100 + 1)
                    .forEach(tree::insert);
        return tree;
    }
}
