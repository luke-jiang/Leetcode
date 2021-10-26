/** Given two binary strings a and b, return their sum as a binary string.
  * Example 1:
  * Input: a = "11", b = "1"
  * Output: "100"
  *
  * Example 2:
  * Input: a = "1010", b = "1011"
  * Output: "10101"
  *
  * Constraints:
  * 1 <= a.length, b.length <= 104
  * a and b consist only of '0' or '1' characters.
  * Each string does not contain leading zeros except for the zero itself.
  */

class Solution {
    // Use a full adder
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len1 = a.length();
        int len2 = b.length();
        
        int carry = 0;
        for (int i = 0; i < Math.max(len1, len2); i++) {
            int x = len1 - 1 - i;
            int y = len2 - 1 - i;
            int X = x >= 0 ? a.charAt(x) - '0': 0;
            int Y = y >= 0 ? b.charAt(y) - '0': 0;
            
            int S = sum(X, Y, carry);
            int C = carry(X, Y, carry);
            sb.append(S);
            carry = C;
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }
    
    private int sum(int a, int b, int c) {
        return a ^ b ^ c;
    }
    
    private int carry(int a, int b, int c) {
        return a & b | b & c | a & c;
    }
}