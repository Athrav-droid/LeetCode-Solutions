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
    int ans = 0;
    public int longestZigZag(TreeNode root) {
        if(root.left == null && root.right == null) return 0;
        helper(root, true, 0);
        helper(root, false, 0);
        return ans;
    }
    public void helper(TreeNode root, boolean direction, int steps){
        if(root == null) return;
        ans = Math.max(steps, ans);
        if(direction){
            helper(root.left, false, steps + 1); // continuing the old path
            helper(root.right, true, 1); // starting a new path
        }else{
            helper(root.left, false, 1);
            helper(root.right, true, steps + 1);
        }
    }
}