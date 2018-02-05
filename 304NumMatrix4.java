package com.leetcode.RangeSumQuery2DImmutable;

public class NumMatrix4 {

	public int m;
	public int n;
	public int[][] sums;
	
	public NumMatrix4(int[][] matrix) {
        
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			sums = null;
		}else {
			m = matrix.length;
			n = matrix[0].length;
			sums = new int[m][n];
			sums[0][0] = matrix[0][0];
			for(int i = 1;i<m;i++) {
				sums[i][0] = sums[i - 1][0] + matrix[i][0];
			}
			for(int j = 1;j<n;j++) {
				sums[0][j] = sums[0][j - 1] + matrix[0][j];
			}
			for(int i = 1;i<m;i++) {
				int[] temp = new int[n];
				temp[0] = matrix[i][0];
				for(int j = 1;j<n;j++) {
					temp[j] = temp[j - 1] + matrix[i][j];
					sums[i][j] = sums[i - 1][j] + temp[j];
				}
			}
		}
		
		
    }

	public int sumRegion(int row1, int col1, int row2, int col2) {

		if(sums == null) {
			return 0;
		}
		if(row1 == 0 && col1 == 0) {
			return sums[row2][col2];
		}
		if(row1 == 0) {
			return sums[row2][col2] - sums[row2][col1 - 1];
		}
		if(col1 == 0) {
			return sums[row2][col2] - sums[row1 - 1][col2];
		}
		return sums[row2][col2] - (sums[row1 - 1][col2] + sums[row2][col1 - 1] - sums[row1 - 1][col1 - 1]);
		
	}
}
