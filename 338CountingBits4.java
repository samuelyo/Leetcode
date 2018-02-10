package com.leetcode.CountingBits;

import java.util.Arrays;

public class CountingBits4 {

	public static void main(String[] args) {
		
		int num = 5;
		int[] res = countBits(num);
		System.out.println(Arrays.toString(res));

	}

	public static int[] countBits(int num) {
		
		int[] res = new int[num + 1];
		for(int i = 0;i<=num;i++) {
			res[i] = Integer.bitCount(i);
		}
		return res;
		
	}
}
