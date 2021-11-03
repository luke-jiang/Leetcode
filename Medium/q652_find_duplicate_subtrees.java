class Solution {
    
    Map<String, Integer> map;
    List<TreeNode> res;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        res = new ArrayList<>();
        dfs(root);
        return res;
    }
    
    private String dfs(TreeNode node) {
        if (node == null) return "N";
        String leftVal = dfs(node.left);
        String rightVal = dfs(node.right);
        String str = node.val + "," + leftVal + "," + rightVal;
        map.put(str, map.getOrDefault(str, 0) + 1);
        
        if (map.get(str) == 2) {
            res.add(node);
        }
        return str;
    }
}
