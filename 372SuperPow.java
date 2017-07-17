package com.leetcode.SuperPow;

public class SuperPow {

	public static void main(String[] args) {

		int a = 2147483647;
		int[] b = { 2, 0, 0 };
		System.out.println(superPow(a, b));

	}

	/**
	 * One knowledge: a*b % k = (a%k)(b%k)%k 
	 * Since the power here is an array, we'd better handle it digit by digit. 
	 * One observation: a^1234567 % k = (a^1234560 % k) * (a^7 % k) % k = (a^123456 % k)^10 % k * (a^7 % k) % k
	 * Looks complicated? Let me put it other way: 
	 * Suppose f(a, b) calculates a^b % k; 
	 * Then translate above formula to using f : 
	 * f(a,1234567) = f(a,1234560) * f(a, 7) % k = f(f(a, 123456),10) * f(a,7)%k;
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int superPow(int a, int[] b) {
		return superPow(a, b, b.length, 1337);
	}

	public static int superPow(int a, int[] b, int length, int k) {
		if (length == 1) {
			return powMod(a, b[0], k);
		}

		return powMod(superPow(a, b, length - 1, k), 10, k) * powMod(a, b[length - 1], k) % k;
	}

	// x^y mod k
	public static int powMod(int x, int y, int k) {
		x %= k;
		int pow = 1;
		for (int i = 0; i < y; i++) {
			pow = (pow * x) % k;
		}
		return pow;
	}

}
