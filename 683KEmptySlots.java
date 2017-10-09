package com.leetcode.KEmptySlots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KEmptySlots {

	static class Flower {
		int pos;
		int day;
		Flower(int p, int d) {
			pos = p;
			day = d;
		}
	}
	public static void main(String[] args) {
		
		int[] flowers = {3,9,2,8,1,6,10,5,4,7};
		int k = 1;
		System.out.println(kEmptySlots(flowers, k));

	}
	
	public static int kEmptySlots(int[] flowers, int k) {
        
		List<Flower> list = new ArrayList<Flower>();
		for(int i = 0;i<flowers.length;i++) {
			list.add(new Flower(flowers[i], i + 1));
		}
		PriorityQueue<Integer> res = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		Collections.sort(list, new Comparator<Flower>() {

			@Override
			public int compare(Flower o1, Flower o2) {
				return o1.pos - o2.pos;
			}
		});
		for(int i = 1;i<=list.size();i++) {
			if(i - k - 1 >= 1 && i - k - 1 <= list.size()) {
				if(isValid(list, i - k - 2, i - 1)) {
					res.add(Math.max(list.get(i - k - 2).day, list.get(i - 1).day));
				}
			}
			if(i + k + 1 >= 1 && i + k + 1 <= list.size()) {
				if(isValid(list, i - 1, i + k)) {
					res.add(Math.max(list.get(i - 1).day, list.get(i + k).day));
				}
			}
		}
		if(res.size() == 0) {
			return -1;
		}else{
			return res.peek();
		}
		
    }

	public static boolean isValid(List<Flower> list, int start, int end) {
		
		int max = Math.max(list.get(start).day, list.get(end).day);
		for(int i = start + 1;i<end;i++) {
			if(list.get(i).day < max) {
				return false;
			}
		}
		return true;
	}
}
