package com.leetcode.RemoveInvalidParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses3 {

	public static void main(String[] args) {

		String s = "";
		List<String> res = removeInvalidParentheses(s);
		for (int i = 0; i < res.size(); i++) {
			System.out.println(res.get(i));
		}

	}

	public static List<String> removeInvalidParentheses(String s) {

		List<String> res = new ArrayList<String>();
		if(s == null){
			return res;
		}
		Set<String> visited = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		
		queue.add(s);
		visited.add(s);
		boolean hasValid = false;
		
		while(!queue.isEmpty()){
			String cur = queue.poll();
			if(!isValid(cur)){
				if(!hasValid){
					for(int i = 0;i<cur.length();i++){
						if(cur.charAt(i) == '(' || cur.charAt(i) == ')'){
							if(!visited.contains(cur.substring(0, i) + cur.substring(i + 1))) {
								queue.add(cur.substring(0, i) + cur.substring(i + 1));
								visited.add(cur.substring(0, i) + cur.substring(i + 1));
							}
						}
					}
					visited.add(cur);
				}
				
			}else{
				
				res.add(cur);
				visited.add(cur);
				hasValid = true;
				
			}
		}
		return res;
		
		
	}
	
	public static boolean isValid(String s) {
		
		int count = 0;
		int index = 0;
		while(index < s.length()){
			if(s.charAt(index) == '('){
				count ++;
			}
			if(s.charAt(index) == ')'){
				if(count == 0){
					return false;
				}
				count --;
			}
			index ++;
		}
		return count == 0;
		
	}

}
