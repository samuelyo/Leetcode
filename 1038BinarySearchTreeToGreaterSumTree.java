package com.leetcode.BinarySearchTreeToGreaterSumTree;

public class BinarySearchTreeToGreaterSumTree {
    public static void main(String[] args) {

    }

    public static int pre = 0;

    public static TreeNode bstToGst(TreeNode root) {
        if (root.right != null) bstToGst(root.right);
        pre = root.val = pre + root.val;
        if (root.left != null) bstToGst(root.left);
        return root;
    }
}
