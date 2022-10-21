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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
    
    public boolean isPalindrome(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode secondHead = reverseList(mid);
        ListNode reverseHead = secondHead;
        while(head!=null&&secondHead!=null){
            if(head.val!=secondHead.val){
                return false;
                // break;
            }
            head = head.next;
            secondHead = secondHead.next;
        }
        // reverseList(reverseHead);
        // if(head==null||secondHead==null){
        //     return true;
        // }
        // return false;
        return true;
    }
}