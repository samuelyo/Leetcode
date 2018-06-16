package com.leetcode.LoudAndRich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoudAndRich {

	public static void main(String[] args) {

		int[][] richer = { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 7 }, { 4, 3 }, { 5, 3 }, { 6, 3 } };
		int[] quiet = { 3, 2, 5, 4, 6, 1, 7, 0 };
		int[] res = loudAndRich(richer, quiet);
		System.out.println(Arrays.toString(res));

	}

	public static int[] loudAndRich(int[][] richer, int[] quiet) {
		int len = quiet.length;
		int[] res = new int[len];
		List<Integer>[] lists = new List[len];
		for (int i = 0; i < len; i++) {
			lists[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < richer.length; i++) {
			int[] cur = richer[i];
			lists[cur[1]].add(cur[0]);
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			int[] q = new int[1];
			q[0] = i;
			boolean[] visited = new boolean[len];
			loudAndRichHelp(lists, i, quiet, visited, q, map);
			res[i] = q[0];
			map.put(i, q[0]);
		}
		return res;
	}

	public static void loudAndRichHelp(List[] lists, int i, int[] quiet, boolean[] visited, int[] q, Map<Integer, Integer> map) {
		visited[i] = true;
		List<Integer> list = lists[i];
		for (int k = 0; k < list.size(); k++) {
			int next = list.get(k);
			if(map.containsKey(next)) {
				if(quiet[map.get(next)] < quiet[q[0]]) {
					q[0] = map.get(next);
				}
				continue;
			}
			if (!visited[next]) {
				visited[next] = true;
				if (quiet[next] < quiet[q[0]]) {
					q[0] = next;
				}
				loudAndRichHelp(lists, next, quiet, visited, q, map);
				visited[next] = false;
			}
		}
	}

}
