// [Prefix Sum]
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        
        int[] prefixSum = new int[k+1];
        int[] suffixSum = new int[k+1];
        
        for (int i = 0; i < k; i++) {
            prefixSum[i+1] = cardPoints[i] + prefixSum[i];
            suffixSum[i+1] = cardPoints[n-i-1] + suffixSum[i];
        }
        
        System.out.println(Arrays.toString(suffixSum));
        
        int res = 0;
        for (int i = 0; i <= k; i++) {
            int curr = prefixSum[i] + suffixSum[k-i];
            System.out.println(curr);
            res = Math.max(res, curr);
        }
        return res;
    }
}
