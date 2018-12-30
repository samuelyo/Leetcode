package com.leetcode.UnivaluedBinaryTree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class UnivaluedBinaryTree {
    public static void main(String[] args) {

    }

    public static boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        Set<Integer> set = new HashSet<>();
        set.add(root.val);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
                set.add(cur.left.val);
            }
            if (cur.right != null) {
                queue.add(cur.right);
                set.add(cur.right.val);
            }
        }
        return set.size() == 1;
    }
}
