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
    List<Integer> r1 = new ArrayList<>();
    List<Integer> r2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        helper(root1,r1);
        helper(root2,r2);
        if(r1.equals(r2)) return true;
        return false;
    }
    public void helper(TreeNode root, List<Integer> r){
        if(root==null){
            return;
        }
        if(root.left==null&&root.right==null){
            r.add(root.val);
        }
        helper(root.left,r);
        helper(root.right,r);
    }
}