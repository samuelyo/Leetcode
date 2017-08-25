package com.leetcode.QueueReconstructionByHeight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstructionByHeight {

	public static void main(String[] args) {

		int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
		int[][] res = reconstructQueue(people);

		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i][0] + " " + res[i][1]);
		}

	}

	public static int[][] reconstructQueue(int[][] people) {

		ArrayList<int[]> list = new ArrayList<int[]>();
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] > o2[0])
					return -1;
				else if (o1[0] < o2[0])
					return 1;
				else {
					if (o1[1] > o2[1]) {
						return 1;
					} else if (o1[1] < o2[1]) {
						return -1;
					} else {
						return 0;
					}
				}
			}
		});

		for (int i = 0; i < people.length; i++) {
			list.add(people[i][1], new int[] { people[i][0], people[i][1] });
		}

		int res[][] = new int[people.length][2];
		for (int i = 0; i < list.size(); i++) {
			res[i][0] = list.get(i)[0];
			res[i][1] = list.get(i)[1];
		}
		return res;

	}

}
