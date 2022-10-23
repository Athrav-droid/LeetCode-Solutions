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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){  // if head null then return null
            return null;
        }
        if(head.next == null){  //if head's next null then returning new treenode, as function have to return a treenode with head's value
            return new TreeNode(head.val);
        }
        ListNode slow = head; 
        ListNode fast = head;
        ListNode prev = null; //important reference as we want to access the node before the root node to cut the access to entire list else will show time limit exceed error
        while(fast != null && fast.next!=null){  // finds mid and assigns value to prev
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;  // important as we have to cut the link between prev and root node
        TreeNode root = new TreeNode(slow.val); //root node creation
        root.left = sortedListToBST(head); //handling left side of BST
        root.right = sortedListToBST(slow.next); //handling right side of BST
        return root;  //return root
    }
}