package com.leetcode.CountTheRepetitions;

public class CountTheRepetitions {

	public static void main(String[] args) {

		String s1 = "acb";
		int n1 = 4;
		String s2 = "ab";
		int n2 = 2;
		System.out.println(getMaxRepetitions(s1, n1, s2, n2));

	}

	public static int getMaxRepetitions(String s1, int n1, String s2, int n2) {

		char[] array1 = s1.toCharArray(), array2 = s2.toCharArray();
		int count1 = 0, count2 = 0, i = 0, j = 0;

		while (count1 < n1) {
			if (array1[i] == array2[j]) {
				j++;
				if (j == array2.length) {
					j = 0;
					count2++;
				}
			}
			i++;
			if (i == array1.length) {
				i = 0;
				count1++;
			}
		}

		return count2 / n2;

	}
}
