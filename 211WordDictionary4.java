package com.leetcode.AddAndSearchWordDataStructureDesign;

public class WordDictionary4 {

	class TrieNode {
		
		public TrieNode[] children;
		public boolean isWord;
		TrieNode() {
			children = new TrieNode[26];
			isWord = false;
		}
		
	}
	
	public TrieNode root;
	
	/** Initialize your data structure here. */
    public WordDictionary4() {
        
    	root = new TrieNode();
    	
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        
    	TrieNode cur = root;
    	for(int i = 0;i<word.length();i++) {
    		char c = word.charAt(i);
    		if(cur.children[c - 'a'] == null) {
    			cur.children[c - 'a'] = new TrieNode();
    		}
    		cur = cur.children[c - 'a'];
    	}
    	cur.isWord = true;
    	
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        
    	return searchHelp(word, 0, root);
    }
    
    public boolean searchHelp(String word, int index, TrieNode node) {
    	
    	if(index == word.length()) {
    		return node.isWord;
    	}
    	char c = word.charAt(index);
    	if(c != '.') {
    		return node.children[c - 'a'] != null && searchHelp(word, index + 1, node.children[c - 'a']);
    	}else {
    		for(int i = 0;i<26;i++) {
    			if(node.children[i] != null) {
    				if(searchHelp(word, index + 1, node.children[i])) {
    					return true;
    				}
     			}
    		}
    		return false;
    	}
    	
    }
    
}
