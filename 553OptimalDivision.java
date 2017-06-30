package com.leetcode.OptimalDivision;

public class OptimalDivision {

	public static void main(String[] args) {

		int[] nums = { 1, 2 };
		System.out.println(optimalDivision(nums));

	}

	public static String optimalDivision(int[] nums) {

		// X1/X2/X3/../Xn will always be equal to (X1/X2) * Y, no matter how you
		// place parentheses. i.e no matter how you place parentheses, X1 always
		// goes to the numerator and X2 always goes to the denominator. Hence
		// you just need to maximize Y. And Y is maximized when it is equal to
		// X3 *..*Xn. So the answer is always X1/(X2/X3/../Xn) = (X1 *X3
		// *..*Xn)/X2
		
		
		StringBuilder ans = new StringBuilder();
		if (nums.length == 1) {
			return nums[0] + "";
		}
		if (nums.length == 2) {
			return nums[0] + "/" + nums[1];
		}
		if (nums.length >= 3) {
			ans.append(nums[0] + "/" + "(");
			for (int i = 1; i < nums.length - 1; i++) {
				ans.append(nums[i] + "/");
			}
			ans.append(nums[nums.length - 1] + ")");
		}
		return ans.toString();
	}

}
