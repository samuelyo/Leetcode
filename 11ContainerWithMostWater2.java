package com.leetcode.ContainerWithMostWater;

public class ContainerWithMostWater2 {

	public static void main(String[] args) {

		int[] height = { 2, 1, 3 };
		System.out.println(maxArea(height));

	}

	public static int maxArea(int[] height) {

		int water = 0;
		int i = 0, j = height.length - 1;
		while (i < j) {
			int h = Math.min(height[i], height[j]);
			water = Math.max(water, (j - i) * h);
			//the height should be more than the widest area's height
			while (height[i] <= h && i < j)
				i++;
			//the height should be more than the widest area's height
			while (height[j] <= h && i < j)
				j--;
		}
		return water;
	}

}
