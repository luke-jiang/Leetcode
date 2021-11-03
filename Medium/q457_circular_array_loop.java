class Solution {
    boolean[] seen;
    
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        int[] next = new int[n]; // next[i] stores the next index of index i
        for (int i = 0; i < n; i++) {
            next[i] = i + nums[i];
            while (next[i] < 0) next[i] += n;
            while (next[i] >= n) next[i] -= n;
        }

        seen = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (dfs(nums, next, i, i)) return true;
        }
        return false;
    }
    
    private boolean dfs(int[] nums, int[] next, int root, int idx) {
        if (seen[idx]) return true;
        // repreating at idx or wrong direction, not valid cycle
        if (next[idx] == idx || nums[root] * nums[idx] < 0) return false;
        seen[idx] = true;
        boolean res = dfs(nums, next, root, next[idx], idx);
        seen[idx] = false;
        return res;
    }
}
