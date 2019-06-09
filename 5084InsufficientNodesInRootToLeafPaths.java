package com.leetcode.InsufficientNodesInRootToLeafPaths;

public class InsufficientNodesInRootToLeafPaths {
    public static void main(String[] args) {

    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root.left == root.right)
            return root.val < limit ? null : root;
        if (root.left != null)
            root.left = sufficientSubset(root.left, limit - root.val);
        if (root.right != null)
            root.right = sufficientSubset(root.right, limit - root.val);
        return root.left == root.right ? null : root;
    }
}
