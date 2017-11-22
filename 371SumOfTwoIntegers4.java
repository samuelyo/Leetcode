package com.leetcode.SumOfTwoIntegers;

public class SumOfTwoIntegers4 {

	public static void main(String[] args) {
		
		int a = -100;
		int b = 11;
		System.out.println(getSum(a, b));

	}
	
	public static int getSum(int a, int b) {
		
		StringBuilder s1 = new StringBuilder(Integer.toBinaryString(a)).reverse();
		StringBuilder s2 = new StringBuilder(Integer.toBinaryString(b)).reverse();
		
		StringBuilder res = new StringBuilder();
		int index = 0;
		int extra = 0;
		while(index < s1.length() || index < s2.length()) {
			char c1, c2;
			if(index >= s1.length()) {
				c1 = '0';
			}else {
				c1 = s1.charAt(index);
			}
			if(index >= s2.length()) {
				c2 = '0';
			}else {
				c2 = s2.charAt(index);
			}
			if(c1 != c2) {
				if(extra == 0) {
					res.append("1");
				}else {
					res.append("0");
				}
			}
			if(c1 == '0' && c2 == '0') {
				if(extra == 0) {
					res.append("0");
				}else {
					extra = 0;
					res.append("1");
				}
			}
			if(c1 == '1' && c2 == '1') {
				if(extra == 0) {
					res.append("0");
					extra = 1;
				}else {
					res.append("1");
				}
			}
			index ++;
		}
		if(extra == 1 && res.length() < 32) {
			res.append("1");
		}
		res = res.reverse();
		return Integer.parseUnsignedInt(res.toString(), 2);
		
	}

}
