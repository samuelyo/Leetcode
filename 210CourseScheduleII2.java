package com.leetcode.CourseScheduleII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII2 {

	public static void main(String[] args) {
		
		int numCourses = 2;
		
		int[][] prerequisites = new int[2][2];
		
		prerequisites[0][0] = 1;
		prerequisites[0][1] = 0;
		prerequisites[1][0] = 0;
		prerequisites[0][1] = 1;
		
		int[] res = findOrder(numCourses, prerequisites);
		
		for(int i = 0;i<res.length;i++){
			System.out.print(res[i] + " ");
		}

	}

	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		
		int[] res = null ;
		List<Integer> resList = new ArrayList<Integer>();
		int m = prerequisites.length;
		List<Integer>[] list = new List[numCourses];
		int[] inNum = new int[numCourses];
		for(int i = 0;i<m;i++){
			int cur = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if(list[pre] == null){
				list[pre] = new ArrayList<Integer>();
			}
			list[pre].add(cur);
			inNum[cur] ++;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 0;i<numCourses;i++){
			if(inNum[i] == 0){
				queue.add(i);
			}
		}
		while(!queue.isEmpty()){
			Integer cur = queue.poll();
			resList.add(cur);
			List<Integer> next = list[cur];
			if(next != null){
				for(int i = 0;i<next.size();i++){
					inNum[next.get(i)] --;
					if(inNum[next.get(i)] == 0){
						queue.add(next.get(i));
					}
				}
			}
			
		}
		if(resList.size() == numCourses){
			res = new int[numCourses];
			for(int i = 0;i<numCourses;i++){
				res[i] = resList.get(i);
			}
			return res;
		}else{
			return new int[0];
		}
	}
}
