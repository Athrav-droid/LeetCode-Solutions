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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return treeBuilder(preorder, 0, inorder, 0, inorder.length - 1);
    }
    public TreeNode treeBuilder(int[] preorder, int preSt, int[] inorder, int inSt, int inEnd){
        // base case
        if(preSt > preorder.length - 1 || inSt > inEnd) return null;
        //creating new TreeNode with preorder[preSt] value or can be said as root value
        TreeNode root = new TreeNode(preorder[preSt]);
        //finding rootindex in inorder array 
        int rootIndex = 0;
        for(int i = inSt; i <= inEnd; i++){
            if(root.val == inorder[i]){
                rootIndex = i;
                break;
            }
        }
        // left ke liye start ke next element se hi chalu ho jayega and right side ke liye usme rootIndex ko add krke initial value ko minus krdenge and + 1 krdenge 
        root.left = treeBuilder(preorder, preSt + 1, inorder, inSt, rootIndex - 1);
        root.right = treeBuilder(preorder, preSt + rootIndex - inSt + 1, inorder, rootIndex + 1, inEnd);
        return root;
    }
}

