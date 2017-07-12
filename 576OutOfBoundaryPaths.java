package com.leetcode.OutOfBoundaryPaths;

import java.util.HashMap;
import java.util.Map;

public class OutOfBoundaryPaths {

	public static void main(String[] args) {

		int m = 30;
		int n = 24;
		int N = 23;
		int i = 26;
		int j = 12;
		System.out.println(findPaths(m, n, N, i, j));

	}

	public static int findPaths(int m, int n, int N, int i, int j) {

		if (N == 0) {
			return 0;
		}
		long[][] dp = new long[m][n];
		Map<Integer,long[][]> map = new HashMap<Integer,long[][]>();
		for (int a = 0; a < n; a++) {
			dp[0][a]++;
			dp[m - 1][a]++;
		}
		for (int a = 0; a < m; a++) {
			dp[a][0]++;
			dp[a][n - 1]++;
		}
		map.put(1, dp);
		
		long sum = 0;
		for(int a = N;a>=Math.min(Math.abs(m-i), Math.abs(n-j));a--){
			sum += findPathsHelp(m,n,a, i, j,map);
		}
		return (int) (sum % ((long)Math.pow(10, 9) + 7));
	}

	public static long findPathsHelp(int m, int n, int N, int i, int j, Map<Integer,long[][]> map) {

		if (i < 0 || j < 0 || i >= m || j >= n) {
			return 0;
		}
		if (N == 0) {
			return 0;
		}
		if (map.containsKey(N)) {
			long[][] temp = map.get(N);
			if(temp[i][j] != 0){
				return temp[i][j];
			}			
		}
		
		long step =  findPathsHelp(m,n,N - 1, i - 1, j, map) + findPathsHelp(m,n,N - 1, i + 1, j, map)
				+ findPathsHelp(m,n,N - 1, i, j - 1, map) + findPathsHelp(m,n,N - 1, i, j + 1, map);
		
		long[][] temp ; 
		if(map.containsKey(N)){
			temp = map.get(N);
		}else{
			temp = new long[m][n];
		}
		temp[i][j] = (step % ((long)Math.pow(10, 9) + 7));
		map.put(N, temp);
		
		return step;
	}
}
