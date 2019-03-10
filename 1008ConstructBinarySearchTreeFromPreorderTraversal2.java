package com.leetcode.ConstructBinarySearchTreeFromPreorderTraversal;

public class ConstructBinarySearchTreeFromPreorderTraversal2 {
    public static void main(String[] args) {

    }

    public static int i = 0;

    public static TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorderHelper(preorder, Integer.MAX_VALUE);
    }

    public static TreeNode bstFromPreorderHelper(int[] preorder, int max) {
        if (i >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[i++]);
        if(i < preorder.length && preorder[i] < root.val) {
            root.left = bstFromPreorderHelper(preorder, root.val);
        }
        if(i < preorder.length && preorder[i] < max) {
            root.right = bstFromPreorderHelper(preorder, max);
        }
        return root;
    }
}
