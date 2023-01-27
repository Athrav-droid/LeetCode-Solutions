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
 //https://leetcode.com/problems/symmetric-tree/solutions/33054/recursive-and-non-recursive-solutions-in-java/?languageTags=java
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root.left,root.right);
    }
    public boolean helper(TreeNode left, TreeNode right){
        if(left==null||right==null){
            return left==right;
        }
        if(left.val!=right.val){
            return false;
        }
        return helper(left.left,right.right)&&helper(left.right,right.left);
    }
}