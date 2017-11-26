package com.leetcode.ThirdMaximumNumber;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class ThirdMax3 {

	public static void main(String[] args) {
		
		int[] nums = {-2147483648,1,1};
		int res = thirdMax(nums);
		System.out.println(res);

	}
	
	public static int thirdMax(int[] nums) {
		
		TreeSet<Integer> set = new TreeSet<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if((long)o2 - (long)o1 > 0) {
					return 1;
				}else if((long)o2 - (long)o1 < 0) {
					return -1;
				}else {
					return 0;
				}
			}
			
		});
		for(int i = 0;i<nums.length;i++) {
			set.add(nums[i]);
		}
		if(set.size() < 3) {
			return set.first();
		}
		Iterator<Integer> it = set.iterator();
		int count = 0;
		int pre = 0;
		while(it.hasNext()) {
			if(count == 3) {
				break;
			}
			int cur = (int) it.next();
			count ++;
			pre = cur;
		}
		return pre;
		
	}

}
