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
    // public List<List<Integer>> levelOrder(TreeNode root) {
    //     Queue<TreeNode> q = new LinkedList<>();
    //     List<List<Integer>> ans = new ArrayList<List<Integer>>();
 
    //     q.add(root);
    //     q.add(null);
    //     int i = 0;
    //     while(!q.isEmpty()){
    //         TreeNode curr = q.remove();
    //         if(curr==null){
    //             i++;
    //             if(q.isEmpty()){
    //                 break;
    //             }else{
    //                 q.add(null);
    //             }
    //         }else{
    //             ans.get(i).add(curr.val);
    //             if(curr.left!=null){
    //                 q.add(curr.left);
    //             }
    //             if(curr.right!=null){
    //                 q.add(curr.right);
    //             }
    //         }
    //     }
    //     return ans;
    // }
    // https://leetcode.com/problems/binary-tree-level-order-traversal/solutions/2798388/java-runtime-0ms-faster-than-100-memory-usage-less-than-93-58/
    public List<List<Integer>> levelOrder(TreeNode root) {
        //Thought process:- result return hoga last m ... if root null hua then return result directly. queue create kri TreeNode type ki jisme sbse pehle root ko add krdiya. Ab while loop chalayenge jb tk queue end na ho means uska size 0 se greater ho... then dusri list bnayenge jo har level ke values ko lake dega result ko. LevelNumber is used to know how much time the loop will run means how much values are there in a level. Now Node m queue.poll() method se node liya. Uska value to levelList m add kiya add then uske left or right if exists then unko add kra queue m. Or result m finally level list ko add krke return krdiya after whole traversal of list.
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(root);
        while(myQueue.size() > 0){
            List<Integer> levelList = new ArrayList<>();
            int levelNumber = myQueue.size();
            for(int i=0;i<levelNumber;i++){
                TreeNode node = myQueue.poll();
                levelList.add(node.val);
                if(node.left!=null) myQueue.add(node.left);
                if(node.right!=null) myQueue.add(node.right);
            }
            result.add(levelList);
        }
        return result;
    }
}