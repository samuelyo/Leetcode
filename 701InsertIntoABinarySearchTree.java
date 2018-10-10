package com.leetcode.InsertIntoABinarySearchTree;

public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {

    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode pre = root;
        TreeNode node = root;
        while (node != null) {
            if (node.val > val) {
                pre = node;
                node = node.left;
            } else {
                pre = node;
                node = node.right;
            }
        }
        TreeNode temp = new TreeNode(val);
        if (pre.val > val) {
            pre.left = temp;
        } else {
            pre.right = temp;
        }
        return root;
    }
}
