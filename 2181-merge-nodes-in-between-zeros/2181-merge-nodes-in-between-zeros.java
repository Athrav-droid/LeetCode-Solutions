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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head; //listnode so that we don't lost access to head.
        ListNode ans = new ListNode(0);  //ans listnode which we will return as answer and add all the summed node.
        ListNode prev = ans; // prev help us to add node in ans node
        while(temp!=null&&temp.next!=null){ //to traverse whole linked list
            prev.next = temp;  // prev connects next 0 node.
            temp = temp.next;  // temp forward to a non-zero node.
            while(temp!=null&&temp.val!=0){ // traverse all non-zero nodes between two zero nodes.
                prev.next.val += temp.val;  // add current value to the previous zero node.
                temp = temp.next; // forward one step.
            }
            prev = prev.next; // prev point to the summation node (initially 0).
        }
        prev.next = null; // cut off last 0 node.
        return ans.next;
    }
}