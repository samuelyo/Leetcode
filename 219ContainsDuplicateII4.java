package com.leetcode.ContainsDuplicateII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContainsDuplicateII4 {

	static class Num {
		int value;
		int index;
		Num(int v, int i) {
			value = v;
			index = i;
		}
	}
	
	public static void main(String[] args) {
		
		int[] nums = {2,3,4,5,6,7,8,2};
		int k = 6;
		boolean res = containsNearbyDuplicate(nums, k);
		System.out.println(res);

	}

	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		
		List<Num> list = new ArrayList<Num>();
		for(int i = 0;i<nums.length;i++) {
			list.add(new Num(nums[i], i));
		}
		Collections.sort(list, new Comparator<Num>() {

			@Override
			public int compare(Num o1, Num o2) {
				if(o1.value != o2.value) {
					return o1.value - o2.value;
				}else {
					return o1.index - o2.index;
				}
			}
			
		});
		for(int i = 1;i<list.size();i++) {
			if(list.get(i).value == list.get(i - 1).value && list.get(i).index - list.get(i - 1).index <= k) {
				return true;
			}
		}
		return false;
	}
}
