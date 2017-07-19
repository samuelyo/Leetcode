package com.leetcode.SumOfSquareNumbers;

public class SumOfSquareNumbers {

	public static void main(String[] args) {
		
		int c = 0;
//		System.out.println(Math.sqrt(c));
		System.out.println(judgeSquareSum(c));
	}
	
	public static boolean judgeSquareSum(int c) {
		
		int m = c/2;
		int i = (int)Math.sqrt(m);
		int cur = 0;
		while(cur <= i){
			int temp = c - cur * cur;
			if((int)Math.sqrt(temp) * (int)Math.sqrt(temp) == temp){
				return true;
			}
			cur ++;
		}
		return false;
		
	}

}
