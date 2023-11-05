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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder, new int[]{0}, Integer.MAX_VALUE);
    }
    public TreeNode helper(int[] preOrder, int[] idx, int bound){
        if(idx[0] == preOrder.length || preOrder[idx[0]] > bound) return null;
        TreeNode root = new TreeNode(preOrder[idx[0]++]);
        root.left = helper(preOrder, idx, root.val);
        root.right = helper(preOrder, idx, bound);
        return root;
    }
}