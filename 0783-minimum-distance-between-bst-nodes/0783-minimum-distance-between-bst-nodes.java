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
    List<Integer> help = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root);
        int n = help.size();
        int min = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if((help.get(i)-help.get(i-1)<min)) min = help.get(i)-help.get(i-1);
        }
        return min;
    }
    public void helper(TreeNode root){
        if(root == null){
            return;
        }
        helper(root.left);
        help.add(root.val);
        helper(root.right);
    }
}