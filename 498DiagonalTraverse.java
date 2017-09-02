package com.leetcode.DiagonalTraverse;

public class DiagonalTraverse {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		int[] res = findDiagonalOrder(matrix);
		for(int i = 0;i<res.length;i++){
			System.out.print(res[i] + " ");
		}
		
	}
	
	public static int[] findDiagonalOrder(int[][] matrix) {
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return new int[0];
		}
		boolean flag = true;
		int index = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int[] res = new int[m * n];
		int i = 0;
		int j = 0;
		int value = matrix[i][j];
		while(index < m*n){
			res[index] = value;
			if(index == m*n-1){
				break;
			}
			if(flag){
				if(i-1 >= 0 && j+1 < n){
					value = matrix[i-1][j+1];
					i = i-1;
					j = j+1;
				}else if(j+1 < n){
					value = matrix[i][j+1];
					flag = false;
					j = j+1;
				}else{
					value = matrix[i+1][j];
					flag = false;
					i = i+1;
				}
			}else{
				if(i+1 < m && j-1 >= 0){
					value = matrix[i+1][j-1];
					i = i+1;
					j = j-1;
				}else if(i+1 < m){
					value = matrix[i+1][j];
					flag = true;
					i = i+1;
				}else{
					value = matrix[i][j+1];
					flag = true;
					j = j+1;
				}
			}
			index ++;
		}
		return res;
		
	}

}
