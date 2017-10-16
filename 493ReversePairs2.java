package com.leetcode.ReversePairs;

public class ReversePairs2 {

	static class Node {
		int val, cnt;
		Node left, right;

		Node(int val) {
			this.val = val;
			this.cnt = 1;
		}
	}

	public static void main(String[] args) {

		int[] nums = { 2, 4, 3, 5, 1 };
		int res = reversePairs(nums);
		System.out.println(res);

	}

	public static int reversePairs(int[] nums) {

		int res = 0;
		Node root = null;

		for (int ele : nums) {
			res += search(root, 2L * ele + 1);
			root = insert(root, ele);
		}

		return res;

	}

	private static int search(Node root, long val) {

		if (root == null) {
			return 0;
		} else if (val == root.val) {
			return root.cnt;
		} else if (val < root.val) {
			return root.cnt + search(root.left, val);
		} else {
			return search(root.right, val);
		}
	}

	private static Node insert(Node root, int val) {

		if (root == null) {
			root = new Node(val);
		} else if (val == root.val) {
			root.cnt++;
		} else if (val < root.val) {
			root.left = insert(root.left, val);
		} else {
			root.cnt++;
			root.right = insert(root.right, val);
		}

		return root;
	}

}
