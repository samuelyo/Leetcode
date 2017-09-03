package com.leetcode.EliminationGame;

public class EliminationGame3 {

	public static void main(String[] args) {

		int n = 9;
		System.out.println(lastRemaining(n));

	}

	public static int lastRemaining(int n) {

		return leftToRight(n);
	}

	private static int leftToRight(int n) {
		if (n <= 2)
			return n;
		return 2 * rightToLeft(n / 2);
	}

	private static int rightToLeft(int n) {
		if (n <= 2)
			return 1;
		if (n % 2 == 1)
			return 2 * leftToRight(n / 2);
		return 2 * leftToRight(n / 2) - 1;

	}
}
