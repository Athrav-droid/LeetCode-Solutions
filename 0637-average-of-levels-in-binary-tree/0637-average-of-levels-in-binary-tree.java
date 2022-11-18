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
    List<Double> ans = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        if(root == null){
            return ans;
        }
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while(myQueue.size() > 0){
            Double sum = Double.MIN_VALUE;
            int levelNumber = myQueue.size();
            int j=0;
            for(int i=0;i<levelNumber;i++){
                j++;
                TreeNode node = myQueue.poll();
                if(node.left!=null) myQueue.add(node.left);
                if(node.right!=null) myQueue.add(node.right);
                sum += node.val;
            }
            Double avg = sum/j;
            ans.add(avg);
        }
        return ans;
    }
}