package com.leetcode.BinaryTreeMaximumPathSum;

public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		
		node1.left = node2;
		node1.right = node3;
		
		System.out.println(maxPathSum(node1));

	}

	public static int maxPathSum(TreeNode root) {
		
		int[] res = new int[1];
		res[0] = root.val;
		maxPathSumDFS(root, res);
		return res[0];
		
	}
	
	/**
	 * DFS(n) = max(DFS(n->left) + n->val, DFS(n->right) + n->val, n->val);

     * top(n) = max(DFS(n), DFS(n->left) + DFS(n->right) + n->val, n->val);

     * res = max(res, top(n));
	 * @param node
	 * @param res
	 * @return
	 */
	public static int maxPathSumDFS(TreeNode node, int[] res) {
		
		if(node == null) {
			return 0;
		}
		int left = maxPathSumDFS(node.left, res);
		int right = maxPathSumDFS(node.right, res);
		int top = node.val + (left > 0 ? left : 0) + (right > 0 ? right : 0);
		res[0] = Math.max(res[0], top);
		return Math.max(left, right) > 0 ? Math.max(left, right) + node.val : node.val;
	}
}
