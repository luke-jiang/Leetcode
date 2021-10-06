class Solution {
    List<List<Integer>> res;
    
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        backtrack(new ArrayList<>(), nums, 0);
        return res;
    }
    
    private void backtrack(List<Integer> curr, int[] nums, int i) {
        res.add(new ArrayList<>(curr));
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            backtrack(curr, nums, j+1);
            curr.remove(curr.size()-1);
        }
    }
}
