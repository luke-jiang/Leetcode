// [Numbers]

/** Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

  * For example, 2 is written as II in Roman numeral, just two one's added together. 
  * 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, 
  * which is XX + V + II.
  *
  * Roman numerals are usually written largest to smallest from left to right. However, 
  * the numeral for four is not IIII. Instead, the number four is written as IV. Because 
  * the one is before the five we subtract it making four. The same principle applies to 
  * the number nine, which is written as IX. There are six instances where subtraction is used:
  *
  * I can be placed before V (5) and X (10) to make 4 and 9. 
  * X can be placed before L (50) and C (100) to make 40 and 90. 
  * C can be placed before D (500) and M (1000) to make 400 and 900.
  * Given a roman numeral, convert it to an integer.
  *
  * Example 1:
  * Input: s = "III"
  * Output: 3
  *
  * Example 2:
  * Input: s = "IV"
  * Output: 4
  *
  * Example 3:
  * Input: s = "IX"
  * Output: 9
  *
  * Example 4:
  * Input: s = "LVIII"
  * Output: 58
  * Explanation: L = 50, V= 5, III = 3.
  *
  * Example 5:
  * Input: s = "MCMXCIV"
  * Output: 1994
  * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
  */

class Solution {
    Map<Character, Integer> precedence;
    Map<Character, Integer> values;
    
    public int romanToInt(String s) {
        buildPrecedence();
        buildValues();

        int res = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (precedence.get(s.charAt(i)) < precedence.get(s.charAt(i+1))) {
                res -= values.get(s.charAt(i));
            } else {
                res += values.get(s.charAt(i));
            }
        }
        res += values.get(s.charAt(s.length() - 1));
        return res;
    }
    
    private void buildPrecedence() {
        precedence = new HashMap<>();
        precedence.put('I', 0);
        precedence.put('V', 1);
        precedence.put('X', 2);
        precedence.put('L', 3);
        precedence.put('C', 4);
        precedence.put('D', 5);
        precedence.put('M', 6);
    }
    
    private void buildValues() {
        values = new HashMap<>();
        values.put('I', 1);
        values.put('V', 5);
        values.put('X', 10);
        values.put('L', 50);
        values.put('C', 100);
        values.put('D', 500);
        values.put('M', 1000);
    }
}


class Solution {
    public int romanToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char n = i < s.length() - 1 ? s.charAt(i+1) : 'I';
            if (get(c) >= get(n)) {
                res += get(c);
            } else {
                res -= get(c);
            }
        }
        return res;
    }
    
    private int get(char c) {
        if (c == 'I')       return 1;
        else if (c == 'V')  return 5;
        else if (c == 'X')  return 10;
        else if (c == 'L')  return 50;
        else if (c == 'C')  return 100;
        else if (c == 'D')  return 500;
        else                return 1000;
    }
}
