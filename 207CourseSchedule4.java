package com.leetcode.CourseSchedule;

import java.util.ArrayList;

public class CourseSchedule4 {

	public static void main(String[] args) {

		int numCourses = 4;

//		int[][] prerequisites = new int[0][0];

		 int[][] prerequisites = new int[4][2];
		 prerequisites[0][0] = 1;
		 prerequisites[0][1] = 0;
		 prerequisites[1][0] = 2;
		 prerequisites[1][1] = 1;
		 prerequisites[2][0] = 3;
		 prerequisites[2][1] = 2;
		 prerequisites[3][0] = 1;
		 prerequisites[3][1] = 3;

		System.out.println(canFinish(numCourses, prerequisites));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		ArrayList<Integer>[] graph = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++)
			graph[i] = new ArrayList<Integer>();

		boolean[] visited = new boolean[numCourses];
		for (int i = 0; i < prerequisites.length; i++) {
			graph[prerequisites[i][1]].add(prerequisites[i][0]);
		}

		for (int i = 0; i < numCourses; i++) {
			if (!dfs(graph, visited, i))
				return false;
		}
		return true;
	}

	public static boolean dfs(ArrayList<Integer>[] graph, boolean[] visited, int course) {
		if (visited[course])
			return false;
		else
			visited[course] = true;

		for (int i = 0; i < graph[course].size(); i++) {
			if (!dfs(graph, visited, (int) graph[course].get(i)))
				return false;
		}
		visited[course] = false;
		return true;

	}

}
