package com.leetcode.IncreasingOrderSearchTree;

import java.util.*;

public class IncreasingOrderSearchTree {
    public static void main(String[] args) {

    }

    public static TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        return helper(root, null);
    }

    private static TreeNode helper(TreeNode root, TreeNode tail) {
        if (root == null) {
            return tail;
        }
        TreeNode res = helper(root.left, root);
        root.left = null;
        root.right = helper(root.right, tail);
        return res;
    }
}
