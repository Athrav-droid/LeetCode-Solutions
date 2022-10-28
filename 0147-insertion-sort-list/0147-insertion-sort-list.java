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
    public ListNode insertionSortList(ListNode head) {
        //Code using Sort method of ArrayList.
        
        // ListNode temp = head;
        // ArrayList<Integer> list = new ArrayList<>();
        // while(temp!=null){
        //     list.add(temp.val);
        //     temp = temp.next;
        // }
        // Collections.sort(list);
        // temp = head;
        // int i=0;
        // while(temp!=null){
        //     temp.val = list.get(i);
        //     i++;
        //     temp = temp.next;
        // }
        // return head;
        
        //Code using Linked List Approach
        ListNode ans = new ListNode(0);
        ListNode curr = head;
        ListNode prev = ans;
        ListNode next = null;
        while(curr!=null){ // to check every element of linked list to put at correct position
            next = curr.next;  // to have access of the current's next node since we will cut that link to join it with answer linked list
            while(prev.next!=null&&prev.next.val < curr.val){  //finding correct position of current in answer linked list
                prev = prev.next;
            }
            //insert between pre and pre.next
            curr.next = prev.next;  // breaking current's next therefore we used next above. current's next pointing to prev's next
            prev.next = curr;  // prev's next pointing to current
            prev = ans;  // reinitializing prev to starting 
            curr = next; //moving current one element ahead.
        }
        return ans.next;
    }
}