package com.leetcode.Triangle;

import java.util.ArrayList;
import java.util.List;

public class Triangle2 {

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

		if (triangle.size() == 0)
			return 0;

		for (int i = triangle.size() - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				List<Integer> nextRow = triangle.get(i + 1);
				int sum = Math.min(nextRow.get(j), nextRow.get(j + 1)) + triangle.get(i).get(j);
				triangle.get(i).set(j, sum);
			}
		}
		return triangle.get(0).get(0);
	}
}
