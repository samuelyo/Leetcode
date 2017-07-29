package com.leetcode.ReconstructItinerary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ReconstructItinerary3 {

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

	public static List<String> findItinerary(String[][] tickets) {

		Map<String, PriorityQueue<String>> targets = new HashMap<String, PriorityQueue<String>>();
	    for (String[] ticket : tickets)
	        targets.computeIfAbsent(ticket[0], k -> new PriorityQueue()).add(ticket[1]);
	    List<String> route = new LinkedList<String>();
	    Stack<String> stack = new Stack<String>();
	    stack.push("JFK");
	    while (!stack.empty()) {
	        while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
	            stack.push(targets.get(stack.peek()).poll());
	        route.add(0, stack.pop());
	    }
	    return route;

	}

}
