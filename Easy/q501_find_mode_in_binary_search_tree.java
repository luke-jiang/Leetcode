class Solution {
    public int[] findMode(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        while (root != null) {
            st.push(root);
            root = root.left;
        }
        int prev = -1;
        int count = 0;
        int maxCount = 0;
        List<Integer> res = new ArrayList<>();
        while (!st.isEmpty()) {
            TreeNode next = st.pop();
            if (prev == next.val) {
                count++;
            } else {
                prev = next.val;
                count = 1;
            }
            if (count > maxCount) {
                maxCount = count;
                res.clear();
                res.add(prev);
            } else if (count == maxCount) {
                res.add(prev);
            }
            
            TreeNode tmp = next.right;
            while (tmp != null) {
                st.push(tmp);
                tmp = tmp.left;
            }
        }
        System.out.println(res);
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}
