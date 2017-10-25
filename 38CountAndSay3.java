package com.leetcode.CountAndSay;

public class CountAndSay3 {

	public static void main(String[] args) {

		System.out.println(countAndSay(6));

	}

	public static String countAndSay(int n) {

		String s = "11";
		if(n == 1) {
			return "1";
		}
		if(n == 2) {
			return "11";
		}
		for(int i = 3;i<=n;i++) {
			String temp = countAndSayHelp(s);
			if(i == n) {
				return temp;
			}
			s = temp;
		}
		return s;
				
	}
	
	public static String countAndSayHelp(String s) {
		
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(int i = 0;i<s.length();i++) {
			if(i == 0) {
				count ++;
				continue;
			}
			if(s.charAt(i) != s.charAt(i - 1)) {
				sb.append(count);
				sb.append(s.charAt(i - 1));
				count = 1;
			}else {
				count ++;
			}
		}
		sb.append(count);
		sb.append(s.charAt(s.length() - 1));
		return sb.toString();
		
	}

}
