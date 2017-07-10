package com.leetcode.RectangleArea;

public class RectangleArea2 {

	public static void main(String[] args) {

		int A = -5;
		int B = -2;
		int C = 5;
		int D = 1;
		int E = -3;
		int F = -3;
		int G = 3;
		int H = 3;

		System.out.println(computeArea(A, B, C, D, E, F, G, H));

	}

	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

		int areaOfSqrA = (C - A) * (D - B);
		int areaOfSqrB = (G - E) * (H - F);

		int left = Math.max(A, E);
		int right = Math.min(G, C);
		int bottom = Math.max(F, B);
		int top = Math.min(D, H);

		// If overlap
		int overlap = 0;
		if (right > left && top > bottom)
			overlap = (right - left) * (top - bottom);

		return areaOfSqrA + areaOfSqrB - overlap;

	}

}
