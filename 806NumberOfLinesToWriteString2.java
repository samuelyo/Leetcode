package com.leetcode.NumberOfLinesToWriteString;

import java.util.Arrays;

public class NumberOfLinesToWriteString2 {

	public static void main(String[] args) {

		int[] widths = { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10,
				10, 10 };
		String S = "abcdefghijklmnopqrstuvwxyz";
		int[] res = numberOfLines(widths, S);
		System.out.println(Arrays.toString(res));

	}

	public static int[] numberOfLines(int[] widths, String S) {

		int res = 1, cur = 0;
		for (char c : S.toCharArray()) {
			int width = widths[c - 'a'];
			res = cur + width > 100 ? res + 1 : res;
			cur = cur + width > 100 ? width : cur + width;
		}
		return new int[] { res, cur };
		
	}
}
