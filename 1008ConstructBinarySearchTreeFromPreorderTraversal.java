package com.leetcode.ConstructBinarySearchTreeFromPreorderTraversal;

public class ConstructBinarySearchTreeFromPreorderTraversal {
    public static void main(String[] args) {

    }

    public static int i = 0;

    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderHelper(preorder, 0, 100);
    }

    public static TreeNode bstFromPreorderHelper(int[] preorder, int low, int high) {
        if (i == preorder.length || preorder[i] < low || preorder[i] > high) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i]);
        root.left = bstFromPreorderHelper(preorder, low, root.val);
        root.right = bstFromPreorderHelper(preorder, root.val, high);
        i++;
        return root;
    }
}
