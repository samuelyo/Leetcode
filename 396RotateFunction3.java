package com.leetcode.RotateFunction;

public class RotateFunction3 {

	public static void main(String[] args) {
		
		int[] A = {4, 3, 2, 6};
		System.out.println(maxRotateFunction(A));

	}

	public static int maxRotateFunction(int[] A) {
		
		if(A == null || A.length == 0) {
			return 0;
		}
		int sum = 0;
		for(int i = 0;i<A.length;i++) {
			sum += A[i];
		}
		int res = 0;
		int[] dp = new int[A.length];
		for(int i = 0;i<A.length;i++) {
			res += i * A[i];
		}
		dp[0] = res;
		for(int j = 1;j<A.length;j++) {
			dp[j] = dp[j - 1] - (A.length - 1) * A[A.length - j] + sum - A[A.length - j];
			res = Math.max(res, dp[j]);
		}
		return res;
		
	}
}
