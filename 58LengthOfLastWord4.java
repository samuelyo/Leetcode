package com.leetcode.LengthOfLastWord;

public class LengthOfLastWord4 {

	public static void main(String[] args) {
		
		String s = "a ";
		System.out.println(lengthOfLastWord(s));

	}

	public static int lengthOfLastWord(String s){
		
		String sReverse = new StringBuilder(s).reverse().toString().trim();
		int index = 0;
		int res = 0;
		while(index < sReverse.length()) {
			if(sReverse.charAt(index) != ' ') {
				res ++;
			}else {
				break ;
			}
			index ++;
		}
		return res;
		
	}
}
