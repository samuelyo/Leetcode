package com.leetcode.DetectCapital;

public class DetectCapital4 {

	public static void main(String[] args) {
		
		String word = "FlaG";
		boolean res = detectCapitalUse(word);
		System.out.println(res);

	}
	
	public static boolean detectCapitalUse(String word) {
		
		int upper = 0;
		for(int i = 0;i<word.length();i++) {
			char cur = word.charAt(i);
			if(Character.isUpperCase(cur)) {
				upper ++;
			}
		}
		if(upper == word.length() || upper == 0) {
			return true;
		}
		if(upper == 1) {
			if(Character.isUpperCase(word.charAt(0))) {
				return true;
			}
		}
		return false;
		
	}

}
