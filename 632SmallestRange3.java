package com.leetcode.SmallestRange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Ele {

	int val;
	int row;
	int idx;

	Ele(int r, int i, int v) {
		val = v;
		row = r;
		idx = i;
	}

}

public class SmallestRange3 {

	public static void main(String[] args) {

		List<List<Integer>> lists = new ArrayList<List<Integer>>();

		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(4);
		list1.add(10);
		list1.add(15);
		list1.add(24);
		list1.add(26);
		lists.add(list1);

		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(0);
		list2.add(9);
		list2.add(12);
		list2.add(20);
		lists.add(list2);

		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(5);
		list3.add(18);
		list3.add(22);
		list3.add(30);
		lists.add(list3);

		int[] res = smallestRange(lists);
		System.out.println(res[0] + " " + res[1]);

	}

	public static int[] smallestRange(List<List<Integer>> nums) {

		PriorityQueue<Ele> pq = new PriorityQueue<Ele>(new Comparator<Ele>() {
			public int compare(Ele a, Ele b) {
				return a.val - b.val;
			}
		});
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.size(); i++) {
			Ele e = new Ele(i, 0, nums.get(i).get(0));
			pq.offer(e);
			max = Math.max(max, nums.get(i).get(0));
		}
		int range = Integer.MAX_VALUE;
		int start = -1, end = -1;
		while (pq.size() == nums.size()) {

			Ele curr = pq.poll();
			if (max - curr.val < range) {
				range = max - curr.val;
				start = curr.val;
				end = max;
			}
			if (curr.idx + 1 < nums.get(curr.row).size()) {
				curr.idx = curr.idx + 1;
				curr.val = nums.get(curr.row).get(curr.idx);
				pq.offer(curr);
				if (curr.val > max) {
					max = curr.val;
				}
			}
		}

		return new int[] { start, end };
	}
}
