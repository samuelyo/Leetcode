package com.leetcode.TrappingRainWater;

public class TrappingRainWater3 {

	public static void main(String[] args) {
		
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));

	}

	public static int trap(int[] height) {
		
		int sum = 0;
		int len = height.length;
		int[] left = new int[len];
		int[] right = new int[len];
		
		int max = 0;
		for(int i = 0;i<len;i++){
			left[i] = max;
			max = Math.max(max, height[i]);
		}
		
		max = 0;
		for(int i = len-1;i>=0;i--){
			right[i] = max;
			max = Math.max(max, height[i]);
		}
		
		for(int i = 0;i<len;i++){
			if(left[i] > height[i] && right[i] > height[i]){
				sum += Math.min(left[i], right[i]) - height[i];
			}
		}
		
		return sum;
	}
}
