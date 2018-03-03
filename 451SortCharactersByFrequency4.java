package com.leetcode.SortCharactersByFrequency;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SortCharactersByFrequency4 {

	public static void main(String[] args) {
		
		String s = "Aabb";
		String res = frequencySort(s);
		System.out.println(res);

	}
	
	public static String frequencySort(String s) {
		
		int[] map = new int[128];
		for(int i = 0;i<s.length();i++) {
			char cur = s.charAt(i);
			map[cur - ' '] ++;
		}
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		for(int i = 0;i<map.length;i++) {
			queue.add(new int[]{map[i], i});
		}
		StringBuilder sb = new StringBuilder();
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			for(int i = 0;i<cur[0];i++) {
				sb.append((char)(' ' + cur[1]));
			}
		}
		return sb.toString();
		
	}

}
