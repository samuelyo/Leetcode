package com.leetcode.GoatLatin;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {

	public static void main(String[] args) {

		String S = "The quick brown fox jumped over the lazy dog";
		String res = toGoatLatin(S);
		System.out.println(res);
	}

	public static String toGoatLatin(String S) {

		if (S == null || S.length() == 0) {
			return "";
		}
		char[] chars = { 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' };
		Set<Character> set = new HashSet<Character>();
		for (char ch : chars) {
			set.add(ch);
		}
		String[] strs = S.split(" ");
		String res = "";
		for (int i = 0; i < strs.length; i++) {
			String cur = strs[i];
			char[] chs = cur.toCharArray();
			String temp = "";
			if (set.contains(chs[0])) {
				temp = cur + "ma";
			} else {
				temp = cur.substring(1) + chs[0] + "ma";
			}
			for (int j = 0; j < i + 1; j++) {
				temp += "a";
			}
			if (i == 0) {
				res += temp;
			} else {
				res += " " + temp;
			}
		}
		return res;

	}

}
