package com.leetcode.ReconstructItinerary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary4 {

	public static void main(String[] args) {
		
		String[][] tickets = new String[5][2];
		tickets[0][0] = "JFK";
		tickets[0][1] = "SFO";
		tickets[1][0] = "JFK";
		tickets[1][1] = "ATL";
		tickets[2][0] = "SFO";
		tickets[2][1] = "ATL";
		tickets[3][0] = "ATL";
		tickets[3][1] = "JFK";
		tickets[4][0] = "ATL";
		tickets[4][1] = "SFO";
		
		List<String> res = findItinerary(tickets);
		for(int i = 0;i<res.size();i++){
			System.out.print(res.get(i) + " ");
		}

	}

	public static List<String> findItinerary(String[][] tickets) {
		
		List<String> list = new ArrayList<String>();
		if(tickets == null || tickets.length == 0 || tickets[0].length == 0) {
			return list;
		}
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(int i = 0;i<tickets.length;i++) {
			String[] ticket = tickets[i];
			String start = ticket[0];
			String end = ticket[1];
			List<String> temp;
			if(map.containsKey(start)) {
				temp = map.get(start);
			}else {
				temp = new ArrayList<String>();
			}
			temp.add(end);
			Collections.sort(temp);
			map.put(start, temp);
		}
		int size = tickets.length;
		List<List<String>> res = new ArrayList<List<String>>();
		list.add("JFK");
		findItineraryHelp(map, res, list, size);
		return res.get(0);
		
	}
	
	public static void findItineraryHelp(Map<String, List<String>> map, List<List<String>> res, List<String> list, int size) {
		
		if(res.size() > 1) {
			return;
		}
		if(list.size() == size + 1) {
			res.add(new ArrayList<String>(list));
			return;
		}
		String pre = list.get(list.size() - 1);
		List<String> des = map.get(pre);
		if(des != null) {
			for(int i = 0;i<des.size();i++) {
				String cur = des.get(i);
				if(cur != null) {
					list.add(cur);
					des.set(i, null);
					findItineraryHelp(map, res, list, size);
					des.set(i, cur);
					list.remove(list.size() - 1);
				}
			}
		}
		
	}
}
