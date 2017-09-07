package com.leetcode.OnesAndZeroes;

public class OnesAndZeroes2 {

	public static void main(String[] args) {
		
		String[] strs = {"10", "0", "1"};
		int m = 1;
		int n = 1;
		System.out.println(findMaxForm(strs, m, n));

	}
	
	public static int findMaxForm(String[] strs, int m, int n) {
		
		int len = strs.length;
		int[][][] dp = new int[len+1][m+1][n+1];
		for(int i = 1;i<len+1;i++){
			String s = strs[i - 1];
			int[] cur = count(s);
			for(int j = 0;j<m+1;j++){
				for(int k = 0;k<n+1;k++){
					if(j >= cur[0] && k >= cur[1]){
						dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j-cur[0]][k-cur[1]] + 1);
					}else{
						dp[i][j][k] = dp[i-1][j][k];
					}
				}
			}
		}
		return dp[len][m][n];
		
		
	}
	
	public static int[] count(String s) {
		
		int zero = 0;
		int one = 0;
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i) == '0'){
				zero ++;
			}else{
				one ++;
			}
		}
		return new int[]{zero, one};
		
	}

}
