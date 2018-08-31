package com.leetcode.AllPossibleFullBinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class AllPossibleFullBinaryTrees {
    public static void main(String[] args) {
        int N = 7;
        List<TreeNode> list = allPossibleFBT(N);
        System.out.println(list.size());
    }

    public static List<TreeNode> allPossibleFBT(int N) {
        if (N == 1) {
            TreeNode root = new TreeNode(0);
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            return list;
        }
        N--;
        List<TreeNode> list = new ArrayList<>();
        for (int i = 1; i < N; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
