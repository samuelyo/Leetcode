package com.leetcode.SuperPow;

public class SuperPow4 {

	public static void main(String[] args) {
		
		int a = 2147483647;
		int[] b = { 2, 0, 0 };
		System.out.println(superPow(a, b));

	}
	
	public static int superPow(int a, int[] b) {
		
		int res = 1;
		for(int i = 0;i<b.length;i++) {
			res = superPowHelp(res, 10, 1337);
			res *= superPowHelp(a, b[i], 1337);
			res %= 1337;
		}
		return res;
		
	}
	
	public static int superPowHelp(int a, int b, int k) {
		
		int res = 1;
		for(int i = 1;i<=b;i++) {
			res *= a % k;
			res %= k;
		}
		return res;
		
	}

}
