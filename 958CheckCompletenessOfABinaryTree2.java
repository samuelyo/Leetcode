package com.leetcode.CheckCompletenessOfABinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree2 {
    public static void main(String[] args) {

    }

    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();
    }
}
