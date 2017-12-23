package com.leetcode.FindSmallestLetterGreaterThanTarget;

public class FindSmallestLetterGreaterThanTarget {

	public static void main(String[] args) {

		char[] letters = { 'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n' };
		char target = 'e';
		System.out.println(nextGreatestLetter(letters, target));

	}

	public static char nextGreatestLetter(char[] letters, char target) {

		int left = 0;
		int right = letters.length - 1;
		Integer index = null;
		while (left <= right) {
			int mid = (right - left) / 2 + left;
			if (letters[mid] == target) {
				int temp = mid + 1;
				while (temp < letters.length && letters[temp] == letters[temp - 1]) {
					temp++;
				}
				index = temp;
				break;
			} else if (letters[mid] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		if (index == null) {
			index = right + 1;
		}
		return index == letters.length ? letters[0] : letters[index];
		
	}
}
