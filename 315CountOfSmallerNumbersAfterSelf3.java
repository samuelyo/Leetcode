package com.leetcode.CountOfSmallerNumbersAfterSelf;

import java.util.Arrays;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf3 {

	static class Node {
		int val, leftSum = 0, count = 0;
		Node left, right;

		public Node(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {

		int[] nums = { 6, 5, 2, 6, 1 };
		List<Integer> res = countSmaller(nums);
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<Integer> countSmaller(int[] nums) {

		Integer[] count = new Integer[nums.length];
		if (nums.length == 0) {
			return Arrays.asList(count);
		}
		Node root = new Node(nums[nums.length - 1]);
		for (int i = nums.length - 1; i >= 0; i--) {
			count[i] = insert(root, nums[i]);
		}
		return Arrays.asList(count);
	}

	private static int insert(Node node, int num) {
		int sum = 0;
		while (node.val != num) {
			if (node.val > num) {
				if (node.left == null)
					node.left = new Node(num);
				node.leftSum++;
				node = node.left;
			} else {
				sum += node.leftSum + node.count;
				if (node.right == null)
					node.right = new Node(num);
				node = node.right;
			}
		}
		node.count++;
		return sum + node.leftSum;

	}
}
