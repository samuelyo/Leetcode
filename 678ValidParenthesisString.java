package com.leetcode.ValidParenthesisString;

public class ValidParenthesisString {

	public static void main(String[] args) {
		
		String s = "()";
		System.out.println(checkValidString(s));

	}
	
	public static boolean checkValidString(String s) {
		
		if(s == null){
			return false;
		}
		return checkValidString(s, 0, 0);
		
	}
	
	public static boolean checkValidString(String s ,int index, int count) {
		
		while(index < s.length()) {
			if(s.charAt(index) == '(') {
				count ++;
			}else if(s.charAt(index) == ')') {
				count --;
				if(count < 0) {
					return false;
				}
			}else {
				return checkValidString(s, index + 1, count) || checkValidString(s, index + 1, count + 1) 
						|| checkValidString(s, index + 1, count - 1);
			}
			index ++;
		}
		return count == 0;
		
	}

}
