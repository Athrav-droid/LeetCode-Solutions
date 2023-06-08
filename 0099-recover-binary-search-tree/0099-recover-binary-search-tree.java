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
    private TreeNode first; 
    private TreeNode middle; 
    private TreeNode last; 
    private TreeNode prev;
    public void recoverTree(TreeNode root) {
        first = middle = last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first != null && last != null){
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }else if(first != null && middle != null){
            int temp = first.val;
            first.val = middle.val;
            middle.val = temp;
        }
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev != null && (root.val < prev.val)){
            if(first == null){
                first = prev;
                middle = root;
            }else{
                last = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    // public void recoverTree(TreeNode root) {
    //     if(root == null) return;
    //     if(root.left != null){
    //         if(root.val <  root.left.val){
    //             swap(root, root.left);
    //         }
    //     }
    //     if(root.right != null){
    //         if(root.val > root.right.val){
    //             swap(root, root.right);
    //         }
    //     }
    //     recoverTree(root.left);
    //     recoverTree(root.right);   
    // }
    // public void swap(TreeNode first, TreeNode second){
    //     int temp = first.val;
    //     first.val = second.val;
    //     second.val = temp;
    // }
}