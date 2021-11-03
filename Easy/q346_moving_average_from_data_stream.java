class MovingAverage {
    Queue<Integer> q;
    double sum;
    int capacity;

    public MovingAverage(int size) {
        q = new LinkedList<>();
        sum = 0.0;
        capacity = size;
    }
    
    public double next(int val) {
        if (q.size() == capacity) {
            Integer prev = q.remove();
            sum -= prev;
        }
        sum += val;
        q.add(val);
        return sum / q.size();
    }
}
