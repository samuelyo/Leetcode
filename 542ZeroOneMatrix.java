package com.leetcode.ZeroOneMatrix;

public class ZeroOneMatrix {

	public static void main(String[] args) {
		
		int[][] matrix = {{0,1,1},{0,1,1},{1,1,1}};
		int[][] ans = updateMatrix(matrix);
		for(int i = 0;i<ans.length;i++){
			for(int j = 0;j<ans[0].length;j++){
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	public static int[][] updateMatrix(int[][] matrix) {
		
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] res = new int[m][n];
		Integer[][] ans = new Integer[m][n];
		boolean[][] v = new boolean[m][n];
		for(int i = 0;i<m;i++){
			for(int j = 0;j<n;j++){
				res[i][j] = updateMatrixHelp(matrix, i, j, v, ans);
				ans[i][j] = res[i][j];
			}
		}
		return res;
	}

	public static int updateMatrixHelp(int[][] copy, int i, int j,boolean[][] v,Integer[][] ans) {
		
		if(i < 0 || i >= copy.length || j < 0 || j >= copy[0].length || v[i][j] == true){
			return -1;
		}
		
		if(copy[i][j] == 0){
			return 0;
		}
		if(ans[i][j] != null){
			return ans[i][j];
		}
		v[i][j] = true;
		int res = Integer.MAX_VALUE;
		if(updateMatrixHelp(copy, i-1, j, v, ans) >= 0){
			res = Math.min(res, updateMatrixHelp(copy, i-1, j, v, ans) + 1);
		}
		if(updateMatrixHelp(copy, i+1, j, v, ans) >= 0){
			res = Math.min(res, updateMatrixHelp(copy, i+1, j, v, ans) + 1);
		}
		if(updateMatrixHelp(copy, i, j-1, v, ans) >= 0){
			res = Math.min(res, updateMatrixHelp(copy, i, j-1, v, ans) + 1);
		}
		if(updateMatrixHelp(copy, i, j+1, v, ans) >= 0){
			res = Math.min(res, updateMatrixHelp(copy, i, j+1, v, ans) + 1);
		}
		v[i][j] = false;
		return res;
	}
}
