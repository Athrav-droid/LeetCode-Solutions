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
    public class Pair{
        TreeNode root;
        int row;
        int col;
        Pair(TreeNode root, int row, int col){
            this.root = root;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();  
        q.offer(new Pair(root, 0, 0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair curr = q.poll();
                map.computeIfAbsent(curr.col, k -> new HashMap<>())
                .computeIfAbsent(curr.row, k -> new ArrayList<>())
                .add(curr.root.val);
                if(curr.root.left != null) q.offer(new Pair(curr.root.left, curr.row + 1, curr.col - 1));
                if(curr.root.right != null) q.offer(new Pair(curr.root.right, curr.row + 1, curr.col + 1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = -10000; i < 10000; i++){
            if(map.containsKey(i)){
                List<Integer> helper = new ArrayList<>();
                for(int j = 0; j < 10000; j++){
                    if(map.get(i).containsKey(j)){
                        List<Integer> temp = map.get(i).get(j);
                        if(temp.size() > 1) Collections.sort(temp);
                        helper.addAll(temp);
                    }
                }
                ans.add(helper);
            }
        }      
        return ans;
    }
}