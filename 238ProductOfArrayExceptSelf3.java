package com.leetcode.ProductOfArrayExceptSelf;

public class ProductOfArrayExceptSelf3 {

	public static void main(String[] args) {
		
		int[] nums = {1,2,3,4};
		int[] pro = productExceptSelf(nums);
		for(int i = 0;i<pro.length;i++){
			System.out.print(pro[i] + " ");
		}

	}

	public static int[] productExceptSelf(int[] nums) {
		
		int len = nums.length;
		long[] leftPro = new long[len];
		long[] rightPro = new long[len];
		
		long res = 1;
		for(int i = 0;i<len;i++) {
			res *= nums[i];
			leftPro[i] = res;
		}
		res = 1;
		for(int i = len - 1;i>=0;i--) {
			res *= nums[i];
			rightPro[i] = res;
		}
		
		int[] ans = new int[len];
		for(int i = 0;i<len;i++) {
			ans[i] = (int) ((i - 1 >= 0 ? leftPro[i - 1] : 1) * (i + 1 < len ? rightPro[i + 1] : 1));
		}
		return ans;
		
	}
}
