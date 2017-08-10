package com.leetcode.SumOfTwoIntegers;

public class SumOfTwoIntegers3 {

	public static void main(String[] args) {

		int a = 1;
		int b = -1;

		System.out.println(getSum(a, b));

	}

	public static int getSum(int a, int b) {

		return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);

	}

}
