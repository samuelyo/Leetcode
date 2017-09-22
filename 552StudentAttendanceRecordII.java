package com.leetcode.StudentAttendanceRecordII;

public class StudentAttendanceRecordII {

	public static void main(String[] args) {
		
		int n = 2;
		System.out.println(checkRecord(n));

	}
	
	public static int M = 1000000007;
	
	public static int checkRecord(int n) {
		
		if(n == 0) {
			return 0;
		}
		int[][][] dp = new int[n + 1][2][3];
		for(int i = 0;i<2;i++) {
			for(int j = 0;j<3;j++) {
				dp[0][i][j] = 1;
			}
		}
		
		for(int i = 1;i<=n;i++) {
			for(int j = 0;j<2;j++) {
				for(int k = 0;k<3;k++) {
					int val = dp[i-1][j][2];
					if(j > 0) {
						val = (val + dp[i-1][j-1][2]) % M;
					}
					if(k > 0) {
						val = (val + dp[i-1][j][k-1]) % M;
					}
					dp[i][j][k] = val;
				}
			}
		}
		return dp[n][1][2];
		
	}

}
