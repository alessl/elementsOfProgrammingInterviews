package com.leonenko.myinterview.facebook;

import com.leonenko.tree.Bst;
import com.leonenko.tree.PrettyPrint;

import java.util.*;

/**
 * Created by Alex on 5/26/2017.
 *
 * http://www.geeksforgeeks.org/find-distance-two-given-nodes/
 */
public class ShortestPathBetweenNodes {

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
        Path shortestPath = getShortestPath(tree.getRoot(), key1, key2);
        System.out.printf("from %s to %s: %s%n", key1, key2, shortestPath);
    }

    private static Path getShortestPath(
            Bst.UnmodifiableNode root, int key1, int key2) {
        if (root == null) {
            return null;
        }
        Path leftPath = getShortestPath(root.getLeft(), key1, key2);
        if (leftPath != null && leftPath.isDone) {
            return leftPath;
        }
        Path rightPath = getShortestPath(root.getRight(), key1, key2);
        if (rightPath != null && rightPath.isDone) {
            return rightPath;
        }
        if (leftPath != null && rightPath != null) {
            leftPath.setDone();
            leftPath.push(root);
            leftPath.pushAll(rightPath);
            return leftPath;
        }
        Path path = leftPath != null ? leftPath : rightPath;
        if (root.getKey() == key1 || root.getKey() == key2) {
            if (path == null) {
                path = new Path();
            } else {
                path.setDone();
            }
        }
        if (path != null) {
            path.push(root);
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

    private static final class Path {
        private Deque<Integer> nodes = new LinkedList<>();
        private boolean isDone;

        void push(Bst.UnmodifiableNode node) {
            nodes.push(node.getKey());
        }

        void pushAll(Path path) {
            for (int key : path.nodes) {
                nodes.push(key);
            }
        }

        void setDone() {
            isDone = true;
        }

        @Override
        public String toString() {
            return nodes.toString();
        }
    }
}
