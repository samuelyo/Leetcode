package com.leetcode.RelativeRanks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person{
	
	int score;
	int index;
	String medal;
	
	Person(int s, int i) {
		score = s;
		index = i;
	}
	
}
public class RelativeRanks {

	public static void main(String[] args) {
		
		int[] nums = {5,4,3,2,1};
		String[] res = findRelativeRanks(nums);
		for(int i = 0;i<res.length;i++){
			System.out.print(res[i] + " ");
		}
		
	}

	public static String[] findRelativeRanks(int[] nums) {
		
		List<Person> list = new ArrayList<Person>();
		for(int i = 0;i<nums.length;i++){
			list.add(new Person(nums[i], i));
		}
		Collections.sort(list, new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				
				return p2.score - p1.score;
			}
		});
		String[] res = new String[list.size()];
		for(int i = 0;i<list.size();i++){
			if(i == 0){
				res[list.get(i).index] = "Gold Medal";
			}else if(i == 1){
				res[list.get(i).index] = "Silver Medal";
			}else if(i == 2){
				res[list.get(i).index] = "Bronze Medal";
			}else{
				res[list.get(i).index] = i + 1 + "";
			}
		}
		return res;
		
	}
}
