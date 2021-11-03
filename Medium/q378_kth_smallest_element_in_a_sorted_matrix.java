class Solution {
    // Element hold data of matrix elements:
    // i, j are indices; val is the value
    class Element {
        int i, j, val;
        public Element(int i, int j, int val) {
            this.i = i; this.j = j; this.val = val;
        }
    }
    
    public int kthSmallest(int[][] matrix, int k) {
        // heap stores next elements in each row of the matrix
        PriorityQueue<Element> heap = new PriorityQueue<>((x, y) -> x.val - y.val);
        for (int i = 0; i < matrix.length; i++) {
            heap.add(new Element(i, 0, matrix[i][0]));
        }
        for (int i = 0; i < k - 1; i++) {
            Element p = heap.poll();
            if (p.j < matrix[0].length - 1) {
                heap.add(new Element(p.i, p.j+1, matrix[p.i][p.j+1]));
            }
        }
        return heap.peek().val;
    }
}
