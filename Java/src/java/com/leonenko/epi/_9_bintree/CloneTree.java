package com.leonenko.epi._9_bintree;

import com.leonenko.tree.Bst;

import java.util.Random;

/**
 * Created by Alex on 5/3/2017.
 */
public class CloneTree {

    public static void main(String[] args) {
        Bst tree = getTree();
        System.out.println("Original");
        System.out.println(tree);

        Bst cloneTree = cloneTree(tree);
        System.out.println("Clone");
        System.out.println(cloneTree);
    }

    static Bst cloneTree(Bst bst) {
        Bst cloneTree = new Bst(false);
        cloneTree(bst.getRoot(), cloneTree);
        return cloneTree;
    }

    private static void cloneTree(Bst.UnmodifiableNode node, Bst cloneTree) {
        if (node == null) {
            return;
        }
        cloneTree.insert(node.getKey());
        cloneTree(node.getLeft(), cloneTree);
        cloneTree(node.getRight(), cloneTree);
    }

    private static Bst getTree() {
        Bst tree = new Bst(true);
        Random random = new Random();
        int num = 10;
        int minNum = 0;
        int maxNum = 100 + 1;
        random.ints(num, minNum, maxNum).forEach(tree::insert);
        return tree;
    }
}
