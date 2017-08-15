package com.leetcode.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning2 {

	public static void main(String[] args) {

		String s = "aaba";

		List<List<String>> ans = partition(s);

		for (int i = 0; i < ans.size(); i++) {
			List<String> cur = ans.get(i);
			for (int j = 0; j < cur.size(); j++) {
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}

	}

	public static List<List<String>> partition(String s) {

		List<List<String>> list = new ArrayList<>();
		backtrack(list, new ArrayList<String>(), s, 0);
		return list;
	}

	public static void backtrack(List<List<String>> list, List<String> tempList, String s, int start) {
		if (start == s.length())
			list.add(new ArrayList<String>(tempList));
		else {
			for (int i = start; i < s.length(); i++) {
				if (isPalindrome(s, start, i)) {
					tempList.add(s.substring(start, i + 1));
					backtrack(list, tempList, s, i + 1);
					tempList.remove(tempList.size() - 1);
				}
			}
		}
	}

	public static boolean isPalindrome(String s, int low, int high) {
		while (low < high)
			if (s.charAt(low++) != s.charAt(high--))
				return false;
		return true;

	}

}
