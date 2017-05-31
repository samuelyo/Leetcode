package com.leetcode.PathSumIII;

import java.util.HashMap;

public class PathSumIII2 {

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.right = t5;

		System.out.println(pathSum(t1, 9));

	}

	/**
	 * using HashMap to store ( key : the prefix sum, value : how many ways get
	 * to this prefix sum) , and whenever reach a node, we check if prefix sum -
	 * target exists in hashmap or not, if it does, we added up the ways of
	 * prefix sum - target into res. For instance : in one path we have
	 * 1,2,-1,-1,2, then the prefix sum will be: 1, 3, 2, 1, 3, let's say we
	 * want to find target sum is 2, then we will have{2}, {1,2,-1}, {2,-1,-1,2}
	 * and {2}ways.
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public static int pathSum(TreeNode root, int sum) {

		HashMap<Integer, Integer> preSum = new HashMap();
		preSum.put(0, 1);
		helper(root, 0, sum, preSum);
		return count;
	}

	static int count = 0;

	public static void helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
		if (root == null) {
			return;
		}

		currSum += root.val;

		if (preSum.containsKey(currSum - target)) {
			count += preSum.get(currSum - target);
		}

		if (!preSum.containsKey(currSum)) {
			preSum.put(currSum, 1);
		} else {
			preSum.put(currSum, preSum.get(currSum) + 1);
		}

		helper(root.left, currSum, target, preSum);
		helper(root.right, currSum, target, preSum);
		// minus the key-value pair in the map which key is the sum of the root to the leaf
		preSum.put(currSum, preSum.get(currSum) - 1);
	}
}
