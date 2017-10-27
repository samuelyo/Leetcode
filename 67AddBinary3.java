package com.leetcode.AddBinary;

public class AddBinary3 {

	public static void main(String[] args) {

		String a = "11";
		String b = "1";
		System.out.println(addBinary(a, b));

	}

	public static String addBinary(String a, String b) {

		StringBuilder res = new StringBuilder();
		if(a.length() > b.length()) {
			int diff = a.length() - b.length();
			StringBuilder sb = new StringBuilder(b).reverse();
			for(int i = 0;i<diff;i++) {
				sb.append("0");
			}
			b = sb.reverse().toString();
		}
		if(b.length() > a.length()) {
			int diff = b.length() - a.length();
			StringBuilder sb = new StringBuilder(a).reverse();
			for(int i = 0;i<diff;i++) {
				sb.append("0");
			}
			a = sb.reverse().toString();
		}
		int extra = 0;
		int len = a.length();
		for(int i = len - 1;i>=0;i--) {
			int temp = (a.charAt(i) - '0') + (b.charAt(i) - '0') + extra;
			res.append(temp % 2);
			extra = temp / 2;
		}
		if(extra != 0) {
			res.append(extra);
		}
		return res.reverse().toString();
		
	}
}
