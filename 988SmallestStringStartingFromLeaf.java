package com.leetcode.SmallestStringStartingFromLeaf;

public class SmallestStringStartingFromLeaf {
    public static void main(String[] args) {

    }

    public static String smallestFromLeaf(TreeNode root) {
        if (root == null) return null;
        return dfs(root);
    }

    private static String dfs(TreeNode node) {
        char c = (char) (node.val + 'a');
        String l = null, r = null;
        if (node.left != null) {
            l = dfs(node.left);
        }
        if (node.right != null) {
            r = dfs(node.right);
        }
        if (l == null && r == null) return "" + c;
        if (l == null) return r + c;
        if (r == null) return l + c;
        return (l.compareTo(r) > 0 ? r : l) + c;
    }
}
