package com.leetcode.MatchsticksToSquare;

public class MatchsticksToSquare2 {

	public static void main(String[] args) {

		int[] nums = { 5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4 };
		System.out.println(makesquare(nums));
	}

	public static boolean makesquare(int[] nums) {

		if (nums == null || nums.length < 4)
			return false;
		int sum = 0;
		for (int num : nums)
			sum += num;
		if (sum % 4 != 0)
			return false;

		return dfs(nums, new int[4], 0, sum / 4);
	}

	public static boolean dfs(int[] nums, int[] sums, int index, int target) {

		if (index == nums.length) {
			if (sums[0] == target && sums[1] == target && sums[2] == target) {
				return true;
			}
			return false;
		}

		for (int i = 0; i < 4; i++) {
			if (sums[i] + nums[index] > target)
				continue;
			sums[i] += nums[index];
			if (dfs(nums, sums, index + 1, target))
				return true;
			sums[i] -= nums[index];
		}

		return false;
	}

}
