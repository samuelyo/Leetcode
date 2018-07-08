package com.leetcode.SmallestSubtreeWithAllTheDeepestNodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SmallestSubtreeWithAllTheDeepestNodes {
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
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        int maxLen = maxLen(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (level == maxLen) {
                    list.add(cur);
                }
            }
        }
        if (list.size() == 1) {
            return list.get(0);
        }
        TreeNode res = lowestCommonAncestor(root, list.get(0), list.get(1));
        for (int i = 2; i < list.size(); i++) {
            res = lowestCommonAncestor(root, res, list.get(i));
        }
        return res;

    }

    public static int maxLen(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(maxLen(node.left), maxLen(node.right));
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == root || q == root) {
            return root;
        }
        TreeNode node1 = lowestCommonAncestor(root.left, p, q);
        TreeNode node2 = lowestCommonAncestor(root.right, p, q);
        if (node1 != null && node2 != null) {
            return root;
        } else if (node1 != null) {
            return node1;
        } else {
            return node2;
        }

    }
}
