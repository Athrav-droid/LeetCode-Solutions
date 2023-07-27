class Solution {
    public List<TreeNode> allPossibleFBT(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if (n % 2 == 0) return ans; // Return empty list for even 'n'
        if (n == 1) {
            TreeNode root = new TreeNode(0);
            ans.add(root); // Add the single-node tree to ans
            return ans;
        }
        
        for (int i = 1; i < n; i += 2) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n - i - 1);

            for (TreeNode leftRoot : left) {
                for (TreeNode rightRoot : right) {
                    TreeNode root = new TreeNode(0);
                    root.left = leftRoot;
                    root.right = rightRoot;
                    ans.add(root);
                }
            }
        }
        return ans; // Return the list of trees for the current method call
    }
}
