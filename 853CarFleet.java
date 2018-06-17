package com.leetcode.CarFleet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CarFleet {

	public static void main(String[] args) {

//		int target = 12;
//		int[] position = { 10, 8, 0, 5, 3 };
//		int[] speed = { 2, 4, 1, 1, 3 };
		int target = 10;
		int[] position = { 6, 8 };
		int[] speed = { 3, 2 };
		int res = carFleet(target, position, speed);
		System.out.println(res);

	}

	public static int carFleet(int target, int[] position, int[] speed) {

		ArrayList<double[]> list = new ArrayList<double[]>();
		for (int i = 0; i < position.length; i++) {
			list.add(new double[] { position[i], (double)(target - position[i]) / speed[i] });
		}
		Collections.sort(list, new Comparator<double[]>() {

			@Override
			public int compare(double[] o1, double[] o2) {
				return (int)(o1[0] - o2[0]);
			}

		});
		int res = 0;
		double time = 0;
		for (int i = list.size() - 1; i >= 0; i--) {
		    double cur = list.get(i)[1];
			if (cur > time) {
				time = cur;
				res++;
			}
		}
		return res;
	}
}
