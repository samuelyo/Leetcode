package com.leetcode.SimplifyPath;

import java.util.Deque;
import java.util.LinkedList;

public class SimplifyPath3 {

	public static void main(String[] args) {
		
		String path = "/../";
		System.out.println(simplifyPath(path));

	}
	
	 public static String simplifyPath(String path) {
		 
		 String[] split = path.split("/");
		 Deque<String> queue = new LinkedList<String>();
		 for(String s : split) {
			 if(s.equals("") || s.equals(".")) {
				 continue;
			 }else if(s.equals("..")) {
				 if(queue.size() >= 1) {
					 queue.removeLast();
				 }
			 }else {
				 queue.offerLast(s);
			 }
		 }
		 StringBuilder res = new StringBuilder("/");
		 if(queue.size() == 0) {
			 return res.toString();
		 }
		 while(queue.size() != 0) {
			 String cur = queue.removeFirst();
			 res.append(cur + "/");
		 }
		 return res.toString().substring(0, res.length() - 1);
		 
	 }

}
