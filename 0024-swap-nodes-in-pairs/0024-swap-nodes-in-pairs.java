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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {  //agr head ya head ka next null hojaye to return krde head; THESE IS BASE CASE
            return head;
        };
        ListNode n = head.next;  //head.next ko new Listnode m isliye rkha because usko hume head ki traf point krana h after recursive call and ans bhi vhi se return hoga
        head.next = swapPairs(head.next.next);  //head.next ko next adjacent pair pe recursive call lgane ke baad uspe point krdo
        n.next = head;  //as said earliar 2nd node ko first vale node pe point krane ke liye
        return n;  //since swap hone ke baad 2nd node humari head node ban jayegi
    }
}