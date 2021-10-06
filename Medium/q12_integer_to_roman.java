class Solution {
    // 1 ~ 9
    String[] l1 = new String[] {
        "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"
    };
    // 10 ~ 90
    String[] l2 = new String[] {
        "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"
    };
    // 100 ~ 900
    String[] l3 = new String[] {
        "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"
    };
    // 1000 ~ 3000
    String[] l4 = new String[] {
        "M", "MM", "MMM"
    };
    
    public String intToRoman(int num) {
        int ones = num % 10;
        num /= 10;
        int tens = num % 10;
        num /= 10;
        int hundreds = num % 10;
        num /= 10;
        int thousands = num % 10;
        
        StringBuilder sb = new StringBuilder();
        if (thousands > 0) {
            sb.append(l4[thousands - 1]);
        }
        if (hundreds > 0) {
            sb.append(l3[hundreds - 1]);
        }
        if (tens > 0) {
            sb.append(l2[tens - 1]);
        }
        if (ones > 0) {
            sb.append(l1[ones - 1]);
        }
        return sb.toString();
    }
}
