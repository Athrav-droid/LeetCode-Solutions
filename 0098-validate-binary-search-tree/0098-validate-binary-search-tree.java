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
    List<Integer> ans = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        for(int i=0;i<ans.size()-1;i++){
            if(ans.get(i)>=ans.get(i+1)) return false;
        }
        return true;
    }
    public List<Integer> inOrder(TreeNode root){
        if(root == null){
            return ans;
        }
        inOrder(root.left);
        ans.add(root.val);
        inOrder(root.right);
        return ans;
    }

    // public boolean isValidBST(TreeNode root) {
    //     if(root.left!=null){
    //         if(root.left.val>=root.val){
    //         return false;
    //         }
    //         isValidBST(root.left);
    //     }
    //     if(root.right!=null){
    //         if(root.right.val<=root.val){
    //         return false;
    //         }
    //         isValidBST(root.right);
    //     }
    //     return true;
    // }
}