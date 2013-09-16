import java.util.LinkedList;

/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	 */

public class MergeTwoSortedLists {
	 public static class ListNode {
		 int val;
	     ListNode next;
	     ListNode(int x) {
	         val = x;
			 next = null;
		 }
	 }
	 
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode merge_node = new ListNode(0);
    	ListNode temp = merge_node;
    	
    	while(l1 != null && l2 != null){
    		if(l1.val >= l2.val){
    			merge_node = l2;
    			l2 = l2.next;
    		} else {
    			merge_node = l1;
    			l1 = l1.next;
    		}
    		merge_node = merge_node.next;
    	}
    	if(l1 != null) merge_node.next = l1;
    	if(l2 != null) merge_node.next = l2;
    	return temp.next;
    }
    
    public static void main(String[] args){
    	System.out.println(mergeTwoLists(null, null));
    }
}

