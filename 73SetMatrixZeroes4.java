package com.leetcode.SetMatrixZeroes;

import java.util.HashSet;
import java.util.Set;

public class SetMatrixZeroes4 {

	public static void main(String[] args) {
		
		int[][] matrix = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
		setZeroes(matrix);
		for(int i = 0;i<matrix.length;i++){
			for(int j = 0;j<matrix[i].length;j++){
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	public static void setZeroes(int[][] matrix) {
		
		Set<Integer> rows = new HashSet<Integer>();
		Set<Integer> cols = new HashSet<Integer>();
		for(int i = 0;i<matrix.length;i++) {
			for(int j = 0;j<matrix[0].length;j++) {
				if(matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}
		for(int i = 0;i<matrix.length;i++) {
			for(int j = 0;j<matrix[0].length;j++) {
				if(rows.contains(i) || cols.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}

}
