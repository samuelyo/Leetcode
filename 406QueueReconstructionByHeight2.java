package com.leetcode.QueueReconstructionByHeight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstructionByHeight2 {

	public static void main(String[] args) {

		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		int[][] res = reconstructQueue(people);

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i][0] + " " + res[i][1]);
		}

	}

	public static int[][] reconstructQueue(int[][] people) {

		// pick up the tallest guy first
		// when insert the next tall guy, just need to insert him into kth
		// position
		// repeat until all people are inserted into list
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] != o2[0] ? -o1[0] + o2[0] : o1[1] - o2[1];
			}
		});
		List<int[]> res = new LinkedList<>();
		for (int[] cur : people) {
			res.add(cur[1], cur);
		}
		return res.toArray(new int[people.length][]);
		
	}

}
