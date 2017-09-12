package com.leetcode.SmallestRange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Element {
	
	int value;
	int kind;
	int index;
	
	Element(int v, int k, int i) {
		value = v;
		kind = k;
		index = i;
	}
	
}
public class SmallestRange2 {

	public static void main(String[] args) {
		
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		
		List<Integer> list1 = new ArrayList<Integer>();
		list1.add(4);
		list1.add(10);
		list1.add(15);
		list1.add(24);
		list1.add(26);
		lists.add(list1);
		
		List<Integer> list2 = new ArrayList<Integer>();
		list2.add(0);
		list2.add(9);
		list2.add(12);
		list2.add(20);
		lists.add(list2);
		
		List<Integer> list3 = new ArrayList<Integer>();
		list3.add(5);
		list3.add(18);
		list3.add(22);
		list3.add(30);
		lists.add(list3);
		
		int[] res = smallestRange(lists);
		System.out.println(res[0] + " " + res[1]);
		

	}

	 public static int[] smallestRange(List<List<Integer>> nums) {
		 
		 int[] res = { 0, Integer.MAX_VALUE };
		 PriorityQueue<Element> queue = new PriorityQueue<Element>(new Comparator<Element>() {

			@Override
			public int compare(Element o1, Element o2) {
				return o1.value - o2.value;
			}
		});
		 
		 int min = Integer.MAX_VALUE;
		 int max = Integer.MIN_VALUE;
		 
		 for(int i = 0;i<nums.size();i++){
			 queue.add(new Element(nums.get(i).get(0), i, 0));
			 min = Math.min(min, nums.get(i).get(0));
			 max = Math.max(max, nums.get(i).get(0));
		 }
		 res[0] = min;
		 res[1] = max;
		 
		 while(queue.size() == nums.size()){
			 
			 int oldmin = min;
			 Element cur = queue.poll();
			 int kind = cur.kind;
			 int index = cur.index;
			 if(index + 1 < nums.get(kind).size()){
				 queue.add(new Element(nums.get(kind).get(index + 1), kind, index + 1));
				 max = Math.max(max, nums.get(kind).get(index + 1));
				 min = queue.peek().value;
				 if(max - min < res[1] - res[0] || (max - min == res[1] - res[0] && min < oldmin)) {
					 res[0] = min;
					 res[1] = max;
				 }
			 }
		 }
		 return res;
	 }
}
