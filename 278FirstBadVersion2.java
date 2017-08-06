package com.leetcode.FirstBadVersion;

public class FirstBadVersion2 {

	public static void main(String[] args) {

		int n = 5;
		System.out.println(firstBadVersion(n));

	}

	public static int firstBadVersion(int n) {

		int start = 1, end = n;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (!isBadVersion(mid))
				start = mid + 1;
			else
				end = mid;
		}
		return start;

	}

	public static boolean isBadVersion(int version) {

		if (version < 3) {
			return false;
		} else {
			return true;
		}

	}
}
