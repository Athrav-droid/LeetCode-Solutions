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
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        // prepare the results for each of the buckets upto k size
		ListNode[] result = new ListNode[k];
        
        // if root is null then return the empty array
        if (head == null)
            return result;
        
        // find the total length of the list
        int length = 0;
        ListNode curr = head;
        while (curr != null){
            length++;
            curr = curr.next;
        }
        
        int index = 0; //to put elements in the array.
        int eachLength = length / k; //for every part list
        int extraLength = length % k; //to add a node in part list . Since we don't want to make diff greater than 1.
        curr = head;
        
        while(curr!=null){ //to traverse linked list
            ListNode temp = curr; 
            int diff = extraLength <= 0 ? 0 : 1; //difference to take extra node in every part till extralength is there.
            for(int i=0;i<eachLength+diff-1;i++){
                curr = curr.next;
            }
            ListNode temp2 = curr.next; // access of next node
            curr.next = null; // curr's next null to break the link since we don't want entire list to be present in the array each index
            curr = temp2; // reassigning the next node to curr 
            result[index++] = temp; // putting list at the index of the array
            extraLength--; //decrementing extra lenght by one since if we don't do this than we will get extra length of 1 in every part.
        }
        return result;
    }
}