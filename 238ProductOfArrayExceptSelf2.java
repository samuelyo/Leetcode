package com.leetcode.ProductOfArrayExceptSelf;

public class ProductOfArrayExceptSelf2 {

	public static void main(String[] args) {

		int[] nums = { 1,2,3,4 };
		int[] pro = productExceptSelf(nums);
		for (int i = 0; i < pro.length; i++) {
			System.out.print(pro[i] + " ");
		}

	}

	public static int[] productExceptSelf(int[] nums) {

		int n = nums.length;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			res[i] = res[i - 1] * nums[i - 1];
		}
		int right = 1;
		for (int i = n - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}
		return res;

	}

}
