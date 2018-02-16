package com.leetcode.KthSmallestElementInASortedMatrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix4 {

	public static void main(String[] args) {
		
		int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
		int k = 8;
		System.out.println(kthSmallest(matrix, k));

	}
	
	public static int kthSmallest(int[][] matrix, int k) {
		
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		for(int i = 0;i<matrix.length;i++) {
			queue.add(new int[]{matrix[i][0], i, 1});
		}
		
		int[] cur = null;
		while(k > 0 && !queue.isEmpty()) {
			cur = queue.poll();
			if(cur[2] < matrix[0].length) {
				queue.add(new int[]{matrix[cur[1]][cur[2]], cur[1], cur[2] + 1});
			}
			k --;
		}
		return cur[0];
		
	}

}
