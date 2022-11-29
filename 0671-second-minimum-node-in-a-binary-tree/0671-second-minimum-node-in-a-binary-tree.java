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
    HashSet<Integer> set = new HashSet<>();  
    public int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        helper(root);
        int minval = root.val;
        long ans = Long.MAX_VALUE;
        for(int i:set){
            if(minval<i&&i<ans) ans = i;
        }
        return ans < Long.MAX_VALUE ? (int)ans : -1;
    }
    public void helper(TreeNode root){
        if(root == null) return;
        set.add(root.val);
        helper(root.left);
        helper(root.right);
        return;
    }
}