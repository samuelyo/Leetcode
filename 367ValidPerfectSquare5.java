package com.leetcode.ValidPerfectSquare;

public class ValidPerfectSquare5 {

	public static void main(String[] args) {
		
		int num = 1;
		System.out.println(isPerfectSquare(num));

	}

	public static boolean isPerfectSquare(int num) {
		
		if(num <= 0) {
			return false;
		}
		int start = 1;
		int end = num;
		while(start <= end) {
			int mid = (end - start) / 2 + start;
			if(num % mid == 0 && num / mid == mid && num / mid * mid == num) {
				return true;
			}else if(num / mid < mid) {
				end = mid - 1;
			}else {
				start = mid + 1;
			}
		}
		return false;
		
	}
}
