package com.leetcode.AccountsMerge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AccountsMerge {

	public static void main(String[] args) {
		
		List<List<String>> accounts = new ArrayList<List<String>>();
		List<String> list1 = new ArrayList<String>();
		list1.add("John");
		list1.add("johnsmith@mail.com");
		list1.add("john00@mail.com");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("John");
		list2.add("johnnybravo@mail.com");
		
		List<String> list3 = new ArrayList<String>();
		list3.add("John");
		list3.add("johnsmith@mail.com");
		list3.add("john_newyork@mail.com");
		
		List<String> list4 = new ArrayList<String>();
		list4.add("Mary");
		list4.add("mary@mail.com");
		
		accounts.add(list1);
		accounts.add(list2);
		accounts.add(list3);
		accounts.add(list4);
		
		List<List<String>> res = accountsMerge(accounts);
		for(int i = 0;i<res.size();i++) {
			List<String> cur = res.get(i);
			for(int j = 0;j<cur.size();j++) {
				System.out.print(cur.get(j) + " ");
			}
			System.out.println();
		}

	}

	static class Node {
		
		String val;
		String username;
		List<Node> neighbours;
		Node(String val, String username) {
			this.val = val;
			this.username = username;
			neighbours = new ArrayList<Node>();
		}
	}
	
	public static List<List<String>> accountsMerge(List<List<String>> accounts) {
		
		List<List<String>> res = new ArrayList<List<String>>();
		Map<String, Node> map = new HashMap<String, Node>();
		
		for(int i = 0;i<accounts.size();i++) {
			List<String> list = accounts.get(i);
			for(int j = 1;j<list.size();j++) {
				String email = list.get(j);
				if(!map.containsKey(email)) {
					Node node = new Node(email, list.get(0));
					map.put(email, node);
				}
				if(j == 1) {
					continue;
				}
				map.get(list.get(j - 1)).neighbours.add(map.get(email));
				map.get(email).neighbours.add(map.get(list.get(j - 1)));
			}
		}
		
		Set<String> visited = new HashSet<String>();
		for(String s : map.keySet()) {
			if(visited.add(s)) {
				List<String> list = new LinkedList<String>();
				list.add(s);
				dfs(map.get(s), visited, list);
				Collections.sort(list);
				list.add(0, map.get(s).username);
				res.add(list);
			}
		}
		return res;
		
	}
	
	public static void dfs(Node root, Set<String> visited, List<String> list) {
		for(Node node : root.neighbours) {
			if(visited.add(node.val)) {
				list.add(node.val);
				dfs(node, visited, list);
			}
		}
	}

}
