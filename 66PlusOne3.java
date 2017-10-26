package com.leetcode.PlusOne;

import java.util.Arrays;

public class PlusOne3 {

	public static void main(String[] args) {

		int[] digits = { 9, 9 };
		System.out.println(Arrays.toString(plusOne(digits)));

	}

	public static int[] plusOne(int[] digits) {

		int len = digits.length;
		int extra = 0;
		for (int i = len - 1; i >= 0; i--) {
			int res = digits[i] + (i == len - 1 ? 1 : 0) + extra;
			digits[i] = res % 10;
			extra = res / 10;
		}
		if (extra != 0) {
			int[] res = new int[len + 1];
			res[0] = extra;
			for (int i = 1; i < res.length; i++) {
				res[i] = digits[i - 1];
			}
			return res;
		} else {
			return digits;
		}

	}
}
