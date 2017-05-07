package com.leetcode.removelinkedlistelements;

public class RemoveLinkedListElements3 {

	public static void main(String[] arg){
		
		int[] nums = {1,9,9,9,9,9,9,9,1,9,9,9};
		ListNode head = buildList(nums);
		ListNode res = removeElements(head, 1);
		while(null != res){
			System.out.print(res.val + " ");
			res = res.next;
		}
		
		
	}
	public static ListNode removeElements(ListNode head,int val){
		
		/**
		 * It basically goes down to the last null node,
		 * and rebuilds the linked list,
		 * by adding only the nodes which are not equal to val to this null,
		 * so it goes from
			null ;
			[5->null] //when head is 6 it doesnt add anything to head
			[4-->5-->null]
			[3-->4-->5-->-->null]
			[2-->3-->4-->5-->null]
			[1-->2-->3-->4-->5-->null]
		 * 
		 */
		if (head == null)
			return null;
		head.next = removeElements(head.next, val);
		return head.val == val ? head.next : head;
		
	}
	
	public static ListNode buildList(int[] nums){
		ListNode head = null;
		ListNode last = null;
		ListNode newNode = null;
		for(int i = 0;i<nums.length;i++){
			newNode = new ListNode(nums[i]);
			if(head == null){
				head = newNode;
				last = newNode;
			}else{
				last.next = newNode;
				last = newNode;
			}
		}
		return head;
	}
}
