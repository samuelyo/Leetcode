package com.leetcode.LargestRectangleInHistogram;

public class LargestRectangleInHistogram2 {

	public static void main(String[] args) {
		
		int[] heights = {2,1,5,6,5,2,3};
		System.out.println(largestRectangleArea(heights));
	}
	
	public static int largestRectangleArea(int[] heights) {
		
		int res = 0;
		for(int i = 0;i<heights.length;i++) {
			if(i+1 < heights.length && heights[i] <= heights[i+1]) {
				continue;
			}
			int minHeight = heights[i];
			for(int j = i;j>=0;j--) {
				minHeight = Math.min(minHeight, heights[j]);
				int area = minHeight * (i - j + 1);
				res = Math.max(res, area);
			}
		}
		return res;
		
	}

}
