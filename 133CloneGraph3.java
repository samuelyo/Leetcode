package com.leetcode.CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph3 {

	public static void main(String[] args) {
		
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		UndirectedGraphNode node3 = new UndirectedGraphNode(3);
		UndirectedGraphNode node4 = new UndirectedGraphNode(4);
		UndirectedGraphNode node5 = new UndirectedGraphNode(5);
		
		node0.neighbors.add(node1);
		node0.neighbors.add(node5);
		node1.neighbors.add(node2);
		node1.neighbors.add(node5);
		node2.neighbors.add(node3);
		node3.neighbors.add(node4);
		node3.neighbors.add(node4);
		node4.neighbors.add(node5);
		node4.neighbors.add(node5);
		
		UndirectedGraphNode res = cloneGraph(node0);
		List<UndirectedGraphNode> neighbors = res.neighbors;
		for(int i = 0;i<neighbors.size();i++){
			System.out.print(neighbors.get(i).label + " ");
		}

	}
	
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		
		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		return cloneGraphHelp(node, map);
		
	}
	
	public static UndirectedGraphNode cloneGraphHelp(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
		
		if(node == null) {
			return null;
		}
		UndirectedGraphNode res = new UndirectedGraphNode(node.label);
		res.neighbors = new ArrayList<UndirectedGraphNode>();
		map.put(res.label, res);
		for(UndirectedGraphNode n : node.neighbors) {
			UndirectedGraphNode temp ;
			if(map.containsKey(n.label)) {
				temp = map.get(n.label);
			}else {
				temp = cloneGraphHelp(n, map);
			}
			res.neighbors.add(temp);
		}
		return res;
		
	}

}
