package com.leetcode.Sqrtx;

public class Sqrtx3 {

	public static void main(String[] args) {

		int x = 2147395599;
		System.out.println(mySqrt(x));
	}

	public static int mySqrt(int x) {

		int left = 1, right = x;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (mid == x / mid) {
				return mid;
			} else if (mid < x / mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;

	}

}
