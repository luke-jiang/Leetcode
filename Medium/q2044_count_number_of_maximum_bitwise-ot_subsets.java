// [Backtracking]

class Solution {
    int max;
    int count;

    public int countMaxOrSubsets(int[] nums) {
        max = 0;
        count = 1;
        backtrack(new ArrayList<>(), nums, 0);
        return count;
    }
    
    private void backtrack(List<Integer> curr, int[] nums, int i) {
        if (curr.size() > 0) {
            int acc = curr.get(0);
            for (int j = 1; j < curr.size(); j++) acc |= curr.get(j);
            if (acc == max) {
                count++;
            } else if (acc > max) {
                max = acc;
                count = 1;
            }
        }
        
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            backtrack(curr, nums, j+1);
            curr.remove(curr.size()-1);
        }
    }
}
