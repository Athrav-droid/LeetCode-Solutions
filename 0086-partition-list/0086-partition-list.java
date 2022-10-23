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
    public ListNode partition(ListNode head, int x) {
        //created two new heads and their refernces
        ListNode before_head = new ListNode(0);
        ListNode after_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after = after_head;
        
        if(head == null || head.next == null){ //if head or head's next is equal to null then return head.
            return head;
        }
        while(head!=null){ //while head is not null check if head's value is less than x . if so then put before next on head and move before ahead else put after's next on head and move after ahead.
            if(head.val<x){
                before.next = head;
                before = before.next;
            }else{
                after.next = head;
                after = after.next;
            }
            head = head.next; //after moving before or after move head ahead for the next value
        }
        after.next = null;  //since after's last node must point to null else it will give error of presenting cycle in LL
        before.next = after_head.next; // join both the before and after list.
        return before_head.next;
    }
}