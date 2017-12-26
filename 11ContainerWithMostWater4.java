package com.leetcode.ContainerWithMostWater;

public class ContainerWithMostWater4 {

	public static void main(String[] args) {
		
		int[] height = {3,1,4};
		System.out.println(maxArea(height));

	}

	public static int maxArea(int[] height) {
		
		int left = 0;
		int right = height.length - 1;
		int max = 0;
		
		while(left < right) {
			int h = Math.min(height[left], height[right]);
			max = Math.max(max, (right - left) * h);
			while(left < right && height[left] <= h) {
				left ++;
			}
			while(left < right && height[right] <= h) {
				right --;
			}
		}
		return max;
		
	}
}
