package com.leetcode.ReverseWordsInAString;

public class ReverseWordsInAString4 {

	public static void main(String[] args) {
		
		String s = "  a  b";
		System.out.println(reverseWords(s));

	}
	
	public static String reverseWords(String s) {
		
		s = s.trim();
		String res = "";
		int index = 0;
		while(index < s.length()) {
			int temp = index;
			while(temp < s.length() && s.charAt(temp) != ' ') {
				temp ++;
			}
			String cur = s.substring(index, temp);
			if(res.length() == 0) {
				res = cur;
			}else {
				res = cur + ' ' + res;
			}
			while(temp < s.length() && s.charAt(temp) == ' ') {
				temp ++;
			}
			index = temp;
		}
		return res;
		
	}
	
}
