package com.leetcode.containsduplicateII;

import java.lang.reflect.MalformedParametersException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateII2 {

	public static void main(String[] args){
		
		int[] nums = {1,2,1};
		System.out.println(Boolean.toString(containsNearbyDuplicate(nums, 0)));
	}
	
	public static boolean containsNearbyDuplicate(int[] nums,int k){
		
		List<Num> list = new ArrayList<Num>();
		for(int i = 0;i<nums.length;i++){
			list.add(new Num(nums[i],i));
		}
		Collections.sort(list);
		for(int i = 0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		for(int t = 1;t<list.size();t++){
			if(list.get(t).getNum() == list.get(t-1).getNum() && list.get(t).getIndex()-list.get(t-1).getIndex() <= k){
				return true;
			}
		}
		return false;
	}
}

class Num implements Comparable<Num>{
	private int num;
	private int index;
	
	public Num(int num, int index) {
		super();
		this.num = num;
		this.index = index;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
	@Override
	public int compareTo(Num o) {
		
		return this.num>o.num ? 1:(this.num == o.num?0:-1);
	}
	@Override
	public String toString() {
		return "Num [num=" + num + ", index=" + index + "]";
	}
	
	
}