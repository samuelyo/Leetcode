package com.leetcode.ExamRoom;

import java.util.ArrayList;
import java.util.Collections;

public class ExamRoom {

	int n;
	ArrayList<Integer> list;

	public ExamRoom(int N) {
		n = N;
		list = new ArrayList<Integer>();
	}

	public int seat() {
		if (list.size() == 0) {
			list.add(0);
			return 0;
		}
		Collections.sort(list);
		if (list.size() == 1) {
			if (list.get(0) - 0 > n - 1 - list.get(0)) {
				list.add(0);
				return 0;
			} else {
				list.add(n - 1);
				return n - 1;
			}
		}
		int max = 0;
		max = Math.max(list.get(0) - 0, max);
		max = Math.max(n - 1 - list.get(list.size() - 1), max);
		for (int i = 1; i < list.size(); i++) {
			int dis = (list.get(i) - list.get(i - 1)) / 2;
			max = Math.max(max, dis);
		}
		if (list.get(0) - 0 == max) {
			list.add(0);
			return 0;
		}
		for (int i = 1; i < list.size(); i++) {
			int dis = (list.get(i) - list.get(i - 1)) / 2;
			if (dis == max) {
				list.add(list.get(i - 1) + dis);
				return list.get(i - 1) + dis;
			}
		}
		if (n - 1 - list.get(list.size() - 1) == max) {
			list.add(n - 1);
			return n - 1;
		}
		return -1;
	}

	public void leave(int p) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == p) {
				list.remove(i);
			}
		}
	}
}
