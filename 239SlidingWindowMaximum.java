package com.leetcode.SlidingWindowMaximum;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		
		int[] nums = {1,3,-1,-3,5,3,6,7};
		int k = 3;
		int[] res = maxSlidingWindow(nums, k);
		for(int i = 0;i<res.length;i++){
			System.out.print(res[i] + " ");
		}

	}

	public static int[] maxSlidingWindow(int[] nums, int k) {
		
		if(nums.length - k + 1 < 0){
			return null;
		}
		if(k == 0){
			return new int[0];
		}
		int[] res = new int[nums.length - k + 1];
		int max = Integer.MIN_VALUE;
		for(int i = 0;i<k;i++){
			max = Math.max(max, nums[i]);
		}
		res[0] = max;
		for(int i = 1;i<res.length;i++){
			if(nums[i - 1] != max){
				max = Math.max(max, nums[i + k - 1]);
			}else{
				int newMax = Integer.MIN_VALUE;
				for(int j = i;j < k+i;j++){
					newMax = Math.max(newMax, nums[j]);
				}
				max = newMax;
			}
			res[i] = max;
		}
		return res;
		
	}
}
