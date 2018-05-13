package com.leetcode.ImageOverlap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImageOverlap2 {

	public static void main(String[] args) {

		int[][] A = { { 0, 1, 0, 0, 0 }, { 1, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 1, 1 } };
		int[][] B = { { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 0 }, { 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1 } };
		int res = largestOverlap(A, B);
		System.out.println(res);

	}

	public static int largestOverlap(int[][] A, int[][] B) {

		int N = A.length;
		List<Integer> LA = new ArrayList<>();
		List<Integer> LB = new ArrayList<>();
		HashMap<Integer, Integer> count = new HashMap<>();
		for (int i = 0; i < N * N; ++i)
			if (A[i / N][i % N] == 1)
				LA.add(i / N * 100 + i % N);
		for (int i = 0; i < N * N; ++i)
			if (B[i / N][i % N] == 1)
				LB.add(i / N * 100 + i % N);
		for (int i : LA)
			for (int j : LB)
				count.put(i - j, count.getOrDefault(i - j, 0) + 1);
		int res = 0;
		for (int i : count.values())
			res = Math.max(res, i);
		return res;
	}

}
