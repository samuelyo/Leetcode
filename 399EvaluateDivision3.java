package com.leetcode.EvaluateDivision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision3 {

	public static void main(String[] args) {
		
		String[][] equations = {{"a", "b"}, {"b", "c"}};
		double[] values = {2.0, 3.0};
		String[][] queries = {{"a", "c"}, {"b", "a"}, {"a", "e"}, {"a", "a"}, {"x", "x"} };
		double[] res = calcEquation(equations, values, queries);
		for(int i = 0;i<res.length;i++) {
			System.out.print(res[i] + " ");
		}

	}
	
	public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		Map<String, List<Double>> value = new HashMap<String, List<Double>>();
		
		for(int i = 0;i<equations.length;i++) {
			String[] cur = equations[i];
			double v = values[i];
			if(!map.containsKey(cur[0])) {
				map.put(cur[0], new ArrayList<String>());
				value.put(cur[0], new ArrayList<Double>());
			}
			if(!map.containsKey(cur[1])) {
				map.put(cur[1], new ArrayList<String>());
				value.put(cur[1], new ArrayList<Double>());
			}
			map.get(cur[0]).add(cur[1]);
			value.get(cur[0]).add(v);
			map.get(cur[1]).add(cur[0]);
			value.get(cur[1]).add(1.0 / v);
		}
		
		double[] res = new double[queries.length];
		for(int i = 0;i<queries.length;i++) {
			String[] cur = queries[i];
			double temp = calcEquationHelp(map, value, cur[0], cur[1], 1.0, new HashSet<String>());
			res[i] = temp == 0.0 ? -1.0 : temp;
		}
		return res;
		
	}

	public static double calcEquationHelp(Map<String, List<String>> map, Map<String, List<Double>> value, String s1, String s2, Double res, Set<String> visited) {
		
		if(map.get(s1) == null || map.get(s2) == null) {
			return 0.0;
		}
		if(s1.equals(s2)) {
			return res;
		}
		List<String> next = map.get(s1);
		List<Double> val = value.get(s1);
		visited.add(s1);
		for(int i = 0;i<next.size();i++) {
			if(!visited.contains(next.get(i))) {
				double temp = calcEquationHelp(map, value, next.get(i), s2, res * val.get(i), visited);
				if(temp != 0.0) {
					return temp;
				}
			}		
		}
		visited.remove(s1);
		return 0.0;
		
	}
}
