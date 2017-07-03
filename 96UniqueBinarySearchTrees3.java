package com.leetcode.UniqueBinarySearchTrees;

import java.util.HashMap;
import java.util.Map;

public class UniqueBinarySearchTrees3 {

	public static void main(String[] args) {

		int n = 19;
		System.out.println(numTrees(n));

	}

	public static int numTrees(int n) {

		int[] G = new int[n + 1];
		G[0] = G[1] = 1;

		for (int i = 2; i <= n; ++i) {
			for (int j = 1; j <= i; ++j) {
				G[i] += G[j - 1] * G[i - j];
			}
		}

		return G[n];

	}

}
