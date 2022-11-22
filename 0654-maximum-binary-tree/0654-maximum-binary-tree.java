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
//  https://leetcode.com/problems/maximum-binary-tree/solutions/106153/very-simple-recursion-solution-similar-to-canonical-binary-tree/?languageTags=java
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null){
            return null;
        }
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int[] nums, int left, int right){
        if(left>right){
            return null;
        }
        int maxIndex = 0;
        int max = Integer.MIN_VALUE;
        for(int i=left;i<=right;i++){ // using variable max for two purpose 1. for index 2. for max value
            maxIndex = nums[i] > max ? i : maxIndex;
            max = Math.max(max,nums[i]);
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums,left,maxIndex-1);
        root.right = helper(nums,maxIndex+1,right);
        return root;
    }
}