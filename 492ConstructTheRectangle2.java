package com.leetcode.ConstructTheRectangle;

public class ConstructTheRectangle2 {

	public static void main(String[] args) {

		int area = 2;
		int[] res = constructRectangle(area);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	public static int[] constructRectangle(int area) {

		int w = (int) Math.sqrt(area);
		while (area % w != 0)
			w--;
		return new int[] { area / w, w };

	}
}
