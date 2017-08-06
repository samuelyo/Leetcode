package com.leetcode.NumberComplement;

public class NumberComplement {

	public static void main(String[] args) {
		
		int num = 5;
		System.out.println(findComplement(num));

	}

	public static int findComplement(int num) {
		
		String s = Integer.toBinaryString(num);
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i) == '1'){
				sb.append('0');
			}else{
				sb.append('1');
			}
		}
		return Integer.valueOf(sb.toString(), 2);
		
	}
}
