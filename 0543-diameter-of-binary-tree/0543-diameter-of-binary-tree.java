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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        helper(root,diameter);
        return diameter[0];
    }
    // public int helper(TreeNode root, int count){
    //     if(root == null) return count;
    //     if(root.left == null) root=root.right;
    //     if(root.right == null) root=root.left;
    //     if(root.left == null && root.right == null){
    //         return Math.max(maxVal,count);
    //     }
    //     count++;
    //     helper(root.left,count);
    //     helper(root.right,count);
    //     return count;
    // }
    public int helper(TreeNode root, int[] count){
        if(root == null) return 0;
        int left = helper(root.left,count);
        int right = helper(root.right,count);
        count[0] = Math.max(count[0], left+right);
        return Math.max(left,right) + 1;
    }
}