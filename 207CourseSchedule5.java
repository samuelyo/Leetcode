package com.leetcode.CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule5 {

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
		
		int[] inDegree = new int[numCourses];
		List<Integer>[] lists = new List[numCourses];
		for(int i = 0;i<prerequisites.length;i++) {
			int num1 = prerequisites[i][0];
			int num2 = prerequisites[i][1];
			inDegree[num1] ++;
			if(lists[num2] == null) {
				lists[num2] = new ArrayList<Integer>();
			}
			lists[num2].add(num1);
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0;i<inDegree.length;i++) {
			if(inDegree[i] == 0) {
				queue.add(i);
			}
		}
		int count = 0;
		while(!queue.isEmpty()) {
			Integer cur = queue.poll();
			count ++;
			List<Integer> list = lists[cur];
			if(list != null) {
				for(int i = 0;i<list.size();i++) {
					inDegree[list.get(i)] --;
					if(inDegree[list.get(i)] == 0) {
						queue.add(list.get(i));
					}
				}
			}
		}
		return count == numCourses;
		
	}

}
