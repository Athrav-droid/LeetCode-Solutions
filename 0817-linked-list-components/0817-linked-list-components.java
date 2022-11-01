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
    public int numComponents(ListNode head, int[] nums) {
        HashSet<Integer> set = new HashSet<>();  //first taken values in set (unique value of nums)
        for(int i=0;i<nums.length;i++) set.add(nums[i]);
        int count =0 ; //since we have to return count of consecutives
        ListNode curr = head; //temprory node
        while(curr!=null){ //till current is not equals to null
            if(set.contains(curr.val)){ //if set contains value of current node 
                while(curr.next!=null&&set.contains(curr.next.val)){  //then check if it have current next or not if have then check for next's value if it belongs to set or not if yes then move curr one step ahead and check the same.
                    curr=curr.next;
                }
                count++;  //increase the count since it shows that consequently values are there in linked list
            }
            curr=curr.next;  //this one since we have to start now from the next node of the current node .
        }
        return count;
    }
}