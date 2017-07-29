package com.leetcode.ReconstructItinerary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary2 {

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
		for (int i = 0; i < res.size(); i++) {
			System.out.print(res.get(i) + " ");
		}

	}

	public static Map<String, PriorityQueue<String>> targets = new HashMap<String, PriorityQueue<String>>();
	public static List<String> route = new LinkedList<String>();

	public static List<String> findItinerary(String[][] tickets) {

		for (String[] ticket : tickets)
			targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
		visit("JFK");
		return route;

	}

	public static void visit(String airport) {
		while (targets.containsKey(airport) && !targets.get(airport).isEmpty())
			visit(targets.get(airport).poll());
		route.add(0, airport);
	}

}
