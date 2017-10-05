package com.leetcode.CourseScheduleIII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CourseScheduleIII {
	
	static class Course {
		
		int dur;
		int end;
		Course(int d, int e) {
			dur = d;
			end = e;
		}
		
	}

	public static void main(String[] args) {
		
		int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
		System.out.println(scheduleCourse(courses));
		
	}
	
	public static int scheduleCourse(int[][] courses) {
		
		List<Course> list = new ArrayList<Course>();
		for(int i = 0;i<courses.length;i++) {
			list.add(new Course(courses[i][0], courses[i][1]));
		}
		Collections.sort(list, new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				if(o1.end == o2.end) {
					return o1.dur - o2.dur;
				}else{
					return o1.end - o2.end;
				}
				
			}
		});
		
		PriorityQueue<Course> queue = new PriorityQueue<Course>(new Comparator<Course>() {

			@Override
			public int compare(Course o1, Course o2) {
				
				return o2.dur - o1.dur;
			}
		});
		
		int cur = 0;
		for(int i = 0;i<list.size();i++) {
			cur += list.get(i).dur;
			queue.add(list.get(i));
			if(cur > list.get(i).end) {
				Course c = queue.poll();
				cur -= c.dur;
			}
		}
		return queue.size();
		
	}

}
