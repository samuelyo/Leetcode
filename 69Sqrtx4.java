package com.leetcode.Sqrtx;

public class Sqrtx4 {

	public static void main(String[] args) {
		
		int x = 0;
		System.out.println(mySqrt(x));
	}
	
	public static int mySqrt(int x) {
		
		int left = 1;
		int right = x;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(mid == x / mid) {
				return mid;
			}else if(mid > x / mid) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		return right;
				
	}

}
