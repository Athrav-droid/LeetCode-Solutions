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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null){
            root = new TreeNode(val);
            return root;
        }
        helper(root,val);
        return root;
    }
    public TreeNode helper(TreeNode root, int val){
        if(root==null){
            root = new TreeNode(val);
            return root;
        }
        if(val<root.val) root.left = helper(root.left,val);
        else root.right = helper(root.right,val);
        return root;
    }
}