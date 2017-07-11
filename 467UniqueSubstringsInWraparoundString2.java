package com.leetcode.UniqueSubstringsInWraparoundString;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubstringsInWraparoundString2 {

	public static void main(String[] args) {

		String p = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";
		System.out.println(findSubstringInWraproundString(p));

	}

	/**
	 * 1、The max number of unique substring ends with a letter equals to the
	 * length of max contiguous substring ends with that letter. Example "abcd",
	 * the max number of unique substring ends with 'd' is 4, apparently they
	 * are "abcd", "bcd", "cd" and "d".
	 * 2、 If there are overlapping, we only need
	 * to consider the longest one because it covers all the possible
	 * substrings. Example: "abcdbcd", the max number of unique substring ends
	 * with 'd' is 4 and all substrings formed by the 2nd "bcd" part are covered
	 * in the 4 substrings already. 
	 * 3、No matter how long is a contiguous substring
	 * in p, it is in s since s has infinite length.
	 * 
	 * 4、Now we know the max number
	 * of unique substrings in p ends with 'a', 'b', ..., 'z' and those
	 * substrings are all in s. Summary is the answer, according to the
	 * question.
	 * 
	 * @param p
	 * @return
	 */

	public static int findSubstringInWraproundString(String p) {

		// count[i] is the maximum unique substring end with ith letter.
		// 0 - 'a', 1 - 'b', ..., 25 - 'z'.
		int[] count = new int[26];
		int maxLengthCur = 0;

		for (int i = 0; i < p.length(); i++) {
			int len = 1;
			if (i > 0 && (p.charAt(i) - p.charAt(i - 1) == 1 || (p.charAt(i - 1) - p.charAt(i) == 25)))
				maxLengthCur++;
			else
				maxLengthCur = 1;

			int index = p.charAt(i) - 'a';
			count[index] = Math.max(count[index], maxLengthCur);
		}

		// Sum to get result
		int sum = 0;
		for (int i = 0; i < 26; i++) {
			sum += count[i];
		}
		return sum;
	}
}
