/** In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.
  * (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
  * We may rotate the i-th domino, so that A[i] and B[i] swap values.
  * Return the minimum number of rotations so that all the values in A are the same,
  * or all the values in B are the same. If it cannot be done, return -1.
  *
  * Example 1:
  * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
  * Output: 2
  * Explanation: swap values at index 1 and index 3 so that A contains only 2.
  *
  * Example 2:
  * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
  * Output: -1
  *
  */
  
class Solution {
    // there are 6 values possible for each domino.
    // countA/countB stores the frequency of values for each array.
    // same[i] stores the frequency of some value i, which, for some index x,
    // A[x] == B[x].

    public int minDominoRotations(int[] A, int[] B) {
        int[] countA = new int[7];
        int[] countB = new int[7];
        int[] same = new int[7];
        for (int i = 0; i < A.length; i++) {
            countA[A[i]]++;
            countB[B[i]]++;
            if (A[i] == B[i]) same[A[i]]++;
        }

        for (int i = 1; i <= 6; i++) {
            // select occurences of value i from both A and B, and see if we have
            // enough sccurences of i to fill the domino array.
            if (countA[i] + countB[i] - same[i] == A.length) {
                // now countX[i] can be interpreted as number of swaps of value i
                // from array A/B to B/A to construct one row of same value.
                return Math.min(countA[i], countB[i]) - same[i];
            }
        }
        return -1;
    }
}
