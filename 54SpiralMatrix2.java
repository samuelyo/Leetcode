package com.leetcode.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix2 {

	public static void main(String[] args) {

		int[][] matrix = { { 1 } };
		List<Integer> ans = spiralOrder(matrix);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> list = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return list;

		int rowMin = 0, rowMax = matrix.length - 1, colMin = 0, colMax = matrix[0].length - 1;
		while (rowMin <= rowMax && colMin <= colMax) {
			for (int i = colMin; i <= colMax; i++)
				list.add(matrix[rowMin][i]);
			rowMin++;

			for (int i = rowMin; i <= rowMax; i++)
				list.add(matrix[i][colMax]);
			colMax--;

			if (rowMin > rowMax || colMin > colMax)
				break;

			for (int i = colMax; i >= colMin; i--)
				list.add(matrix[rowMax][i]);
			rowMax--;

			for (int i = rowMax; i >= rowMin; i--)
				list.add(matrix[i][colMin]);
			colMin++;
		}
		return list;
	}

}
