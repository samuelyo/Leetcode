package com.leetcode.JumpGameII;

public class JumpGameII3 {

	public static void main(String[] args) {

		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(jump(nums));

	}

	public static int jump(int[] nums) {

		if (nums.length < 2)
			return 0;
		int level = 0, currentMax = 0, i = 0, nextMax = 0;
		while (currentMax - i + 1 > 0) { // nodes count of current level>0
			for (; i <= currentMax; i++) { // traverse current level , and
											// update the max reach of next
											// level
				nextMax = Math.max(nextMax, nums[i] + i);
				if (nextMax >= nums.length - 1)
					return level + 1; // if last element is in level+1, then the min
									// jump=level
			}
			currentMax = nextMax;
			level ++;
		}
		return 0;
	}

}
