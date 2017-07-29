package com.leetcode.CloneGraph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CloneGraph {

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

	public static Set<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
	
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		
		if(node == null){
			return null;
		}
		
		for(UndirectedGraphNode cur : set){
			if(cur.label == node.label){
				return cur;
			}
		}
		
		UndirectedGraphNode copyNode = new UndirectedGraphNode(node.label);
		
		List<UndirectedGraphNode> neighbors = node.neighbors;
		for(int i = 0;i<neighbors.size();i++){
			if(neighbors.get(i) != node){
				copyNode.neighbors.add(cloneGraph(neighbors.get(i)));
			}else{
				copyNode.neighbors.add(copyNode);
			}
			
		}
		set.add(copyNode);
		return copyNode;
		
	}
}
