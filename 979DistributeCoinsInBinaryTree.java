package com.leetcode.DistributeCoinsInBinaryTree;

public class DistributeCoinsInBinaryTree {
    public static void main(String[] args) {

    }

    static int res = 0;

    public static int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    public static int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}
