package com.leetcode.NthDigit;

public class NthDigit3 {

	public static void main(String[] args) {
		
		int n = 119;
		int res = findNthDigit(n);
		System.out.println(res);

	}
	
	public static int findNthDigit(int n) {
	
		int temp = n;
		int num = 0;
		while(temp - 9 * Math.pow(10, num) * (num + 1) > 0) {
			temp -= 9 * Math.pow(10, num) * (num + 1);
			num ++;
		}
		int times = temp / (num + 1);
		int left = temp % (num + 1);
		int base = (int)Math.pow(10, num) + times - 1;
		String s = String.valueOf(base);
		if(left == 0) {
			return s.charAt(s.length() - 1) - '0'; 
		}else {
			s = String.valueOf(base + 1);
			return s.charAt(left - 1) - '0';
		}
		
	}

}
