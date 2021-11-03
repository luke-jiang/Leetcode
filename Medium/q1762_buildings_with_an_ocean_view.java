class Solution {
    public int[] findBuildings(int[] heights) {
        int len = heights.length;
        int[] nextGreater = new int[len];
        Arrays.fill(nextGreater, -1);
        Stack<Integer> st = new Stack<>();
        int count = 0;
        for (int i = 0; i < len; i++) {
            while (!st.isEmpty() && heights[st.peek()] <= heights[i]) {
                nextGreater[st.pop()] = i;
                count++;
            }
            st.push(i);
        }
        // System.out.println(Arrays.toString(nextGreater));
        int[] res = new int[len - count];
        int next = 0;
        for (int i = 0; i < len; i++) {
            if (nextGreater[i] == -1) {
                res[next] = i;
                next++;
            }
        }
        return res;
    }
}
