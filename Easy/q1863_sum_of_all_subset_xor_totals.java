class Solution {
    int res;
    public int subsetXORSum(int[] nums) {
        res = 0;
        backtrack(new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void backtrack(List<Integer> path, int[] nums, int idx) {
        if (path.size() > 0) {
            int acc = path.get(0);
            for (int i = 1; i < path.size(); i++) {
                acc ^= path.get(i);
            }
            res += acc;
        }
        for (int i = idx; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(path, nums, i+1);
            path.remove(path.size()-1);
        }
    }
}
