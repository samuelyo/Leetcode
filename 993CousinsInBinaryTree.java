package com.leetcode.CousinsInBinaryTree;

public class CousinsInBinaryTree {

    public static void main(String[] args) {

    }

    int depth_x = -1;
    int depth_y = -1;
    TreeNode parent_x = null, parent_y = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        helper(root, null, x, y, 0);
        if (depth_x == depth_y) {
            if (parent_x != null && parent_y != null && parent_x != parent_y) {
                return true;
            }
        }
        return false;
    }

    public void helper(TreeNode node, TreeNode parent, int x, int y, int depth) {
        if (node == null) return;
        if (node.val == x) {
            depth_x = depth;
            parent_x = parent;
        }
        if (node.val == y) {
            depth_y = depth;
            parent_y = parent;
        }
        helper(node.left, node, x, y, depth + 1);
        helper(node.right, node, x, y, depth + 1);
    }
}
