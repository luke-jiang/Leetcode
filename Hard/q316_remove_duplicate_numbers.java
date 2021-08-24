class Solution {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] seen = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            freq[index]--;
            if (seen[index]) continue;
            while (!st.isEmpty() && st.peek() > c && freq[st.peek() - 'a'] > 0) {
                char prev = st.pop();
                seen[prev - 'a'] = false;
            }
            st.push(c);
            seen[index] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, st.pop());
        }
        return sb.toString();
    }
}
