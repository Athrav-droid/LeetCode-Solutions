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
    //Reversed Both List then performed addition as done before and then again reversed the ans list to return.
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newHead1 = reverseList(l1);
        ListNode newHead2 = reverseList(l2);
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
        ListNode mAns = reverseList(mainAns.next);
        return mAns;
        
    }
    
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){  //check for no element or only one element in the linked list
            return head;
        }
        ListNode prev = null;  //prev pointer initially pointing to null.
        ListNode present = head;  //present pointer pointing towards head.
        ListNode next = present.next;  // next pointer pointing to the next of present pointer.
        
        while(present!=null){  //traversing throughout the linked list till present is not equals to null.
            present.next = prev;  //pointing to the present node behind pointer. if no ones behind then pointing to null as prev is intialized to null.
            prev = present;  //moving prev ahead one step or can be said to present state.
            present = next;  //moving present one step ahead now.
            if(next!=null){  //check if the next element is null or not.
                next = next.next;  //moving the next pointer ahead one time.
            }
        }
        return prev;  //returning the prev node as it is now become the head node after the while loop ends.
    }
}