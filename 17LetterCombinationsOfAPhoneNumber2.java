package com.leetcode.LetterCombinationsOfAPhoneNumber;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber2 {

	public static void main(String[] args) {

		String digits = "233";
		List<String> ans = letterCombinations(digits);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

	public static List<String> letterCombinations(String digits) {

		LinkedList<String> ans = new LinkedList<String>();
		if (digits.length()==0){
			return ans;
		}
		String[] mapping = new String[] { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;
	}

}
