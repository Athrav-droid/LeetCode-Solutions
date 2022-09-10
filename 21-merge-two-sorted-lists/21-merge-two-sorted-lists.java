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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode ans = new ListNode();
        ListNode temp = ans;
        
        while(head1!=null && head2!=null){
            if(head1.val < head2.val){
                ans.next = head1;
                head1 = head1.next;
                ans = ans.next;
            }else{
                ans.next = head2;
                head2 = head2.next;
                ans = ans.next;
            }
        }
        while(head1!=null){
                ans.next = head1;
                head1 = head1.next;
                ans = ans.next;
        }
        while(head2!=null){
             ans.next = head2;
                head2 = head2.next;
                ans = ans.next;
        }
        
        return temp.next;
    }
}