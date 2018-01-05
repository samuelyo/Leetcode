package com.leetcode.SearchA2DMatrix;

public class SearchA2DMatrix3 {

	public static void main(String[] args) {
		
//		int[][] matrix = {{1,3,5,7,8},{10,11,16,20,21},{23,30,34,36,50}};
		int[][] matrix = {{1,3,5}};
		int target = 0;
		System.out.println(searchMatrix(matrix, target));

	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		
		int left = 0;
		int right = m * n - 1;
		
		while(left <= right) {
			int mid = (right - left) / 2 + left;
			int value = matrix[mid / n][mid % n];
			if(value == target) {
				return true;
			}else if(value < target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		return false;
		
	}
}
