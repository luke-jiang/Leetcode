/**
 */
class Solution {
    public String validIPAddress(String IP) {
        if (IP.length() <= 0 || IP.length() > 39) return "Neither";
        if (IP.charAt(0) == ':' || IP.charAt(IP.length() - 1) == ':') return "Neither";
        if (IP.charAt(0) == '.' || IP.charAt(IP.length() - 1) == '.') return "Neither";
        
        String[] IP4 = IP.split("\\.");
        String[] IP6 = IP.split(":");
        // System.out.println(Arrays.toString(IP4));
        System.out.println(Arrays.toString(IP6));
        
        if (IP4.length == 4 && valid4(IP4)) {
            return "IPv4";
        } else if (IP6.length == 8 && valid6(IP6)) {
            return "IPv6";
        } else {
            return "Neither";
        }
    }
        
    private boolean valid4(String[] IP) {
        for (String s : IP) {
            if (s.length() == 0) return false;
            if (s.charAt(0) == '0' && s.length() > 1) return false;
            int x = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c < '0' || c > '9') return false;
                x = x * 10 + (c - '0');
            }
            if (x < 0 || x > 255) return false;
        }
        return true;
    }
        
    private boolean valid6(String[] IP) {
        for (String s : IP) {
            if (s.length() <= 0 || s.length() > 4) return false;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') continue;
                if (c >= 'a' && c <= 'f') continue;
                if (c >= 'A' && c <= 'F') continue;
                return false;
            }
        }
        return true;
    }
}
