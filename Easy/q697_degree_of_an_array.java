class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> last = new HashMap<>();

        int maxfreq = 1;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int f = freq.getOrDefault(n, 0) + 1;
            if (f > maxfreq) maxfreq = f;
            freq.put(n, f);
            if (!first.containsKey(n)) first.put(n, i);
            last.put(n, i);
            
        }
        int res = nums.length;
        for (int n : freq.keySet()) {
            if (freq.get(n) == maxfreq) {
                res = Math.min(res, last.get(n) - first.get(n) + 1);
            }
        }
        return res;
    }
}
