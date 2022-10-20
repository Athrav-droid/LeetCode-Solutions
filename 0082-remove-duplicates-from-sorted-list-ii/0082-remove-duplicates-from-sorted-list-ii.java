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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = new ListNode(); // Temprory List for ans
        ListNode curr = head;  // current node pointing to head of the linked list
        ListNode prev = temp;  // helper node for temp

        temp.next = head;
        while(curr!=null){  // while currentis not null
            if(curr.next != null && curr.val == curr.next.val){  //check whether current next is not null and value of current and current's next is equal only then run while loop again till we have equal value for current and current's next.
                while(curr.next != null && curr.val == curr.next.val){
                    curr = curr.next;
                }//after all the same value we will point prev.next to next element of current so that all duplicates are removed 
                prev.next = curr.next;
            }else{
                prev=curr; // if value are distinct then directly provide it prev
            }
            curr=curr.next; //moving to the next element 
        }
        return temp.next; //returning temp.next as we started from there
    }
}