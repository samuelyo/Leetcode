package com.leetcode.ReverseWordsInAStringIII;

public class ReverseWordsInAStringIII3 {

	public static void main(String[] args) {
		
		String s = "Let's take LeetCode contest";
		System.out.println(reverseWords(s));

	}

	public static String reverseWords(String s) {
		
		char[] chs = s.toCharArray();
		int index = 0;
		while(index < s.length()) {
			int temp = index;
			while(temp < s.length() && chs[temp] != ' ') {
				temp ++;
			}
			reverse(chs, index, temp - 1);
			index = temp + 1;
		}
		return new String(chs);
		
	}
	
	public static void reverse(char[] chs, int start, int end) {
		
		while(start <= end) {
			char temp = chs[end];
			chs[end] = chs[start];
			chs[start] = temp;
			start ++;
			end --;
		}
		
	}
}
