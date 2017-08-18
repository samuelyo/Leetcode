package com.leetcode.OneThreeTwoPattern;

import java.util.Stack;

public class OneThreeTwoPattern3 {

	public static void main(String[] args) {

		int[] nums = { -1, 3, 2, 0 };
		System.out.println(find132pattern(nums));

	}

	public static boolean find132pattern(int[] nums) {

		int thirdIndex = Integer.MIN_VALUE;
		//Stack is storing the num whose value is bigger than thirdIndex's value by index
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] < thirdIndex) {
				return true;
			} else {
				while (!stack.isEmpty() && nums[i] > stack.peek()) {
					thirdIndex = stack.pop();
				}
			}
			stack.push(nums[i]);
		}
		return false;

	}
}
