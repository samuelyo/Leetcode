package com.leetcode.NextGreaterElementII;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII2 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 1 };
		int[] res = nextGreaterElements(nums);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	public static int[] nextGreaterElements(int[] nums) {

		int n = nums.length, next[] = new int[n];
		Arrays.fill(next, -1);
		Stack<Integer> stack = new Stack<Integer>(); // index stack
		for (int i = 0; i < n * 2; i++) {
			int num = nums[i % n];
			while (!stack.isEmpty() && nums[stack.peek()] < num)
				next[stack.pop()] = num;
			if (i < n)
				stack.push(i);
		}
		return next;

	}

}
