package com.leetcode.KeysAndRooms;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms2 {

	public static void main(String[] args) {

		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(3);
		rooms.add(list1);
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(3);
		list2.add(0);
		list2.add(1);
		rooms.add(list2);
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(2);
		rooms.add(list3);
		List<Integer> list4 = new ArrayList<Integer>();
		list4.add(0);
		rooms.add(list4);
		boolean res = canVisitAllRooms(rooms);
		System.out.println(res);

	}

	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {

		boolean[] v = new boolean[rooms.size()];
		dfs(rooms, 0, v);
		for (boolean each : v) {
			if (each == false)
				return false;
		}
		return true;
	}

	private static void dfs(List<List<Integer>> rooms, int i, boolean[] v) {
		if (v[i] == true)
			return;
		v[i] = true;
		for (int room : rooms.get(i)) {
			dfs(rooms, room, v);
		}
	}

}
