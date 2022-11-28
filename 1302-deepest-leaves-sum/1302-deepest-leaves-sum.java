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
    int sum=0;
    int maxLevel=0;
    public int deepestLeavesSum(TreeNode root) {
        if(root==null) return sum;
        helper(root,0);
        return sum;
    }
    public void helper(TreeNode root,int level){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            if(level == maxLevel){
                sum+=root.val;
            }
            if(level>maxLevel){
                maxLevel = level;
                sum=0;
                sum+=root.val;
            }
        }
        level++;
        helper(root.left,level);
        helper(root.right,level);
        return;
    }
}