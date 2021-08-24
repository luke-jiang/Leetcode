class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
       //map's key is column, we assume the root column is zero, the left node will minus 1 ,and the right node will plus 1
        HashMap<Integer, ArrayList<Integer>> colMap = new HashMap<Integer, ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
       //use a HashMap to store the TreeNode and the according cloumn value
        HashMap<TreeNode, Integer> weight = new HashMap<TreeNode, Integer>();
        queue.offer(root);
        weight.put(root, 0);
        int min = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int w = weight.get(node);
            if (!colMap.containsKey(w)) {
                colMap.put(w, new ArrayList<>());
            }
            colMap.get(w).add(node.val);
            if (node.left != null) {
                queue.add(node.left);
                weight.put(node.left, w - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                weight.put(node.right, w + 1);
            }
            //update min ,min means the minimum column value, which is the left most node
            min = Math.min(min, w);
        }
        while (colMap.containsKey(min)) {
            res.add(colMap.get(min++));
        }
        return res;
    }
}
