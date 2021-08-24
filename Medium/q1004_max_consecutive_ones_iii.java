// [SlidingWindow]

class Solution {
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < A.length) {
            if (A[right] == 1) {
                right++;
            } else if (A[right] == 0 && K > 0) {
                right++;
                K--;
            } else {
                while (K == 0) {
                    K += A[left] == 0 ? 1 : 0;
                    left++;
                }
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}
