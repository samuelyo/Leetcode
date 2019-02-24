package com.leetcode.MaximumBinaryTreeII;

public class MaximumBinaryTreeII2 {
    public static void main(String[] args) {

    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val < val) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}
