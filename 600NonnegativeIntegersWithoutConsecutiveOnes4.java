package com.leetcode.NonnegativeIntegersWithoutConsecutiveOnes;

public class NonnegativeIntegersWithoutConsecutiveOnes4 {

	public static void main(String[] args) {

		int num = 7;
		System.out.println(findIntegers(num));

	}

	public static int findIntegers(int num) {
		
		int res = 0;
		int k = 31;
		int pre = 0;
		int[] f = new int[32];
		f[0] = 1;
		f[1] = 2;
		for(int i = 2;i<31;i++) {
			f[i] = f[i - 2] + f[i - 1];
		}
		while(k >= 0) {
			if((num & (1 << k)) != 0) {
				res += f[k];
				if(pre != 0) {
					return res;
				}
				pre = 1;
			}else{
				pre = 0;
			}
			k --;
		}
		return res + 1;

	}

}
