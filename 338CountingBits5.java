package com.leetcode.CountingBits;

import java.util.Arrays;

public class CountingBits5 {

	public static void main(String[] args) {
		
		int num = 5;
		int[] res = countBits(num);
		System.out.println(Arrays.toString(res));

	}

	public static int[] countBits(int num) {
		
		int[] res = new int[num + 1];
		for(int i = 0;i<=num;i++) {
			String s = Integer.toBinaryString(i);
			int count = 0;
			for(int j = 0;j<s.length();j++) {
				if(s.charAt(j) == '1') {
					count ++;
				}
			}
			res[i] = count;
		}
		return res;
		
	}
}
