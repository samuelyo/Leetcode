package com.leetcode.CourseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

	public static void main(String[] args) {
		
		int numCourses = 4;
		
		int[][] prerequisites = new int[0][0];
		
//		int[][] prerequisites = new int[4][2];
//		prerequisites[0][0] = 1;
//		prerequisites[0][1] = 0;
//		prerequisites[1][0] = 2;
//		prerequisites[1][1] = 1;
//		prerequisites[2][0] = 3;
//		prerequisites[2][1] = 2;
//		prerequisites[3][0] = 1;
//		prerequisites[3][1] = 3;
		
		System.out.println(canFinish(numCourses, prerequisites));
	}
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		
		int count = 0;
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
			count ++;
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
		if(count != numCourses){
			return false;
		}else{
			return true;
		}
		
	}
	
}
