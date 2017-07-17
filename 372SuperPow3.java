package com.leetcode.SuperPow;

public class SuperPow3 {

	public static void main(String[] args) {

		int a = 2147483647;
		int[] b = { 2, 0, 0 };
		System.out.println(superPow(a, b));

	}

	public static int superPow(int a, int[] b) {
		int res = 1;
		for (int i : b) {
			res = pow(res, 10) * pow(a, i) % 1337;
		}
		return res;
	}

	public static int pow(int x, int y) {
		x %= 1337;
		int res = 1;
		for(int i = 1;i <= y;i++){
			res *= x;
			res %= 1337;
		}
		return res;
	}

}
