package com.leetcode.CourseScheduleII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII3 {

	public static void main(String[] args) {

		int numCourses = 2;

		int[][] prerequisites = new int[1][2];

		prerequisites[0][0] = 1;
		prerequisites[0][1] = 0;
//		prerequisites[1][0] = 0;
//		prerequisites[0][1] = 1;

		int[] res = findOrder(numCourses, prerequisites);

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {

		int[] incLinkCounts = new int[numCourses];
		List<List<Integer>> adjs = new ArrayList<List<Integer>>(numCourses);
		int n = incLinkCounts.length;
		while (n-- > 0)
			adjs.add(new ArrayList<Integer>());
		for (int[] edge : prerequisites) {
			incLinkCounts[edge[0]]++;
			adjs.get(edge[1]).add(edge[0]);
		}
		int[] order = new int[incLinkCounts.length];
		Queue<Integer> toVisit = new ArrayDeque<Integer>();
		for (int i = 0; i < incLinkCounts.length; i++) {
			if (incLinkCounts[i] == 0)
				toVisit.offer(i);
		}
		int visited = 0;
		while (!toVisit.isEmpty()) {
			int from = toVisit.poll();
			order[visited++] = from;
			for (int to : adjs.get(from)) {
				incLinkCounts[to]--;
				if (incLinkCounts[to] == 0)
					toVisit.offer(to);
			}
		}
		return visited == incLinkCounts.length ? order : new int[0];
	}
}
