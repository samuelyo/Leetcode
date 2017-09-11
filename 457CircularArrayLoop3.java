package com.leetcode.CircularArrayLoop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CircularArrayLoop3 {

	public static void main(String[] args) {
		
		int[] nums = {2, -1, 1, 2, 2};
		System.out.println(circularArrayLoop(nums));

	}
	
	public static boolean circularArrayLoop(int[] nums) {
		
		Map<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i = 0;i<nums.length;i++){
			List<Integer> list ;
			int next ;
			if(i + nums[i] >= nums.length){
				next = (i + nums[i]) % nums.length;
			}else if(i + nums[i] < 0){
				next = i + nums[i] + nums.length;
			}else{
				next = i + nums[i];
			}
			if(map.containsKey(next)){
				list = map.get(next);
			}else{
				list = new ArrayList<Integer>();
			}
			list.add(i);
			map.put(next, list);
		}
		Queue<Integer> zero = new LinkedList<Integer>();
		for(int i = 0;i<nums.length;i++){
			if(!map.containsKey(i)){
				zero.add(i);
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		while(zero.size() != 0){
			Integer index = zero.poll();
			res.add(index);
			for(Integer key : map.keySet()){
				List<Integer> temp = map.get(key);
				if(temp.contains(index)){
					temp.remove(index);
					if(temp.size() == 0){
						zero.add(key);
					}
					map.put(key, temp);
				}
			}
		}
		if(nums.length - res.size() <= 2){
			return false;
		}else{
			List<Integer> list = new ArrayList<Integer>();
			for(Integer key : map.keySet()){
				if(map.get(key).size() != 0){
					list.add(map.get(key).get(0));
				}
			}
			List<Integer> temp = new ArrayList<Integer>();
			int j = list.get(0);
			while(temp.size() < list.size()){
				temp.add(map.get(j).get(0));
				j = temp.get(temp.size() - 1);
			}
			Collections.reverse(temp);
			int mul = nums[temp.get(0)];
			int begin = mul;
			for(int i = 1;i<temp.size();i++){
				mul *= nums[temp.get(i)];
				if(mul * begin < 0){
					return false;
				}
			}
			return true;
		}
		
		
	}

}
