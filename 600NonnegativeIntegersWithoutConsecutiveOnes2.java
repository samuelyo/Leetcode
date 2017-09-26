package com.leetcode.NonnegativeIntegersWithoutConsecutiveOnes;

public class NonnegativeIntegersWithoutConsecutiveOnes2 {

	public static void main(String[] args) {
		
		int num = 5;
		System.out.println(findIntegers(num));

	}
	
	public static int findIntegers(int num) {
		
		int count = 0;
		int n = num;
		StringBuilder t = new StringBuilder();
		while(n > 0) {
			count ++;
			t.append(n % 2);
			n /= 2;
		}
		int[] zero = new int[count];
		int[] one = new int[count];
		zero[0] = 1;
		one[0] = 1;
		for(int i = 1;i<count;i++) {
			zero[i] = zero[i - 1] + one[i - 1];
			one[i] = zero[i - 1];
		}
		int res = zero[count - 1] + one[count - 1];
		for(int i = count - 2; i >= 0;i--) {
			if(t.charAt(i) == '1' && t.charAt(i + 1) == '1') {
				break;
			}
			if(t.charAt(i) == '0' && t.charAt(i + 1) == '0') {
				res -= one[i];
			}
 		}
		return res;
		
	}

}
