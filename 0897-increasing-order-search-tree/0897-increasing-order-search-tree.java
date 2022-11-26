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
    List<Integer> helperList = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        if(root == null) return null;
        helper(root);
        Collections.sort(helperList);
        return helper2(ans);
    }
    public void helper(TreeNode root){
        if(root.left != null) helper(root.left);
        if(root.right != null) helper(root.right);
        helperList.add(root.val);
    }
    public TreeNode helper2( TreeNode root){
        
        TreeNode hel = root;
        for(int i=0;i<helperList.size()-1;i++){
            TreeNode newNode = new TreeNode();
            if(root!= null) root.val = helperList.get(i);
            root.right = newNode;
            root = root.right;
        }
        root.val = helperList.get(helperList.size()-1);
        return hel;
    }
}