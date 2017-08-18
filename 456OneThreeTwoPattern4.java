package com.leetcode.OneThreeTwoPattern;

import java.util.Stack;

class Pair {
	int min, max;

	public Pair(int min, int max) {
		this.min = min;
		this.max = max;
	}
}

public class OneThreeTwoPattern4 {

	public static void main(String[] args) {

		int[] nums = { 3, 1, 4, 2 };
		System.out.println(find132pattern(nums));

	}

	public static boolean find132pattern(int[] nums) {

		Stack<Pair> stack = new Stack<Pair>();
		for (int n : nums) {
			if (stack.isEmpty() || n < stack.peek().min)
				stack.push(new Pair(n, n));
			else if (n > stack.peek().min) {
				Pair last = stack.pop();
				if (n < last.max)
					return true;
				else {
					last.max = n;
					while (!stack.isEmpty() && n >= stack.peek().max)
						stack.pop();
					// At this time, n < stack.peek().max (if stack not empty)
					if (!stack.isEmpty() && stack.peek().min < n)
						return true;
					stack.push(last);
				}

			}
		}
		return false;

	}
}
