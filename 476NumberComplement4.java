package com.leetcode.NumberComplement;

public class NumberComplement4 {

	public static void main(String[] args) {
		
		int num = 5;
		System.out.println(findComplement(num));

	}
	
	public static int findComplement(int num) {
		
		String s = Integer.toBinaryString(num);
		StringBuilder res = new StringBuilder();
		for(int i = 0;i<s.length();i++) {
			if(s.charAt(i) == '1') {
				res.append('0');
			}else {
				res.append('1');
			}
		}
		return Integer.valueOf(res.toString(), 2);
		
	}

}
