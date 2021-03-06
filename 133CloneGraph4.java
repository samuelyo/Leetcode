package com.leetcode.CloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CloneGraph4 {

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

		UndirectedGraphNode res = cloneGraph(node5);
		List<UndirectedGraphNode> neighbors = res.neighbors;
		for (int i = 0; i < neighbors.size(); i++) {
			System.out.print(neighbors.get(i).label + " ");
		}

	}

	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (node == null)
			return null;

		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		map.put(newNode.label, newNode); // add first node to HashMap
		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		queue.add(node); // add first **original** node to queue
		while (!queue.isEmpty()) { // if more nodes need to be visited
			UndirectedGraphNode n = queue.pop();
			for (UndirectedGraphNode neighbor : n.neighbors) {
				if (!map.containsKey(neighbor.label)) {
					map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
					queue.add(neighbor);
				}
				map.get(n.label).neighbors.add(map.get(neighbor.label));
			}
		}
		return newNode;

	}
}
