// [Segment Tree]

class NumArray {
    int[] tree;
    int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n * 2];
        // construct the segment tree
        // 1). copy all values in num into tree[n, 2n]. They are leaf values.
        for (int i = n, j = 0; j < n; i++, j++) {
            tree[i] = nums[j];
        }
        // 2). iteratively compute non-leaf values
        for (int i = n - 1; i > 0; i--) {
            tree[i] = tree[i * 2] + tree[i * 2 + 1];
        }
        // System.out.println(Arrays.toString(tree));
    }
    
    public void update(int pos, int val) {
        // 1). convert pos to tree index and update leaf value
        pos += n;
        tree[pos] = val;
        // 2). iteratively update parents
        while (pos > 0) {
            int left  = pos % 2 == 0 ? pos : pos - 1;
            int right = pos % 2 == 0 ? pos + 1 : pos;
            tree[pos / 2] = tree[left] + tree[right];
            pos /= 2;
        }
    }
    
    public int sumRange(int left, int right) {
        // 1). get leaves corresponding to left and right
        left += n; right += n;
        int sum = 0;
        while (left <= right) {
             // 2). extra left, should not be included in the sum.
            if (left % 2 == 1) {
                // add the value to sum, and increment left
                sum += tree[left];
                left++;
            }
            if (right % 2 == 0) {
                sum += tree[right];
                right--;
            }
            // 3). go to their parents
            left /= 2;
            right /= 2;
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
