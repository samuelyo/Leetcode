package com.leetcode.RangeSumOfBST;

public class RangeSumOfBST {
    //10,5,15,3,7,null,18
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(18);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;

        int sum = rangeSumBST(root, 7, 15);
        System.out.println(sum);
    }

    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (root.val >= L && root.val <= R) {
                return root.val;
            } else {
                return 0;
            }
        }
        int sum = 0;
        sum += rangeSumBST(root.left, L, R);
        sum += rangeSumBST(root.right, L, R);
        if (root.val >= L && root.val <= R) {
            sum += root.val;
        }
        return sum;
    }
}
