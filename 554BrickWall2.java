package com.leetcode.BrickWall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BrickWall2 {

	public static void main(String[] args) {

		List<List<Integer>> wall = new ArrayList<List<Integer>>();

		List<Integer> row1 = new ArrayList<Integer>();
		row1.add(1);
		row1.add(2);
		row1.add(2);
		row1.add(1);

		List<Integer> row2 = new ArrayList<Integer>();
		row2.add(3);
		row2.add(1);
		row2.add(2);

		List<Integer> row3 = new ArrayList<Integer>();
		row3.add(1);
		row3.add(3);
		row3.add(2);

		List<Integer> row4 = new ArrayList<Integer>();
		row4.add(2);
		row4.add(4);

		List<Integer> row5 = new ArrayList<Integer>();
		row5.add(3);
		row5.add(1);
		row5.add(2);

		List<Integer> row6 = new ArrayList<Integer>();
		row6.add(1);
		row6.add(3);
		row6.add(1);
		row6.add(1);

		wall.add(row1);
		wall.add(row2);
		wall.add(row3);
		wall.add(row4);
		wall.add(row5);
		wall.add(row6);

		System.out.println(leastBricks(wall));
	}

	public static int leastBricks(List<List<Integer>> wall) {

		if (wall.size() == 0)
			return 0;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (List<Integer> list : wall) {
			int length = 0;
			for (int i = 0; i < list.size() - 1; i++) {
				length += list.get(i);
				map.put(length, map.getOrDefault(length, 0) + 1);
				count = Math.max(count, map.get(length));
			}
		}
		return wall.size() - count;
	}
}
