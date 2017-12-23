package com.leetcode.FindSmallestLetterGreaterThanTarget;

public class FindSmallestLetterGreaterThanTarget3 {

	public static void main(String[] args) {

		char[] letters = { 'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n' };
		char target = 'e';
		System.out.println(nextGreatestLetter(letters, target));

	}

	public static char nextGreatestLetter(char[] letters, char target) {

		int n = letters.length;

		if (target >= letters[n - 1])
			target = letters[0];
		else
			target ++;

		int lo = 0, hi = n - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (letters[mid] == target)
				return letters[mid];
			if (letters[mid] < target)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return letters[lo];
//		return letters[hi + 1];
		
	}
}
