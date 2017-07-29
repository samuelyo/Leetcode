package com.leetcode.CourseScheduleII;

import java.util.ArrayList;
import java.util.List;

class Course {
	boolean visited = false;
	boolean tested = false;
	int number;
	List<Course> pre = new ArrayList<Course>();

	public Course(int i) {
		number = i;
	}

	public void add(Course c) {
		pre.add(c);
	}
}

public class CourseScheduleII {

	public static int N = 0;

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

		int[] result = new int[numCourses];
		Course[] courses = new Course[numCourses];
		for (int i = 0; i < numCourses; i++) {
			courses[i] = new Course(i);
		}
		for (int i = 0; i < prerequisites.length; i++) {
			courses[prerequisites[i][0]].add(courses[prerequisites[i][1]]);
		}
		for (int i = 0; i < numCourses; i++) {
			if (isCyclic(courses[i], result)) {
				return new int[0];
			}
		}
		return result;
	}

	private static boolean isCyclic(Course cur, int[] result) {
		if (cur.tested == true)
			return false;
		if (cur.visited == true)
			return true;
		cur.visited = true;
		for (Course c : cur.pre) {
			if (isCyclic(c, result)) {
				return true;
			}
		}
		cur.tested = true;
		result[N++] = cur.number;
		cur.visited = false;
		return false;
	}
}
