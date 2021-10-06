class MaxStack {
    class Element {
        int value;
        int index;
        public Element(int v, int i) {
            value = v;
            index = i;
        }
    }
    
    List<Element> st;
    PriorityQueue<Element> maxHeap;

    public MaxStack() {
        st = new LinkedList<>();
        maxHeap = new PriorityQueue<>((a, b) -> b.value != a.value ? b.value - a.value : b.index - a.index);
    }
    
    public void push(int x) {
        Element n = new Element(x, st.size());
        st.add(n);
        maxHeap.add(n);
    }
    
    public int pop() {
        Element n = st.get(st.size() - 1);
        st.remove(st.size() - 1);
        maxHeap.remove(n);
        return n.value;
    }
    
    public int top() {
        return st.get(st.size() - 1).value;
    }
    
    public int peekMax() {
        return maxHeap.peek().value;
    }
    
    public int popMax() {
        Element n = maxHeap.poll();
        st.remove(n);
        return n.value;
    }
}
