package com.leetcode.LongestIncreasingPathInAMatrix;

import java.util.ArrayList;
import java.util.List;

public class LongestIncreasingPathInAMatrix {

	public static void main(String[] args) {
		
		int[][] matrix = {{13,5,13,9},{5,0,2,9},{10,13,11,10},{0,0,13,13}};
		System.out.println(longestIncreasingPath(matrix));

	}

	public static int longestIncreasingPath(int[][] matrix) {
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return 0;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int[][] dir = {{-1,0}, {1,0}, {0,1}, {0,-1}};
		int res = Integer.MIN_VALUE;
		for(int i = 0;i<m;i++){
			for(int j = 0;j<n;j++){
				List<Integer> list = new ArrayList<Integer>();
				res = Math.max(res, longestIncreasingPathHelp(matrix, dp, i, j, list, dir));
			}
		}
		return res;
		
	}
	
	public static int longestIncreasingPathHelp(int[][] matrix, int[][] dp, int i, int j, List<Integer> list, int[][] dir) {
		
		if(dp[i][j] != 0){
			return dp[i][j];
		}
		
		int len = 1;
		int value = matrix[i][j];
		for(int k = 0;k<dir.length;k++){
			i += dir[k][0];
			j += dir[k][1];
			if(i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length ){
				if((list.size() == 0 && matrix[i][j] > value) || (list.size() != 0 && matrix[i][j] > list.get(list.size() - 1))){
					list.add(matrix[i][j]);
					len = Math.max(len, 1 + longestIncreasingPathHelp(matrix, dp, i, j, list, dir));
					list.remove(list.size() - 1);
				}
			}
			i -= dir[k][0];
			j -= dir[k][1];
		}
		dp[i][j] = len;
		return len;
		
	}
}
