package com.leetcode.RectangleArea;

public class RectangleArea3 {

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
		
		int area1 = (C - A) * (D - B);
		int area2 = (G - E) * (H - F);
		
		int left = Math.max(A, E);
		int right = Math.min(C, G);
		int high = Math.min(H, D);
		int low = Math.max(B, F);
		
		if(left <= right && high >= low) {
			return area1 + area2 - (right - left) * (high - low);
		}else {
			return area1 + area2;
		}
		
	}

}
