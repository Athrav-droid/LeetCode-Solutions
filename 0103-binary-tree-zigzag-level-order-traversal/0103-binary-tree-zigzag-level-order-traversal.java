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
    //Approach:- isme level to function parameter ke through hi count kr rhe h. New Thing is isme ArrayList m hum values ko ulta hi add krenge jisse ki vo zig zag manner m nikle
    public void helper(TreeNode root,List<List<Integer>> ans,int level){
        if(root == null){
            return;
        }
        if(ans.size()<=level){
            List<Integer> newLevel = new ArrayList<>();
            ans.add(newLevel);
        }
        List<Integer> collection  = ans.get(level); //it is helping me to put the value in the correct position in ans, since we are doing recursive calls so levels may get changed every time therefore.
        if(level%2==0) collection.add(root.val);
        else collection.add(0,root.val);
        helper(root.left,ans,level+1);
        helper(root.right,ans,level+1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root,ans,0);
        return ans;

        // //Just added a level integer to check in which level we are and added a check if even level then go as it is else go right first and then left.
        // // Else whole code is copy pasted from the https://leetcode.com/problems/binary-tree-level-order-traversal/ .
        // List<List<Integer>> result = new ArrayList<>();
        // if(root == null){
        //     return result;
        // }
        // Queue<TreeNode> myQueue = new LinkedList<>();
        // myQueue.add(root);
        // int level = 0;
        // while(myQueue.size() > 0){
        //     level++;
        //     List<Integer> levelList = new ArrayList<>();
        //     int levelNumber = myQueue.size();
        //     for(int i=0;i<levelNumber;i++){
        //         if(level%2==0){
        //             TreeNode node = myQueue.poll();
        //             levelList.add(node.val);
        //             if(node.left!=null) myQueue.add(node.left);
        //             if(node.right!=null) myQueue.add(node.right);
        //         }else{
        //             // //if last element can be removed from queue then this would work.
        //             TreeNode node = myQueue.poll(myQueue.size()-1);
        //             levelList.add(node.val);
        //             if(node.right!=null) myQueue.add(node.right);
        //             if(node.left!=null) myQueue.add(node.left);
        //         }
        //     }
        //     result.add(levelList);
        // }
        // return result;
    }
}