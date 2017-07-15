package com.leetcode.PermutationSequence;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence2 {

	public static void main(String[] args) {

		int n = 4;
		int k = 8;
		System.out.println(getPermutation(n, k));

	}

	public static String getPermutation(int n, int k) {

		List<Integer> numbers = new ArrayList<Integer>();
		int[] factorial = new int[n + 1];
		StringBuilder sb = new StringBuilder();

		// create an array of factorial lookup
		int sum = 1;
		factorial[0] = 1;
		for (int i = 1; i <= n; i++) {
			sum *= i;
			factorial[i] = sum;
		}
		// factorial[] = {1, 1, 2, 6, 24, ... n!}

		// create a list of numbers to get indices
		for (int i = 1; i <= n; i++) {
			numbers.add(i);
		}
		// numbers = {1, 2, 3, 4}

		k--;

		for (int i = 1; i <= n; i++) {
			int index = k / factorial[n - i];
			sb.append(String.valueOf(numbers.get(index)));
			numbers.remove(index);
			k -= index * factorial[n - i];
		}

		return String.valueOf(sb);
	}

}
