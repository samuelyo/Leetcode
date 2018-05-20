package com.leetcode.RectangleOverlap;

public class RectangleOverlap {

	public static void main(String[] args) {

		int[] rec1 = { 0, 0, 2, 2 };
		int[] rec2 = { 1, 1, 3, 3 };
		boolean res = isRectangleOverlap(rec1, rec2);
		System.out.println(res);

	}

	public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {

		if (rec1 == null || rec2 == null || rec1.length != 4 || rec2.length != 4) {
			return false;
		}
		if (rec1[0] >= rec1[2] || rec1[1] >= rec1[3] || rec2[0] >= rec2[2] || rec2[1] >= rec2[3]) {
			return false;
		}
		int maxLeft = Math.max(rec1[0], rec2[0]);
		int minRight = Math.min(rec1[2], rec2[2]);
		int maxDown = Math.max(rec1[1], rec2[1]);
		int minUp = Math.min(rec1[3], rec2[3]);
		return maxLeft < minRight && maxDown < minUp;

	}

}
