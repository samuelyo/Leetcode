package com.leetcode.BinaryWatch;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch5 {

	public static void main(String[] args) {
		
		int num = 1;
		List<String> res = readBinaryWatch(num);
		for(int i = 0;i<res.size();i++) {
			System.out.print(res.get(i) + " ");
		}
 
	}
	
	public static List<String> readBinaryWatch(int num) {
		
		List<String> res = new ArrayList<String>();
		int[] nums = {1,2,4,8,16,32};
		for(int hour = 0;hour<=num;hour++) {
			int min = num - hour;
			List<Integer> hours = new ArrayList<Integer>();
			readBinaryWatchHelp(nums, hour, hours, 0, 0);
			List<Integer> mins = new ArrayList<Integer>();
			readBinaryWatchHelp(nums, min, mins, 0, 0);
			for(int i = 0;i<hours.size();i++) {
				for(int j = 0;j<mins.size();j++) {
					if(hours.get(i) >= 12) {
						continue;
					}
					if(mins.get(j) >= 60) {
						continue;
					}
					StringBuilder sb = new StringBuilder();
					sb.append(hours.get(i));
					sb.append(":");
					if(mins.get(j) < 10) {
						sb.append("0");
					}
					sb.append(mins.get(j));
					res.add(sb.toString());
				}
			}
		}
		return res;
		
	}
	
	public static void readBinaryWatchHelp(int[] nums, int hour, List<Integer> res, int sum, int pos) {
		
		if(hour == 0) {
			res.add(sum);
			return;
		}
		for(int i = pos;i<nums.length;i++) {
			readBinaryWatchHelp(nums, hour - 1, res, sum + nums[i], i + 1);
		}
		
	}

}
