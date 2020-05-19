
/** The set [1,2,3,...,n] contains a total of n! unique permutations.
  * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
  * "123"
  * "132"
  * "213"
  * "231"
  * "312"
  * "321"
  * Given n and k, return the kth permutation sequence.
  * Given n will be between 1 and 9 inclusive.
  * Given k will be between 1 and n! inclusive.
  */

class Solution {
    // O(n). iteratively find the next number in the sequence.
    // nothing deep.
    public String getPermutation(int n, int k) {
        List<Integer> digits = new ArrayList<>();
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            digits.add(i);
            fact *= i;
        }

        k -= 1;           // since digits starts from 1
        fact /= n;        // fact = (n-1) * (n-2) * ... * 1
        String res = "";

        while (digits.size() > 1) {
            int next = digits.remove(k / fact);
            res += next;
            k = k % fact;
            fact /= digits.size();
        }

        res += digits.get(0);
        return res;
    }
}
