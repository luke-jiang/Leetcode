
/** The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 *  countAndSay(1) = "1"
 *  countAndSay(n) is the way you would "say" the digit string from countAndSay(n-1), which is then converted into a different digit string.
 *
 * To determine how you "say" a digit string, split it into the minimal number of groups so that each group is a contiguous section all of 
 * the same character. Then for each group, say the number of characters, then say the character. To convert the saying into a digit string, 
 * replace the counts with a number and concatenate every saying.
 *
 * Example:
 * Input: n = 4
 * Output: "1211"
 * Explanation:
 * countAndSay(1) = "1"
 * countAndSay(2) = say "1" = one 1 = "11"
 * countAndSay(3) = say "11" = two 1's = "21"
 * countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
 */

class Solution {
    
    public String countAndSay(int n) {
        String res = "1";
        for (int i = 2; i <= n; i++) {
            res = count(res);
        }
        return res;
    }
    
    private String count(String n) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char c = n.charAt(0);
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == c) {
                count++;
            } else {
                sb.append("" + count + c);
                count = 1;
                c = n.charAt(i);
            }
        }
        if (count > 0) {
            sb.append("" + count + c);
        }
        return sb.toString();
    }
}
