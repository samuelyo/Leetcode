package com.leetcode.FirstBadVersion;

public class FirstBadVersion3 {

	public static void main(String[] args) {
		
		int n = 5;
		System.out.println(firstBadVersion(n));

	}
	
	public static int firstBadVersion(int n) {
		
		int start = 0;
		int end = n - 1;
		
		while(start <= end) {
			int mid = start + (end - start) / 2;
			if(isBadVersion(mid)) {
				if(!isBadVersion(mid - 1)) {
					return mid;
				}else {
					end = mid - 1;
				}
			}else {
				start = mid + 1;
			}
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
