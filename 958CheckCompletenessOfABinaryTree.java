package com.leetcode.CheckCompletenessOfABinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {
    public static void main(String[] args) {

    }

    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean allNull = true;
            boolean hasNull = false;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur == null) {
                    hasNull = true;
                } else {
                    allNull = false;
                    if (hasNull) {
                        return false;
                    }
                }
                queue.offer(cur == null ? null : cur.left);
                queue.offer(cur == null ? null : cur.right);
            }
            if (allNull) {
                break;
            }
            if (hasNull) {
                boolean nextNull = true;
                int temp = queue.size();
                for (int j = 0; j < temp; j++) {
                    TreeNode node = queue.poll();
                    if (node != null) {
                        nextNull = false;
                    }
                    queue.offer(node);
                }
                if (!nextNull) {
                    return false;
                }
            }
        }
        return true;
    }
}
