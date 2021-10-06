
/** Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.
  */

class MinStack {
    List<Integer> s;
    int min;
    int freq; // stores the frequency of the min value

    /** initialize your data structure here. */
    public MinStack() {
        s = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        s.add(x);
        if (x < min) {
            min = x;
            freq = 1;
        } else if (x == min) {
            freq++;
        }
    }

    public void pop() {
        int next = s.remove(s.size() - 1);
        if (next == min) {
            freq--;
            if (freq == 0) {
                min = Integer.MAX_VALUE;
                for (int n : s) {
                    if (n < min) {
                        min = n;
                        freq = 1;
                    } else {
                        freq++;
                    }
                }
            }
        }
    }

    public int top() {
        return s.get(s.size() - 1);
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
