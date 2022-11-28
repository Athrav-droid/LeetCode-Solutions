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
    StringBuilder ans = new StringBuilder();
    public String tree2str(TreeNode root) {
        if(root==null) return "";
        helper(root);
        return ans.toString();
    }
    public void helper(TreeNode root){
        if(root == null) return;
        if(root.left == null && root.right == null){
            ans.append(root.val);
            return;
        }
        ans.append(root.val);
        ans.append("(");
        helper(root.left);
        ans.append(")");
        if(root.right!=null){
            ans.append("(");
            helper(root.right);
            ans.append(")");
        }
        return;
    }
}