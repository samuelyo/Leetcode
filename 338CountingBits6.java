package com.leetcode.CountingBits;

import java.util.Arrays;

public class CountingBits6 {

	public static void main(String[] args) {
		
		int num = 5;
		int[] res = countBits(num);
		System.out.println(Arrays.toString(res));

	}

	public static int[] countBits(int num) {
		
		int[] res = new int[num + 1];
		res[0] = 0;
		for(int i = 1;i<=num;i++) {
			res[i] = res[i >> 1] + (i & 1);
		}
		return res;
		
	}
}
