package com.leetcode.CountBinarySubstrings;

public class CountBinarySubstrings {

	public static void main(String[] args) {
		
		String s = "10101";
		int res = countBinarySubstrings(s);
		System.out.println(res);

	}

	public static int countBinarySubstrings(String s) {
		
		int count = 0;
		for(int i = 0;i<s.length();i++) {
			char cur = s.charAt(i);
			int j = i + 1;
			while(j < s.length() && s.charAt(j) == cur) {
				j ++;
			}
			int num = j - i;
			if(j == s.length()) {
				continue;
			}
			cur = s.charAt(j);
			int k = j + 1;
			while(k < s.length() && s.charAt(k) == cur) {
				k ++;
			}
			if(k - j >= num) {
				count += num;
				j--;
				i = j;
			}
		}
		return count;
		
	}
}
