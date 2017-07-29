package com.leetcode.CloneGraph;

import java.util.HashMap;
import java.util.List;

public class CloneGraph2 {

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
		for(int i = 0;i<neighbors.size();i++){
			System.out.print(neighbors.get(i).label + " ");
		}

	}

	public static HashMap<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
    
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }

    public static UndirectedGraphNode clone(UndirectedGraphNode node) {
        if (node == null) return null;
        
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label, clone);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        return clone;
    }
		
}
