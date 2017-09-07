package com.leetcode.OnesAndZeroes;

public class OnesAndZeroes {

	public static void main(String[] args) {
		
		String[] strs = {"10", "0", "1"};
		int m = 1;
		int n = 1;
		System.out.println(findMaxForm(strs, m, n));

	}
	
	public static int findMaxForm(String[] strs, int m, int n) {
		
		int[][] dp = new int[m+1][n+1];
		for(String s : strs){
			int[] cur = count(s);
			for(int i = m;i>=cur[0];i--){
				for(int j = n;j>=cur[1];j--){
					dp[i][j] = Math.max(dp[i][j], dp[i - cur[0]][j - cur[1]] + 1);
				}
			}
		}
		return dp[m][n];
		
		
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
