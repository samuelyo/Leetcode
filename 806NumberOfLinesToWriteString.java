package com.leetcode.NumberOfLinesToWriteString;

import java.util.Arrays;

public class NumberOfLinesToWriteString {

	public static void main(String[] args) {
		
		int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		String S = "abcdefghijklmnopqrstuvwxyz";
		int[] res = numberOfLines(widths, S);
		System.out.println(Arrays.toString(res));

	}

	public static int[] numberOfLines(int[] widths, String S) {
		
		char[] chs = S.toCharArray();
		int count = 0;
		int index = 0;
		int sum = 0;
		while(index < chs.length) {
			char cur = chs[index];
			sum += widths[cur - 'a'];
			if(sum > 100) {
				sum -= widths[cur - 'a'];
				count ++;
				sum = 0;
			}else {
				index ++;
			}
		}
		return new int[]{count + 1, sum};
	}
}
