class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;
		if (nums == null || nums.length == 0) return res;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int sum = 0;
		
		for (int i = 0 ;i < nums.length; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) 
				res = Math.max(res, i - map.get(sum - k));
			
			if (!map.containsKey(sum))
				map.put(sum, i);
		}
		
		return res;   
    }
}