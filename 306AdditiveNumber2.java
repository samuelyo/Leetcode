package com.leetcode.AdditiveNumber;

import java.math.BigInteger;

public class AdditiveNumber2 {

	public static void main(String[] args) {

		String num = "112358";
		System.out.println(isAdditiveNumber(num));

	}

	/**
	 * i represents the first num's length
	 * j represents the second num's length
	 * @param num
	 * @return
	 */
	public static boolean isAdditiveNumber(String num) {

		int n = num.length();
		for (int i = 1; i <= n / 2; ++i) {
			if (num.charAt(0) == '0' && i > 1)
				return false;
			BigInteger x1 = new BigInteger(num.substring(0, i));
			for (int j = 1; Math.max(j, i) <= n - i - j; ++j) {
				if (num.charAt(i) == '0' && j > 1)
					break;
				BigInteger x2 = new BigInteger(num.substring(i, i + j));
				if (isValid(x1, x2, j + i, num))
					return true;
			}
		}
		return false;
	}

	/**
	 * x2 become the sum of the first num and the second num
	 * x1 become the second num
	 * num.startsWith(sum,start) represents first + second = next
	 * @param x1
	 * @param x2
	 * @param start
	 * @param num
	 * @return
	 */
	public static boolean isValid(BigInteger x1, BigInteger x2, int start, String num) {
		if (start == num.length())
			return true;
		x2 = x2.add(x1);
		x1 = x2.subtract(x1);
		String sum = x2.toString();
		return num.startsWith(sum, start) && isValid(x1, x2, start + sum.length(), num);
	}
}
