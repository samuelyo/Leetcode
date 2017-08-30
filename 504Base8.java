package com.leetcode.Base7;

public class Base8 {

	public static void main(String[] args) {

		int num = -7;
		System.out.println(convertToBase7(num));

	}

	public static String convertToBase7(int num) {

		if (num < 0)
			return '-' + convertToBase7(-num);
		if (num < 7)
			return num + "";
		return convertToBase7(num / 7) + num % 7;

	}
}
