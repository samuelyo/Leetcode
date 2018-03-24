package com.leetcode.RotateString;

public class RotateString {

	public static void main(String[] args) {
		
		String A = "abcde";
//		String B = "cdeab";
		String B = "abced";
		System.out.println(rotateString(A, B));

	}
	
	public static boolean rotateString(String A, String B) {
		
		if(A == null || B == null) {
			return false;
		}
		if(A.length() == 0) {
			return B.length() == 0;
		}
		int len = A.length();
		String temp = A;
		for(int i = 0;i<len;i++) {
			if(i == 0) {
				temp = A;
			}else {
				String cur = temp.charAt(temp.length() - 1) + temp.substring(0, temp.length() - 1);
				temp = cur;
			}
			if(temp.equals(B)) {
				return true;
			}
		}
		return false;
	}

}
