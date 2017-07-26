package com.leetcode.SerializeAndDeserializeBST;

public class Codec {

	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
    	StringBuilder res = new StringBuilder();
    	res = serializeHelp(root, res, 0);
    	return res.toString();
    	
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        
    	TreeNode res = null;
    	if(data == null || data.equals("")){
    		return res;
    	}
    	int min = Integer.MAX_VALUE;
    	int root = 0;
    	int end = 0;
    	for(int i = 0;i<data.length();i++){
    		if(data.charAt(i) == '['){
    			int index = i+1;
    			while(index < data.length() && data.charAt(index) != ']'){
    				index ++;
    			}
    			String cur = data.substring(i + 1, index);
    			if(Integer.valueOf(cur) < min){
    				min = Integer.valueOf(cur);
    				root = i;
    				end = index;
    			}
    			i = index;
    		}
    	}
    	int index = root;
    	while(index >= 0 && data.charAt(index) != ']'){
    		index --;
    	}
    	String value = data.substring(index + 1, root);
    	res = new TreeNode(Integer.valueOf(value));
    	if(index > -1){
    		res.left = deserialize(data.substring(0,index + 1));
    	}
    	res.right = deserialize(data.substring(end + 1));
    	return res;
    	
    }
    
    public StringBuilder serializeHelp(TreeNode node, StringBuilder sb, int level) {
    	
    	if(node == null){
    		return sb;
    	}
    	sb = serializeHelp(node.left, sb, level + 1);
    	sb.append(node.val).append("[").append(level).append("]");
    	sb = serializeHelp(node.right, sb, level + 1);
    	return sb;
    	
    }
    
}
