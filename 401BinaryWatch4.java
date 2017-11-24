package com.leetcode.BinaryWatch;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch4 {

	public static void main(String[] args) {
		
		int num = 2;
		List<String> res = readBinaryWatch(num);
		for(int i = 0;i<res.size();i++) {
			System.out.print(res.get(i) + " ");
		}
 
	}
	
	public static List<String> readBinaryWatch(int num) {
		
		List<String> res = new ArrayList<String>();
		for(int hour = 0;hour<12;hour++) {
			for(int min = 0;min<60;min++) {
				if(Integer.bitCount(hour) + Integer.bitCount(min) == num) {
					StringBuilder sb = new StringBuilder();
					sb.append(hour);
					sb.append(":");
					if(min < 10) {
						sb.append("0");
					}
					sb.append(min);
					res.add(sb.toString());
				}
			}
		}
		return res;
		
	}

}
