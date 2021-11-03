class FreqStack {
    Map<Integer, Integer> freq;  // val |-> freq
    Map<Integer, Stack<Integer>> sts; // freq |-> stack of val
    int maxfreq;

    public FreqStack() {
        freq = new HashMap<>();
        sts = new HashMap<>();
        maxfreq = 0;
    }
    
    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        maxfreq = Math.max(maxfreq, f);
        freq.put(val, f);
        sts.putIfAbsent(f, new Stack());
        sts.get(f).push(val);
    }
    
    public int pop() {
        Stack<Integer> st = sts.get(maxfreq);
        int val = st.pop();
        freq.put(val, freq.get(val) - 1);
        if (st.isEmpty()) maxfreq--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
 