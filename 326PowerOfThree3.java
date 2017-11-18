package com.leetcode.PowerOfThree;

public class PowerOfThree3 {

	public static void main(String[] args) {
		
		int n = 9;
		boolean res = isPowerOfThree(n);
		System.out.println(res);

	}
	
	public static boolean isPowerOfThree(int n) {
        
		if(n <= 0) {
			return false;
		}
		if(n == 1) {
			return true;
		}
		if(n % 3 != 0) {
			return false;
		}else {
			return isPowerOfThree(n / 3);
		}
		
    }


}
