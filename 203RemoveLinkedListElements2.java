package com.leetcode.removelinkedlistelements;

public class RemoveLinkedListElements2 {

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
		
		ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode curr = head, prev = fakeHead;
        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return fakeHead.next;
		
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
