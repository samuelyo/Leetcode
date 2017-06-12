package com.leetcode.RotateImage;

import com.leetcode.maximumsubarray.maximumSubarray;

public class RotateImage {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		for(int i = 0;i<matrix.length;i++){
			for(int j = 0;j<matrix.length;j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

	}
	
	public static void rotate(int[][] matrix) {
        
		int len = matrix.length;
		int[][] temp = new int[len][len];
		for(int i = len - 1;i>=0;i--){
			int[] row = matrix[i];
			for(int j = 0;j<len;j++){
				for(int k = 0;k<len;k++){
					if(k == len - i - 1){
						temp[j][k] = row[j];
					}
				}
			}
		}
		for(int i = 0;i<len;i++){
			for(int j = 0;j<len;j++){
				matrix[i][j] = temp[i][j];
			}
		}
    }

}
