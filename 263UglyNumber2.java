package com.leetcode.UglyNumber;

public class UglyNumber2 {

	public static void main(String[] args) {

		int num = -1000;
		System.out.println(isUgly(num));

	}

	public static boolean isUgly(int num) {

		for (int i = 2; i < 6 && num > 0; i++) {
			while (num % i == 0) {
				num /= i;
			}
		}
		return num == 1;
	}

}
