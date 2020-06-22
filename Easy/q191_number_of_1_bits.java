
/** Write a function that takes an unsigned integer and return the number of '1' bits it has
  * (also known as the Hamming weight).
  *
  * Example 1:
  * Input: 00000000000000000000000000001011
  * Output: 3
  * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits
  */
  
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int res = 0;
        while (n != 0) {
            res += (1 & n);
            n >>>= 1;
        }
        return res;
    }
}
