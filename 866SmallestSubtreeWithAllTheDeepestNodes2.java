package com.leetcode.SmallestSubtreeWithAllTheDeepestNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SmallestSubtreeWithAllTheDeepestNodes2 {
    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node2 = new TreeNode(2);
        TreeNode node0 = new TreeNode(0);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node4 = new TreeNode(4);

        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node1.left = node0;
        node1.right = node8;
        node2.left = node7;
        node2.right = node4;

        TreeNode node = subtreeWithAllDeepest(node3);
        System.out.println(node.val);
    }

    public static TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        int left = maxLen(root.left);
        int right = maxLen(root.right);
        if (left == right) return root;
        if (left > right) return subtreeWithAllDeepest(root.left);
        return subtreeWithAllDeepest(root.right);

    }

    public static int maxLen(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxLen(node.left), maxLen(node.right));
    }

}
