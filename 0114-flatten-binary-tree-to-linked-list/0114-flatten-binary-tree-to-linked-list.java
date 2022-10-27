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
    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/discuss/1208004/Extremely-Intuitive-O(1)-Space-solution-with-Simple-explanation-Python
    public void flatten(TreeNode root) {
        if(root == null){  //check for null
            return;
        }
        TreeNode temp = null;  // left node ke rightmost node ke right m root ke right ko dalna h so temp created, so that it can traverse to the rightmost node of root's left
        TreeNode curr = root;  // copy of root;
        while(curr!=null){ // till the current is not null
            if(curr.left!=null){  //check current's left is null or not. If not then assign temp to current's left.
                temp = curr.left;
                while(temp.right!=null){ //again since we have to move temp to the right most element of the root's left or current's left so check till temp's right is not null assign temp's right to temp.
                    temp = temp.right;
                }
                //after reaching at the right most node of current's left assign following
                temp.right = curr.right; //current's right to temp's right :- puri right side ko temp ke right m daal do
                curr.right = curr.left; //ab puri root/current ki left side ko ussi ki right side m daal do
                curr.left = null; // and current/root ke left ko null krdo 
            }
            //now next loop will run for current's right so assign current's right to current.
            curr = curr.right;
        }
       
    }
}