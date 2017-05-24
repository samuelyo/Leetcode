package com.leetcode.detectcapital;

public class DetectCapital2 {

	public static void main(String[] args) {
		
		String word = "USA";
		System.out.println(detectCapitalUse(word));

	}

	public static boolean detectCapitalUse(String word) {
	
		
		return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
		
//		return word.matches("[A-Z]*|[A-Z]?[a-z]*");
	
		
	}
}
