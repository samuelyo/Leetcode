package com.leetcode.CourseSchedule;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule3 {

	public static void main(String[] args) {

		int numCourses = 4;

		int[][] prerequisites = new int[0][0];

		// int[][] prerequisites = new int[4][2];
		// prerequisites[0][0] = 1;
		// prerequisites[0][1] = 0;
		// prerequisites[1][0] = 2;
		// prerequisites[1][1] = 1;
		// prerequisites[2][0] = 3;
		// prerequisites[2][1] = 2;
		// prerequisites[3][0] = 1;
		// prerequisites[3][1] = 3;

		System.out.println(canFinish(numCourses, prerequisites));
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {

		int[][] matrix = new int[numCourses][numCourses]; // i -> j
		int[] indegree = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			int ready = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if (matrix[pre][ready] == 0)
				indegree[ready]++; // duplicate case
			matrix[pre][ready] = 1;
		}

		int count = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[course][i] != 0) {
					if (--indegree[i] == 0)
						queue.offer(i);
				}
			}
		}
		return count == numCourses;

	}

}
