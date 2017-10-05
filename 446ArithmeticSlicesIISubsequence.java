package com.leetcode.ArithmeticSlicesIISubsequence;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArithmeticSlicesIISubsequence {

	public static void main(String[] args) {
		
		int[] A = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(numberOfArithmeticSlices(A));

	}
	
	public static int numberOfArithmeticSlices(int[] A) {
		
		if(A == null || A.length <= 2) {
			return 0;
		}
		int len = A.length;
		Map<Long, List<List<Integer>>>[] maps = new Map[len];
		for(int i = 0;i<len;i++) {
			maps[i] = new HashMap<Long, List<List<Integer>>>();
		}
		for(int j = 0;j<len-1;j++) {
			for(int i = j+1;i<len;i++) {
				List<Integer> list = new ArrayList<Integer>();
				list.add(A[j]);
				list.add(A[i]);
				List<List<Integer>> t;
				if(maps[i].containsKey(((long)A[i] - (long)A[j]))) {
					t = maps[i].get(((long)A[i] - (long)A[j]));
				}else{
					t = new ArrayList<List<Integer>>();
				}
				t.add(list);
				maps[i].put( ((long)A[i] - (long)A[j]), t);
			}
		}
		
		for(int i = 1;i<len;i++) {
			for(int j = 1;j<i;j++) {
				Map<Long, List<List<Integer>>> map = maps[j];
				if(map.containsKey(((long)A[i] - (long)A[j]))) {
					List<List<Integer>> temp = map.get(((long)A[i] - (long)A[j]));
					for(int k = 0;k<temp.size();k++) {
						List<Integer> curr = new ArrayList<Integer>(temp.get(k));
						curr.add(A[i]);
						List<List<Integer>> c;
						if(maps[i].containsKey(((long)A[i] - (long)A[j]))) {
							c = maps[i].get(((long)A[i] - (long)A[j]));
						}else{
							c = new ArrayList<List<Integer>>();
						}
						c.add(curr);
						maps[i].put((long)A[i] - (long)(A[j]), c);
					}
				}
			}
		}
		int count = 0;
		for(int i = 0;i<len;i++) {
			Map<Long, List<List<Integer>>> map = maps[i];
			for(Long key : map.keySet()) {
				List<List<Integer>> lists = map.get(key);
				for(int j = 0;j<lists.size();j++) {
					if(lists.get(j).size() >= 3) {
						count ++;
					}
				}
			}
		}
		return count;
	}

}
