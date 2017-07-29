package com.leetcode.ReconstructItinerary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {

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

	public static List<String> res ;
	
	public static List<String> findItinerary(String[][] tickets) {
		
		if(tickets == null || tickets.length == 0 || tickets[0].length == 0){
			return res;
		}
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		for(int i = 0;i<tickets.length;i++){
			String start = tickets[i][0];
			String end = tickets[i][1];
			List<String> list;
			if(map.containsKey(start)){
				list = map.get(start);
			}else{
				list = new ArrayList<String>();
			}
			list.add(end);
			Collections.sort(list, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					int index = 0;
					while(index < o1.length() && index < o2.length() && o1.charAt(index) == o2.charAt(index)){
						index ++;
					}
					if(index >= o1.length()){
						return o1.charAt(index - 1) - o2.charAt(index - 1);
					}
					return o1.charAt(index) - o2.charAt(index);
				}
			});
			map.put(start, list);
		}
		
		List<String> list = new ArrayList<String>();
		int num = tickets.length;
		findItineraryHelp(map, list, num);
		return res;
		
	}
	
	public static void findItineraryHelp(Map<String,List<String>> map,List<String> list, int num) {
		
		if(res != null){
			return;
		}
		if(list.size() == num + 1){
			res = new ArrayList<String>(list);
			return;
		}
		if(list.size() == 0){
			list.add("JFK");
		}
		String last = list.get(list.size() - 1);
		List<String> des = map.get(last);
		if(des == null){
			return;
		}
		for(int i = 0;i<des.size();i++){
			String cur = des.get(i);
			if(cur != null){
				list.add(cur);
				des.set(i, null);
			}else{
				continue;
			}
			findItineraryHelp(map, list, num);
			list.remove(list.size() - 1);
			des.set(i, cur);
		}
		
	}
}
