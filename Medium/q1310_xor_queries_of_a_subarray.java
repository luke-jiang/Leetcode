// [Bit Manipulation, xor, Prefix Sum]

/** Given the array arr of positive integers and the array queries where
  * queries[i] = [Li, Ri], for each query i compute the XOR of elements from Li to
  * Ri (that is, arr[Li] xor arr[Li+1] xor ... xor arr[Ri] ). Return an array
  * containing the result for the given queries.
  *
  * Example 1:
  * Input: arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
  * Output: [2,7,14,8]
  * Explanation:
  * The binary representation of the elements in the array are:
  * 1 = 0001
  * 3 = 0011
  * 4 = 0100
  * 8 = 1000
  * The XOR values for queries are:
  * [0,1] = 1 xor 3 = 2
  * [1,2] = 3 xor 4 = 7
  * [0,3] = 1 xor 3 xor 4 xor 8 = 14
  * [3,3] = 8
  */

class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] sums = new int[n+1];
        sums[1] = arr[0];
        for (int i = 1; i < n; i++) {
            sums[i+1] = sums[i] ^ arr[i];
        }

        int[] res = new int[queries.length];
        int i = 0;
        for (int[] q : queries) {
            int from = q[0];
            int to = q[1] + 1;
            res[i] = sums[from] ^ sums[to];
            i++;
        }

        return res;
    }
}
