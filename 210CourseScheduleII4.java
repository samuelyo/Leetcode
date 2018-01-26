package com.leetcode.CourseScheduleII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII4 {

	public static void main(String[] args) {

		int numCourses = 2;

		int[][] prerequisites = new int[2][2];

		prerequisites[0][0] = 1;
		prerequisites[0][1] = 0;
		prerequisites[1][0] = 0;
		prerequisites[0][1] = 1;

		int[] res = findOrder(numCourses, prerequisites);

		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}

	}
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
	
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
		List<Integer> res = new ArrayList<Integer>();
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
			res.add(cur);
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
		if(count == numCourses) {
			int[] ans = new int[res.size()];
			for(int i = 0;i<res.size();i++) {
				ans[i] = res.get(i);
			}
			return ans;
		}else {
			return new int[0];
		}
		
	}

}
