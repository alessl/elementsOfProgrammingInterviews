package com.leonenko.myinterview.facebook;

import com.leonenko.tree.Bst;
import com.leonenko.tree.PrettyPrint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Alex on 5/26/2017.
 *
 * http://www.geeksforgeeks.org/find-distance-two-given-nodes/
 *
 * // TODO try solve it as a graph
 */
public class ShortestPathBetweenNodes2 {

    public static void main(String[] args) {
        Bst tree = getTree();
        PrettyPrint.printHorizontally(tree);
        printShortestPath(tree, 35, 29);
        printShortestPath(tree, 35, 50);
        printShortestPath(tree, 19, 7);
        printShortestPath(tree, 15, 19);
        printShortestPath(tree, 50, 9);
    }

    private static void printShortestPath(Bst tree, int key1, int key2) {
        List<Integer> shortestPath;
        Bst.UnmodifiableNode lca = getLCA(tree.getRoot(), key1, key2);
        if (lca.getKey() != key1 && lca.getKey() != key2) {
            shortestPath = getPath(lca, key1);
            List<Integer> path2 = getPath(lca, key2);
            Collections.reverse(path2);
            shortestPath.addAll(path2);
        } else if (lca.getKey() == key1) {
            shortestPath = getPath(lca, key2);
            Collections.reverse(shortestPath);
        } else {
            shortestPath = getPath(lca, key1);
            Collections.reverse(shortestPath);
        }
        System.out.printf("from %s to %s: %s%n", key1, key2, shortestPath);
    }

    private static Bst.UnmodifiableNode getLCA(Bst.UnmodifiableNode root, int key1, int key2) {
        if (root == null) {
            return null;
        }
        if (root.getKey() == key1 || root.getKey() == key2) {
            return root;
        }
        Bst.UnmodifiableNode leftLCA = getLCA(root.getLeft(), key1, key2);
        Bst.UnmodifiableNode rightLCA = getLCA(root.getRight(), key1, key2);
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        if (leftLCA != null) {
            return leftLCA;
        }
        if (rightLCA != null) {
            return rightLCA;
        }
        return null;
    }

    private static List<Integer> getPath(Bst.UnmodifiableNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.getKey() == key) {
            return new ArrayList<>(Collections.singleton(key));
        }
        List<Integer> path = getPath(root.getLeft(), key);
        if (path == null) {
            path = getPath(root.getRight(), key);
        }
        if (path != null) {
            path.add(root.getKey());
        }
        return path;
    }

    private static Bst getTree() {
        return new Bst(false)
                .insert(20)
                .insert(35)
                .insert(15)
                .insert(16)
                .insert(17)
                .insert(18)
                .insert(19)
                .insert(14)
                .insert(2)
                .insert(7)
                .insert(9)
                .insert(50)
                .insert(24)
                .insert(26)
                .insert(29);
    }
}
