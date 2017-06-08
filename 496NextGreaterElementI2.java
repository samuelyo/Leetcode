package com.leetcode.NextGreaterElementI;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI2 {

	public static void main(String[] args) {

		int[] findNums = { 3,1,2 };
		int[] nums = { 9,8,7,3,2,1,6 };
		int[] ans = nextGreaterElement(findNums, nums);
		for (int i = 0; i < ans.length; i++) {
			System.out.print(ans[i] + " ");
		}

	}

	public static int[] nextGreaterElement(int[] findNums, int[] nums) {

		Map<Integer, Integer> map = new HashMap<Integer,Integer>(); // map from x to next
														
		Stack<Integer> stack = new Stack<Integer>();// greater element of x
		for (int num : nums) {
			while (!stack.isEmpty() && stack.peek() < num)
				map.put(stack.pop(), num);
			stack.push(num);
		}
		for (int i = 0; i < findNums.length; i++)
			findNums[i] = map.getOrDefault(findNums[i], -1);
		return findNums;
	}
}
