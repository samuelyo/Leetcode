package com.leetcode.IntegerReplacement;

public class IntegerReplacement5 {

	public static void main(String[] args) {
		
		int res = integerReplacement(100000000);
		System.out.println(res);

	}

	public static int integerReplacement(int n) {
		
		int count = 0;
		long temp = (long)n;
		while(temp > 3) {
			if((temp & 1) == 0) {
				temp >>= 1;
			}else {
				if((temp & 3) == 3) {
					temp ++;
				}else {
					temp --;
				}
			}
			count ++;
		}
		return temp == 3 ? count + 2 : (temp == 2 ? count + 1 : count);
		
	}
}
