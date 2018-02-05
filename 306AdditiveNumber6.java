package com.leetcode.AdditiveNumber;

import java.math.BigInteger;

public class AdditiveNumber6 {

	public static void main(String[] args) {

		String num = "199100199";
		System.out.println(isAdditiveNumber(num));

	}

	public static boolean isAdditiveNumber(String num) {
		if (num == null || num.length() <= 2) {
			return false;
		}
		boolean res = false;
		for (int i = 1; i <= num.length(); i++) {
			String s1 = num.substring(0, i);
			if (s1.length() > 1 && s1.charAt(0) == '0') {
				continue;
			}
			BigInteger num1 = new BigInteger(s1, 10);
			for (int j = i + 1; j < num.length(); j++) {
				String s2 = num.substring(i, j);
				if (s2.length() > 1 && s2.charAt(0) == '0') {
					continue;
				}
				BigInteger num2 = new BigInteger(s2, 10);
				BigInteger result = num1.add(num2);
				String temp = String.valueOf(result);
				if (j < num.length() && j + temp.length() <= num.length()
						&& temp.equals(num.substring(j, j + temp.length()))) {
					res = res | isAdditiveNumberHelp(num, i, j, j + temp.length());
				}
			}
		}
		return res;

	}

	public static boolean isAdditiveNumberHelp(String num, int i, int j, int index) {

		BigInteger num1 = new BigInteger(num.substring(i, j), 10);
		BigInteger num2 = new BigInteger(num.substring(j, index), 10);
		BigInteger res = num1.add(num2);
		String temp = String.valueOf(res);
		while (index < num.length() && index + temp.length() <= num.length()
				&& temp.equals(num.substring(index, index + temp.length()))) {
			index = index + temp.length();
			num1 = num2;
			num2 = res;
			res = num1.add(num2);
			temp = String.valueOf(res);
		}
		return index == num.length();
	}
}
