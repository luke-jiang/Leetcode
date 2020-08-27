// [Monotonic Stack] ***

/** Given an array of integers A, find the sum of min(B), where B ranges over every
  * (contiguous) subarray of A.
  *
  * Since the answer may be large, return the answer modulo 10^9 + 7.
  *
  * Example 1:
  * Input: [3,1,2,4]
  * Output: 17
  * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4],
  * [3,1,2,4].
  * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
  *
  * Note:
  * 1 <= A.length <= 30000
  * 1 <= A[i] <= 30000
  */

class Solution {

    /** For each element A[i], try to find the leftest and rightest elements
      * that are smaller than A[i] so that the minimum of A[left+1, i] and A[i, right-1]
      * are both A[i]. Then, the total possible combintions of desirable subarrays
      * centered at A[i] would be len(left_array) * len(right_array), since there are
      * "len(left_array)" number of possible left subarrays and "len(right_array)"
      * number of possible right subarrays
      *
      * We can use the Monotonic Stack technique to find the two boundaries.
      */

    public int sumSubarrayMins(int[] A) {
        int MOD = 1_000_000_007;
        int n = A.length;

        Stack<Integer> stack = new Stack<>();
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        int[] next = new int[n];
        for (int i = n-1; i >= 0; i--) {
            // the '<' is used instead of '<=' to avoid counting duplicates
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (i - prev[i]) * (next[i] - i) % MOD * A[i];
            res %= MOD;
        }
        return (int) res;
    }
}
