package com.leetcode.PowerOfFour;

public class PowerOfFour3 {

	public static void main(String[] args) {
		
		int num = 16;
		boolean res = isPowerOfFour(num);
		System.out.println(res);

	}
	
	public static boolean isPowerOfFour(int num) {
        
		if(num <= 0) {
			return false;
		}
		if(num == 1) {
			return true;
		}
		String s = Integer.toBinaryString(num);
		int len = s.length();
		if(s.charAt(0) == '0' || (len - 1) % 2 != 0) {
			return false;
		}
		for(int i = 1;i<len;i++) {
			if(s.charAt(i) == '1') {
				return false;
			}
		}
		return true;
		
    }


}
