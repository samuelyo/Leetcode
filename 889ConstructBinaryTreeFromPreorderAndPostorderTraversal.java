package com.leetcode.ConstructBinaryTreeFromPreorderAndPostorderTraversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {
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
        if (pre == null || post == null || pre.length == 0 || post.length == 0 || pre.length != post.length) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            map.put(post[i], i);
        }
        return builder(pre, 0, pre.length - 1, post, 0, post.length - 1, map);
    }

    private static TreeNode builder(int[] pre, int prestart, int preend, int[] post, int poststart, int postend, Map<Integer, Integer> map) {
        if (prestart > preend || poststart > postend) {
            return null;
        }
        TreeNode root = new TreeNode(pre[prestart]);
        if (prestart + 1 <= preend) {
            int index = map.get(pre[prestart + 1]);
            int len = index - poststart;
            root.left = builder(pre, prestart + 1, prestart + len + 1, post, poststart, poststart + len, map);
            root.right = builder(pre, prestart + len + 2, preend, post, poststart + len + 1, postend, map);
        }
        return root;
    }
}
