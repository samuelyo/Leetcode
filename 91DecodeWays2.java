package com.leetcode.DecodeWays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DecodeWays2 {

	public static void main(String[] args) {
		
		String s = "123";
		System.out.println(numDecodings(s));

	}
	
	public static int numDecodings(String s) {
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		if(s == null || s.length() == 0){
			return 0;
		}
		if(s.length() == 1){
			if(Integer.valueOf(s) > 0){
				return 1;
			}
			return 0;
		}
		if(s.length() == 2){
			int count = 0;
			if(Integer.valueOf(s.substring(0, 1)) > 0){
				if(Integer.valueOf(s.substring(1, 2)) > 0){
					count ++;
				}
			}
			if(s.charAt(0) != '0' && Integer.valueOf(s) < 27 && Integer.valueOf(s) > 0){
				count ++;
			}
			return count;
		}else{
			if(Integer.valueOf(s.substring(0, 1)) > 0){
				map.put(0, 1);
			}else{
				map.put(0, 0);
			}
			
			int count = 0;
			if(Integer.valueOf(s.substring(0, 1)) > 0 ){
				if(Integer.valueOf(s.substring(1, 2)) > 0){
					count ++;
				}
			}
			if(s.substring(0, 2).charAt(0) != '0' && Integer.valueOf(s.substring(0, 2)) < 27 && Integer.valueOf(s.substring(0, 2)) > 0){
				count ++;
			}
			map.put(1, count);
			
			for(int i = 2;i < s.length();i++){
				int num = 0;
				String cur = s.substring(i - 1,i + 1);
				String c = String.valueOf(s.charAt(i));
				if(cur.charAt(0) != '0' && Integer.valueOf(cur) < 27 && Integer.valueOf(cur) > 0){
					num += map.get(i - 2);
				}
				if(Integer.valueOf(c) > 0){
					num += map.get(i - 1);
				}
				map.put(i, num);
			}
			
			return map.get(s.length() - 1);
		}
		
	}

	
}
