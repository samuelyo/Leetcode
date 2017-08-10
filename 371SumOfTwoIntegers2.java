package com.leetcode.SumOfTwoIntegers;

public class SumOfTwoIntegers2 {

	public static void main(String[] args) {

		int a = 1;
		int b = -1;

		System.out.println(getSum(a, b));

	}

	public static int getSum(int a, int b) {

		if (a == 0)
			return b;
		if (b == 0)
			return a;

		while (b != 0) {
			int carry = a & b;
			a = a ^ b;
			b = carry << 1;
		}

		return a;

	}

}
