package com.leetcode.ReverseInteger;

public class ReverseInteger4 {

	public static void main(String[] args) {

		int x = -123;
		int res = reverse(x);
		System.out.println(res);

	}

	public static int reverse(int x) {

		long rev = 0;
		while (x != 0) {
			rev = rev * 10 + x % 10;
			x = x / 10;
			if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
				return 0;
		}
		return (int) rev;

	}
}
