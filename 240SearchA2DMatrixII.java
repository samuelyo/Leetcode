package com.leetcode.SearchA2DMatrixII;

public class SearchA2DMatrixII {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int target = 5;
		System.out.println(searchMatrix(matrix, target));

	}
	
	public static boolean searchMatrix(int[][] matrix, int target) {
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		if(target < matrix[0][0] || target > matrix[m-1][n-1]){
			return false;
		}
		
		for(int i = 0;i<m && matrix[i][0] <= target;i++){
			int left = 0;
			int right = n-1;
			while(left <= right){
				int middle = left + (right - left) / 2;
				if(matrix[i][middle] == target){
					return true;
				}else if(matrix[i][middle] < target){
					left = middle + 1;
				}else{
					right = middle - 1;
				}
			}
		}
		return false;
		
	}

}
