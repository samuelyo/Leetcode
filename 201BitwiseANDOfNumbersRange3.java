package com.leetcode.BitwiseANDOfNumbersRange;

public class BitwiseANDOfNumbersRange3 {

	public static void main(String[] args) {
		
		int m = 90;
		int n = 200;
		
		System.out.println(rangeBitwiseAnd(m, n));

	}
	
	public static int rangeBitwiseAnd(int m, int n) {
		
		String s1 = Integer.toBinaryString(m);
		String s2 = Integer.toBinaryString(n);
		int len1 = s1.length();
		int len2 = s2.length();
		for(int i = 0;i<32 - len1;i++) {
			s1 = "0" + s1;
		}
		for(int i = 0;i<32 - len2;i++) {
			s2 = "0" + s2;
		}
		String res = "";
		int i = 0;
		for(;i<32;i++) {
			char c1 = s1.charAt(i);
			char c2 = s2.charAt(i);
			if(c1 != c2) {
				break ;
			}else {
				res += c1;
			}
		}
		while(i < 32) {
			res += '0';
			i ++;
		}
		return Integer.valueOf(res, 2);
		
	}

}
