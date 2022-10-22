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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null){
            return head;
        }
        int size = Size(head);
        if(size == 1){
            return null;
        }
        ListNode temp = head;
        for(int i=0;i<size/2-1;i++){
                temp = temp.next;
            }
        if(temp.next!=null && temp.next.next != null){
            temp.next = temp.next.next;
        }else{
            temp.next = null;
        }
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
}