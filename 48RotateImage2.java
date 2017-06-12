package com.leetcode.RotateImage;

import com.leetcode.MaximumDepthOfBinaryTree.MaximumDepthOfBinaryTree;
import com.leetcode.maximumsubarray.maximumSubarray;

public class RotateImage2 {

	public static void main(String[] args) {

		int[][] matrix = { { 1, 2 }, { 3, 4 } };
		rotate(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

		int[][] matrix2 = { { 1, 2 ,3}, { 4, 5,6 },{7,8,9} };
		antiRotate(matrix2);
		for (int i = 0; i < matrix2.length; i++) {
			for (int j = 0; j < matrix2.length; j++) {
				System.out.print(matrix2[i][j]);
			}
			System.out.println();
		}
	}

	/*
	 * clockwise rotate
	 * first reverse up to down, then swap the symmetry 
	 * 1 2 3     7 8 9     7 4 1
	 * 4 5 6  => 4 5 6  => 8 5 2
	 * 7 8 9     1 2 3     9 6 3
	*/
	public static void rotate(int[][] matrix) {
		int s = 0, e = matrix.length - 1;
		while (s < e) {
			int[] temp = matrix[s];
			matrix[s] = matrix[e];
			matrix[e] = temp;
			s++;
			e--;
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	/*
	 * anticlockwise rotate
	 * first reverse left to right, then swap the symmetry
	 * 1 2 3     3 2 1     3 6 9
	 * 4 5 6  => 6 5 4  => 2 5 8
	 * 7 8 9     9 8 7     1 4 7
	*/
	public static void antiRotate(int[][] matrix) {
		for(int i = 0;i<matrix.length;i++){
			int s = 0, e = matrix.length - 1;
			while (s < e) {
				int temp = matrix[i][s];
				matrix[i][s] = matrix[i][e];
				matrix[i][e] = temp;
				s++;
				e--;
			}
		}
	
		for (int i = 0; i < matrix.length; i++) {
			for (int j = i + 1; j < matrix[i].length; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}
	
}
