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
    public ListNode oddEvenList(ListNode head) {
        //my code Time Limit Exceed
        // if(head==null){
        //     return head;
        // }
        // ListNode odd = head;
        // ListNode even = head;
        // ListNode odd_head = odd;
        // ListNode even_head = even;
        // int count = 1;
        // while(head!=null){
        //     if(count%2==0){
        //         even.next = head;
        //     }else{
        //         odd.next = head;
        //     }
        //     head = head.next;
        //     count++;
        // }
        // even.next = null;
        // odd.next = even_head.next;
        // return odd_head.next;
        if(head==null||head.next==null){
            return head;
        }
        ListNode odd = head;  //for odd nodes
        ListNode even = head.next; //for even nodes
        ListNode even_head = even; //even_head, since inlast we have to point odd's next to even head to join both odd and even list
        while(even!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = even_head; //join condition
        return head;
    }
}