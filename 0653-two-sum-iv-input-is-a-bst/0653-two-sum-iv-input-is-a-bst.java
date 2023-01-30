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
    List<Integer> helper = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        listMaker(root);
        for(int i=0;i<helper.size()-1;i++){
            for(int j=i+1;j<helper.size();j++){
                if(k == (helper.get(i) + helper.get(j))) return true;
            }
        }
        return false;
    }
    public void listMaker(TreeNode root){
        if(root == null) return;
        if(root.left != null) listMaker(root.left);
        helper.add(root.val);
        if(root.right != null) listMaker(root.right);
    }
}