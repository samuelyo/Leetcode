package com.leetcode.LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber3 {

	public static void main(String[] args) {
		
		String digits = "23";
		List<String> res = letterCombinations(digits);
		for(int i = 0;i<res.size();i++) {
			System.out.print(res.get(i) + " ");
		}

	}
	
	public static String[] s = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	
	public static List<String> letterCombinations(String digits) {
        
		List<String> res = new ArrayList<String>();
		if(digits.length() == 0) {
			return res;
		}
		res.add("");
		res = letterCombinationsHelper(digits, res, 0);
		return res;
		
    }
	
	public static List<String> letterCombinationsHelper(String digits, List<String> res, int index) {
		
		if(index == digits.length()) {
			return res;
		}
		char ch = digits.charAt(index);
		String cur = s[ch - '0' - 1];
		List<String> temp = new ArrayList<String>();
		for(int i = 0;i<res.size();i++) {
			String pre = res.get(i);
			for(int j = 0;j<cur.length();j++) {
				temp.add(pre + cur.charAt(j));
			}
		}
		res = temp;
		res = letterCombinationsHelper(digits, res, index + 1);
		return res;
	}

}
