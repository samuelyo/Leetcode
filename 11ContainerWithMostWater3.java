package com.leetcode.ContainerWithMostWater;

public class ContainerWithMostWater3 {

	public static void main(String[] args) {

		int[] height = { 2, 1, 3 };
		System.out.println(maxArea(height));

	}

	public static int maxArea(int[] height) {

		int left = 0, right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
			//  3     6
			//if(height[3] < height[6])
			//if  right -- :the area must decrease because the wide is shorter
			//so  it should be left ++
			if (height[left] < height[right])
				left++;
			else
				right--;
		}

		return maxArea;
	}

}
