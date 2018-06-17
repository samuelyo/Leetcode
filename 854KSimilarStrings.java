package com.leetcode.KSimilarStrings;

public class KSimilarStrings {

	public static void main(String[] args) {

		String A = "abac";
		String B = "baca";
		int k = kSimilarity(A, B);
		System.out.println(k);

	}

	public static int kSimilarity(String A, String B) {

		char[] a = A.toCharArray();
		char[] b = B.toCharArray();

		return search(a, b, 0, 0);
	}

	public static int search(char[] now, char[] target, int i, int swap) {
		if (i >= now.length) {
			return swap;
		}

		if (now[i] == target[i]) {
			return search(now, target, i + 1, swap);
		}

		int min = 10000;
		for (int j = i + 1; j < now.length; j++) {
			if (now[j] != target[i]) {
				continue;
			}
			swap(now, i, j);
			min = Math.min(min, search(now, target, i + 1, swap + 1));
			swap(now, i, j);
		}

		return min;
	}

	public static void swap(char[] data, int i, int j) {
		char tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

}
