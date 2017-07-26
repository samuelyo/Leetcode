package com.leetcode.DeleteNodeInABST;

public class DeleteNodeInABST3 {

	public static void main(String[] args) {

		// TreeNode root = new TreeNode(5);
		// TreeNode node3 = new TreeNode(3);
		// TreeNode node6 = new TreeNode(6);
		// TreeNode node2 = new TreeNode(2);
		// TreeNode node4 = new TreeNode(4);
		// TreeNode node7 = new TreeNode(7);
		//
		// root.left = node3;
		// root.right = node6;
		// node3.left = node2;
		// node3.right = node4;
		// node6.right = node7;

		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);

		root.right = node2;

		TreeNode res = deleteNode(root, 1);

	}

	public static TreeNode deleteRootNode(TreeNode root) {

		if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode next = root.right;
        TreeNode pre = null;
        for(; next.left != null; pre = next, next = next.left);
        next.left = root.left;
        if(root.right != next) {
            pre.left = next.right;
            next.right = root.right;
        }
        return next;
    }
    
    public static TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null && cur.val != key) {
            pre = cur;
            if (key < cur.val) {
                cur = cur.left;
            } else if (key > cur.val) {
                cur = cur.right;
            }
        }
        if (pre == null) {
            return deleteRootNode(cur);
        }
        if (pre.left == cur) {
            pre.left = deleteRootNode(cur);
        } else {
            pre.right = deleteRootNode(cur);
        }
        return root;

	}
}
