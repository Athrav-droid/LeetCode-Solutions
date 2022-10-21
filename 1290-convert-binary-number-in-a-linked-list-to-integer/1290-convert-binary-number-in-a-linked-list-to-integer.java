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
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        int i = 0;
        ListNode reverseHead = reverseList(head);  //reversed linked list because binary to decimal m piche se convert krna start krte h
        while(reverseHead!=null){
            ans+= reverseHead.val*Math.pow(2, i);
            reverseHead = reverseHead.next;
            i++;
        }
        return ans;
    }
    public ListNode reverseList(ListNode head){
        if(head == null||head.next == null){
            return head;
        }
        ListNode newHeadNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHeadNode;
    }
}