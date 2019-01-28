package com.leonenko.epi._14_bst_TODO;

import lombok.AllArgsConstructor;


public class _1410_InsertionAndDeletionInBst_TODO {

    static BinaryTree createBst() {
        return new BinaryTree();
    }

    static class BinaryTree {

        private TreeNode rootNode;

        boolean insert(int key) {
            var newNode = new TreeNode(key, null, null);

            if (rootNode == null) {
                rootNode = newNode;
            } else {
                var currNode = rootNode;
                var parentNode = currNode;

                while (currNode != null) {
                    parentNode =currNode;

                    if (key == currNode.data) {
                        return false;
                    } else if (key < currNode.data) {
                        currNode = currNode.left;
                    } else {
                        currNode = currNode.right;
                    }
                }

                if (key < parentNode.data) {
                    parentNode.left = newNode;
                } else {
                    parentNode.right = newNode;
                }
            }

            return true;
        }

        boolean delete1(int key) {
            var currNode = rootNode;
            var parentNode = (TreeNode) null;

            while (currNode != null && currNode.data != key) {
                parentNode = currNode;
                currNode = key < currNode.data ? currNode.left : currNode.right;
            }

            if (currNode == null) {
                return false;
            }

            var deleteNode = currNode;

            if (deleteNode.right != null) {
                var deleteRightNode = deleteNode.right;
                var deleteParent = deleteNode;

                while (deleteRightNode.left != null) {
                    deleteParent = deleteRightNode;
                    deleteRightNode = deleteRightNode.left;
                }

                deleteNode.data = deleteRightNode.data;

                if (deleteParent.left == deleteRightNode) {
                    deleteParent.left = deleteRightNode.right;
                } else{
                    deleteParent.right = deleteRightNode.right;
                }

                deleteRightNode.right = null;

            } else {
                if (rootNode == deleteNode) {
                    rootNode = deleteNode.left;
                } else {
                    if (parentNode.left == deleteNode) {
                        parentNode.left = deleteNode.left;
                    } else {
                        deleteNode.right = deleteNode.left;
                    }

                }

                deleteNode.left = null;
            }

            return true;
        }

        boolean delete2(int key) {
            return false;
        }

        @Override
        public String toString() {
            return rootNode.toString();
        }
    }

    @AllArgsConstructor
    private static class TreeNode {
        private Integer data;
        private TreeNode left;
        private TreeNode right;

        @Override
        public String toString() {
            return String.format("(%s %s %s)",
                    (left != null ? left.toString() : "-"),
                    data,
                    (right != null ? right.toString() : "-"));
        }
    }
}
