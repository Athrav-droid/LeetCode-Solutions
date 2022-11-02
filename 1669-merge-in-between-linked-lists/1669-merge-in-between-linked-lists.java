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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        //Logic:- pehle a point tk traverse kro and ek dummy vha chod do de b node tk traverse kro and ek dummy vha chod do . then pehle dummy ko dusri list pe point kra do and dusri list ke last tk traverse kro and usko next ko dusre dummy pe point kra do
        ListNode head1 = list1; 
        a--;
        while(a!=0){
            head1 = head1.next;
            a--;
        }
        b++;
        ListNode head2 = list1;
        while(b!=0){
            head2 = head2.next;
            b--;
        }
        head1.next = list2;
        while(list2.next!=null){
            list2 = list2.next;
        }
        list2.next = head2;
        return list1;
    }
}