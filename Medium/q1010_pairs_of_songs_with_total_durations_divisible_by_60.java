class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : time) {
            res += map.getOrDefault((60 - (n % 60)) % 60, 0);
            map.put(n % 60, map.getOrDefault(n % 60, 0) + 1);
        }
        return res;
    }
}
