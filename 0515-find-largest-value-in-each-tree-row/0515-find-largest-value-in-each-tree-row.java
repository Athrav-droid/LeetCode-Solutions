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
 //Phele level order traversal m sare elements ko hum ek sublist bna ke daal rhe tha but is bar direct hi humne sari values ko check krliya Math.max function lga k and then jo maximum hoga usko ans list m add krke return krdiya at the last.
class Solution {
    List<Integer> ans = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root == null){
            return ans;
        }
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while(myQueue.size() > 0){
            int max = Integer.MIN_VALUE;
            int levelNumber = myQueue.size();
            for(int i=0;i<levelNumber;i++){
                TreeNode node = myQueue.poll();
                if(node.left!=null) myQueue.add(node.left);
                if(node.right!=null) myQueue.add(node.right);
                max = Math.max(max,node.val);
            }
            ans.add(max);
        }
        return ans;
    }
}