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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead1 = l1;  //we can directly use l1 and l2 or we can use dummy nodes
        ListNode newHead2 = l2;
        ListNode ans = new ListNode();  //creating ans node which will put the ans in it.
        ListNode mainAns = ans; //creating main ans as we use ans to traverse through the list so we lost the location of head, therefore to get the location of the head we use dummy variable/list.
        int carry = 0;  //carry since if it is one then we have to again create a node.
        while(newHead1!=null||newHead2!=null||carry == 1){  
            int anshelp = 0;
            if(newHead1!=null){
                anshelp += newHead1.val;
                newHead1 = newHead1.next;
            }
            if(newHead2!=null){
                anshelp += newHead2.val;
                newHead2 = newHead2.next;
            }
            anshelp += carry;  //necesarry to add carry first and then store new value in carry of new anshelp
            carry = anshelp/10;
            ListNode node = new ListNode(anshelp%10);  //create new node with modulo value and point the ans list's to it and then move the ans list's head to next node
            ans.next = node;
            ans = ans.next;
        }
        return mainAns.next;
    }
}