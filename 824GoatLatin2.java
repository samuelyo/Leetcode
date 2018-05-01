package com.leetcode.GoatLatin;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin2 {

	public static void main(String[] args) {

		String S = "The quick brown fox jumped over the lazy dog";
		String res = toGoatLatin(S);
		System.out.println(res);
	}

	public static String toGoatLatin(String S) {

		String[] strArr = S.split(" ");
		StringBuilder strBld = new StringBuilder();

		Set<Character> vowel = new HashSet<Character>();
		for (char c : "aeiouAEIOU".toCharArray())
			vowel.add(c);
		StringBuilder aCounter = new StringBuilder();
		aCounter.append("a");

		for (int i = 0; i < strArr.length; i++) {
			if (vowel.contains(strArr[i].toLowerCase().charAt(0))) {
				strBld.append(strArr[i] + "ma");
			} else {
				strBld.append(strArr[i].substring(1, strArr[i].length()) + strArr[i].charAt(0) + "ma");
			}
			strBld.append(aCounter + " ");
			aCounter.append("a");
		}
		return strBld.toString().substring(0, strBld.length() - 1);

	}

}
