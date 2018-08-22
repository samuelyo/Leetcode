package com.leetcode.ConstructBinaryTreeFromPreorderAndPostorderTraversal;

import java.util.*;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal2 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 5, 3, 6, 7};
        int[] post = {4, 5, 2, 6, 7, 3, 1};
        TreeNode res = constructFromPrePost(pre, post);
        List<Integer> list = new ArrayList<>();
        list = inOrder(res, list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    private static List<Integer> inOrder(TreeNode res, List<Integer> list) {
        if (res == null) {
            return list;
        }
        inOrder(res.left, list);
        list.add(res.val);
        inOrder(res.right, list);
        return list;
    }

    public static TreeNode constructFromPrePost(int[] pre, int[] post) {
        Deque<TreeNode> s = new ArrayDeque<>();
        s.offer(new TreeNode(pre[0]));
        for (int i = 1, j = 0; i < pre.length; ++i) {
            TreeNode node = new TreeNode(pre[i]);
            while (s.getLast().val == post[j]) {
                s.pollLast();
                j++;
            }
            if (s.getLast().left == null) s.getLast().left = node;
            else s.getLast().right = node;
            s.offer(node);
        }
        return s.getFirst();
    }
}
