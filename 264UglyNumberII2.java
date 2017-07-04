package com.leetcode.UglyNumberII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UglyNumberII2 {

	public static void main(String[] args) {

		int n = 1600;
		System.out.println(nthUglyNumber(n));

	}

	public static int nthUglyNumber(int n) {

		int num[] = new int[n + 1];
		num[0] = 0;
		num[1] = 1;
		int two = 0, three = 0, five = 0;// 刚好大于现有最大丑数的三个
		for (int i = 1; i <= n - 1; i++) {// 每次找出一个丑数
			for (int j = 1; j <= i; j++) {
				// 从头向后扫描，若某数的两倍刚好大于上回找出的丑数，将它值记录下来
				if ((2 * num[j - 1] <= num[i]) && (2 * num[j] > num[i])) {
					two = num[j] * 2;
					break;
				}
			}
			for (int j = 1; j <= i; j++) {
				// 从头向后扫描，若某数的三倍刚好大于上回找出的丑数，将它值记录下来
				if ((3 * num[j - 1] <= num[i]) && (3 * num[j] > num[i])) {
					three = num[j] * 3;
					break;
				}
			}
			for (int j = 1; j <= i; j++) {
				// 从头向后扫描，若某数的五倍刚好大于上回找出的丑数，将它值记录下来
				if ((5 * num[j - 1] <= num[i]) && (5 * num[j] > num[i])) {
					five = num[j] * 5;
					break;
				}
			}
			// 比较出三个数中最小的
			num[i + 1] = Math.min(two, Math.min(three, five));
		}
		return num[n];
	}

}
