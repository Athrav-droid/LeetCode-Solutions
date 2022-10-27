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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0){
            return null;
        }
        return hbbst(nums,0,nums.length-1);
    }
    
    public TreeNode hbbst(int[] arr,int left, int right){
        if(left>right){
            return null;
        }
        int mid = (right+left)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = hbbst(arr,left,mid-1);
        root.right = hbbst(arr,mid+1,right);
        return root;
    }
}