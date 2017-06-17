package com.leetcode.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Triangle3 {

	public static void main(String[] args) {

		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> row1 = new ArrayList<Integer>();
		row1.add(-7);
		List<Integer> row2 = new ArrayList<Integer>();
		row2.add(-2);
		row2.add(-1);
		List<Integer> row3 = new ArrayList<Integer>();
		row3.add(-5);
		row3.add(-5);
		row3.add(9);
		List<Integer> row4 = new ArrayList<Integer>();
		row4.add(-4);
		row4.add(-5);
		row4.add(4);
		row4.add(4);
		List<Integer> row5 = new ArrayList<Integer>();
		row5.add(-6);
		row5.add(-6);
		row5.add(2);
		row5.add(-1);
		row5.add(-5);
		List<Integer> row6 = new ArrayList<Integer>();
		row6.add(3);
		row6.add(7);
		row6.add(8);
		row6.add(-3);
		row6.add(7);
		row6.add(-9);

		triangle.add(row1);
		triangle.add(row2);
		triangle.add(row3);
		triangle.add(row4);
		triangle.add(row5);
		triangle.add(row6);

		System.out.println(minimumTotal(triangle));
	}

	public static int minimumTotal(List<List<Integer>> triangle) {

		int rowNum = triangle.size();
		int[] dp = new int[rowNum];
		for (int i = 0; i < triangle.get(rowNum - 1).size(); i++) {
			dp[i] = triangle.get(rowNum - 1).get(i);
		}
		for (int row = rowNum - 2; row >= 0; row--) {// for each layer
			for (int col = 0; col <= row; col++) {
				dp[col] = Math.min(dp[col], dp[col + 1]) + triangle.get(row).get(col);
			}
		}
		return dp[0];
	}
}
