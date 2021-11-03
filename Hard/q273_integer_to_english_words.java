class Solution {
    private static final String[] d0to9 = new String[] {
        "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    };
    private static final String[] d10to19 = new String[] {
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };
    private static final String[] d20to90 = new String[] {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };
    
    public String numberToWords(int num) {
        if (num == 0) return d0to9[0];
        return String.join(" ", helper(num).split("/+")).trim();
    }
    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        
        int B   = num / 1000000000;
        if (B > 0) sb.append(numberToWords(B) + "/Billion/");
        
        int M   = (num % 1000000000) / 1000000;
        if (M > 0) sb.append(numberToWords(M) + "/Million/");
        
        int Th  = (num % 1000000) / 1000;
        if (Th > 0) sb.append(numberToWords(Th) + "/Thousand/");
        
        int H   = (num % 1000) / 100;
        if (H > 0) sb.append(d0to9[H] + "/Hundred/");
        
        int Te  = (num % 100) / 10; 
        int D   = num % 10;
        if (Te == 0 && D > 0) {
            sb.append("/" + d0to9[D]);
        } else if (Te == 1) {
            sb.append("/" + d10to19[D]);
        } else {
            sb.append("/" + d20to90[Te]);
            if (D > 0) sb.append("/" + d0to9[D]);
        }
        return sb.toString();
    }
}