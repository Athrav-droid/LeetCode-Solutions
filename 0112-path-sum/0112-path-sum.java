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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        return helper(root,targetSum,0);
    }
    public boolean helper(TreeNode root, int targetSum, int currSum){
        if(root == null){ //it's not leaf node so return false
            return false;
        }
        currSum += root.val; // adding root's val to currSum
        if(root.left==null&&root.right==null){ //when reaching the leaf node than check that our currSum value i.e is value we calculated by adding all the roots from root to leaf, to the target sum given. if so then return true else return false.
            if(currSum == targetSum){
                return true;
            }else{
                return false;
            }
        }
        //else check for the next nodes of the tree.
        return helper(root.left,targetSum,currSum)||helper(root.right,targetSum,currSum);
    }
}