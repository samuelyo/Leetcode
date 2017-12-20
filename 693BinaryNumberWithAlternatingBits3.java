package com.leetcode.BinaryNumberWithAlternatingBits;

public class BinaryNumberWithAlternatingBits3 {

	public static void main(String[] args) {
		
		int n = 11;
		boolean res = hasAlternatingBits(n);
		System.out.println(res);

	}

	public static boolean hasAlternatingBits(int n) {
		
		String s = Integer.toBinaryString(n);
		char head = s.charAt(0);
		char pre = head;
		for(int i = 1;i<s.length();i++) {
			char cur = s.charAt(i);
			if(cur == pre) {
				return false;
			}
			pre = cur;
		}
		return true;
		
	}
}
