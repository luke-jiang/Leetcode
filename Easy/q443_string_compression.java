

class Solution {
  // runtime: O(n)
    public int compress(char[] chars) {
        int write = 0;  // where to write the next data
        int i = 0;
        while (i < chars.length) {
            if (i+1 >= chars.length || chars[i] != chars[i+1]) {
                chars[write] = chars[i];
                write++;
                i++;
            } else {
                int end = i;
                while (end+1 < chars.length && chars[end+1] == chars[i]) end++;
                // end now points to the last index of the sequence to compress.
                String len = "" + (end - i + 1);
                chars[write] = chars[i];
                write++;
                for (int j = 0; j < len.length(); j++) {
                    chars[write] = len.charAt(j);
                    write++;
                }
                i = end + 1;
            }
        }
        return write;

    }
}
