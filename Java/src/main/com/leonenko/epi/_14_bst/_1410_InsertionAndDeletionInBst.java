package com.leonenko.epi._14_bst;

import lombok.AllArgsConstructor;


public class _1410_InsertionAndDeletionInBst {

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
                var substituteNode = deleteNode.right;
                var substituteNodeParent = deleteNode;

                while (substituteNode.left != null) {
                    substituteNodeParent = substituteNode;
                    substituteNode = substituteNode.left;
                }

                deleteNode.data = substituteNode.data;

                if (substituteNodeParent.left == substituteNode) {
                    substituteNodeParent.left = substituteNode.right;
                } else{
                    substituteNodeParent.right = substituteNode.right;
                }
            } else {
                if (rootNode == deleteNode) {
                    rootNode = deleteNode.left;
                } else {
                    if (parentNode.left == deleteNode) {
                        parentNode.left = deleteNode.left;
                    } else {
                        parentNode.right = deleteNode.left;
                    }

                }
            }

            return true;
        }

        boolean delete2(int key) {
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
                var substituteNode = deleteNode.right;
                var substituteNodeParent = deleteNode;

                while (substituteNode.left != null) {
                    substituteNodeParent = substituteNode;
                    substituteNode = substituteNode.left;
                }

                if (substituteNode != deleteNode.right) {
                    if (substituteNodeParent.left == substituteNode) {
                        substituteNodeParent.left = substituteNode.right;
                    } else{
                        substituteNodeParent.right = substituteNode.right;
                    }
                    substituteNode.right = deleteNode.right;
                }

                substituteNode.left = deleteNode.left;

                if (rootNode == deleteNode) {
                    rootNode = substituteNode;
                } else {
                    if (parentNode.left == deleteNode) {
                        parentNode.left = substituteNode;
                    } else {
                        parentNode.right = substituteNode;
                    }
                }
            } else {
                if (rootNode == deleteNode) {
                    rootNode = deleteNode.left;
                } else {
                    if (parentNode.left == deleteNode) {
                        parentNode.left = deleteNode.left;
                    } else {
                        parentNode.right = deleteNode.left;
                    }
                }
            }

            return true;
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
