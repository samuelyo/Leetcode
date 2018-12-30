package com.leetcode.BinaryTreeCameras;

public class BinaryTreeCameras {
    public static void main(String[] args) {

    }

    static int res = 0;

    public static int minCameraCover(TreeNode root) {
        return (dfs(root) < 1 ? 1 : 0) + res;
    }

    public static int dfs(TreeNode root) {
        int left = root.left == null ? 2 : dfs(root.left),
                right = root.right == null ? 2 : dfs(root.right);
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        return left == 1 || right == 1 ? 2 : 0;
    }
}
