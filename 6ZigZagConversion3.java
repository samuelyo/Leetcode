package com.leetcode.ZigZagConversion;

public class ZigZagConversion3 {

	public static void main(String[] args) {
		
		String s = "PAYPALISHIRING";
		int numRows = 3;
		System.out.println(convert(s, numRows));

	}

	public static String convert(String s, int numRows) {
		
		int len = numRows * 2 - 2;
		if(len == 0) {
			return s;
		}
		int times = (s.length() + len - 1) / len;
		Character[][] chars = new Character[numRows][times * (numRows - 1)];
		for(int i = 0;i<s.length();i++) {
			char cur = s.charAt(i);
			int group = i / len;
			int extra = i % len;
			int row, col;
			if(extra < numRows) {
				row = extra;
				col = group * (numRows - 1);
			}else {
				row = len - extra;
				col = group * (numRows - 1) + extra - numRows + 1;
			}
			chars[row][col] = cur;
		}
		StringBuilder res = new StringBuilder();
		for(int i = 0;i<chars.length;i++) {
			for(int j = 0;j<chars[0].length;j++) {
				if(chars[i][j] != null) {
					res.append(chars[i][j]);
				}
			}
		}
		return res.toString();
		
	}
}
