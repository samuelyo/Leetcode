package com.leetcode.ArithmeticSlices;

public class ArithmeticSlices4 {

	public static void main(String[] args) {
		
		int[] A = {1,2,3,4,5};
		System.out.println(numberOfArithmeticSlices(A));

	}
	
	public static int numberOfArithmeticSlices(int[] A) {
		
		int res = 0;
		Integer[][] dp = new Integer[A.length][A.length];
		for(int i = 0;i<A.length - 2;i++) {
			if(A[i + 1] * 2 == A[i] + A[i + 2]) {
				dp[i][i + 2] = A[i + 1] - A[i];
				res ++;
			}
		}
		for(int i = 0;i<A.length - 3;i++) {
			for(int j = i + 3;j<A.length;j++) {
				if(dp[i][j - 1] != null && dp[i][j - 1] == A[j] - A[j - 1]) {
					res ++;
					dp[i][j] = dp[i][j - 1];
				}
			}
		}
		return res;
		
	}

}
