package com.leetcode.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix3 {

	public static void main(String[] args) {
		
//		int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
//		int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}, {17,18,19,20}};
//		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
//		int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
//		int[][] matrix = {{1}};
//		int[][] matrix = {{1,2,3}};
		int[][] matrix = {{1},{2},{3}};
		List<Integer> ans = spiralOrder(matrix);
		for(int i = 0;i<ans.size();i++){
			System.out.print(ans.get(i) + " ");
		}

	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> res = new ArrayList<Integer>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return res;
		}
		int m = matrix.length;
		int n = matrix[0].length;
		int times = 0;
		int i = times;
		int j = times;
		while(res.size() < m * n) {
			i = times;
			j = times;
			while(j < n - times) {
				res.add(matrix[i][j]);
				j ++;
			}
			j --;
			i ++;
			if(i >= m - times) {
				break ;
			}
			while(i < m - times) {
				res.add(matrix[i][j]);
				i ++;
			}
			i --;
			j --;
			if(j < times) {
				break ;
			}
			while(j >= times) {
				res.add(matrix[i][j]);
				j --;
			}
			j ++;
			i --;
			if(i < times) {
				break ;
			}
			while(i > times) {
				res.add(matrix[i][j]);
				i --;
			}
			i ++;
			j ++;
			times ++;
		}
		return res;
		
	}
}
