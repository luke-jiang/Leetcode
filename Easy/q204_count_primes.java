// [DP, Math] ***

/** Count the number of prime numbers less than a non-negative number, n.
  * Example:
  * Input: 10
  * Output: 4
  * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
  */

class Solution {
    public int countPrimes(int n) {
        if (n <= 1) return 0;

        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;

        for (int i = 2; i < Math.sqrt(n); i++) {
            if (!notPrime[i]) {
                for (int j = 2; j*i < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i< notPrime.length; i++){
            if (!notPrime[i]) count++;
        }

        return count;
    }
}
