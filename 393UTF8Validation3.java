package com.leetcode.UTF8Validation;

public class UTF8Validation3 {

	public static void main(String[] args) {

		int[] data = { 255 };
		System.out.println(validUtf8(data));

	}

	public static boolean validUtf8(int[] data) {

		int count = 0;
		for (int c : data) {
			if (count == 0) {
				if (((c >> 3) & 31) == 31) {
					return false;
				} else if (((c >> 4) & 15) == 15) {
					count = 3;
				} else if (((c >> 5) & 7) == 7) {
					count = 2;
				} else if (((c >> 6) & 3) == 3) {
					count = 1;
				} else if (((c >> 7) & 1) == 1) {
					return false;
				}
			} else {
				if (((c >> 6) & 2) != 2) {
					return false;
				}
				count--;
			}
		}
		return count == 0;

	}

}
