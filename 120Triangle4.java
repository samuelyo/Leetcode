package com.leetcode.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Triangle4 {

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
		
		if(triangle == null || triangle.size() == 0) {
			return 0;
		}
		int[] dp = new int[1];
		dp[0] = triangle.get(0).get(0);
		for(int i = 1;i<triangle.size();i++) {
			List<Integer> list = triangle.get(i);
			int[] temp = new int[list.size()];
			for(int j = 0;j<temp.length;j++) {
				if(j == 0) {
					temp[j] = list.get(j) + dp[j];
				}else if(j == temp.length - 1) {
					temp[j] = list.get(j) + dp[j - 1];
				}else {
					temp[j] = list.get(j) + Math.min(dp[j], dp[j - 1]);
				}
			}
			dp = temp;
 		}
		int res = Integer.MAX_VALUE;
		for(int i = 0;i<dp.length;i++) {
			res = Math.min(res, dp[i]);
		}
		return res;
		
	}

}
