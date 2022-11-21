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
    public boolean isEvenOddTree(TreeNode root) {
        int level = 0;
        if(root == null){
            return false;
        }
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while(myQueue.size() > 0){
            List<Integer> helper = new ArrayList<>();
            int levelNumber = myQueue.size();
            int j=0;
            for(int i=0;i<levelNumber;i++){
                j++;
                TreeNode node = myQueue.poll();
                helper.add(node.val);
                if(node.left!=null) myQueue.add(node.left);
                if(node.right!=null) myQueue.add(node.right);
            }
            if(level%2==0){
                for(int i=0;i<helper.size();i++){
                    if(helper.get(i)%2==0){
                        return false;
                    }
                }
                for(int i=0;i<helper.size()-1;i++){
                    if(helper.get(i)>=helper.get(i+1)){
                        return false;
                    }
                }
            }else{
                for(int i=0;i<helper.size();i++){
                    if(helper.get(i)%2!=0){
                        return false;
                    }
                }
                for(int i=0;i<helper.size()-1;i++){
                    if(helper.get(i)<=helper.get(i+1)){
                        return false;
                    }
                }
            }
            level++;
        }
        return true;
    }
}