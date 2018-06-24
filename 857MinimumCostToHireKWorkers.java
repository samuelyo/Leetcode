package com.leetcode.MinimumCostToHireKWorkers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumCostToHireKWorkers {

	public static void main(String[] args) {

		// [70,90,81,2,13,73,79,2,67,63,14,3,61,66,17,19,21,53,20,68,12,90,10,77,30,91,78,43,66,41,67,97,79,1,50,7,85,37,60,93,23,41,17,1,46,74,63,97,96,99,53,84,99,15,82,22,24,43,8,12,42,96,20,9,9,45,61,57,17,27,54,65,83,95,30,42,44,27,15,5,52,76,42,21,8,28,4,39,26,49,18,32,51,63,88,94,47,28,41,17]
		// [229,146,463,94,195,175,500,23,145,405,45,187,107,49,267,151,291,390,206,384,153,249,84,420,297,264,203,447,24,423,263,441,310,138,8,14,155,394,237,378,46,407,427,380,28,275,498,385,322,177,351,499,294,238,177,347,294,463,296,487,73,157,153,61,132,66,38,84,16,380,116,233,195,402,129,28,350,364,37,177,352,92,329,302,427,314,482,160,71,178,338,343,156,261,414,172,498,202,220,37]
		// 60
		// int[] quality = {
		// 70,90,81,2,13,73,79,2,67,63,14,3,61,66,17,19,21,53,20,68,12,90,10,77,30,91,78,43,66,41,67,97,79,1,50,7,85,37,60,93,23,41,17,1,46,74,63,97,96,99,53,84,99,15,82,22,24,43,8,12,42,96,20,9,9,45,61,57,17,27,54,65,83,95,30,42,44,27,15,5,52,76,42,21,8,28,4,39,26,49,18,32,51,63,88,94,47,28,41,17
		// };
		// int[] wage = {
		// 229,146,463,94,195,175,500,23,145,405,45,187,107,49,267,151,291,390,206,384,153,249,84,420,297,264,203,447,24,423,263,441,310,138,8,14,155,394,237,378,46,407,427,380,28,275,498,385,322,177,351,499,294,238,177,347,294,463,296,487,73,157,153,61,132,66,38,84,16,380,116,233,195,402,129,28,350,364,37,177,352,92,329,302,427,314,482,160,71,178,338,343,156,261,414,172,498,202,220,37
		// };
		// int K = 60;
		int[] quality = { 10, 20, 5 };
		int[] wage = { 70, 50, 30 };
		int K = 2;
		double res = mincostToHireWorkers(quality, wage, K);
		System.out.println(res);

	}

	public static double mincostToHireWorkers(int[] quality, int[] wage, int K) {

		List<Double[]> list = new ArrayList<Double[]>();
		for (int i = 0; i < quality.length; i++) {
			double temp = (double) wage[i] / (double) quality[i];
			list.add(new Double[] { temp, (double) i });
		}
		Collections.sort(list, new Comparator<Double[]>() {

			@Override
			public int compare(Double[] o1, Double[] o2) {
				return o1[0].compareTo(o2[0]);
			}

		});
		double res = Double.MAX_VALUE;
		List<int[]> indexes = new ArrayList<int[]>();
		for (int i = 0; i < K - 1; i++) {
			int[] temp = new int[] { list.get(i)[1].intValue(), quality[list.get(i)[1].intValue()] };
			indexes.add(temp);
		}
		for (int index = K - 1; index < list.size(); index++) {
			double ratio = list.get(index)[0];
			int[] temp = new int[] { list.get(index)[1].intValue(), quality[list.get(index)[1].intValue()] };
			indexes.add(temp);
			int sum = 0;
			Collections.sort(indexes, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					return o1[1] - o2[1];
				}

			});

			for (int i = 0; i < K; i++) {
				int[] cur = indexes.get(i);
				sum += cur[1];
			}
			res = Math.min(res, ratio * sum);
		}
		return res;
	}

}
