package com.leetcode.BulbSwitcherII;

import java.util.HashSet;
import java.util.Set;

public class BulbSwitcherII {

	public static void main(String[] args) {
		
		int n = 4;
		int m = 4;
		System.out.println(flipLights(n, m));

	}

	public static int flipLights(int n, int m) {
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0;i<n;i++){
			sb.append("1");
		}
		
		Set<String> set = new HashSet<String>();
		set.add(sb.toString());
		int times = 1;
		while(times <= m){
			
			Set<String> newSet = new HashSet<String>();
			for (String cur : set) {
				newSet.add(action1(new StringBuilder(cur)).toString());
				newSet.add(action2(new StringBuilder(cur)).toString());
				newSet.add(action3(new StringBuilder(cur)).toString());
				newSet.add(action4(new StringBuilder(cur)).toString());
			}
			set = newSet;
			times++;
		}
		return set.size();
		
	}
	
	public static StringBuilder action1(StringBuilder lights){
		
		for(int i = 0;i<lights.length();i++){
			if(lights.charAt(i) == '0'){
				lights.setCharAt(i, '1');
			}else{
				lights.setCharAt(i, '0');
			}
		}
		return lights;
		
	}
	
	public static StringBuilder action2(StringBuilder lights){
		
		for(int i = 0;i<lights.length();i++){
			if(i % 2 == 0){
				if(lights.charAt(i) == '0'){
					lights.setCharAt(i, '1');
				}else{
					lights.setCharAt(i, '0');
				}
			}
		}
		return lights;
		
	}
	
	public static StringBuilder action3(StringBuilder lights){
		
		for(int i = 0;i<lights.length();i++){
			if(i % 2 == 1){
				if(lights.charAt(i) == '0'){
					lights.setCharAt(i, '1');
				}else{
					lights.setCharAt(i, '0');
				}
			}
		}
		return lights;
		
	}
	
	public static StringBuilder action4(StringBuilder lights){
		
		for(int i = 0;i<lights.length();i++){
			if(i % 3 == 0){
				if(lights.charAt(i) == '0'){
					lights.setCharAt(i, '1');
				}else{
					lights.setCharAt(i, '0');
				}
			}
		}
		return lights;
		
	}
}
