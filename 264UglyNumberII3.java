package com.leetcode.UglyNumberII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UglyNumberII3 {

	public static void main(String[] args) {

		int n = 1500;
		System.out.println(nthUglyNumber(n));

	}

	public static int nthUglyNumber(int n) {

		if (n <= 0)
			return 0;
		int[] result = new int[n];
		result[0] = 1;
		int begin = 1, m2 = 0, m3 = 0, m5 = 0;
		while (begin < n) {
			result[begin] = Math.min(result[m2] * 2, Math.min(result[m3] * 3, result[m5] * 5));// 大于当前最大丑数的最小数
			while ((result[m2] * 2 <= result[begin])) {
				m2++;
			}
			while ((result[m3] * 3 <= result[begin])) {
				m3++;
			}
			while ((result[m5] * 5 <= result[begin])) {
				m5++;
			}
			begin++;
		}
		return result[n - 1];
	}
	
}
