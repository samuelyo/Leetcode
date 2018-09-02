package com.leetcode.IncreasingOrderSearchTree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree2 {
    public static void main(String[] args) {

    }

    public static TreeNode increasingBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        if (list.size() == 0) {
            return null;
        }
        TreeNode node = new TreeNode(list.get(0));
        TreeNode pre = node;
        for (int i = 1; i < list.size(); i++) {
            TreeNode cur = new TreeNode(list.get(i));
            pre.right = cur;
            pre = cur;
        }
        return node;
    }

    private static void helper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }
}
