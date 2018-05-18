package com.onlinetest.tencent;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GluttonousQ {

	public static Set<Long> set = new HashSet<Long>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			long days = sc.nextLong();
			long value = sc.nextLong();
			long left = 0;
			long right = value;
			while (left < right) {
				long mid = (right - left) / 2 + left;
				int temp = isValid(mid, days, value);
				if (temp < 0) {
					right = mid - 1;
				} else if (temp > 0) {
					left = mid + 1;
				} else {
					break;
				}
			}
			long res = (right - left) / 2 + left;
			if (isValid(res, days, value) < 0) {
				System.out.println(res - 1);
			} else {
				System.out.println(res);
			}
		}
		sc.close();
	}

	public static int isValid(long start, long days, long value) {
		if (set.contains(start)) {
			return -1;
		}
		long temp = 0;
		for (int i = 0; i < days; i++) {
			temp += start;
			if (temp > value) {
				set.add(start);
				return -1;
			}
			start = (long) Math.ceil((double) (start / 2.0));
		}
		return temp < value ? 1 : 0;
	}

}
