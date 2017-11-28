package com.leetcode.ArrangingCoins;

public class ArrangingCoins4 {

	public static void main(String[] args) {
		
		int n = 1804289383;
		System.out.println(arrangeCoins(n));

	}

	public static int arrangeCoins(int n) {

		int left = 0;
		int right = n;
		while(left <= right) {
			int mid = (right - left) / 2 + left;
			long cur = (long) (0.5 * mid * mid + 0.5 * mid);
			if(cur == n) {
				return mid;
			}else if(cur < n) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return right;
		
	}

}
