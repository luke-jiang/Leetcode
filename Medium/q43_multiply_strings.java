// [String, Multiplication]

/** Given two non-negative integers num1 and num2 represented as strings, return
  * the product of num1 and num2, also represented as a string.
  *
  * Example 1:
  * Input: num1 = "2", num2 = "3"
  * Output: "6"
  *
  * Example 2:
  * Input: num1 = "123", num2 = "456"
  * Output: "56088"
  *
  * Note:
  * The length of both num1 and num2 is < 110.
  * Both num1 and num2 contain only digits 0-9.
  * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
  * You must not use any built-in BigInteger library or convert the inputs to integer directly.
  */

class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] ans = new int[num1.length() + num2.length()];

        for (int i = num1.length()-1; i >= 0; i--) {
            for (int j = num2.length()-1; j >= 0; j--) {
                int mult = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int low = i + j + 1;
                int high = i + j;
                int sum = mult + ans[low];
                ans[low] = sum % 10;
                ans[high] += sum / 10;
            }
        }


        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (ans[i] == 0) i++;
        while (i < ans.length) {
            sb.append(Integer.toString(ans[i]));
            i++;
        }

        return sb.toString();
    }
}
