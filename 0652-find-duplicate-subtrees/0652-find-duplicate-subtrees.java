
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new LinkedList<>();
        helper(root, new HashMap<>(), new HashMap<>(), ans);
        return ans;
    }
    public int helper(TreeNode root, HashMap<String, Integer> hashId, HashMap<Integer, Integer> count, List<TreeNode> ans){
        if(root == null) return 0;
        String hash = helper(root.left, hashId, count, ans) + "," + root.val + "," + helper(root.right, hashId, count, ans);
        if(!hashId.containsKey(hash)) hashId.put(hash, hashId.size() + 1);
        int currId = hashId.get(hash);
        count.put(currId, count.getOrDefault(currId, 0) + 1);
        if(count.get(currId) == 2) ans.add(root);
        return currId;
    }
}