package com.leetcode.AdditiveNumber;

import java.math.BigInteger;

public class AdditiveNumber3 {

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
		for (int i = 1; i <= n / 2; ++i)
			for (int j = 1; Math.max(j, i) <= n - i - j; ++j)
				if (isValid(i, j, num))
					return true;
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
	private static boolean isValid(int i, int j, String num) {
		if (num.charAt(0) == '0' && i > 1)
			return false;
		if (num.charAt(i) == '0' && j > 1)
			return false;
		String sum;
		BigInteger x1 = new BigInteger(num.substring(0, i));
		BigInteger x2 = new BigInteger(num.substring(i, i + j));
		for (int start = i + j; start != num.length(); start += sum.length()) {
			x2 = x2.add(x1);
			x1 = x2.subtract(x1);
			sum = x2.toString();
			if (!num.startsWith(sum, start))
				return false;
		}
		return true;
	}
}
