package com.leetcode.SerializeAndDeserializeBST;

import java.util.ArrayList;
import java.util.List;

public class Codec4 {

	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
    	if(root == null) {
    		return "null,";
    	}
    	return root.val + "," + serialize(root.left) + serialize(root.right);
    	
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
    	String[] strs = data.split(",");
    	List<String> list = new ArrayList<String>();
    	for(String str : strs) {
    		list.add(str);
    	}
    	return deserializeHelp(list);
    	
    	
    }
    
    public TreeNode deserializeHelp(List<String> list) {
    	
    	if(list.size() == 0) {
    		return null;
    	}else if(list.get(0).equals("null")) {
    		list.remove(0);
    		return null;
    	}else {
    		TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
    		list.remove(0);
    		root.left = deserializeHelp(list);
    		root.right = deserializeHelp(list);
    		return root;
    	}
    }
    
}
