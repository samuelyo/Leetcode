package com.leetcode.SumOfSquareNumbers;

public class SumOfSquareNumbers3 {

	public static void main(String[] args) {
		
		int c = 4;
		System.out.println(judgeSquareSum(c));

	}
	
	public static boolean judgeSquareSum(int c) {
		
		int len = (int) (Math.sqrt(c / 2) + 1);
		for(int i = 0;i<len;i++) {
			if(isSquare(c - i * i)) {
				return true;
			}
		}
		return false;
		
	}
	
	public static boolean isSquare(int num) {
		
		int start = 0;
		int end = (int) (Math.sqrt(num) + 1);
		while(start <= end) {
			int mid = (end - start) / 2 + start;
			if(mid * mid == num) {
				return true;
			}else if(mid * mid < num) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
		}
		return false;
		
	}

}
