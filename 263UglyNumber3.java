package com.leetcode.UglyNumber;

public class UglyNumber3 {

	public static void main(String[] args) {
		
		int num = 12;
		System.out.println(isUgly(num));
	}
	
	public static boolean isUgly(int num) {
		
		if(num <= 0) {
			return false;
		}
		if(num == 1) {
			return true;
		}
		for(int i = 1;i<=Math.sqrt(num);i++) {
			if(num % i == 0) {
				int cur = num / i;
				if(isPrime(cur) && cur != 2 && cur != 3 && cur != 5) {
					return false;
				}
				if(isPrime(i) && i != 2 && i != 3 && i != 5) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	public static boolean isPrime(int num) {
		
		if(num == 1) {
			return false;
		}
		if(num == 2) {
			return true;
		}
		if(num % 2 == 0) {
			return false;
		}
		for(int i = 3;i<=Math.sqrt(num);i++) {
			if(num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
