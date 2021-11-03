class Solution {
    public String restoreString(String s, int[] indices) {
        char[] res = new char[s.length()];
        for (int i : indices) {
            char c = s.charAt(i);
            int index = indices[i];
            res[index] = c;
        }
        return String.valueOf(res);
    }
}
