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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Call the recursive function with full arrays and return the result
        return treeBuilder(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    public TreeNode treeBuilder(int[] inorder, int inSt, int inEnd, int[] postorder, int poSt, int poEnd){
        //Base Case
        if(inSt > inEnd || poSt > poEnd) return null;
        //getting the root node
        int rootVal = postorder[poEnd];
        TreeNode root = new TreeNode(rootVal);
        //finding position of root node in inorder list
        int rootIndex = 0;
        for(int i = inSt; i <= inEnd; i++){
            if(rootVal == inorder[i]){
                rootIndex = i;
                break;
            }
        }
        //getting new left and right size 
        int leftSize = rootIndex - inSt;
        int rightSize = inEnd - rootIndex;
        //recursively calling to build the left and right subtree
        root.left = treeBuilder(inorder, inSt, rootIndex -1, postorder, poSt, poSt + leftSize - 1);
        root.right = treeBuilder(inorder, rootIndex + 1, inEnd, postorder, poEnd - rightSize, poEnd - 1);
        return root;
    }
}