/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null){  //important check will find the null pointer exception
            return null;
        }
        // to find size of the linked list if linked list have 5 nodes then size in 5
        int size = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        
        if(n == size){ // if the node to be deleted is given as the size of linked list means it arrives at the head so we directly return the next node of head as the ans.
            return head.next;
        }
        int fromLast = Size(head) - n;  //find the index from last 
        ListNode prev = head;
        for(int i=0;i<fromLast-1;i++){  //reach till prev node of the current node to break the link
            prev = prev.next;
        }
        prev.next = prev.next.next;
        
        
        // ListNode prev = getNode(head,fromLast-1); 
        // if(prev == head){
        //     head = head.next;
        // }
        // prev.next = prev.next.next;
        return head; 
    }
    public int Size(ListNode head){  //function to get the size of the Linked List
        ListNode temp = head;
        int size = 1;
        while(temp.next!=null){
            temp = temp.next;
            size++;
        }
        return size;
    }
     public ListNode getNode(ListNode head, int n){  // function to get the Nth Node of the Linked List
        ListNode temp = head;
        for(int i=0;i<n-1;i++){
            temp = temp.next;
        }
        return temp;
    }
}
   