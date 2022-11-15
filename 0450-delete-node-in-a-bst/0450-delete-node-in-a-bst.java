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
    List<Integer> check = new ArrayList<>();
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        if(root.val>key){
            root.left = deleteNode(root.left,key);
        }
        else if(root.val<key){
            root.right = deleteNode(root.right,key);
        }
        else{
            if(root.left==null&&root.right==null){
                return null;
            }
            if(root.left==null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            TreeNode nextNode = helper(root.right);
            root.val = nextNode.val;
            root.right = deleteNode(root.right,nextNode.val);
        }
        return root;
    }
    public TreeNode helper(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        check.add(root.val);
        inorder(root.right);
    }
}