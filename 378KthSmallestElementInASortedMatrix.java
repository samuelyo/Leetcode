package com.leetcode.KthSmallestElementInASortedMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthSmallestElementInASortedMatrix {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		int k = 8;
		System.out.println(kthSmallest(matrix, k));

	}
	
	public static int kthSmallest(int[][] matrix, int k) {
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0;i<matrix.length;i++){
			for(int j = 0;j<matrix[0].length;j++){
				list.add((Integer)(matrix[i][j]));
			}
		}
		Collections.sort(list);
		return list.get(k - 1);
		
	}

}
