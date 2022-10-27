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
    public ListNode swapNodes(ListNode head, int k) {
        // Just Swap the Values of the Nodes
        ListNode firstk = head;  // listnode to take hold of the first kth node and its value is stored in a;
        for(int i=1;i<k;i++){
            firstk = firstk.next;
        }
        int a = firstk.val;
        ListNode temp = head; //temp listnode to count the number of nodes since we need the last kth node for it's value.
        int count = 0;
        while(temp!=null){
            temp=temp.next;
            count++;
        }
        ListNode secondk = head; // listnode to take hold of the second/from end kth node and its value is stored in b;
        for(int i=1;i<count-k+1;i++){
            secondk = secondk.next;
        }
        //just swaped the values of both nodes
        int b = secondk.val; 
        firstk.val = b;
        secondk.val = a;
        return head;
    }
}