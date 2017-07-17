package com.leetcode.IntegerReplacement;

import java.util.ArrayList;
import java.util.List;

public class IntegerReplacement3 {

	public static void main(String[] args) {

		int n = 2;
		System.out.println(integerReplacement(n));

	}

	public static int integerReplacement(int n) {

		int c = 0;
		while (n != 1) {
			if ((n & 1) == 0) {
				n >>>= 1;
			} else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
				n--;
			} else {
				n++;
			}
			c++;
		}
		return c;

	}

}
