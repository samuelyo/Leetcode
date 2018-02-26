package com.leetcode.QueueReconstructionByHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight3 {

	public static void main(String[] args) {
		
		int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int[][] queue = reconstructQueue(people);
		for(int i = 0;i<queue.length;i++) {
			int[] cur = queue[i];
			System.out.print(Arrays.toString(cur) + " ");
		}

	}
	
	public static int[][] reconstructQueue(int[][] people) {
		
		Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] people1, int[] people2) {
				if(people1[0] != people2[0]) {
					return people2[0] - people1[0];
				}else {
					return people1[1] - people2[1];
				}
			}
			
		});
		
		List<int[]> list = new ArrayList<int[]>();
		for(int i = 0;i<people.length;i++) {
			int[] cur = people[i];
			list.add(cur[1], cur);
		}
		int[][] res = new int[people.length][2];
		for(int i = 0;i<people.length;i++) {
			res[i] = list.get(i);
		}
		return res;
		
	}

}
