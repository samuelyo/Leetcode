package com.leetcode.LowestCommonAncestorOfDeepestLeaves;

public class LowestCommonAncestorOfDeepestLeaves2 {
    public static void main(String[] args) {

    }

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null || height(root.right) == height(root.left)) return root;
        return lcaDeepestLeaves(height(root.left) > height(root.right) ? root.left : root.right);
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
