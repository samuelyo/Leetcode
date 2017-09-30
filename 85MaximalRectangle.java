package com.leetcode.MaximalRectangle;

import java.util.Stack;

public class MaximalRectangle {

	public static void main(String[] args) {
		
		char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','1'}};
		System.out.println(maximalRectangle(matrix));

	}

	public static int maximalRectangle(char[][] matrix) {
		
		int res = 0;
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int[] height = new int[matrix[0].length];
		for(int i = 0;i<matrix.length;i++) {
			for(int j = 0;j<matrix[i].length;j++) {
				height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
			}
			res = Math.max(res, largestRectangleArea(height));
		}
		return res;
		
	}
	
	public static int largestRectangleArea(int[] heights) {

		int len = heights.length;
		Stack<Integer> s = new Stack<Integer>();
		int maxArea = 0;
		for (int i = 0; i <= len; i++) {
			int h = (i == len ? 0 : heights[i]);
			if (s.isEmpty() || h >= heights[s.peek()]) {
				s.push(i);
			} else {
				int tp = s.pop();
				maxArea = Math.max(maxArea, heights[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
				i--;
			}
		}
		return maxArea;
		
	}
        
}
