package com.leetcode.UglyNumberII;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class UglyNumberII5 {

	public static void main(String[] args) {
		
		int n = 1600;
		System.out.println(nthUglyNumber(n));

	}
	
	public static int nthUglyNumber(int n) {
		
		if(n <= 0) {
			return 0;
		}
		Deque<Integer> queue2 = new LinkedList<Integer>();
		Deque<Integer> queue3 = new LinkedList<Integer>();
		Deque<Integer> queue5 = new LinkedList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		int pre = 1;
		set.add(pre);
		while(set.size() < n) {
			queue2.add(2 * pre);
			queue3.add(3 * pre);
			queue5.add(5 * pre);
			int cur;
			do {
				int num2 = queue2.peek();
				int num3 = queue3.peek();
				int num5 = queue5.peek();
				cur = Math.min(Math.min(num2, num3), num5);
				if(cur == num2) {
					queue2.poll();
				}else if(cur == num3) {
					queue3.poll();
				}else {
					queue5.poll();
				}
			}while(set.contains(cur));
			set.add(cur);
			pre = cur;
		}
		return pre;
		
	}

}
