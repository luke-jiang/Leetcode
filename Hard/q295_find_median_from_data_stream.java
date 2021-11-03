// [Heap]

class MedianFinder {
    // use a maxHeap and a minHeap to store the two halves of the sorted array
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (max.isEmpty() || num <= max.peek()) {
            max.offer((Integer) num);
        } else {
            min.offer((Integer) num);
        }
        
        while (min.size() > max.size()) {
            max.offer(min.poll());
        }
        
        while (max.size() > min.size() + 1) {
            min.offer(max.poll());
        }
    }
    
    public double findMedian() {
        if (max.size() == min.size()) {
            return (double) (max.peek() + min.peek()) / 2.0;
        }
        
        return (double) max.peek();
    }
}
