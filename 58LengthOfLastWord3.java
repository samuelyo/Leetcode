package com.leetcode.LengthOfLastWord;

public class LengthOfLastWord3 {

	public static void main(String[] args) {
		
		String s = " ";
		System.out.println(lengthOfLastWord(s));

	}

	public static int lengthOfLastWord(String s){
		
		String[] words = s.split(" ");
		if(words.length != 0) {
			return words[words.length - 1].length();
		}else {
			return 0;
		}
		
	}
}
