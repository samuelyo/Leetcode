package com.leetcode.KeysAndRooms;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms {

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

		if (rooms == null || rooms.size() == 0) {
			return false;
		}
		int len = rooms.size();
		boolean[] visited = new boolean[len];
		canVisitAllRoomsHelp(rooms, 0, visited);
		for (int i = 0; i < len; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;

	}

	public static void canVisitAllRoomsHelp(List<List<Integer>> rooms, int index, boolean[] visited) {

		if (visited[index]) {
			return;
		}
		visited[index] = true;
		List<Integer> list = rooms.get(index);
		for (int i = 0; i < list.size(); i++) {
			Integer next = list.get(i);
			canVisitAllRoomsHelp(rooms, next, visited);
		}

	}

}
