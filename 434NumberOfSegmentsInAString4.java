package com.leetcode.NumberOfSegmentsInAString;

public class NumberOfSegmentsInAString4 {

	public static void main(String[] args) {
		
		String s = "Hello, my name is John";
		System.out.println(countSegments(s));

	}

	public static int countSegments(String s) {
		
		s = s + ' ';
		int count = 0;
		int index = 1;
		while(index < s.length()) {
			char cur = s.charAt(index);
			char pre = s.charAt(index - 1);
			if(cur == ' ' && pre != ' ') {
				count ++;
			}
			index ++;
		}
		return count;
		
	}
}
