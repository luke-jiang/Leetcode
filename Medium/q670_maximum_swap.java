class Solution {
    public int maximumSwap(int num) {
        if (num < 10) return num;
        // StringBuilder s = new StringBuilder("" + num);
        char[] s = String.valueOf(num).toCharArray();
        int len = s.length;
        int[] nextGreater = new int[len];
        int[] lastOccurence = new int[10];
        Arrays.fill(nextGreater, -1);
        Arrays.fill(lastOccurence, -1);
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < len; i++) {
            lastOccurence[s[i] - '0'] = i;
            while (!st.isEmpty() && s[st.peek()] < s[i]) {
                nextGreater[st.pop()] = i;
            }
            st.push(i);
        }
        // System.out.println(Arrays.toString(nextGreater));
        // System.out.println(Arrays.toString(lastOccurence));
        int i = 0;
        while (i < len && (nextGreater[i] == -1)) i++;
        if (i == len) return num;
        int j = i;
        while (nextGreater[j] != -1) j = nextGreater[j];
        j = Math.max(j, lastOccurence[s[j] - '0']);
        char c = s[i];
        s[i] = s[j];
        s[j] = c;
        return Integer.parseInt(new String(s));
    }
}
