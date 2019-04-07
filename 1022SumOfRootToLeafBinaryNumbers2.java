package com.leetcode.SumOfRootToLeafBinaryNumbers;

public class SumOfRootToLeafBinaryNumbers2 {
    public static void main(String[] args) {

    }

    private static int mod = 1000000007;

    public static int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode node, int parent) {
        if (null == node) {
            return parent % mod;
        }
        int value = (parent * 2 + node.val) % mod;
        if (node.left == null && node.right == null) {
            return value % mod;
        }
        int sum = 0;
        if (null != node.left) {
            sum += dfs(node.left, value);
        }
        if (null != node.right) {
            sum += dfs(node.right, value);
        }
        return sum % mod;
    }
}

