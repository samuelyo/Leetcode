package com.leetcode.PerfectNumber;

public class PerfectNumber3 {

	public static void main(String[] args) {
		
		int num = 28;
		System.out.println(checkPerfectNumber(num));

	}

	public static boolean checkPerfectNumber(int num) {
		
		if(num <= 0) {
			return false;
		}
		int sum  = 0;
		for(int i = 1;i<=Math.sqrt(num);i++) {
			if(num % i == 0) {
				if(i != num) {
					sum += i;
				}
				if(num / i != num) {
					sum += num / i;
				}
			}
		}
		return sum == num;
		
	}
}
