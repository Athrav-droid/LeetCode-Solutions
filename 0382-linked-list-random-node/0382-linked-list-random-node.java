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

//https://leetcode.com/problems/linked-list-random-node/discuss/1672358/C%2B%2BPythonJava-Reservoir-sampling-oror-Prove-step-by-step-oror-Image

class Solution {
    //Global Variable Declaratin because we have to use the variables in both the functions
    int size=0;
    ListNode head = null;
    public Solution(ListNode head) {
        this.head = head;  //Assigning global head value of the listnode head;
        ListNode temp = head; //temp is not necessary to use only used to have access of head forever.
        // counting the length to the list as we have to use it to get random value from the length of the listl
        while(temp!=null){
            this.size++;
            temp = temp.next;
        }
    }
    
    public int getRandom() {
        int ans = (int)(Math.random()*this.size); //getting random value and typecasting it into the list
        ListNode p = this.head;  //we want to have the value of that node so we must have to travel to that node.
        while(ans>0){ 
            p = p.next;
            ans--;
        }
        return p.val;
    }
}
//another approach can be of using arraylist then add every value of linked list in the arraylist and then return the random value among them 

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */